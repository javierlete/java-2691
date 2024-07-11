package com.ipartek.formacion.spring.webservidorspring.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// JPA
@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nombre;
	
	private String descripcion;
	
	@Min(0)
	@NotNull
	private BigDecimal precio;
	
	@Min(0)
	private Integer stock;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Future
	private LocalDate fechaCaducidad;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
}
