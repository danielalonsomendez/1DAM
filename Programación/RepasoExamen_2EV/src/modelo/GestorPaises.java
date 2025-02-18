package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorPaises {
	public ArrayList<Pais> cargarPaisesFichero() {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		File archivo = new File("paises.txt");
		try {
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] datolinea = linea.split(";");
					Pais pais = new Pais();
					pais.setISO(datolinea[0]);
					pais.setNombre(datolinea[1]);
					pais.setExtension(Integer.parseInt(datolinea[2]));
					pais.setPoblacion(Integer.parseInt(datolinea[3]));
					pais.setCapital(datolinea[4]);
					pais.setIdioma(datolinea[5]);
					paises.add(pais);
				}
			} else {
				archivo.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return paises;
	}

	public ArrayList<Pais> selectPaises() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Pais> paises = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = SQLQuerys.SELECT_TODOS_PAISES;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			paises = new ArrayList<Pais>();
			while (resultSet.next()) {
				Pais pais = new Pais(resultSet.getString("ISO"), resultSet.getString("nombre"),
						resultSet.getInt("extension"), resultSet.getInt("poblacion"), resultSet.getString("capital"),
						resultSet.getString("idioma"));
				paises.add(pais);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
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
		return paises;
	}

	public boolean eliminarPaises() {
		boolean valido = false;
		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			sentencia = conexion.prepareStatement(SQLQuerys.DELETE_PAISES);
			sentencia.executeUpdate();
			valido = true;
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexion.");
		}
		return valido;
	}

	public boolean insertarPais(Pais pais) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_PAIS + pais.getISO() + SQLQuerys.SEPARATOR + pais.getNombre()
					+ SQLQuerys.SEPARATOR + pais.getExtension() + SQLQuerys.SEPARATOR + pais.getPoblacion()
					+ SQLQuerys.SEPARATOR + pais.getCapital() + SQLQuerys.SEPARATOR + pais.getIdioma()
					+ SQLQuerys.END_BLOCK;
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
		return valido;

	}
}
