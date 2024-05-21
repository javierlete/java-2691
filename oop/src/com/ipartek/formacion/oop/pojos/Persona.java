package com.ipartek.formacion.oop.pojos;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
	// Variables de instancia
	private Long id;
	private String nombre;
	private LocalDate fechaNacimiento;

	// Constructores
	public Persona(Long id, String nombre, LocalDate fechaNacimiento) {
		// Llamamos a los setters para validación
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}
	
	// Constructor de copia
	public Persona(Persona persona) {
		this(persona.getId(), persona.getNombre(), persona.getFechaNacimiento());
	}
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this(null, nombre, fechaNacimiento);
	}
	
	public Persona(String nombre) {
		this(null, nombre, null);
	}
	
	public Persona() {
		this(null, "Anónimo", null);
	}

	// MÉTODOS DE INSTANCIA
	// Getters y Setters
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
		if(nombre == null) {
			throw new RuntimeException("No admito nombres nulos");
		}
		
		if(nombre.isBlank()) {
			throw new RuntimeException("No se admiten nombres vacíos");
		}
		
		this.nombre = nombre.trim();
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, id, nombre);
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
		return Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	public String ficha() {
		return String.format("""
			Id:\t\t\t%s
			Nombre:\t\t\t%s
			Fecha de Nacimiento:\t%s
			""", id, nombre, fechaNacimiento);
	}
}
