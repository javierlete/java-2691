package com.ipartek.formacion.spring.holamundoempresarialspring;

import java.util.Scanner;

public class EntradaConsola implements Entrada {
	private static final Scanner sc = new Scanner(System.in);
	
	@Override
	public String recibir() {
		return sc.nextLine();
	}
}
