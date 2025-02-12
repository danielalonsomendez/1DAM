package ejs_tema5_OOP;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ComplejoMenu {
	static Scanner teclado = new Scanner(System.in);
	static Complejo[] complejos = new Complejo[100];

	public static void main(String[] args) {
		
		int operacion;

		do {

			operacion = menuConOpcion(
					"\nMENÚ de COMPLEJOS:\nElige una OPCIÓN: \n 1.Añadir complejo\n 2.Buscar complejo\n 3.Borrar complejo\n 4.Listar array\n 5.Salir\n>");
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
		for (int i = 0; i < complejos.length; i++) {
			if (complejos[i] != null) {
				cantidad++;
			}
		}
		return cantidad;
	}

	public static void añadir() {
		int posicion = numeroArray();
		if (posicion > complejos.length) {
			System.out.println("NO se pueden AÑADIR MÁS. Elimina uno para continuar.");
		} else {
			Complejo complejoNuevo = new Complejo();
			complejoNuevo.leer();
			complejos[posicion] = complejoNuevo;
			System.out.println("Complejo AÑADIDO correctamente!");

		}
	}

	public static void buscar() {
		int index = -1;
		int numero = numeroArray();
		Complejo complejoBuscar = new Complejo();
		complejoBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (complejoBuscar.equals(complejos[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			System.out.println(complejos[index]);
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}
	public static void borrar() {
		int index = -1;
		int numero = numeroArray();
		Complejo complejoBuscar = new Complejo();
		complejoBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (complejoBuscar.equals(complejos[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			complejos[index] = null;
			System.out.println("ELIMINADO Correctamente");
		} else {
			System.out.println("No SE HA ENCONTRADO para eliminarlo.");

		}
	}
	public static void listar() {
		for (int i = 0; i < complejos.length; i++) {
			if (complejos[i] != null) {
				System.out.println(complejos[i]);
			}
		}
	}
}
