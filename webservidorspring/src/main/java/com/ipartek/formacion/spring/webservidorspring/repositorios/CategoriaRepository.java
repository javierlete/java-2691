package com.ipartek.formacion.spring.webservidorspring.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.webservidorspring.entidades.Categoria;

@RepositoryRestResource(collectionResourceRel = "categorias", path = "categorias")
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	@Query("select c from Categoria c left join fetch c.productos where c.id = :id")
	Categoria obtenerPorIdConProductos(Long id);
}
