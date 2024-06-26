package com.ipartek.formacion.veterinario.entidades;

import java.io.Serializable;
import java.util.TreeMap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
//LOMBOK
@Data
@NoArgsConstructor
@SuperBuilder

//JPA
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

	private static final long serialVersionUID = -4833836082202489578L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(length = 100)
	private String apellidos;
	
	@Column(columnDefinition = "CHAR(9)")
	private String nif;
	
	@Column(columnDefinition = "CHAR(9)")
	private String telefono;

	@Transient
	protected final TreeMap<String, String> errores = new TreeMap<>();

	public Persona(Long id, String nombre, String apellidos, String nif, String telefono) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setNif(nif);
		setTelefono(telefono);
	}

	public void setNombre(String nombre) {
		if (nombre.isBlank()) {
			errores.put("nombre", "El nombre debe estar rellenado");
		}

		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		if (apellidos.isBlank()) {
			errores.put("apellidos", "Los apellidos se deben rellenar");
		}
		this.apellidos = apellidos;
	}

	public void setNif(String nif) {
		if (nif != null && !nif.matches("^[XYZ\\d]\\d{7}[A-Z]$")) {
			errores.put("nif", "El NIF no concuerda con el formato");
		}
		this.nif = nif;
	}

}
