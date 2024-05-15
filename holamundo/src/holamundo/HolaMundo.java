package holamundo;

import java.math.BigDecimal;

/**
 * Clase de ejemplo de Java
 */
public class HolaMundo {
	/**
	 * Método que se ejecuta cuando arranca un programa Java
	 * @param args Argumentos de consola
	 */
	public static void main(String[] args) {
		// Muestra "Hola" por pantalla
		System.out.println("Hola");
		
		/*
		 * Hola
		 * Que 
		 * tal
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
		
		for(char c = 0; c <= 127; c++) {
			System.out.println((int)c + ": " + c + "\n");
		}
		
		String nombre1 = new String("Javier");
		String nombre2 = "Javier";
		
		System.out.println(nombre1 == nombre2);
		System.out.println(nombre1.equals(nombre2));
	}
}
