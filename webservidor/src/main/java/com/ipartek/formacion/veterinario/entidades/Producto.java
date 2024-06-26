package com.ipartek.formacion.veterinario.entidades;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private Integer stock;
}
