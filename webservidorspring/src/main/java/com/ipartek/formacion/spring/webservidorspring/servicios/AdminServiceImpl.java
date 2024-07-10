package com.ipartek.formacion.spring.webservidorspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;
import com.ipartek.formacion.spring.webservidorspring.repositorios.ProductoRepository;

@Service
public class AdminServiceImpl extends UsuarioServiceImpl implements AdminService {
	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public Producto altaProducto(Producto producto) {
		producto.setId(null);
		return productoRepo.save(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		if(producto.getId() == null) {
			throw new AdminServiceException("No se puede modificar un producto sin id");
		}
		
		return productoRepo.save(producto);
	}

	@Override
	public void bajaProducto(Long id) {
		productoRepo.deleteById(id);
	}

}
