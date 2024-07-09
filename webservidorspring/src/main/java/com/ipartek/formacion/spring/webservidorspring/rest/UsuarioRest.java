package com.ipartek.formacion.spring.webservidorspring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.webservidorspring.entidades.Categoria;
import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;
import com.ipartek.formacion.spring.webservidorspring.servicios.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRest {
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/categorias")
	public Iterable<Categoria> categorias() {
		return servicio.obtenerCategorias();
	}
	
	@GetMapping("/categorias/{idCategoria}/productos")
	public Iterable<Producto> productosPorCategoria(@PathVariable Long idCategoria) {
		return servicio.obtenerProductos(idCategoria);
	}
	
	@GetMapping("/productos")
	public Iterable<Producto> productos(Integer pagina, Integer tamano) {
		if(pagina != null) {
			if(tamano != null) {
				return servicio.obtenerProductos(pagina, tamano);
			}
			
			return servicio.obtenerProductos(pagina);
		}
		
		return servicio.obtenerProductos();
	}
	
	@GetMapping("/productos/{id}")
	public Producto productoPorId(@PathVariable Long id) {
		return servicio.obtenerProductoPorId(id);
	}
}
