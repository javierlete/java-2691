package com.ipartek.formacion.veterinario.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleado;
import com.ipartek.formacion.veterinario.accesodatos.DaoEmpleadoTreeMap;
import com.ipartek.formacion.veterinario.entidades.Empleado;

public class AccesoDatosPruebas {
	public static void main(String[] args) {
		DaoEmpleado dao = new DaoEmpleadoTreeMap();
		
		dao.insertar(new Empleado(null, "Javier", "Lete", "12345678A", "654321654", "1234123412341234", new BigDecimal(23456)));
		dao.insertar(new Empleado(null, "Pepe", "Pérez", "87654321A", "654123456", "4321432143214321", new BigDecimal(12345)));
		
		for(var e: dao.obtenerTodos()) {
			System.out.println(e);
		}
		
		System.out.println(dao.obtenerPorId(2L));
		
		System.out.println(dao.obtenerPorNif("12345678A"));
		
	}
}
