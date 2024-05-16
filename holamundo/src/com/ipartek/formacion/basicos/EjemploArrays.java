package com.ipartek.formacion.basicos;

public class EjemploArrays {
	public static void main(String[] args) {
		int tamanoArray = 5;
		int[] arr = new int[tamanoArray];
		
		arr[0] = 5;
		arr[1] = 4;
		arr[4] = 3;
		
		System.out.println(java.util.Arrays.toString(arr));
		System.out.println(arr[1]);
		System.out.println(arr.length);
		
		char[][] tablero = new char[8][8];
		
		tablero[0][0] = 'T';
		tablero[1][0] = 'C';
		tablero[0][1] = 'P';
		tablero[7][7] = 't';
		
		for(int fila = 0; fila < tablero.length; fila++) {
			for(int columna = 0; columna < tablero[fila].length; columna++) {
				if(tablero[columna][fila] == 0) {
					System.out.print('.');
				} else {
					System.out.print(tablero[columna][fila]);
				}
			}
			System.out.println();
		}
	}
}
