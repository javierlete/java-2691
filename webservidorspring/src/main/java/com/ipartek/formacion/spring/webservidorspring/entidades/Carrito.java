package com.ipartek.formacion.spring.webservidorspring.entidades;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrito {
	private ArrayList<Producto> productos = new ArrayList<>();
	
	public Iterable<Producto> getProductos() {
		return Collections.unmodifiableCollection(productos);
	}

	public void agregar(Producto producto) {
		productos.add(producto);		
	}
}
