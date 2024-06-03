package com.ipartek.formacion.veterinario.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.ipartek.formacion.veterinario.entidades.Cita;
import com.ipartek.formacion.veterinario.entidades.Empleado;

public class DaoCitaSqlite extends DaoSqlite implements DaoCita {

	private static final String SQL_SELECT = """
			SELECT c.id AS c_id, c.inicio AS c_inicio, c.fin AS c_fin, e.id AS e_id, e.nombre AS e_nombre, e.apellidos AS e_apellidos, e.telefono AS e_telefono, e.nif AS e_nif, e.nss AS e_nss, e.sueldo_mensual AS e_sueldo_mensual
			FROM citas c
			JOIN empleados e ON c.empleado_id = e.id
			""";

	@Override
	public Iterable<Cita> obtenerTodos() {
		var citas = new ArrayList<Cita>();

		try (Connection con = conectar(); Statement st = con.createStatement();) {

			ResultSet rs = st.executeQuery(SQL_SELECT);

			Cita cita;
			Empleado empleado;

			while (rs.next()) {
				empleado = new Empleado(rs.getLong("e_id"), rs.getString("e_nombre"), rs.getString("e_apellidos"),
						rs.getString("e_nif"), rs.getString("e_telefono"), rs.getString("e_nss"),
						rs.getBigDecimal("e_sueldo_mensual"));

				cita = new Cita(rs.getLong("c_id"), LocalDateTime.parse(rs.getString("c_inicio")),
						LocalDateTime.parse(rs.getString("c_fin")), empleado, null, null, null);

				citas.add(cita);
			}

			return citas;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener las citas", e);
		}
	}

	@Override
	public Cita obtenerPorId(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	@Override
	public Cita insertar(Cita objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	@Override
	public Cita modificar(Cita objeto) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	@Override
	public void borrar(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

}
