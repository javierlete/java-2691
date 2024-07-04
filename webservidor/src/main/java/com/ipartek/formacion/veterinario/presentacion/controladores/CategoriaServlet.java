package com.ipartek.formacion.veterinario.presentacion.controladores;

import java.io.IOException;

import com.ipartek.formacion.veterinario.accesodatos.DaoCategoria;
import com.ipartek.formacion.veterinario.accesodatos.DaoCategoriaJpa;
import com.ipartek.formacion.veterinario.entidades.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/categoria")
public class CategoriaServlet extends HttpServlet {

	private static final long serialVersionUID = 3884456527233712355L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		DaoCategoria dao = new DaoCategoriaJpa();
		
		Categoria categoria = dao.obtenerPorIdConProductos(Long.parseLong(id));

		request.setAttribute("categoria", categoria);
		request.setAttribute("productos", categoria.getProductos());
		
		request.getRequestDispatcher("productos.jsp").forward(request, response);
	}

}
