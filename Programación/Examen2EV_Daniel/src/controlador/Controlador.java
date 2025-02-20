package controlador;

import java.util.ArrayList;
import modelo.Empleado;
import modelo.GestorEmpleados;

public class Controlador {

	public ArrayList<Empleado> selectEmpleados() {
		GestorEmpleados gestor = new GestorEmpleados();
		return gestor.selectEmpleados();
	}

	public ArrayList<Empleado> selectEmpleadosPuesto(String Puesto) {
		GestorEmpleados gestor = new GestorEmpleados();
		return gestor.selectEmpleadosPuesto(Puesto);
	}

	public boolean insertarEmpleado(Empleado empleado) {
		GestorEmpleados gestor = new GestorEmpleados();
		return gestor.insertarEmpleado(empleado);
	}

	public boolean eliminarEmpleadoNumero(int numEmp) {
		GestorEmpleados gestor = new GestorEmpleados();
		return gestor.eliminarEmpleadoNumero(numEmp);
	}

	public boolean guardarEmpleadosFichero() {
		GestorEmpleados gestor = new GestorEmpleados();
		return gestor.guardarEmpleadosFichero(gestor.selectEmpleados());
	}

	public boolean guardarBBDD() {
		GestorEmpleados gestor = new GestorEmpleados();
		// Elimina todos los empleados de la tabla y guarda si lo ha hecho correctamente
		boolean valido = gestor.eliminarEmpleados();
		// En caso de que se hayan eliminado correctamente,
		if (valido == true) {
			// Recorre todos los empleados del fichero y los inserta en la base de datos. 
			ArrayList<Empleado> empleados = gestor.empleadosFichero();
			for (Empleado empleado : empleados) {
				// En caso que alguno no se inserte bien para de insertar todos.
				if (valido != false) {
					valido = gestor.insertarEmpleado(empleado);
				}
			}
		}
		return valido;
	}

}
