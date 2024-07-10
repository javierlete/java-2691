package com.ipartek.formacion.spring.webservidorspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.webservidorspring.entidades.Categoria;
import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;
import com.ipartek.formacion.spring.webservidorspring.repositorios.CategoriaRepository;
import com.ipartek.formacion.spring.webservidorspring.repositorios.ProductoRepository;

import lombok.extern.java.Log;

@Log
@Service
@Primary
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public Iterable<Categoria> obtenerCategorias() {
		return categoriaRepo.findAll();
	}

	@Override
	public Iterable<Producto> obtenerProductos() {
		return productoRepo.findAll();
	}

	@Override
	public Iterable<Producto> obtenerProductos(int pagina) {
		return obtenerProductos(pagina, 3);
	}
	
	@Override
	public Iterable<Producto> obtenerProductos(int pagina, int tamano) {
		return productoRepo.findAll(Pageable.ofSize(tamano).withPage(pagina));
	}
	
	@Override
	public Iterable<Producto> obtenerProductos(Long idCategoria) {
		return productoRepo.findByCategoriaId(idCategoria);
	}

	@Override
	public Producto obtenerProductoPorId(Long id) {
		log.info("HAN PEDIDO EL PRODUCTO " + id);
		return productoRepo.findById(id).orElse(null);
	}

}
