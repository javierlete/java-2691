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
		setNss(nss);
		setSueldoMensual(sueldoMensual);
	}
	
	public Empleado() {}

	@Override
	public String toString() {
		return "Empleado [nss=" + nss + ", sueldoMensual=" + sueldoMensual + ", toString()=" + super.toString() + "]";
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		if(nss != null && !nss.matches("^\\d{11}$")) {
			errores.put("nss", "El número de la seguridad social debe tener 11 dígitos");
		}
		this.nss = nss;
	}

	public BigDecimal getSueldoMensual() {
		return sueldoMensual;
	}

	public void setSueldoMensual(BigDecimal sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	
	
}
