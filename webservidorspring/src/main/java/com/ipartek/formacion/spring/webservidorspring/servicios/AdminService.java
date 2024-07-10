package com.ipartek.formacion.spring.webservidorspring.servicios;

import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;

public interface AdminService extends UsuarioService {
	Producto altaProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void bajaProducto(Long id);
}
