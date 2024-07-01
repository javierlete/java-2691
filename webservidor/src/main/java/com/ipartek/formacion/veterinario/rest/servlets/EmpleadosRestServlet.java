package com.ipartek.formacion.veterinario.rest.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.TreeMap;

import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleado;
import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleadoJpa;
import com.ipartek.formacion.veterinario.entidades.Empleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/empleados/*")
public class EmpleadosRestServlet extends HttpServlet {

	private static final long serialVersionUID = 3884456527233712355L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		PrintWriter out = response.getWriter();

		DaoEmpleado dao = DaoEmpleadoJpa.getInstancia();

		if (pathInfo == null) {

			var empleados = dao.obtenerTodos();

			out.write("[");

			boolean esPrimerRegistro = true;

			for (Empleado e : empleados) {
				if (!esPrimerRegistro) {
					out.println(", ");
				}

				out.printf(
						"""
									{ "id": %s, "nombre": "%s", "apellidos": "%s", "nif": "%s", "nss": "%s", "sueldoMensual": "%s" }
								""",
						e.getId(), e.getNombre(), e.getApellidos(), e.getNif(), e.getNss(), e.getSueldoMensual());

				esPrimerRegistro = false;
			}

			out.write("]");
		} else {
			Long id = Long.parseLong(pathInfo.substring(1));

			Empleado e = dao.obtenerPorId(id);

			out.printf("""
						{ "id": %s, "nombre": "%s", "apellidos": "%s", "nif": "%s", "nss": "%s", "sueldoMensual": "%s" }
					""", e.getId(), e.getNombre(), e.getApellidos(), e.getNif(), e.getNss(), e.getSueldoMensual());

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();

		StringBuffer sb = new StringBuffer();

		String linea;

		while ((linea = br.readLine()) != null) {
			sb.append(linea);
		}
		
		String json = sb.toString();
		
		json = json.replace("{", "").replace("}", "").replace("\"", "");
		
		TreeMap<String, String> dic = new TreeMap<>();
		
		String[] pares = json.split(",");
		
		for(String textoPar: pares) {
			String[] par = textoPar.split(":");
			dic.put(par[0].trim(), par[1].trim());
		}
		
		Empleado empleado = new Empleado(null, dic.get("nombre"), dic.get("apellidos"), dic.get("nif"), dic.get("telefono"), dic.get("nss"), new BigDecimal(dic.get("sueldoMensual")));

		DaoEmpleado dao = DaoEmpleadoJpa.getInstancia();

		var e = dao.insertar(empleado);

		out.printf("""
					{ "id": %s, "nombre": "%s", "apellidos": "%s", "nif": "%s", "nss": "%s", "sueldoMensual": "%s" }
				""", e.getId(), e.getNombre(), e.getApellidos(), e.getNif(), e.getNss(), e.getSueldoMensual());

	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();

		StringBuffer sb = new StringBuffer();

		String linea;

		while ((linea = br.readLine()) != null) {
			sb.append(linea);
		}
		
		String json = sb.toString();
		
		json = json.replace("{", "").replace("}", "").replace("\"", "");
		
		TreeMap<String, String> dic = new TreeMap<>();
		
		String[] pares = json.split(",");
		
		for(String textoPar: pares) {
			String[] par = textoPar.split(":");
			dic.put(par[0].trim(), par[1].trim());
		}
		
		Empleado empleado = new Empleado(Long.parseLong(dic.get("id")), dic.get("nombre"), dic.get("apellidos"), dic.get("nif"), dic.get("telefono"), dic.get("nss"), new BigDecimal(dic.get("sueldoMensual")));

		DaoEmpleado dao = DaoEmpleadoJpa.getInstancia();

		var e = dao.modificar(empleado);

		out.printf("""
					{ "id": %s, "nombre": "%s", "apellidos": "%s", "nif": "%s", "nss": "%s", "sueldoMensual": "%s" }
				""", e.getId(), e.getNombre(), e.getApellidos(), e.getNif(), e.getNss(), e.getSueldoMensual());

	}


	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		DaoEmpleado dao = DaoEmpleadoJpa.getInstancia();

		if (pathInfo != null) {
			Long id = Long.parseLong(pathInfo.substring(1));

			dao.borrar(id);
		}
	}
}
