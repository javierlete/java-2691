package com.ipartek.formacion.veterinario.rest.jersey;

import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleado;
import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleadoJpa;
import com.ipartek.formacion.veterinario.entidades.Empleado;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/empleados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpleadoRest {
	private static final DaoEmpleado dao = DaoEmpleadoJpa.getInstancia();
	
	@GET
	public Iterable<Empleado> getEmpleados() {
		return dao.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public Empleado getEmpleado(@PathParam("id") Long id) {
		return dao.obtenerPorId(id);
	}
	
	@POST
	public Empleado insertar(Empleado e) {
		dao.insertar(e);
		return e;
	}
	
	@PUT
	@Path("/{id}")
	public Empleado modificar(@PathParam("id") Long id, Empleado e) {
		e.setId(id);
		dao.modificar(e);
		return e;
	}
	
	@DELETE
	@Path("/{id}")
	public void borrar(@PathParam("id") Long id) {
		dao.borrar(id);
	}
	
}
