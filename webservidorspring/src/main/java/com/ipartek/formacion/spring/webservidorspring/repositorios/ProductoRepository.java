package com.ipartek.formacion.spring.webservidorspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.webservidorspring.entides.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
