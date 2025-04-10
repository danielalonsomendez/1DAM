package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorEmpleados {
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	public ArrayList<Empleado> selectEmpleados() {
		return empleados;
	}
	public void leerArchivo() throws NumberFormatException, IOException {
		File archivo = new File("empleados.txt");
		try {
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] atributos = linea.split(": ");
					String tipo = atributos[0], nomEmp = atributos[1];
					float salario = Float.parseFloat(atributos[2]);
					if (tipo.equals("Administrativo")) {
						String titulacion = atributos[3];
						empleados.add(new Administrativo(nomEmp, salario, titulacion));
					} else if (tipo.equals("Vendedor")) {
						float comisión = Float.parseFloat(atributos[3]);
						String contrato = atributos[4];
						empleados.add(new Vendedor(nomEmp, salario, comisión, contrato));
					}
				}
				br.close();

			}

		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		} catch (IOException e) {
			throw new IOException(e);
		}
	}
	public int existeEmpleado(int numEmp) throws Exception {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getNumEmp() == numEmp) {
				return i;
			}
		}
		return -1;
	}
	public void modificarSalario(int i, float salario) throws Exception {
		empleados.get(i).setSalario(salario);
	}
	public void eliminarEmpleado(int numEmp) throws Exception {
		empleados.remove(numEmp);
	}
	public void añadirAdministrativo(String nomEmp, float salario, String titulacion) throws Exception {
		empleados.add( new Administrativo(nomEmp, salario, titulacion));
	}

	public void añadirVendedor(String nomEmp, float salario, float comisión, String contrato) throws Exception {
		switch (contrato) {
		case "I":
			contrato = "Indefinido";
		case "T":
			contrato = "Temporal";
		case "F":
			contrato = "Fijo discontinuo";
		}
		empleados.add(new Vendedor(nomEmp, salario, comisión, contrato));
	}

	public void insertar(String sql) throws SQLException, Exception {

		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate(sql);
			sentencia.close();
			conexion.close();
		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public void eliminarEmpleados() throws SQLException, Exception {
		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			PreparedStatement sentencia = conexion.prepareStatement(SQLQuerys.DELETE_TODOS_EMPLEADOS);
			sentencia.executeUpdate();
			sentencia.close();
			conexion.close();
		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (Exception e) {
			throw new Exception(e);

		}

	}

	public void insertarEmpleados() throws SQLException, Exception {
		for (Empleado empleado : empleados) {
			String datoscomunes = empleado.getNumEmp() + SQLQuerys.SEPARATOR + empleado.getNomEmp()
					+ SQLQuerys.SEPARATOR + empleado.getSalario();
			if (empleado instanceof Administrativo) {
				insertar(SQLQuerys.INSERT_ADMINISTRATIVO + datoscomunes + SQLQuerys.SEPARATOR
						+ ((Administrativo) empleado).getTitulacion() + SQLQuerys.END_BLOCK);
			} else if (empleado instanceof Vendedor) {
				insertar(SQLQuerys.INSERT_VENDEDOR + datoscomunes + SQLQuerys.SEPARATOR + ((Vendedor) empleado).getComision()
						+ SQLQuerys.SEPARATOR + ((Vendedor) empleado).getContrato() + SQLQuerys.END_BLOCK);
			}
		}

	}

}
