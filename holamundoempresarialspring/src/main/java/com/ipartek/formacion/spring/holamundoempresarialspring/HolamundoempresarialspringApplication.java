package com.ipartek.formacion.spring.holamundoempresarialspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolamundoempresarialspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HolamundoempresarialspringApplication.class, args);
	}

	@Autowired
	private Entrada entrada;
	
	@Autowired
	private Salida salida;
	
	@Override
	public void run(String... args) throws Exception {
		salida.enviar(entrada.recibir());
	}

}
