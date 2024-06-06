package com.ipartek.formacion.veterinario.accesodatos;

import com.ipartek.formacion.veterinario.entidades.Empleado;

public interface DaoEmpleado extends Dao<Empleado> {
	Empleado obtenerPorNif(String nif);
}
