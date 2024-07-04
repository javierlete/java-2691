package com.ipartek.formacion.veterinario.accesodatos;

import com.ipartek.formacion.veterinario.entidades.Categoria;

public class DaoCategoriaTest {
	public static void main(String[] args) {
		DaoCategoria dao = new DaoCategoriaJpa();
		
		System.out.println("Categoría sin productos");
		
		Categoria categoria = dao.obtenerPorId(1L);
		
		System.out.println("categoria = " + categoria);
		
		System.out.println("Categoría con productos");
		
		Categoria catProductos = dao.obtenerPorIdConProductos(1L);
		
		System.out.println("catProductos = " + catProductos);
		System.out.println("catProductos.productos = " + catProductos.getProductos());
	}
}
