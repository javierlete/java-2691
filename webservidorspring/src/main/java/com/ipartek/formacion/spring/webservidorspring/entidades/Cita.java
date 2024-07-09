package com.ipartek.formacion.spring.webservidorspring.entidades;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cita {
	private Long id;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFinal;
	private Empleado empleado;
	private Cliente cliente;
	private Animal animal;
	private Servicio servicio;

	public Cita(Long id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinal, Empleado empleado,
			Cliente cliente, Animal animal, Servicio servicio) {
		super();
		this.id = id;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFinal = fechaHoraFinal;
		this.empleado = empleado;
		this.cliente = cliente;
		this.animal = animal;
		this.servicio = servicio;
	}

	public Cita() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFinal() {
		return fechaHoraFinal;
	}

	public void setFechaHoraFinal(LocalDateTime fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(animal, cliente, empleado, fechaHoraFinal, fechaHoraInicio, id, servicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(animal, other.animal) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(empleado, other.empleado) && Objects.equals(fechaHoraFinal, other.fechaHoraFinal)
				&& Objects.equals(fechaHoraInicio, other.fechaHoraInicio) && Objects.equals(id, other.id)
				&& Objects.equals(servicio, other.servicio);
	}

	@Override
	public String toString() {
		return "Cita [id=" + id + ", fechaHoraInicio=" + fechaHoraInicio + ", fechaHoraFinal=" + fechaHoraFinal
				+ ", empleado=" + empleado + ", cliente=" + cliente + ", animal=" + animal + ", servicio=" + servicio
				+ "]";
	}

}
