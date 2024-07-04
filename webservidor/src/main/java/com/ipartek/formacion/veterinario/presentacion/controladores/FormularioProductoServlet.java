package com.ipartek.formacion.veterinario.presentacion.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeMap;

import com.ipartek.formacion.veterinario.accesodatos.DaoProducto;
import com.ipartek.formacion.veterinario.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.veterinario.entidades.Categoria;
import com.ipartek.formacion.veterinario.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@WebServlet("/admin/formulario-producto")
public class FormularioProductoServlet extends HttpServlet {

	private static final long serialVersionUID = 3884456527233712355L;
	private static final DaoProducto dao = new DaoProductoJpa();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.parseLong(sId);

			var producto = dao.obtenerPorId(id);

			request.setAttribute("producto", producto);
		}

		request.getRequestDispatcher("/formulario-producto.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. RECOGER INFORMACIÓN DE LA PETICIÓN
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sStock = request.getParameter("stock");
		String descripcion = request.getParameter("descripcion");
		String sIdCategoria = request.getParameter("categoria");

		// 2. CONVERTIR LOS DATOS
		Long id = sId.isBlank() ? null : Long.parseLong(sId);
		Integer stock = sStock.isBlank() ? null : Integer.parseInt(sStock);
		Long idCategoria = sIdCategoria.isBlank() ? null : Long.parseLong(sIdCategoria);
		BigDecimal precio = sPrecio.isBlank() ? null : new BigDecimal(sPrecio);

		// 3. EMPAQUETAR EN MODELO
		Categoria categoria = Categoria.builder().id(idCategoria).build();
		
		Producto producto = Producto.builder().id(id).nombre(nombre).descripcion(descripcion).stock(stock).precio(precio).categoria(categoria).build();

		// 4. LÓGICA DE NEGOCIO
		// Locale.setDefault(Locale.ENGLISH);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Producto>> constraintViolations = validator.validate(producto);

		TreeMap<String, String> errores = new TreeMap<>();

		for (ConstraintViolation<Producto> constraintViolation : constraintViolations) {
			errores.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		if (errores.size() > 0) {
			request.setAttribute("errores", errores);
			request.setAttribute("producto", producto);

			request.getRequestDispatcher("/formulario-producto.jsp").forward(request, response);

			return;
		}

		if (id == null) {
			dao.insertar(producto);
		} else {
			dao.modificar(producto);
		}

		// 5. PREPARAR EL MODELO PARA LA SIGUIENTE VISTA

		// request.setAttribute("clave", valor);

		// 6. SALTAR A LA SIGUIENTE VISTA (FORWARD/REDIRECT)
		response.sendRedirect(request.getContextPath() + "/productos");
		// request.getRequestDispatcher("pantalla.jsp").forward(request, response);
	}

}
