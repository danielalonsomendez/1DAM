package vista;

import controlador.Controlador;
import modelo.Empleado;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Scanner teclado = new Scanner(System.in);
	Controlador controlador = new Controlador();

	public void verMenu() {
		int opcion = 0;
		do {
			opcion = elegirOpcion(teclado);
			switch (opcion) {
			case 1:
				mostrarTodosEmpleados();
				break;
			case 2:
				mostrarEmpleadosPuesto();
				break;
			case 3:
				añadirEmpleado();
				break;
			case 4:
				eliminarEmpleado();
				break;
			case 5:
				guardarFichero();
				break;
			case 6:
				guardarBBDD();
				break;
			}
		} while (opcion != 7);
		teclado.close();
	}

	public void mostrarTodosEmpleados() {
		System.out.println("TODOS LOS EMPLEADOS\n------------");
		mostrarEmpleados(controlador.selectEmpleados());
	}

	public void mostrarEmpleadosPuesto() {
		String puesto = pedirPuesto();
		System.out.println("TODOS LOS EMPLEADOS QUE SON " + puesto.toUpperCase()+"\n------------");
		mostrarEmpleados(controlador.selectEmpleadosPuesto(puesto));
	}
	
	public void mostrarEmpleados(ArrayList<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
	}
	public void añadirEmpleado() {
		Empleado empleado = pedirDatosEmpleado(teclado);
		if (controlador.insertarEmpleado(empleado) == true) {
			System.out.println("¡Empleado " + empleado.getNomEmp() + " añadido correctamente!");
		} else {
			System.out.println("Error al añadir empleado a la base de datos.");
		}
	}

	public void eliminarEmpleado() {
		ArrayList<Empleado> empleados = controlador.selectEmpleados();
		boolean existe = false;
		int NumEmp;
		// Pide un numero de empleado. Si no esta en la BBDD, vuelve a pedir numero
		// hasta que este.
		do {
			NumEmp = pedirNumero(teclado);
			for (Empleado empleado : empleados) {
				if (empleado.getNumEmp() == NumEmp) {
					existe = true;
				}
			}
			if (existe == false) {
				System.out.println("No existe un empleado con número " + NumEmp);
			}
		} while (existe == false);
		if (controlador.eliminarEmpleadoNumero(NumEmp) == true) {
			System.out.println("¡Empleado " + NumEmp + " eliminado correctamente!");
		} else {
			System.out.println("Error al eliminar empleado en la base de datos.");
		}
	}

	public void guardarFichero() {
		if (controlador.guardarEmpleadosFichero() == true) {
			System.out.println("¡Todos los empleados han sido guardados correctamente en el fichero empleados.txt!");
		} else {
			System.out.println("Error al guardar los empleados en un fichero.");
		}
	}

	public void guardarBBDD() {
		if (controlador.guardarBBDD() == true) {
			System.out.println("¡Todos los empleados han sido guardados correctamente en la base de datos!");
		} else {
			System.out.println("Error al guardar los empleados en la base de datos.");
		}
	}
	
	
	
	public int elegirOpcion(Scanner teclado) {
		System.out.println("       MENÚ EMPLEADOS");
		System.out.println("       --------------");
		System.out.println("1. Mostrar todos los empleados.");
		System.out.println("2. Mostrar empleado por puesto.");
		System.out.println("3. Añadir empleado.");
		System.out.println("4. Eliminar empleado");
		System.out.println("5. Guardar empleados en fichero.");
		System.out.println("6. Guardar empleados de fichero en la BD.");
		System.out.println("7. Salir.");
		System.out.println("");
		boolean opcionCorrecta = false;
		int opcion = 0;
		do {
			try {
				System.out.print("Introduzca una opcion: ");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 7) {
					System.out.println("Debe introducir un número entre 1 y 7.");
				} else {
					opcionCorrecta = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Se debe introducir un número entero.");
				teclado.nextLine();
			}
		} while (!opcionCorrecta);
		return opcion;
	}
	
	private int pedirNumero(Scanner teclado) {
		int num = -1;
		do {
			try {
				System.out.print("Número del empleado: ");
				num = teclado.nextInt();
			} catch (InputMismatchException e) {
				teclado.nextLine();
				num = -1;
			}
		} while (num < 0);
		return num;
	}

	public Empleado pedirDatosEmpleado(Scanner teclado) {
		Empleado empleado = new Empleado();
		teclado.nextLine();
		System.out.print("Introduce el nombre del empleado: ");
		String nombre = teclado.nextLine();
		empleado.setNomEmp(nombre);
		String puesto = pedirPuesto();
		empleado.setPuesto(puesto);
		float salario = 0;
		do {
			System.out.print("Introduce el salario del empleado (superior o igual a 1100€): ");
			salario = (float) teclado.nextDouble();
		} while (salario < 1100);
		empleado.setSalario(salario);

		return empleado;
	}

	public String pedirPuesto() {
		char p = 'a';
		while (p != 'G' && p != 'D' && p != 'E' && p != 'V') {
			System.out
					.print("Introduce el puesto del empleado (G (gerente), D (director), E (empleado), V (vendedor): ");
			p = teclado.next().charAt(0);
		}
		String puesto = null;
		switch (p) {
		case 'G':
			puesto = "Gerente";
			break;
		case 'D':
			puesto = "Director";
			break;
		case 'E':
			puesto = "Empleado";
			break;
		case 'V':
			puesto = "Vendedor";
		}
		return puesto;
	}

}
