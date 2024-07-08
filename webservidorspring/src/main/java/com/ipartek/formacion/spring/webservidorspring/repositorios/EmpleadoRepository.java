package com.ipartek.formacion.spring.webservidorspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.webservidorspring.entides.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
	Empleado findByNif(String nif);
}
