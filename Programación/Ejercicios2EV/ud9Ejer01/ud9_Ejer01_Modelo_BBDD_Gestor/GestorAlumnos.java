package ud9_Ejer01_Modelo_BBDD_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ud9Ejer01_Modelo_Pojos.Alumno;
import ud9_Ejer01_Modelo_BBDD_utils.DBUtils;
import ud9_Ejer01_Modelo_BBDD_utils.SQLQueries;

public class GestorAlumnos {

	public void actualizarAlumno(String grupo, String dni) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.UPDATE_GRUPO_ALUMNO;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, grupo);
			sentencia.setString(2, dni);
			sentencia.executeUpdate();

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
