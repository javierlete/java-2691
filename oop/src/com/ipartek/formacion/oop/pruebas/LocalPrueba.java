package com.ipartek.formacion.oop.pruebas;

import com.ipartek.formacion.oop.pojos.Local;
import com.ipartek.formacion.oop.pojos.Persona;

public class LocalPrueba {
	public static void main(String[] args) {
		Local l = new Local(new Persona("Jefazo"));
		
		l.agregarAsistente(new Persona());
		l.agregarAsistente(new Persona("Otro"));
		
		System.out.println(l);
		
		System.out.println(l.getGerente().getNombre());
		
		for(var p: l.getAsistentes()) {
			System.out.println(p.getNombre());
		}
	}
}
