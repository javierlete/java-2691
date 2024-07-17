package com.ipartek.formacion.spring.ipartektube.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//JPA
@Entity
@Table(name = "videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(max = 100)
	private String titulo;
	
	@NotNull
	@NotBlank
	@Size(max = 255)
	@Pattern(regexp = "^https://www.youtube.com/embed/[a-zA-Z0-9_]+$", message = "URL no válida")
	private String url;
	
	@Lob
	@Size(max = 1000)
	private String descripcion;
}
