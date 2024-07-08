package com.ipartek.formacion.spring.holamundoempresarialspring;

import org.springframework.stereotype.Component;

@Component
public class SalidaConsolaFormateada implements Salida {
	@Override
	public void enviar(String mensaje) {
		System.out.printf("*** %s ***%n", mensaje);
	}
}
