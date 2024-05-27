package com.ipartek.formacion.veterinario.entidades;

public class Local {
	private Long id;
	private String nombre;
	private String direccion;
	private Iterable<Servicio> servicios;
	private Iterable<Empleado> empleados;
	private Iterable<Producto> productos;
}
