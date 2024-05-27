package com.ipartek.formacion.veterinario.entidades;

public class Animal {
	private Long id;
	private String nombre;
	private String chip;
	private Iterable<Cliente> propietario;
	private TipoAnimal tipo;
}
