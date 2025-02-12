package ExamenDaniel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExamenDaniel {
	static Scanner teclado = new Scanner(System.in);
	static String[][] notas = new String[100][4];

	public static void main(String[] args) {
		int operacion;
		do {
			// Mostrar menu y pedir operacion, numero entre 1 y 4
			operacion = pedirNumeroIntervalo(
					"\nMENÚ VALORACIÓN PROFESORES\n--------------------------\n1- Introducir nota.\n2- Ver notas profesor.\n3- Ver nota media profesor.\n4- Salir.\nIntroduce una opción (1-4):",
					1, 4);
			switch (operacion) {
			case 1:
				introducirNota();
				break;
			case 2:
				mostrarNotasProfesor();
				break;
			case 3:
				mostrarMediaProfesor();
				break;
			case 4:
				System.out.println("Saliendo del menú valoración profesores...");
				break;
			}
		} while (operacion != 4);
		teclado.close();
	}

	public static int pedirNumeroIntervalo(String texto, int valorMin, int valorMax) {
		int opcion;
		try {
			do {
				System.out.printf(texto);
				opcion = teclado.nextInt();
				if (opcion < valorMin || opcion > valorMax) {
					System.out.printf("Opción no válida. Tiene que ser un número entre %s y %s.\n", valorMin, valorMax);
				}
			} while (opcion < valorMin || opcion > valorMax);
		} catch (InputMismatchException e) {
			System.out.println("Opción no válida. Tiene que ser un número.");
			teclado.nextLine();
			return pedirNumeroIntervalo(texto, valorMin, valorMax);
		}
		return opcion;
	}

	public static void introducirNota() {
		String nombreProfesor;
		String codigoAlumno;
		String nota;
		String observaciones;
		int posicionNuevo = 0;
		for (int i = 0; i < notas.length; i++) {
			if (notas[i][0] != null) {
				posicionNuevo++;
			}
		}
		if (posicionNuevo > notas.length) {
			System.out.println(
					"NO se pueden AÑADIR MÁS NOTAS porque se ha alcanzado el NÚMERO MÁXIMO de NOTAS que se pueden guardar en el sistema.");
		} else {
			teclado.nextLine();
			codigoAlumno = pedir("codigoAlumno");
			nombreProfesor = pedir("profesor");
			nota = pedir("nota");
			teclado.nextLine();
			observaciones = pedir("observaciones");
			int posicionNota = buscarNota(nombreProfesor, codigoAlumno);
			if (posicionNota != -1) {
				modificar(posicionNota, codigoAlumno, nombreProfesor);
			} else {
				guardarNota(posicionNuevo, codigoAlumno, nombreProfesor, nota, observaciones);
				System.out.printf("Nota al profesor %s GUARDADA correctamente!", nombreProfesor);
			}

		}
	}

	public static String pedir(String devolver) {
		if (devolver == "codigoAlumno" || devolver == "observaciones" || devolver == "profesor") {
			String mensajeImprimir = "";
			String texto;
			do {
				switch (devolver) {
				case "codigoAlumno":
					mensajeImprimir = "Introduce tu CÓDIGO SECRETO de ALUMNO";
					break;
				case "observaciones":
					mensajeImprimir = "Introduce unas OBSERVACIONES al PROFESOR";
					break;
				case "profesor":
					mensajeImprimir = "Introduce el NOMBRE del PROFESOR";
					break;
				}
				System.out.printf(mensajeImprimir + ":");
				texto = teclado.nextLine();
			} while (texto.equals("") || texto.equals(" "));
			return texto;
		} else {
			return pedirNumeroIntervalo("Introduce la NOTA:", 0, 10) + "";
		}

	}

	public static int buscarNota(String nombreProfesor, String codigoAlumno) {
		int posicionNota = -1;
		// En caso de que nos haya proporcionado codigoAlumno, verificara que la nota es
		// del mismo profesor y del mismo alumno.
		// En caso de que no nos haya proporcionado codigoAlumno, solo verificara si la
		// nota es del mismo profesor.
		for (int i = 0; i < notas.length; i++) {
			if (notas[i][0] != null && nombreProfesor.toLowerCase().equals(notas[i][1])) {
				if (codigoAlumno == null || (codigoAlumno.toLowerCase().equals(notas[i][0]) && posicionNota == -1)) {
					posicionNota = i;
				}
			}
		}
		// En caso de no encontrar ninguna nota con esa busqueda, devuelve -1
		return posicionNota;
	}

	public static void modificar(int nuevaPosicion, String codigoAlumno, String nombreProfesor) {
		int opcionModificar;
		String nota;
		String observaciones;
		do {
			opcionModificar = pedirNumeroIntervalo(
					"\nYa existe una NOTA TUYA para este profesor. ¿Deseas modificarla?\n1- SI modificar\n2- NO modificar \nIntroduce una opción (1/2):",
					1, 2);

			switch (opcionModificar) {
			case 1:
				System.out.println("Vuelve a introducir la NOTA y las OBSERVACIONES");
				nota = pedir("nota");
				teclado.nextLine();
				observaciones = pedir("observaciones");
				guardarNota(nuevaPosicion, codigoAlumno, nombreProfesor, nota, observaciones);
				System.out.printf("Nota al profesor %s MODIFICADA correctamente!", nombreProfesor);
				break;
			case 2:
				System.out.printf("Tu operación ha sido cancelada. Volviendo al menú principal.\n");
				break;
			}
		} while (opcionModificar != 1 && opcionModificar != 2);
	}

	public static void guardarNota(int posicion, String codigoAlumno, String nombreProfesor, String nota,
			String observaciones) {
		notas[posicion][0] = codigoAlumno.toLowerCase();
		notas[posicion][1] = nombreProfesor.toLowerCase();
		notas[posicion][2] = nota;
		notas[posicion][3] = observaciones;
	}

	public static void mostrarNotasProfesor() {
		notasProfesor("lista");
	}

	public static void mostrarMediaProfesor() {
		notasProfesor("media");
	}

	public static void notasProfesor(String mostrar) {
		teclado.nextLine();
		String nombreProfesor = pedir("profesor");
		int hayNotas = buscarNota(nombreProfesor, null);
		if (hayNotas != -1) {
			float sumaNotas = 0;
			int cantidadNotas = 0;
			if (mostrar == "lista") {
				System.out.printf("\nLISTA DE NOTAS AL PROFESOR %s:\n%-10s %-20s \n", nombreProfesor, "NOTA",
						"OBSERVACIONES");
			}
			for (int i = 0; i < notas.length; i++) {
				int nota = solicitarNota(i, nombreProfesor.toLowerCase());
				if (nota != -1) {
					if (mostrar == "lista") {
						System.out.printf("%-10s %-20s \n", nota, notas[i][3]);
					} else if (mostrar == "media") {
						sumaNotas = sumaNotas + nota;
						cantidadNotas++;
					}
				}
			}
			if (mostrar == "media") {
				System.out.printf("\nMEDIA PROFESOR %s:\n%s ALUMNO(S) le ha(n) asignado una NOTA\nLa MEDIA es %.1f\n",
						nombreProfesor, cantidadNotas, (sumaNotas / cantidadNotas));
			}
		} else {
			System.out.printf("NO se ha ASIGNADO ninguna NOTA al profesor %s.\n", nombreProfesor);
		}
	}

	public static int solicitarNota(int posicionNota, String nombreProfesor) {
		if (notas[posicionNota][0] != null && notas[posicionNota][1].equals(nombreProfesor)) {
			int nota = Integer.parseInt(notas[posicionNota][2]);
			if (!(nota < 1 || nota > 10)) {
				return nota;
			}
		}
		return -1;

	}

}
