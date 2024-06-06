package com.ipartek.formacion.veterinario.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoSqlite {
//	private static final String URL = "jdbc:mysql://localhost:3306/veterinario";
	private static final String URL = "jdbc:sqlite:C:\\Users\\curso.IPARTEKAULA\\git\\java-2691\\webservidor\\src\\main\\webapp\\WEB-INF\\sql\\veterinario.db";
	private static final String USER = "root";
	private static final String PASS = "admin";
	
	// Necesario para que se pueda utilizar desde Tomcat
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de SQLite", e);
		}
	}
	// Fin
	
	protected Connection conectar() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new AccesoDatosException("No ha funcionado la conexión a la base de datos", e);
		}
	}
}
