package com.ipartek.formacion.veterinario.presentacion.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -5535227491572048209L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. RECOGER INFORMACIÓN DE LA PETICIÓN
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// 2. CONVERTIR LOS DATOS

		// 3. EMPAQUETAR EN MODELO

		// 4. LÓGICA DE NEGOCIO
		if(validarUsuario(email, password)) {
			HttpSession session = request.getSession();
			
			session.setAttribute("email", email);
			
			response.sendRedirect(request.getContextPath() + "/admin/empleados");
		} else {
			// 5. PREPARAR EL MODELO PARA LA SIGUIENTE VISTA
			request.setAttribute("error", "Usuario o contraseña incorrectos");
			request.setAttribute("email", email);
			
			// 6. SALTAR A LA SIGUIENTE VISTA (FORWARD/REDIRECT)
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	private boolean validarUsuario(String email, String password) {
		return "javier@email.net".equals(email) && "contra".equals(password);
	}

}
