package com.ipartek.formacion.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Anotación que configura el PATH a través del cuál se llega a esta servlet
@WebServlet("/escribir-cookie")
public class EscribirCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("color", "oscuro");
		c.setMaxAge(60*60*24*365);
		
		response.addCookie(c);
		
		response.getWriter().write("Cookie escrita");
	}

}
