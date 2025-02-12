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

public class GestionDeLibros {
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Libro> libros = new ArrayList<Libro>();

	public static void main(String[] args) {
		guardarEnArray();
		int operacion;
		do {

			operacion = menuConOpcion(
					"\nMENÚ de LIBROS:\nElige una OPCIÓN: \n 1.Añadir libro\n 2.Buscar libro\n 3.Borrar libro\n 4.Listar libros\n 5.Salir\n>");
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
		File archivo = new File("libros.log");
		try {
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] atrb = linea.split("-");
					libros.add(new Libro(atrb[0], atrb[1], Integer.parseInt(atrb[2])));
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
			FileWriter fichero = new FileWriter("libros.log");

			PrintWriter pw = new PrintWriter(fichero);
			for (int i = 0; i < libros.size(); i++) {
				pw.println(libros.get(i));
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
		libros.add(new Libro(true));
		System.out.println("Libro AÑADIDO correctamente!");
	}

	public static String pedirTitulo() {
		System.out.printf("Introduce el TITULO del LIBRO:");
		return teclado.nextLine();
	}
	public static int buscarPosicionPorTitulo(String tituloabuscar) {
		int index = -1;
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getTitulo().equals(tituloabuscar) && index == -1) {
				index = i;
			}
		}
		return index;
	}
	public static void buscar() {
		int index = buscarPosicionPorTitulo(pedirTitulo());
		if (index != -1) {
			System.out.println(libros.get(index));
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}

	public static void borrar() {
		int index = buscarPosicionPorTitulo(pedirTitulo());
		if (index != -1) {
			libros.remove(index);
			System.out.println("Eliminado CORRECTAMENTE!");
		} else {
			System.out.println("No SE HA ENCONTRADO.");

		}
	}

	public static void listar() {
		for (int i = 0; i < libros.size(); i++) {
			System.out.println(libros.get(i));
		}
	}
}
