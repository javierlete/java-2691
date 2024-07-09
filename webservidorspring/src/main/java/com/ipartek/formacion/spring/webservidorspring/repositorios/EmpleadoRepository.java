package com.ipartek.formacion.spring.webservidorspring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.webservidorspring.entidades.Empleado;

@RepositoryRestResource(collectionResourceRel = "empleados", path = "empleados")
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	Empleado findByNif(String nif);
}
