package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Empleado;
import modelo.GestorEmpleados;

public class Controlador {
	GestorEmpleados gestor = new GestorEmpleados();

	public ArrayList<Empleado> selectEmpleados() {
		return gestor.selectEmpleados();
	}

	public void leerArchivo() throws NumberFormatException, IOException {
		gestor.leerArchivo();
	}

	public void añadirAdministrativo(String nomEmp, float salario, String titulacion) throws Exception {
		gestor.añadirAdministrativo(nomEmp, salario, titulacion);
	}

	public void añadirVendedor(String nomEmp, float salario, float comision, String contrato) throws Exception {
		gestor.añadirVendedor(nomEmp, salario, comision, contrato);
	}

	public int existeEmpleado(int numEmp) throws Exception {
		return gestor.existeEmpleado(numEmp);
	}

	public void modificarSalario(int i, float salario) throws Exception {
		gestor.modificarSalario(i, salario);
	}

	public void eliminarEmpleado(int numEmp) throws Exception {
		gestor.eliminarEmpleado(numEmp);

	}

	public void cargarenBBDD() throws SQLException, Exception {
		gestor.eliminarEmpleados();
		gestor.insertarEmpleados();

	}
}
