package com.ipartek.formacion.veterinario.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.veterinario.accesodatos.DaoProducto;
import com.ipartek.formacion.veterinario.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.veterinario.entidades.Producto;

public class DaoProductoJpaPrueba {
	public static void main(String[] args) {
		DaoProducto dao = new DaoProductoJpa();
		
		Producto producto = dao.insertar(Producto.builder().nombre("Nuevo").precio(new BigDecimal(1234.45)).build());
		
		System.out.println(producto);
		
		for(Producto p: dao.obtenerTodos()) {
			System.out.println(p);
		}
	}
}
