package com.ipartek.formacion.spring.webservidorspring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;

@RepositoryRestResource(collectionResourceRel = "productos", path = "productos")
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	Iterable<Producto> findByCategoriaId(Long idCategoria);
}
