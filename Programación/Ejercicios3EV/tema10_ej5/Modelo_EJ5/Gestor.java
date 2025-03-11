package Modelo_EJ5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestor {
	public boolean insertar(String sql) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(sql);
			valido = true;
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return valido;	}
	
	public boolean añadirMascota(Mascota mascota) {
insertar(SQLQueries.INSERT_MASCOTA);
return true	
	}

}
