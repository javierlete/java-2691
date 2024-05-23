package com.ipartek.formacion.oop.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Local {
	private Long id;
	private Persona gerente;
	private ArrayList<Persona> asistentes = new ArrayList<>();
	
	public Local(Persona gerente) {
		setGerente(gerente);
	}
	
	public Persona getGerente() {
		return gerente;
	}
	
	private void setGerente(Persona gerente) {
		if(gerente == null) {
			throw new RuntimeException("Es obligatorio facilitar un gerente");
		}
		
		this.gerente = gerente;
	}
	
	public void agregarAsistente(Persona asistente) {
		if(asistente == null) {
			throw new RuntimeException("No se admiten asistentes nulos");
		}
		asistentes.add(asistente);
	}
	
	public ArrayList<Persona> getAsistentes() {
		return asistentes;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", gerente=" + gerente + ", asistentes=" + asistentes + "]";
	}
	
	public BigDecimal costeNominas() {
		BigDecimal coste = BigDecimal.ZERO;
		
		if(gerente instanceof Empleado e) {
			coste = coste.add(e.getSueldoMensual());
		}
		
		for(Persona p: asistentes) {
			if(p instanceof Empleado e) {
				coste = coste.add(e.getSueldoMensual());
			}
		}
		
		return coste;
	}
}
