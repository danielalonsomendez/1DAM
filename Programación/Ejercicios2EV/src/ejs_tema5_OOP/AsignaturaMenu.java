package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AsignaturaMenu {


	static Scanner teclado = new Scanner(System.in);
	static Asignatura[] asignaturas = new Asignatura[100];

	public static void main(String[] args) {
		int operacion;

		do {

			operacion = menuConOpcion(
					"\nMENÚ de ASIGNATURA:\nElige una OPCIÓN: \n 1.Añadir asignatura\n 2.Buscar asignatura\n 3.Borrar asignatura\n 4.Listar array\n 5.Salir\n>");
			switch (operacion) {
			case 1:
				añadir();
				break;
			case 2:
				buscar();
				break;
			case 3:
				borrar();
				break;
			case 4:
				listar();
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			}
			teclado.nextLine();
		} while (operacion != 5);
	}

	public static int menuConOpcion(String texto) {
		int opcion;
		System.out.printf(texto);
		try {
			opcion = teclado.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Opción no válida.\n");
			teclado.nextLine();
			return menuConOpcion(texto);
		}
		return opcion;
	}

	public static int numeroArray() {
		int cantidad = 0;
		for (int i = 0; i < asignaturas.length; i++) {
			if (asignaturas[i] != null) {
				cantidad++;
			}
		}
		return cantidad;
	}

	public static void añadir() {
		String nombre;
		String codigo;
		float precio;
		int tipo;
		int posicion = numeroArray();
		if (posicion > asignaturas.length) {
			System.out.println("NO se pueden AÑADIR MÁS. Elimina uno para continuar.");
		} else {
			Asignatura nuevo = new Asignatura();
			nuevo.leer();
			asignaturas[posicion] = nuevo;
			System.out.println("Asignatura AÑADIDO correctamente!");

		}
	}

	public static void buscar() {
		int index = -1;
		int numero = numeroArray();
		Asignatura arrayBuscar = new Asignatura();
		arrayBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (arrayBuscar.equals(asignaturas[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			System.out.println(asignaturas[index]);
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}
	public static void borrar() {
		int index = -1;
		int numero = numeroArray();
		Asignatura arrayBuscar = new Asignatura();
		arrayBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (arrayBuscar.equals(asignaturas[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			asignaturas[index] = null;
			System.out.println("ELIMINADO Correctamente");
		} else {
			System.out.println("No SE HA ENCONTRADO para eliminarlo.");

		}
	}
	public static void listar() {
		for (int i = 0; i < asignaturas.length; i++) {
			if (asignaturas[i] != null) {
				System.out.println(asignaturas[i]);
			}
		}
	}

}
