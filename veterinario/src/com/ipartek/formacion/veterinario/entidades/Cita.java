package com.ipartek.formacion.veterinario.entidades;

import java.time.LocalDateTime;

public class Cita {
	private Long id;
	private LocalDateTime fechaHoraInicio;
	private LocalDateTime fechaHoraFinal;
	private Empleado empleado;
	private Cliente cliente;
	private Animal animal;
	private Servicio servicio;
}
