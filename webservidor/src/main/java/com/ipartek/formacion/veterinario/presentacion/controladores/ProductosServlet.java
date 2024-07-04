package com.ipartek.formacion.veterinario.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.veterinario.accesodatos.DaoProducto;
import com.ipartek.formacion.veterinario.accesodatos.DaoProductoJpa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {

	private static final long serialVersionUID = 3884456527233712355L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoProducto dao = new DaoProductoJpa();
		
		request.setAttribute("productos", dao.obtenerTodos());
		
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

}
