package com.ipartek.formacion.veterinario.accesodatos;

import com.ipartek.formacion.veterinario.entidades.Empleado;

public class DaoEmpleadoJpa extends DaoJpa implements DaoEmpleado {
	// SINGLETON
	private DaoEmpleadoJpa() {
	}

	private static final DaoEmpleadoJpa INSTANCIA = new DaoEmpleadoJpa();

	public static DaoEmpleadoJpa getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Empleado> obtenerTodos() {
		return enTransaccionConsulta(em -> em.createQuery("select e from Empleado e", Empleado.class).getResultList());
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return enTransaccionConsulta(em -> em.find(Empleado.class, id));
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		enTransaccionActualizacion(em -> em.persist(empleado));
		return empleado;
	}

	@Override
	public Empleado modificar(Empleado empleado) {
		enTransaccionActualizacion(em -> em.merge(empleado));
		return empleado;
	}

	@Override
	public void borrar(Long id) {
		enTransaccionActualizacion(em -> em.remove(em.find(Empleado.class, id)));
	}

	@Override
	public Empleado obtenerPorNif(String nif) {
		return enTransaccionConsulta(em -> em.createQuery("select e from Empleado e where e.nif = ?", Empleado.class)
				.setParameter(1, nif).getSingleResult());
	}

}
