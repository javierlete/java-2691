package com.ipartek.formacion.veterinario.accesodatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.veterinario.entidades.Empleado;

class DaoEmpleadoTest {
	private static final Empleado EMPLEADO1 = new Empleado(1L, "Javier", "Lete", null, null, null, null);
	private static final Empleado EMPLEADO2 = new Empleado(2L, "Pepe", "Pérez", null, null, null, null);

	DaoEmpleadoTreeMap dao = new DaoEmpleadoTreeMap();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		DaoEmpleadoTreeMap.empleados.clear();
		DaoEmpleadoTreeMap.empleados.put(1L, EMPLEADO1);
		DaoEmpleadoTreeMap.empleados.put(2L, EMPLEADO2);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testObtenerTodos() {
		fail("Not yet implemented");
	}

	@Test
	void testObtenerPorId() {
		Empleado e = dao.obtenerPorId(1000L);

		assertNull(e);

		e = dao.obtenerPorId(1L);

		assertNotNull(e);
		assertEquals(EMPLEADO1, e);
	}

	@Test
	void testInsertar() {
		fail("Not yet implemented");
	}

	@Test
	void testModificar() {
		fail("Not yet implemented");
	}

	@Test
	void testBorrar() {
		dao.borrar(1L);
		
		assertEquals(1, DaoEmpleadoTreeMap.empleados.size());

		assertThrows(AccesoDatosException.class, () -> dao.borrar(10L));
	}

	@Test
	void testObtenerPorNif() {
		fail("Not yet implemented");
	}

}
