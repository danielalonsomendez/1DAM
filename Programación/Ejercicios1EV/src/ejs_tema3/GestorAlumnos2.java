package ejs_tema3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorAlumnos2 {

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
					"\nMENÚ GESTORALUMNO2: \n1.Añadir alumnos \n2.Ver todos los alumnos \n3.Ver un alumno\n4.Modificar alumno \n5.Borrar alumno \n6.Salir\n> ");
			try {
				operacion = teclado.nextInt();

				if (operacion == 6) {
					System.out.printf("Saliendo...");
					repetir = false;
				} else if (operacion >= 1 && operacion <= 5) {
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
					case 4:
						alumnos = modificarAlumno(teclado, alumnos);
						break;
					case 5:
						String[] nuevo = borrarAlumno(teclado, alumnos);
						if(nuevo!= null) {
							alumnos = nuevo;
						}
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

			alumnos[valoresusados + 1] = pedirDatosAlumno(teclado);
			System.out.printf("\nALUMNO AÑADIDO correctamente. (%s)\n", alumnos[valoresusados + 1]);

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
		String nombreabuscar = pideString(teclado, "el NOMBRE del alumno a buscar");
		int busquedpos = buscarAlumno(nombreabuscar,alumnos);

		if (busquedpos == -1) {
			System.out.printf("\nNO se ha ENCONTRADO ningún ALUMNO con nombre %s \n", nombreabuscar);
			return; 
		} else {
			System.out.printf("\nEncontrado en %s: %s\n", busquedpos+1, alumnos[busquedpos]);

		}
		
	}
	public static int buscarAlumno(String nombreabuscar, String[] alumnos) {
		boolean buscado = false;
		int v = -1;
		for (int i = 0; i < alumnos.length; i++) {
			String nombrearray = alumnos[i].split(",")[0].trim();
			if (nombrearray.equals(nombreabuscar)) {
				v = i;
				buscado = true;
			}
		}
		return v;
	}
	public static String[] modificarAlumno(Scanner teclado, String[] alumnos) {
		String nombreabuscar = pideString(teclado, "el NOMBRE del alumno a MODIFICAR");
		int busquedpos = buscarAlumno(nombreabuscar,alumnos);

		if (busquedpos == -1) {
			System.out.printf("\nNO se ha ENCONTRADO ningún ALUMNO con nombre %s que modificar \n", nombreabuscar);
			return null; 
		} else {
			alumnos[busquedpos] = pedirDatosAlumno(teclado);
			System.out.printf("\nALUMNO MODIFICADO correctamente. (%s)\n", alumnos[busquedpos]);
		}
		return alumnos;
	}
	public static String[] borrarAlumno(Scanner teclado, String[] alumnos) {
		String nombreaeliminar = pideString(teclado, "el NOMBRE del alumno a BORRAR");
		int busquedpos = buscarAlumno(nombreaeliminar,alumnos);

		if (busquedpos == -1) {
			System.out.printf("\nNO se ha ENCONTRADO ningún ALUMNO con nombre %s que borrar \n", nombreaeliminar);
			return null; 
		} else {
			alumnos[busquedpos] = "";
			System.out.printf("\nALUMNO con nombre %s ELIMINADO correctamente.\n", nombreaeliminar);
		}
		return alumnos;
	}
	
	public static String pedirDatosAlumno(Scanner teclado) {
		String nombre = pideString(teclado, "el NOMBRE del alumno");
		String fechanacimiento = pideString(teclado, "el FECHA de NACIMIENTO del alumno");
		int curso = pideNumero(teclado, "el CURSO del alumno");
		String ciclo = pideString(teclado, "el CICLO del alumno");
		return nombre + "," + fechanacimiento + "," + curso + "," + ciclo;
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
