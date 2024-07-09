package com.ipartek.formacion.spring.webservidorspring.entidades;

public class Cliente extends Persona {

	private static final long serialVersionUID = -4580614628240632101L;
	
	private Iterable<Animal> animales;

	public Cliente() {
	}

	public Iterable<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(Iterable<Animal> animales) {
		this.animales = animales;
	}
	
}
