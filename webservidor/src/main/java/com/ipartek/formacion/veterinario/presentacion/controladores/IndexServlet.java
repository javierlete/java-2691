package com.ipartek.formacion.veterinario.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleado;
import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleadoJpa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 3884456527233712355L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoEmpleado dao = DaoEmpleadoJpa.getInstancia();
		
		var empleados = dao.obtenerTodos();
		
		request.setAttribute("empleados", empleados);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
