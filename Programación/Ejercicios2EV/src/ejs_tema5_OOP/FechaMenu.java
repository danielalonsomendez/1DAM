package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FechaMenu {


	static Scanner teclado = new Scanner(System.in);
	static Fecha[] fechas = new Fecha[100];

	public static void main(String[] args) {
		int operacion;

		do {

			operacion = menuConOpcion(
					"\nMENÚ de FECHA:\nElige una OPCIÓN: \n 1.Añadir fecha\n 2.Buscar fecha\n 3.Borrar fecha\n 4.Listar array\n 5.Salir\n>");
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
		for (int i = 0; i < fechas.length; i++) {
			if (fechas[i] != null) {
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
		if (posicion > fechas.length) {
			System.out.println("NO se pueden AÑADIR MÁS. Elimina uno para continuar.");
		} else {
			Fecha nuevo = new Fecha();
			nuevo.leer();
			fechas[posicion] = nuevo;
			System.out.println("Fecha AÑADIDO correctamente!");

		}
	}

	public static void buscar() {
		int index = -1;
		int numero = numeroArray();
		Fecha arrayBuscar = new Fecha();
		arrayBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (arrayBuscar.equals(fechas[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			System.out.println(fechas[index]);
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}
	public static void borrar() {
		int index = -1;
		int numero = numeroArray();
		Fecha arrayBuscar = new Fecha();
		arrayBuscar.leer();
		for (int i = 0; i < numero; i++) {
			if (arrayBuscar.equals(fechas[i]) && index == -1) {
				index = i;
			}
		}
		if (index != -1) {
			fechas[index] = null;
			System.out.println("ELIMINADO Correctamente");
		} else {
			System.out.println("No SE HA ENCONTRADO para eliminarlo.");

		}
	}
	public static void listar() {
		for (int i = 0; i < fechas.length; i++) {
			if (fechas[i] != null) {
				System.out.println(fechas[i]);
			}
		}
	}


}
