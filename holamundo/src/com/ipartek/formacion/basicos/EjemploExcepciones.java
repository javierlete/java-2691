package com.ipartek.formacion.basicos;

public class EjemploExcepciones {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		int a = 5, b = 1, c;

		try {
			String s = null;
			
			s.toUpperCase();
			
			int[] arr = new int[2];
			
			arr[1] = 5;
			
			c = a / b;
			System.out.println(c);
		} catch (ArithmeticException e) {
			System.err.println("División por cero");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Te has ido de la olla con el array");
		} finally {
			System.out.println("Me ejecuto por mis cojones");
		}

		System.out.println("FIN");
	}
}
