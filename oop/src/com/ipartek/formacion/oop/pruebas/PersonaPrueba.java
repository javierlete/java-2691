package com.ipartek.formacion.oop.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.oop.pojos.Persona;

public class PersonaPrueba {
	public static void main(String[] args) {
		Persona p = null;
		
		System.out.println(p);
		
		p = new Persona();
		
		p.setId(1L);
		p.setNombre("   sdgf  ");
		p.setFechaNacimiento(LocalDate.now());
		
		System.out.println(p.getNombre());
		System.out.println(p);
		
		Persona p2 = new Persona(2L, "sdfg ", LocalDate.now());
		
		System.out.println(p2.getNombre());
		
		Persona p3 = new Persona("Juan");
		
		System.out.println(p3.getNombre());
		
		Persona pCopia = new Persona(p);
		
		// p.setNombre("Pedro");
		
		System.out.println(pCopia.getNombre());
		System.out.println(p.getNombre());
		
		System.out.println(pCopia.equals(p));
		
		System.out.println(p.ficha());
	}
}
