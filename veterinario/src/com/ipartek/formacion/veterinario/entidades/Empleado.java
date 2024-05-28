package com.ipartek.formacion.veterinario.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class Empleado extends Persona implements Serializable {

	private static final long serialVersionUID = -653217143179171064L;

	private String nss;
	private BigDecimal sueldoMensual;
	
	public Empleado(Long id, String nombre, String apellidos, String nif, String telefono, String nss,
			BigDecimal sueldoMensual) {
		super(id, nombre, apellidos, nif, telefono);
		this.nss = nss;
		this.sueldoMensual = sueldoMensual;
	}
	
	public Empleado() {}

	@Override
	public String toString() {
		return "Empleado [nss=" + nss + ", sueldoMensual=" + sueldoMensual + ", toString()=" + super.toString() + "]";
	}
	
	
}
