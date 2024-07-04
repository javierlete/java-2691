package com.ipartek.formacion.veterinario.accesodatos;

import com.ipartek.formacion.veterinario.entidades.Producto;

public class DaoProductoJpa extends DaoJpa implements DaoProducto {

	@Override
	public Iterable<Producto> obtenerTodos() {
		return enTransaccionConsulta(em -> em.createQuery("select p from Producto p join fetch p.categoria", Producto.class).getResultList());
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return enTransaccionConsulta(em -> em.find(Producto.class, id));
	}

	@Override
	public Producto insertar(Producto producto) {
		enTransaccionActualizacion(em -> em.persist(producto));
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		enTransaccionActualizacion(em -> em.merge(producto));
		return producto;
	}

	@Override
	public void borrar(Long id) {
		enTransaccionActualizacion(em -> em.remove(em.find(Producto.class, id)));
	}
	
}
