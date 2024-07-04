package com.ipartek.formacion.veterinario.accesodatos;

import com.ipartek.formacion.veterinario.entidades.Producto;

public class DaoProductoTest {
	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoJpa();
		
		System.out.println("Producto");
		
		Producto p = dao.obtenerPorId(1L);
		System.out.println("p = " + p);
		
		Iterable<Producto> productos = dao.obtenerTodos();
		System.out.println("productos = " + productos);
	}
}
