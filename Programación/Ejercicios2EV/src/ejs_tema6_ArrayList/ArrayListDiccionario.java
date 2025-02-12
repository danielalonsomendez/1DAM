package ejs_tema6_ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListDiccionario {

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<String> cadenas = new ArrayList<String>();

	public static void main(String[] args) {
		int operacion;

		do {

			operacion = menuConOpcion(
					"\nMENÚ DICCIONARIO:\nElige una OPCIÓN: \n 1.Añadir palabra\n 2.Buscar palabra\n 3.Borrar palabra\n 4.Listar diccionario\n 5.Salir\n>");
			teclado.nextLine();

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
		} while (operacion != 5);
	}

	public static String pedirString() {
		System.out.print("Introduce una PALABRA: ");
		String texto = teclado.nextLine();
		return texto;
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

	public static void añadir() {
		String texto = pedirString();
		int index = cadenas.indexOf(texto);
		if (index != -1) {
			System.out.println("NO se ha podido AÑADIR por que YA existe.");
		} else {
			cadenas.add(texto);
			Collections.sort(cadenas);
			System.out.println("Cadena AÑADIDA correctamente!");
		}

	}

	public static void buscar() {
		String buscar = pedirString();
		int index = cadenas.indexOf(buscar);
		if (index != -1) {
			System.out.println(cadenas.get(index));
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}

	public static void borrar() {
		String buscar = pedirString();
		if (cadenas.remove(buscar)) {
			System.out.println("Eliminado CORRECTAMENTE!");
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}

	public static void listar() {
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));

		}
	}

}
