package com.ipartek.formacion.basicos;

import java.math.BigInteger;

public class Recursividad {
	public static void main(String[] args) {
		BigInteger resultado = factorial(new BigInteger("10000"));
		
		System.out.println(resultado);
		System.out.println(resultado.toString().length());
	}

	/*
	 * 4! = 4 * 3 * 2 * 1
	 * 
	 * 4! = 4 * 3!
	 * 3! = 3 * 2!
	 * 2! = 2 * 1!
	 * 1! = 1
	 */
	private static BigInteger factorial(BigInteger numero) {
		if(numero.compareTo(BigInteger.ONE) == 0) {
			return BigInteger.ONE;
		}
		return numero.multiply(factorial(numero.subtract(BigInteger.ONE)));
	}
}
