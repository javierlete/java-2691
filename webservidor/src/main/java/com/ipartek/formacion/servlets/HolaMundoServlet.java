package com.ipartek.formacion.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Anotación que configura el PATH a través del cuál se llega a esta servlet
@WebServlet("/hola")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");

		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();

		if (nombre == null) {
			out.println("HOLA A TODOS");
		} else {
			out.println("Hola " + nombre);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
