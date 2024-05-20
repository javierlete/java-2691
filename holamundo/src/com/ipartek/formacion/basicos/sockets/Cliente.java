package com.ipartek.formacion.basicos.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.ipartek.formacion.bibliotecas.Consola;

public class Cliente {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		try (Socket s = new Socket("localhost", 1234);
				// AUTO_FLUSH es necesario para que envíen los textos INMEDIATAMENTE y no se
						// acumulen en un buffer esperando ser enviados
				 PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
				Scanner sc = new Scanner(s.getInputStream())) {
			System.out.println(sc.nextLine());
			
			pw.println(Consola.leerString("Dime un texto para verlo en mayúsculas"));
			
			System.out.println(sc.nextLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
