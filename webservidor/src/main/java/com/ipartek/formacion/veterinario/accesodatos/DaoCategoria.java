package com.ipartek.formacion.veterinario.accesodatos;

import com.ipartek.formacion.veterinario.entidades.Categoria;

public interface DaoCategoria extends Dao<Categoria> {
	Categoria obtenerPorIdConProductos(Long id);
}
