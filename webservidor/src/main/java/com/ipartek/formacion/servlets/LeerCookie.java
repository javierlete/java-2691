package com.ipartek.formacion.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Anotación que configura el PATH a través del cuál se llega a esta servlet
@WebServlet("/leer-cookie")
public class LeerCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			response.getWriter().println("No hay cookies");
		} else {
			for (Cookie cookie : cookies) {
				response.getWriter().printf("%s = %s\n", cookie.getName(), cookie.getValue());
			}
		}
	}

}
