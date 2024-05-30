package com.ipartek.formacion.veterinario.pruebas;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploJdbc {

//	private static final String URL = "jdbc:mysql://localhost:3306/veterinario";
	private static final String URL = "jdbc:sqlite:sql/veterinario.db";
	private static final String USER = "root";
	private static final String PASS = "admin";

	private static final String SQL_SELECT = "SELECT * FROM empleados";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO empleados (nombre, apellidos, telefono, nif, nss, sueldo_mensual) VALUES (?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE empleados SET nombre=?, apellidos=?, telefono=?, nif=?, nss=?, sueldo_mensual=? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM empleados WHERE id = ?";

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement st = con.createStatement();
				) {
			ResultSet rs = st.executeQuery(SQL_SELECT);
			
			while (rs.next()) {
				System.out.println(rs.getString("nombre") + ", " + rs.getString("apellidos"));
			}

			Long id = 1L;

			PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);

			pst.setLong(1, id);

			rs = pst.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("nombre") + ", " + rs.getString("apellidos"));
			}

			pst = con.prepareStatement(SQL_INSERT);

			pst.setString(1, "Nuevo");
			pst.setString(2, "Nuevez");
			pst.setString(3, "941231234");
			pst.setString(4, "13243546Z");
			pst.setString(5, "5678567856785678");
			pst.setBigDecimal(6, new BigDecimal("23456"));

			int numeroRegistrosCambiados = pst.executeUpdate();

			System.out.println(numeroRegistrosCambiados);

			pst = con.prepareStatement(SQL_UPDATE);

			pst.setString(1, "Modificado");
			pst.setString(2, "Modificadez");
			pst.setString(3, "941231234");
			pst.setString(4, "13243546Z");
			pst.setString(5, "5678567856785678");
			pst.setBigDecimal(6, new BigDecimal("23456"));
			pst.setLong(7, id);

			numeroRegistrosCambiados = pst.executeUpdate();

			System.out.println(numeroRegistrosCambiados);

			pst = con.prepareStatement(SQL_DELETE);

			pst.setLong(1, id);

			numeroRegistrosCambiados = pst.executeUpdate();

			System.out.println(numeroRegistrosCambiados);
		} catch (SQLException e) {
			System.out.println("Ha habido un error con la base de datos");
		}
	}
}
