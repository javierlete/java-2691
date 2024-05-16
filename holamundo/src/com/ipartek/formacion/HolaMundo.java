package com.ipartek.formacion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase de ejemplo de Java
 */
public class HolaMundo {
	/**
	 * Método que se ejecuta cuando arranca un programa Java
	 * 
	 * @param args Argumentos de consola
	 */
	public static void main(String[] args) {
		// Muestra "Hola" por pantalla
		System.out.println("Hola");

		/*
		 * Hola Que tal
		 */

		double d1 = 0.1;
		double d2 = 0.2;

		double d3 = d1 + d2;

		// double d4 = null;

		System.out.println(d3);

		@SuppressWarnings("unused")
		Double dd1 = d3;

		var bd1 = new BigDecimal("0.1");
		var bd2 = new BigDecimal("0.2");

		var bd3 = bd1.add(bd2);

		System.out.println(bd3);

		@SuppressWarnings("unused")
		long l = 123123123123L;

		for (char c = 0; c <= 127; c++) {
			System.out.println((int) c + ": " + c + "\n");
		}

		String nombre1 = new String("Javier");
		String nombre2 = "Javier";

		System.out.println(nombre1 == nombre2);
		System.out.println(nombre1.equals(nombre2));

		System.out.println(nombre1.toUpperCase());
		System.out.println(nombre1.length());
		System.out.println("El nombre es " + nombre1);

		LocalDateTime inicio = LocalDateTime.of(2024, 5, 14, 15, 15);
		LocalDateTime fin = inicio.plusWeeks(190 / 5 / 4);

		System.out.println(new Date());
		System.out.println(new GregorianCalendar());

		System.out.println(fin);

		String sLog = "";

		String texto;

		for (int i = 1; i <= 10; i++) {
			texto = "Evento " + i;
			sLog += LocalDateTime.now() + ": " + texto + "\n";
			// sLog = new StringBuffer(sLog).append(LocalDateTime.now()).append(":
			// ").append(texto).append("\n").toString();
		}

		System.out.println(sLog);

		var sb = new StringBuffer();

		for (int i = 1; i <= 10; i++) {
			texto = "Evento " + i;
			sb.append(LocalDateTime.now()).append(": ").append(texto).append("\n");
		}

		System.out.println(sb.toString());

		System.out.println(Math.pow(5, 2));

		int x = 5;

		System.out.println(0 + x + 10);

		System.out.println(0 <= x && x <= 10);

		System.out.println(-5 >> 2);
		System.out.println(-5 >>> 2);

		System.out.println(++x);
		System.out.println(x);

		int y = 7;

		System.out.println(x > y ? x : y);

		if (x < y) {
			System.out.println("x < y");
			System.out.println("Otra más");
		}

		int dias, mes = 4;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4, 6, 9, 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}
		
		System.out.println(dias);

		int opcion = 3;

		switch (opcion) {
		case 1 -> System.out.println("UNO");
		case 2 -> System.out.println("DOS");
		default -> System.out.println("NPI");
		}
		
		dias = switch(mes) {
		case 2 -> 28;
		case 4, 6, 9, 11 -> 30;
		default -> 31;
		};
	}
}
