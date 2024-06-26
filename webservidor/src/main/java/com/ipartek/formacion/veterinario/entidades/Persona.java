package com.ipartek.formacion.veterinario.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

//JPA
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

	private static final long serialVersionUID = -4833836082202489578L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(max = 50)
	private String nombre;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String apellidos;

	@Pattern(regexp = "^[XYZ\\d]\\d{7}[A-Z]$", message = "Se debe utilizar el formato de NIF correcto")
	@Column(columnDefinition = "CHAR(9)")
	private String nif;

	@Pattern(regexp = "^\\d{9}$")
	@Column(columnDefinition = "CHAR(9)")
	private String telefono;

}
