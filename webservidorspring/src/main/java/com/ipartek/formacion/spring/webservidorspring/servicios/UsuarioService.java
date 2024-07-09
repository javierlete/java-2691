package com.ipartek.formacion.spring.webservidorspring.servicios;

import com.ipartek.formacion.spring.webservidorspring.entidades.Categoria;
import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;

public interface UsuarioService {
	Iterable<Categoria> obtenerCategorias();
	Iterable<Producto> obtenerProductos();
	Iterable<Producto> obtenerProductos(int pagina);
	Iterable<Producto> obtenerProductos(int pagina, int tamano);
	Iterable<Producto> obtenerProductos(Long idCategoria);
	Producto obtenerProductoPorId(Long id);
}
