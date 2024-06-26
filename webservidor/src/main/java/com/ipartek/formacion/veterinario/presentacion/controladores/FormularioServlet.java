package com.ipartek.formacion.veterinario.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeMap;

import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleado;
import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleadoJpa;
import com.ipartek.formacion.veterinario.entidades.Empleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@WebServlet("/admin/formulario")
public class FormularioServlet extends HttpServlet {

	private static final long serialVersionUID = 3884456527233712355L;
	private static final DaoEmpleado dao = DaoEmpleadoJpa.getInstancia();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);

			var empleado = dao.obtenerPorId(id);

			request.setAttribute("empleado", empleado);
		}

		request.getRequestDispatcher("/formulario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. RECOGER INFORMACIÓN DE LA PETICIÓN
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String telefono = request.getParameter("telefono");
		String nif = request.getParameter("nif");
		String nss = request.getParameter("nss");
		String sSueldoMensual = request.getParameter("sueldo-mensual");

		// 2. CONVERTIR LOS DATOS
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		BigDecimal sueldoMensual = sSueldoMensual.isBlank() ? null : new BigDecimal(sSueldoMensual);

		// 3. EMPAQUETAR EN MODELO
		Empleado empleado = new Empleado(id, nombre, apellidos, nif, telefono, nss, sueldoMensual);

		// 4. LÓGICA DE NEGOCIO
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Set<ConstraintViolation<Empleado>> constraintViolations = validator.validate(empleado);
        
        TreeMap<String, String> errores = new TreeMap<>();
        
        for(ConstraintViolation<Empleado> constraintViolation: constraintViolations) {
        	errores.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
        
		if(errores.size() > 0) {
			request.setAttribute("errores", errores);
			request.setAttribute("empleado", empleado);
			
			request.getRequestDispatcher("/formulario.jsp").forward(request, response);
			
			return;
		}
		
		if (id == null) {
			dao.insertar(empleado);
		} else {
			dao.modificar(empleado);
		}

		// 5. PREPARAR EL MODELO PARA LA SIGUIENTE VISTA

		// request.setAttribute("clave", valor);

		// 6. SALTAR A LA SIGUIENTE VISTA (FORWARD/REDIRECT)
		response.sendRedirect(request.getContextPath() + "/admin/empleados");
		// request.getRequestDispatcher("pantalla.jsp").forward(request, response);
	}

}
