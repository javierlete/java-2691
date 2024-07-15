package com.ipartek.formacion.spring.webservidorspring.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ipartek.formacion.spring.webservidorspring.servicios.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService servicio;
	
	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("categorias", servicio.obtenerCategorias());
		modelo.addAttribute("productos", servicio.obtenerProductos());
		return "index";
	}
	
	@GetMapping("/categorias/{id}")
	public String categoria(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("categorias", servicio.obtenerCategorias());
		modelo.addAttribute("productos", servicio.obtenerProductos(id));
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/hola")
	public String holaMundo(String nombre, Model modelo) {
		modelo.addAttribute("mensaje", "Hola " + nombre);
		return "hola";
	}
	
	@GetMapping("/principal")
	public String principal() {
		return "principal";
	}
}
