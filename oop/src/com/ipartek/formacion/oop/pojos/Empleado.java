package com.ipartek.formacion.oop.pojos;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona {
	private String dni;
	private String nss;

	public Empleado(Long id, String nombre, LocalDate fechaNacimiento, String dni, String nss) {
		super(id, nombre, fechaNacimiento);

		setDni(dni);
		setNss(nss);
	}
	
	public Empleado(String nombre, LocalDate fechaNacimiento, String dni, String nss) {
		this(null, nombre, fechaNacimiento, dni, nss);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dni, nss);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nss, other.nss);
	}

	@Override
	public String toString() {
		return "Empleado [id=" + getId() + ", nombre=" + getNombre()
				+ ", fechaNacimiento=" + getFechaNacimiento() + " dni=" + dni + ", nss=" + nss + "]";
	}

	@Override
	public String ficha() {
		return super.ficha() + String.format("""
				DNI:\t\t\t%s
				NSS:\t\t\t%s
				""", dni, nss);
	}
	
	

}
