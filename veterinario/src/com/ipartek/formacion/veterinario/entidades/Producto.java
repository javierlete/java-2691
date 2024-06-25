package com.ipartek.formacion.veterinario.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

// JPA
@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Forma nativa de AUTOINCREMENT
	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private Integer stock;
}
