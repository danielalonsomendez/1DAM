package ejs_tema7_Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListCadenasMenu_Ficheros {

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<String> cadenas = new ArrayList<String>();

	public static void main(String[] args) {
		guardarEnArray();
		int operacion;
		do {

			operacion = menuConOpcion(
					"\nMENÚ de CADENAS:\nElige una OPCIÓN: \n 1.Añadir string\n 2.Buscar string\n 3.Borrar string\n 4.Listar array\n 5.Salir\n>");
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
			guardarEnFichero();
		} while (operacion != 5);
	}

	public static void guardarEnArray() {
		File archivo = new File("cadenas.log");
		try {
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					cadenas.add(linea);
				}
			} else {
				archivo.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void guardarEnFichero() {
		try {
			FileWriter fichero = new FileWriter("cadenas.log");

			PrintWriter pw = new PrintWriter(fichero);
			for (int i = 0; i < cadenas.size(); i++) {
				pw.println(cadenas.get(i));
			}
			fichero.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		cadenas.add(texto);
		System.out.println("Cadena AÑADIDA correctamente!");
	}

	public static String pedirString() {
		System.out.print("Introduce una TEXTO: ");
		String texto = teclado.nextLine();
		return texto;
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
