package ud9_Ejer01_Vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ud9Ejer01_Modelo_Pojos.Alumno;
import ud9_Ejer01_Controlador.Controlador;

public class Menu {
	Controlador controlador = new Controlador();
	Scanner teclado = new Scanner(System.in);

	public int elegirOpcion(String texto) {
		int opcion;
		System.out.printf(texto);
		try {
			opcion = teclado.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Opción no válida. Debes escribir un número entre 1 y 4.\n");
			teclado.nextLine();
			return elegirOpcion(texto);
		}
		return opcion;
	}

	public Alumno pedirDatosAlumno() {
		Alumno alumno = new Alumno();
		System.out.println("Introduce el DNI del alumno:");
		alumno.setDni(teclado.next());
		teclado.nextLine();
		System.out.println("Introduce el nombre del alumno:");
		alumno.setNombre(teclado.next());
		teclado.nextLine();
		System.out.println("Introduce el apellidos del alumno:");
		alumno.setApellidos(teclado.next());
		teclado.nextLine();
		System.out.println("Introduce el grupo del alumno:");
		alumno.setGrupo(teclado.next());
		teclado.nextLine();
		System.out.println("Introduce la fecha de nacimiento del alumno (AÑO-MES-DÍA):");
		alumno.setFecNacimiento(teclado.next());
		return alumno;
	}

	public void añadirAlumno() {
		Alumno alumno = pedirDatosAlumno();
		controlador.insertarAlumno(alumno);
	}

	public void verMenu() {
		int operacion;
		do {
			operacion = elegirOpcion(
					"BIENVENIDO \nElige quien eres:\n 1.Añadir Alumno\n 2.Ver alumnos por apellido\n 3.Ver alumnos por edad\n 4.Salir\n>(1-4) ");
			switch (operacion) {
			case 1:
				añadirAlumno();
				break;
			case 2:
				// verAlumnosApellido(teclado);
				break;
			case 3:
				// verAlumnoEdad(teclado);
			}
		} while (operacion != 4);

	}

	public void actualizarAlumno() {
		System.out.println("Introduce el grupo del alumno:");
		String grupo = teclado.next();
		controlador.modificarGrupoAlumnoPorDni(grupo, "11111111A");

		ArrayList<Alumno> alumnos = null;
		alumnos = controlador.mostrarTodosAlumnos();
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
	}
}
