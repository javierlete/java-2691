package com.ipartek.formacion.oop.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.oop.pojos.Empleado;
import com.ipartek.formacion.oop.pojos.Local;
import com.ipartek.formacion.oop.pojos.Persona;

public class EmpleadoPrueba {
	public static void main(String[] args) {
		var e = new Empleado("Prueba", LocalDate.of(2000, 1, 2), "12345678A", "1234123412341234");

		System.out.println(e);

//		e.setId(null);
//		e.setNombre("Empleado Empleadez");
//		e.setFechaNacimiento(null);

		System.out.println(e.ficha());

		Persona p = e;

		// System.out.println(p.getDni()); // NO PODEMOS

		if (p instanceof Empleado) {
			Empleado e2 = (Empleado) p;

			System.out.println(e2.getDni());
		} else {
			System.out.println("p no es un empleado");
		}
		
		Persona p2 = new Persona();

		if(p2 instanceof Empleado e3) {
			//Empleado e3 = (Empleado) p2;
			System.out.println(e3.getDni());
		} else {
			System.out.println("p2 no es un empleado");
		}
		
		Local l = new Local(e);
		
		l.agregarAsistente(p2);
		l.agregarAsistente(new Empleado("adsfdas", LocalDate.now(), "12345687", "12341234"));
		
		System.out.println(l.getGerente());
		
		for(Persona persona: l.getAsistentes()) {
			System.out.println(persona);
		}
	}
}
