package com.ipartek.formacion.veterinario.pruebas;

import com.ipartek.formacion.veterinario.accesodatos.DaoCita;
import com.ipartek.formacion.veterinario.accesodatos.DaoCitaSqlite;

public class DaoCitaSqlitePruebas {
	public static void main(String[] args) {
		DaoCita dao = new DaoCitaSqlite();
		
		for(var cita: dao.obtenerTodos()) {
			System.out.println(cita.getId());
			System.out.println(cita.getFechaHoraInicio());
			System.out.println(cita.getFechaHoraFinal());
			
			System.out.println(cita.getEmpleado().getNombre());
		}
	}
}
