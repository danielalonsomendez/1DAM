package ud9_Ejer05_Modelo_BBDD_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ud9Ejer05_Modelo_Pojos.Alumno;
import ud9_Ejer05_Modelo_BBDD_utils.DBUtils;
import ud9_Ejer05_Modelo_BBDD_utils.SQLQueries;

public class GestorAlumnos {

	public void insertarAlumno(Alumno alumno) {
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			String sql = SQLQueries.INSERT_ALUMNO + alumno.getDni() + SQLQueries.SEPARATOR + alumno.getNombre()
					+ SQLQueries.SEPARATOR + alumno.getApellidos() + SQLQueries.SEPARATOR + alumno.getGrupo()
				+ SQLQueries.END_BLOCK;
			sentencia.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
	}

	public ArrayList<Alumno> buscarTodosAlumnos() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Alumno> alumnos = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_TODOS_ALUMNOS;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			alumnos = new ArrayList<Alumno>();

			while (resultSet.next()) {
				Alumno alumno = new Alumno();
				alumno.setDni(resultSet.getString("dni"));
				alumno.setNombre(resultSet.getString("nombre"));
				alumno.setApellidos(resultSet.getString("apellidos"));
				alumno.setGrupo(resultSet.getString("grupo"));
				alumnos.add(alumno);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return alumnos;
	}
}
