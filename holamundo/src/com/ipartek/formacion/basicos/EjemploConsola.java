package com.ipartek.formacion.basicos;

import static com.ipartek.formacion.bibliotecas.Consola.DTF;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;
import static com.ipartek.formacion.bibliotecas.Consola.leerLocalDate;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;
import static com.ipartek.formacion.bibliotecas.Consola.pl;

public class EjemploConsola {

	public static void main(String[] args) {
		Integer numero = leerInt("Dime un número");
		
		pl(numero);
		
		var nombre = leerString("¿Cómo te llamas?");
		
		pl("Hola, " + nombre);
		
		var fecha = leerLocalDate("Dime una fecha");
		
		pl(fecha.format(DTF));
	}
}
