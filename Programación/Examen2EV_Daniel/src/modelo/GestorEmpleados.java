package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEmpleados {

	public ArrayList<Empleado> selectEmpleado(String sql, ArrayList<String> atributos) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Empleado> empleados = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			sentencia = conexion.prepareStatement(sql);
			if (atributos != null) {
				for (int i = 0; i < atributos.size(); i++) {
					sentencia.setString(i + 1, atributos.get(i));
				}
			}
			resultSet = sentencia.executeQuery();
			empleados = new ArrayList<Empleado>();
			while (resultSet.next()) {
				Empleado empleado = new Empleado(resultSet.getInt("NumEmp"), resultSet.getString("NomEmp"),
						resultSet.getString("Puesto"), resultSet.getDouble("Salario"));
				empleados.add(empleado);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
			sentencia.close();
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar consulta con la base de datos.");
		}

		return empleados;
	}

	public ArrayList<Empleado> selectEmpleados() {
		return selectEmpleado(SQLQuerys.SELECT_TODOS_EMPLEADO, null);
	}

	public ArrayList<Empleado> selectEmpleadosPuesto(String Puesto) {
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add(Puesto);
		return selectEmpleado(SQLQuerys.SELECT_PUESTO_EMPLEADO, atributos);
	}

	public boolean insertarEmpleado(Empleado empleado) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_EMPLEADO_SINNUMEMP;
			// Si el objecto empleado tiene un numero de empleado especifico, hace el insert con el.
			if (empleado.getNumEmp() != 0) {
				sql = SQLQuerys.INSERT_EMPLEADO + empleado.getNumEmp() + SQLQuerys.SEPARATOR;
			}
			sql = sql + empleado.getNomEmp() + SQLQuerys.SEPARATOR + empleado.getPuesto() + SQLQuerys.SEPARATOR
					+ empleado.getSalario() + SQLQuerys.END_BLOCK;
			sentencia.executeUpdate(sql);
			valido = true;
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			sentencia.close();
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar inserción con la base de datos.");
		}
		return valido;
	}

	public boolean guardarEmpleadosFichero(ArrayList<Empleado> empleados) {
		boolean valido = false;
		try {
			FileWriter fichero = new FileWriter("empleados.txt");
			PrintWriter pw = new PrintWriter(fichero);
			for (Empleado empleado : empleados) {
				pw.println(empleado.getNumEmp() + ";" + empleado.getNomEmp() + ";" + empleado.getPuesto() + ";"
						+ empleado.getSalario());
			}
			fichero.close();
			valido = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valido;
	}

	public ArrayList<Empleado> empleadosFichero() {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		File archivo = new File("empleados.txt");
		try {
			// Comprueba que el archivo existe
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				// Lee el archiov linea por linea
				while ((linea = br.readLine()) != null) {
					// Seoara la linea por punto y coma
					String[] datolinea = linea.split(";");
					// Crea el objeto empleados
					Empleado empleado = new Empleado(Integer.parseInt(datolinea[0]), datolinea[1], datolinea[2],
							Double.parseDouble(datolinea[3]));
					empleados.add(empleado);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empleados;
	}

	public int eliminarEmpleado(String sql, ArrayList<String> atributos) {
		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			sentencia = conexion.prepareStatement(sql);
			if (atributos != null) {
				for (int i = 0; i < atributos.size(); i++) {
					sentencia.setString(i + 1, atributos.get(i));
				}
			}
			return sentencia.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			sentencia.close();
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar consulta con la base de datos.");
		}
		return -1;

	}
	public boolean eliminarEmpleadoNumero(int numEmp) {
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add(numEmp + "");
		int rs = eliminarEmpleado(SQLQuerys.DELETE_EMPLEADO, atributos);
		// Si no se ha eliminado por no encontrar el empleado,muestra un mensaje de error
		if (rs == 0) {
			System.out.println("No existe en la base de datos un empleado con número " + numEmp);
			return false;
		}
		return rs == 1;
	}

	public boolean eliminarEmpleados() {
		return eliminarEmpleado(SQLQuerys.DELETE_TODOS_EMPLEADOS, null) != -1 ;
	}
}
