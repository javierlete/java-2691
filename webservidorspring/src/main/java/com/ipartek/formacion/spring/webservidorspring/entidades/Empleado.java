package com.ipartek.formacion.spring.webservidorspring.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

	@NotNull
	@Pattern(regexp = "^\\d{11}$")
	@Column(columnDefinition = "CHAR(11)")
	private String nss;
	
	@NotNull
	@Min(0)
	@Column(name = "sueldo_mensual")
	private BigDecimal sueldoMensual;
	
	public Empleado(Long id, String nombre, String apellidos, String nif, String telefono, String nss,
			BigDecimal sueldoMensual) {
		super(id, nombre, apellidos, nif, telefono);
		setNss(nss);
		setSueldoMensual(sueldoMensual);
	}
}
