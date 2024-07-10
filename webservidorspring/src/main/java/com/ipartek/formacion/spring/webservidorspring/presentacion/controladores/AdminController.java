package com.ipartek.formacion.spring.webservidorspring.presentacion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;
import com.ipartek.formacion.spring.webservidorspring.servicios.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/productos")
	public String indexProductos(Model modelo) {
		modelo.addAttribute("productos", adminService.obtenerProductos());
		
		return "admin/productos";
	}
	
	@GetMapping({"/producto", "/producto/{id}"})
	public String indexProducto(@PathVariable(required = false) Long id, Model modelo) {
		if (id == null) {
			modelo.addAttribute("producto", new Producto());
		} else {
			modelo.addAttribute("producto", adminService.obtenerProductoPorId(id));
		}
		
		modelo.addAttribute("categorias", adminService.obtenerCategorias());
		
		return "admin/producto";
	}
	
	@PostMapping("/producto") 
	public String guardarProducto(Producto producto) {
		if(producto.getId() == null) {
			adminService.altaProducto(producto);
		} else {
			adminService.modificarProducto(producto);
		}
		
		return "redirect:/admin/productos";
	}
	
	@GetMapping("/producto/borrar/{id}")
	public String borrarProducto(@PathVariable Long id) {
		adminService.bajaProducto(id);
		
		return "redirect:/admin/productos";
	}
}
