package com.ipartek.formacion.spring.webservidorspring.entidades;

import java.util.Objects;

public class Animal {
	private Long id;
	private String nombre;
	private String chip;
	private TipoAnimal tipo;

	private Iterable<Cliente> propietarios;

	public Animal(Long id, String nombre, String chip, TipoAnimal tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.chip = chip;
		this.tipo = tipo;
	}

	public Animal() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public TipoAnimal getTipo() {
		return tipo;
	}

	public void setTipo(TipoAnimal tipo) {
		this.tipo = tipo;
	}

	public Iterable<Cliente> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(Iterable<Cliente> propietarios) {
		this.propietarios = propietarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chip, id, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(chip, other.chip) && Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", chip=" + chip + ", tipo=" + tipo + "]";
	}

}
