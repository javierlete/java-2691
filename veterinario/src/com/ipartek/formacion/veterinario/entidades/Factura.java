package com.ipartek.formacion.veterinario.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Factura {
	private Long id;
	private LocalDate fecha;
	private Cliente cliente;
	private Local local;
	private Iterable<Servicio> servicios;
	private Iterable<Producto> productos;
	private BigDecimal getPrecioTotal() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
