package com.ipartek.formacion.veterinario.accesodatos;

// DAO: Data Access Object
// CRUD: Create Read Update Delete
public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T objeto);
	T modificar(T objeto);
	void borrar(Long id);
}
