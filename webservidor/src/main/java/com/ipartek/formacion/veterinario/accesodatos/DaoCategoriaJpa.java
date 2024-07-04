package com.ipartek.formacion.veterinario.accesodatos;

import com.ipartek.formacion.veterinario.entidades.Categoria;

public class DaoCategoriaJpa extends DaoJpa implements DaoCategoria {

	@Override
	public Iterable<Categoria> obtenerTodos() {
		return enTransaccionConsulta(em -> em.createQuery("select c from Categoria c", Categoria.class).getResultList());
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		return enTransaccionConsulta(em -> em.find(Categoria.class, id));
	}

	@Override
	public Categoria obtenerPorIdConProductos(Long id) {
		return enTransaccionConsulta(em -> em.createQuery("select c from Categoria c left join fetch c.productos where c.id = :id", Categoria.class)
				.setParameter("id", id).getSingleResult());
	}

	@Override
	public Categoria insertar(Categoria categoria) {
		enTransaccionActualizacion(em -> em.persist(categoria));
		return categoria;
	}

	@Override
	public Categoria modificar(Categoria categoria) {
		enTransaccionActualizacion(em -> em.merge(categoria));
		return categoria;
	}

	@Override
	public void borrar(Long id) {
		enTransaccionActualizacion(em -> em.remove(em.find(Categoria.class, id)));		
	}

}
