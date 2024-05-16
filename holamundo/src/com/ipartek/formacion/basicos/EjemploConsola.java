package com.ipartek.formacion.basicos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EjemploConsola {

	public static void main(String[] args) {
		var dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		
		var sc = new Scanner(System.in);
		
		System.out.print("Dime un número: ");
		
		var numero = Integer.parseInt(sc.nextLine());
		
		System.out.println(numero);
		
		System.out.print("¿Cómo te llamas? ");
		
		var nombre = sc.nextLine();
		
		System.out.println("Hola, " + nombre);
		
		System.out.print("Fecha: ");
		
		var fecha = LocalDate.parse(sc.nextLine(), dtf);
		
		System.out.println(fecha.format(dtf));
		
		sc.close();
	}
}
