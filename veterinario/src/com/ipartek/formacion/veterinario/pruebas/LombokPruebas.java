package com.ipartek.formacion.veterinario.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.veterinario.entidades.Producto;

public class LombokPruebas {
	public static void main(String[] args) {
		Producto p = new Producto();
		System.out.println(p);
		
		Producto.ProductoBuilder pb = Producto.builder();
		pb.nombre("Mi producto").precio(new BigDecimal(1234));
		pb.descripcion("lakjdsklfjas");
		Producto creado = pb.build();
		
		System.out.println(creado);
		Producto nuevo = Producto.builder().nombre(null).precio(BigDecimal.ZERO).build();
		
		System.out.println(nuevo);
	}
}
