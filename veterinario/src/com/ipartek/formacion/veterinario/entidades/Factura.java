package com.ipartek.formacion.veterinario.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Factura {
	private Long id;
	private LocalDate fecha;
	private Cliente cliente;
	private Local local;

	private Iterable<Servicio> servicios;
	private Iterable<Producto> productos;

	public Factura(Long id, LocalDate fecha, Cliente cliente, Local local) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.local = local;
	}

	public Factura() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Iterable<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Iterable<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Iterable<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Iterable<Producto> productos) {
		this.productos = productos;
	}

	public BigDecimal getPrecioTotal() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fecha, id, local);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(id, other.id) && Objects.equals(local, other.local);
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", local=" + local + "]";
	}

}
