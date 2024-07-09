package com.ipartek.formacion.spring.webservidorspring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.webservidorspring.entidades.Empleado;

@RepositoryRestResource(collectionResourceRel = "empleados", path = "empleados")
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
	Empleado findByNif(String nif);
}
