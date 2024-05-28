package com.ipartek.formacion.veterinario.entidades;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable {

	private static final long serialVersionUID = -4833836082202489578L;

	private Long id;
	private String nombre;
	private String apellidos;
	private String nif;
	private String telefono;

	public Persona(Long id, String nombre, String apellidos, String nif, String telefono) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setNif(nif);
		setTelefono(telefono);
	}

	public Persona() {}
	
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, id, nif, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(id, other.id)
				&& Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", telefono="
				+ telefono + "]";
	}

}
