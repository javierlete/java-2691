package com.ipartek.formacion.oop.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public class EmpleadoIndefinido extends Empleado {
	private Integer numeroPagas;
	private BigDecimal sueldoAnual;

	public EmpleadoIndefinido(Long id, String nombre, LocalDate fechaNacimiento, String dni, String nss,
			Integer numeroPagas, BigDecimal sueldoAnual) {
		super(id, nombre, fechaNacimiento, dni, nss);
		this.numeroPagas = numeroPagas;
		this.sueldoAnual = sueldoAnual;
	}

	public Integer getNumeroPagas() {
		return numeroPagas;
	}

	public void setNumeroPagas(Integer numeroPagas) {
		this.numeroPagas = numeroPagas;
	}

	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}

	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroPagas, sueldoAnual);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpleadoIndefinido other = (EmpleadoIndefinido) obj;
		return Objects.equals(numeroPagas, other.numeroPagas) && Objects.equals(sueldoAnual, other.sueldoAnual);
	}

	@Override
	public String toString() {
		return "EmpleadoIndefinido [numeroPagas=" + numeroPagas + ", sueldoAnual=" + sueldoAnual + "]";
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}
}
