package com.ipartek.formacion.veterinario.presentacion.listeners;

import com.ipartek.formacion.veterinario.accesodatos.DaoCategoria;
import com.ipartek.formacion.veterinario.accesodatos.DaoCategoriaJpa;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InicioAplicacionListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		DaoCategoria dao = new DaoCategoriaJpa();
		
		event.getServletContext().setAttribute("categorias", dao.obtenerTodos());
	}

}
