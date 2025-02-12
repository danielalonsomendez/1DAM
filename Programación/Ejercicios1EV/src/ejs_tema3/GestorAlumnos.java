package ejs_tema3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorAlumnos {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		menu(teclado);

		teclado.close();
	}

	public static void menu(Scanner teclado) {
		boolean repetir = true;
		String[] alumnos = new String[10];
		for (int i = 0; i < alumnos.length; i++) {
			alumnos[i] = "";
		}
		do {
			int operacion = 0;
			System.out.printf(
					"\nMENÚ GESTORALUMNO: \n1.Añadir alumnos \n2.Ver todos los alumnos \n3.Ver un alumno \n4.Salir\n> ");
			try {
				operacion = teclado.nextInt();

				if (operacion == 4) {
					System.out.printf("Saliendo...");
					repetir = false;
				} else if (operacion >= 1 && operacion <= 3) {
					switch (operacion) {
					case 1:
						alumnos = añadirAlumno(teclado, alumnos);
						break;
					case 2:
						verAlumnos(alumnos);
						break;
					case 3:
						verAlumno(teclado, alumnos);
						break;
					}
				}
			} catch (InputMismatchException e) {
				repetir = true;
				teclado.nextLine();
			}
		} while (repetir == true);
	}

	public static String[] añadirAlumno(Scanner teclado, String[] alumnos) {
		int valoresusados = calcularnumerodevaloresusados(alumnos);
		if (valoresusados + 1 == alumnos.length) {
			System.out.printf(
					"La lista de alumnos esta en su MÁXIMA CAPACIDAD. No es posible añadir un alumno ahora: \n");
		} else {
			String nombre = pideString(teclado, "el NOMBRE del alumno");
			String fechanacimiento = pideString(teclado, "el FECHA de NACIMIENTO del alumno");
			int curso = pideNumero(teclado, "el CURSO del alumno");
			String ciclo = pideString(teclado, "el CICLO del alumno");

			alumnos[valoresusados + 1] = nombre + "," + fechanacimiento + "," + curso + "," + ciclo;
			System.out.printf("\nALUMNO con nombre %s AÑADIDO correctamente. (%s)\n", nombre,
					alumnos[valoresusados + 1]);

		}
		return alumnos;
	}

	public static void verAlumnos(String[] alumnos) {
		int valoresusados = calcularnumerodevaloresusados(alumnos);
		if (valoresusados != -1) {
			for (int i = 0; i < alumnos.length; i++) {
				if (alumnos[i] != "")
					System.out.printf("%s: %s\n", (i + 1), alumnos[i]);
			}
		} else {
			System.out.printf("NO HAY ningún ALUMNO guardado. Añade algún alumno para realizar la operación: \n");
		}
	}

	public static void verAlumno(Scanner teclado, String[] alumnos) {
		String nombreabuscar = pideString(teclado, "el NOMBRE del alumno");
		boolean buscado = false;

		for (int i = 0; i < alumnos.length; i++) {
			String nombrearray = alumnos[i].split(",")[0].trim();
			if (nombrearray.equals(nombreabuscar)) {
				System.out.printf("\nEncontrado en %s: %s\n", i, alumnos[i]);
				buscado = true;
			}
		}
		if (buscado == false) {
			System.out.printf("\nNO se ha ENCONTRADO ningún ALUMNO con nombre %s \n", nombreabuscar);

		}
	}

	public static String pideString(Scanner teclado, String s) {
		System.out.printf("Introduce %s: ", s);
		String v = teclado.next();
		return v;
	}

	public static int pideNumero(Scanner teclado, String s) {
		int v;

		do {
			System.out.printf("Introduce %s: ", s);
			try {
				v = teclado.nextInt();
			} catch (InputMismatchException e) {
				System.out.printf("\nNO HAS introducido un NÚMERO, vuelve a intentarlo!\n");
				teclado.nextLine();
				v = -999;
			}
		} while (v == -999);
		return v;
	}

	public static int calcularnumerodevaloresusados(String[] array) {
		int val = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("") == false)
				val++;
		}
		return val;
	}
}
