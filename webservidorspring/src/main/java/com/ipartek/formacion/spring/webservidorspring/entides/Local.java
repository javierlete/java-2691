package com.ipartek.formacion.spring.webservidorspring.entides;

import java.util.Objects;

public class Local {
	private Long id;
	private String nombre;
	private String direccion;
	
	private Iterable<Servicio> servicios;
	private Iterable<Empleado> empleados;
	private Iterable<Producto> productos;

	public Local(Long id, String nombre, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Local() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Iterable<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Iterable<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Iterable<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Iterable<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Iterable<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Iterable<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Local other = (Local) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

}
