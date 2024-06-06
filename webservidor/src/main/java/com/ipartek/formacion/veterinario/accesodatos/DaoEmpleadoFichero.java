package com.ipartek.formacion.veterinario.accesodatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import com.ipartek.formacion.veterinario.entidades.Empleado;

public class DaoEmpleadoFichero extends DaoEmpleadoTreeMap implements DaoEmpleado {
	private static final String FICHERO = "veterinario.dat";

	@SuppressWarnings("unchecked")
	private static void cargar() {
		try (var ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
			empleados = (TreeMap<Long, Empleado>) ois.readObject();
		} catch (FileNotFoundException e) {
			guardar();
		} catch (ClassNotFoundException | IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero", e);
		}
	}

	private static void guardar() {
		try (var oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
			oos.writeObject(empleados);
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido escribir en el fichero", e);
		}
	}

	@Override
	public Iterable<Empleado> obtenerTodos() {
		cargar();
		return super.obtenerTodos();
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		cargar();
		return super.obtenerPorId(id);
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		var e = super.insertar(empleado);
		guardar();
		return e;
	}

	@Override
	public Empleado modificar(Empleado empleado) {
		var e = super.modificar(empleado);
		guardar();
		return e;
	}

	@Override
	public void borrar(Long id) {
		super.borrar(id);
		guardar();
	}

	@Override
	public Empleado obtenerPorNif(String nif) {
		cargar();
		return super.obtenerPorNif(nif);
	}
}
