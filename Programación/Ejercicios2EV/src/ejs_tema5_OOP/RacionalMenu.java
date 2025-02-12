package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacionalMenu {

	static Scanner teclado = new Scanner(System.in);
	static Racional[] racionales = new Racional[100];

	public static void main(String[] args) {
		int operacion;

		do {

			operacion = menuConOpcion(
					"\nMENÚ de RACIONALES:\nElige una OPCIÓN: \n 1.Añadir racional\n 2.Buscar racional\n 3.Borrar racional\n 4.Listar array\n 5.Salir\n>");
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
		for (int i = 0; i < racionales.length; i++) {
			if (racionales[i] != null) {
				cantidad++;
			}
		}
		return cantidad;
	}

	public static void añadir() {
		int posicion = numeroArray();
		if (posicion > racionales.length) {
			System.out.println("NO se pueden AÑADIR MÁS. Elimina uno para continuar.");
		} else {
			Racional nuevo = new Racional();
			nuevo.leer();
			racionales[posicion] = nuevo;
			System.out.println("Racional AÑADIDO correctamente!");

		}
	}

	public static void buscar() {
		int index = -1;
		int numero = numeroArray();
		Racional arrayBuscar = new Racional();
		arrayBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (arrayBuscar.equals(racionales[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			System.out.println(racionales[index]);
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}
	public static void borrar() {
		int index = -1;
		int numero = numeroArray();
		Racional arrayBuscar = new Racional();
		arrayBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (arrayBuscar.equals(racionales[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			racionales[index] = null;
			System.out.println("ELIMINADO Correctamente");
		} else {
			System.out.println("No SE HA ENCONTRADO para eliminarlo.");

		}
	}
	public static void listar() {
		for (int i = 0; i < racionales.length; i++) {
			if (racionales[i] != null) {
				System.out.println(racionales[i]);
			}
		}
	}

}
