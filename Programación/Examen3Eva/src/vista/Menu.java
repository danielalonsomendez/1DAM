package vista;

import controlador.Controlador;
import modelo.Administrativo;
import modelo.Empleado;
import modelo.Vendedor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Scanner teclado = new Scanner(System.in);
	Controlador controlador = new Controlador();

	public int elegirOpcion(Scanner teclado) {
		System.out.println("       MENÚ EMPLEADOS");
		System.out.println("       ------------");
		System.out.println("1. Mostrar empleados por puesto.");
		System.out.println("2. Añadir empleado.");
		System.out.println("3. Modificar salario de empleado");
		System.out.println("4. Eliminar empleado.");
		System.out.println("5. Salir.");
		System.out.println("");
		boolean opcionCorrecta = false;
		int opcion = 0;
		do {
			try {
				System.out.print("Introduzca una opcion: ");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 5) {
					System.out.println("Debe introducir un número entre 1 y 5.");
				} else {
					opcionCorrecta = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Debe introducir un número entero.");
				teclado.nextLine();
			}
		} while (!opcionCorrecta);
		return opcion;
	}

	public void verMenu() {
		// Se debe cargar el ArrayList con los datos del fichero antes de mostrar el
		// menú
		cargarArchivo();

		int opcion = 0;
		do {
			opcion = elegirOpcion(teclado);
			switch (opcion) {
			case 1:
				mostrarEmpleadosPuesto();
				break;
			case 2:
				añadirEmpleado();
				break;
			case 3:
				modificarSalario();
				break;
			case 4:
				eliminarEmpleado();
				break;
			case 5:
				cargarenBBDD();
				break;
			}
		} while (opcion != 5);
		teclado.close();
	}

	public void cargarArchivo() {
		try {
			controlador.leerArchivo();
		} catch (NumberFormatException e) {
			System.out.println("No ha sido posible leer el archivo.");
		} catch (IOException e) {
			System.out.println("No ha sido posible leer el archivo.");
		}
	}

	public void mostrarEmpleadosPuesto() {
		String tipoEmpleado = pedirTipoEmpleado(teclado) + "";
		for (Empleado empleado : controlador.selectEmpleados()) {
			// Si es A, comprueba que el objecto es Administrativo. Si es V, comprueba que
			// sea Vendedor.
			if ((tipoEmpleado.equals("A") && empleado instanceof Administrativo)
					|| (tipoEmpleado.equals("V") && empleado instanceof Vendedor)) {
				System.out.println("Número:" + empleado.getNumEmp() + ". " + empleado);
			}
		}
	}

	public void añadirEmpleado() {
		String tipoEmpleado = pedirTipoEmpleado(teclado) + "";
		
		teclado.nextLine();
		System.out.print("Introduzca el nombre del empleado: ");
		String nombre = teclado.nextLine();
		float salario = pedirSalario(teclado);
		
		if (tipoEmpleado.equals("A")) {
			
			teclado.nextLine();
			System.out.print("Introduzca la titulación empleado: ");
			String titulacion = teclado.nextLine();
			
			try {
				controlador.añadirAdministrativo(nombre, salario, titulacion);
			} catch (Exception e) {
				System.out.println("No se ha podido añadir el empleado");
			}
		} else if (tipoEmpleado.equals("V")) {
			
			float comision = pedirComision(teclado);
			String contratol = pedirTipoContrato(teclado) + "";
			
			try {
				controlador.añadirVendedor(nombre, salario, comision, contratol);
			} catch (Exception e) {
				System.out.println("No se ha podido añadir el empleado");
			}
		}
		System.out.println("¡Empleado añadido correctamente!");
	}
	private int seleccionarEmpleado() {
		for (Empleado empleado : controlador.selectEmpleados()) {
			System.out.println("Número:" + empleado.getNumEmp() + ". " + empleado);
		}
		int numeroEmpleado = 0;
		int intentos = 0;
		do {
			if (intentos != 0)
				System.out.println("No existe ese número de empleado.");

			try {
				numeroEmpleado = controlador.existeEmpleado(pedirNumEmpleado(teclado));
			} catch (Exception e) {
				System.out.println("No se ha podido seleccionar el empleado");
			}
			intentos++;
		} while (numeroEmpleado == -1);
		return numeroEmpleado;
	}
	private void modificarSalario() {
		int numEmp = seleccionarEmpleado();
		float salario = pedirSalario(teclado);
		
		try {
			controlador.modificarSalario(numEmp, salario);
		} catch (Exception e) {
			System.out.println("No se ha podido modificar el salario");
		}
		System.out.println("¡Salario modificado correctamente!");

	}

	private void eliminarEmpleado() {
		int numEmp = seleccionarEmpleado();
		teclado.nextLine();
		try {
			controlador.eliminarEmpleado(numEmp);
		} catch (Exception e) {
			System.out.println("No se ha podido eliminar el empleado");
		}
		System.out.println("¡Empleado eliminado correctamente!");

	}

	
	
	private void cargarenBBDD() {
		try {
			controlador.cargarenBBDD();
		} catch (SQLException e) {
			System.out.println("No se ha podido guardar en la base de datos");
		} catch (Exception e) {
			System.out.println("No se ha podido guardar en la base de datos");
		}
	}
	
	// MÉTODOS PROPORCIONADOS //
	public char pedirTipoEmpleado(Scanner teclado) {
		char tipo;
		do {
			System.out.print("Introduzca el tipo de empleado (A=administrativo, V=vendedor): ");
			tipo = teclado.next().charAt(0);
			if (tipo != 'A' && tipo != 'V') {
				System.out.println("Se debe introducir una A (administrativo) o una V (vendedor).");
			}
		} while (tipo != 'A' && tipo != 'V');
		return tipo;
	}

	public float pedirSalario(Scanner teclado) {
		float salario = 0;
		boolean salarioCorrecto = false;
		do {
			try {
				System.out.print("Introduzca el salario: ");
				salario = teclado.nextFloat();
				if (salario < 1100) {
					System.out.println("El salario debe ser al menos 1100 €.");
				} else {
					salarioCorrecto = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Se debe introducir un número con decimales.");
				teclado.nextLine();
			}
		} while (!salarioCorrecto);
		return salario;
	}

	public float pedirComision(Scanner teclado) {
		float comision = 0;
		boolean comisionCorrecta = false;
		do {
			try {
				System.out.print("Introduzca la comisión: ");
				comision = teclado.nextFloat();
				if (comision < 0) {
					System.out.println("La comisión no puede ser negativa.");
				} else {
					comisionCorrecta = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Se debe introducir un número con decimales.");
				teclado.nextLine();
			}
		} while (!comisionCorrecta);
		return comision;
	}

	public char pedirTipoContrato(Scanner teclado) {
		char tipo;
		do {
			System.out.print("Introduzca el tipo de contrato (I=indefinido, T=temporal, F=fijo discontinuo: ");
			tipo = teclado.next().charAt(0);
			if (tipo != 'I' && tipo != 'T' && tipo != 'F') {
				System.out.println("Se debe una I (indefinido), una T (temporal) o una F (fijo discontinuo).");
			}
		} while (tipo != 'I' && tipo != 'T' && tipo != 'F');
		return tipo;
	}

	private int pedirNumEmpleado(Scanner teclado) {
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

}
