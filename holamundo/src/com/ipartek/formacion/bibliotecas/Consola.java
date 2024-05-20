package com.ipartek.formacion.bibliotecas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);
	public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("d/M/yyyy");
	
	public static void p(Object o) {
		System.out.print(o);
	}
	
	public static void pl(Object o) {
		System.out.println(o);
	}
	
	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		return SC.nextLine();
	}
	
	public static Integer leerInt(String mensaje) {
		Integer numero = null;
		
		boolean estaMal = true;
		
		do {
			try {
				numero = Integer.parseInt(leerString(mensaje));
				estaMal = false;
			} catch (NumberFormatException e) {
				pl("Debe ser un número comprendido entre " + Integer.MIN_VALUE + " y " + Integer.MAX_VALUE);
			}
		} while (estaMal);
		
		return numero;
	}

	public static LocalDate leerLocalDate(String mensaje) {
		LocalDate fecha = null;
		
		boolean estaMal = true;
		
		do {
			try {
				fecha = LocalDate.parse(leerString(mensaje), DTF);
				estaMal = false;
			} catch (DateTimeParseException e) {
				pl("Debe ser una fecha");
			}
		} while (estaMal);
		
		return fecha;
	}
}
