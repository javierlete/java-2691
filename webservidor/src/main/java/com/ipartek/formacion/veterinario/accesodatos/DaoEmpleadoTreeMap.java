package com.ipartek.formacion.veterinario.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.veterinario.entidades.Empleado;

public class DaoEmpleadoTreeMap implements DaoEmpleado {
	protected static TreeMap<Long, Empleado> empleados = new TreeMap<>();

	@Override
	public Iterable<Empleado> obtenerTodos() {
		return empleados.values();
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return empleados.get(id);
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		Long id = empleados.size() > 0 ? empleados.lastKey() + 1L : 1L;
		empleado.setId(id);
		empleados.put(id, empleado);

		return empleado;
	}

	@Override
	public Empleado modificar(Empleado empleado) {
		empleados.put(empleado.getId(), empleado);

		return empleado;
	}

	@Override
	public void borrar(Long id) {
		if(!empleados.containsKey(id)) {
			throw new AccesoDatosException("No se ha encontrado el id a borrar: " + id);
		}
		
		empleados.remove(id);
	}

	@Override
	public Empleado obtenerPorNif(String nif) {
		// values() : Devuelve una colección con sólo los valores ya sin las claves asociadas
		// stream() : Crea un bucle for each automático que recorre cada empleado
		// filter() : Filtra los datos de los empleados según la expresión lambda
		// e -> nif.equals(e.getNif()) : Para cada empleado e comprueba si tiene un nif igual al que se busca. En la colección final, sólo quedan los que en esta expresión dan true
		// findFirst() : De todos los elementos que pueden salir del filtro sólo pedimos el primero que puede o no existir (Optional)
		// orElse() : Convertimos el optional en un valor de referencia normal, o null en el caso de que no tenga valor
		return empleados.values().stream().filter(e -> nif.equals(e.getNif()))
				.findFirst().orElse(null);

		// Clases anónimas
//		return empleados.values().stream().filter(new Predicate<Empleado>() {
//			@Override
//			public boolean test(Empleado e) {
//				return e.getNif() == nif;
//			}
//		}).findFirst().orElse(null);

		
		// Java 1.0 y 1.1
//		var predicado = new Predicado(nif);
//		return empleados.values().stream().filter(predicado).findFirst().orElse(null);
	}
	
	// Java 1.1
//	static class Predicado implements java.util.function.Predicate<Empleado> {
//		private String nif;
//		
//		public Predicado(String nif) {
//			this.nif = nif;
//		}
//		
//		@Override
//		public boolean test(Empleado e) {
//			return e.getNif() == nif;
//		}
//	}
	
}


// Java 1.0
//class Predicado implements java.util.function.Predicate<Empleado> {
//	private String nif;
//	
//	public Predicado(String nif) {
//		this.nif = nif;
//	}
//	
//	@Override
//	public boolean test(Empleado e) {
//		return e.getNif() == nif;
//	}
//}