package ejs_tema6_ArrayList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListEnterosMenu {

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Integer> numeros = new ArrayList<Integer>();

	public static void main(String[] args) {
		int operacion;

		do {
			operacion = menuConOpcion(
					"\nMENÚ de NÚMEROS:\nElige una OPCIÓN: \n 1.Añadir entero\n 2.Buscar entero\n 3.Borrar entero\n 4.Listar array\n 5.Salir\n>");
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
	public static int pedirInt() {
		System.out.print("Introduce un NÚMERO ENTERO: ");
		int texto= teclado.nextInt();
		return texto;
	}

	public static void añadir() {
		int texto =pedirInt();
		numeros.add(texto);
		System.out.println("Número AÑADIDA correctamente!");
	}

	public static void buscar() {
		int buscar =pedirInt();
		int index = numeros.indexOf(buscar);
		if (index != -1) {
			System.out.println(numeros.get(index));
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}

	public static void borrar() {
		int buscar =pedirInt();
		int index = numeros.indexOf(buscar);
		if (index != -1) {
			numeros.remove(index);
			System.out.println("Eliminado CORRECTAMENTE!");
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}

	public static void listar() {
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}
	}


}
