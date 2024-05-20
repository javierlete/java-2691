package com.ipartek.formacion.basicos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ficheros {
	private static final boolean APPEND = true;

	public static void main(String[] args) {
		PrintWriter pw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("prueba.txt", APPEND);
			pw = new PrintWriter(fw);

			pw.println("Hola");
			pw.println("Escrito desde Java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					
				}
			}
		}

		try (var fr = new FileReader("prueba.txt");
				var sc = new Scanner(fr)) {
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
