package com.ipartek.formacion.veterinario.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
//LOMBOK
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder

//JPA
@Entity
public class Empleado extends Persona implements Serializable {

	private static final long serialVersionUID = -653217143179171064L;

	@Column(columnDefinition = "CHAR(11)")
	private String nss;
	
	@Column(name = "sueldo_mensual")
	private BigDecimal sueldoMensual;
	
	public Empleado(Long id, String nombre, String apellidos, String nif, String telefono, String nss,
			BigDecimal sueldoMensual) {
		super(id, nombre, apellidos, nif, telefono);
		setNss(nss);
		setSueldoMensual(sueldoMensual);
	}
	
	public void setNss(String nss) {
		if(nss != null && !nss.matches("^\\d{11}$")) {
			errores.put("nss", "El número de la seguridad social debe tener 11 dígitos");
		}
		this.nss = nss;
	}
	
}
