package com.ipartek.formacion.basicos.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				// AUTO_FLUSH es necesario para que envíen los textos INMEDIATAMENTE y no se acumulen en un buffer esperando ser enviados
				 PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
				Scanner sc = new Scanner(s.getInputStream())) {
			pw.println("Bienvenido al servidor MAYUSCULATOR");
			
			String texto = sc.nextLine();
			
			pw.println(texto.toUpperCase());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
