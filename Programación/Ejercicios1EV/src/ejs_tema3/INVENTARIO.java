package ejs_tema3;

import java.util.Scanner;

public class INVENTARIO {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		menu(teclado);

		teclado.close();
	}

	public static void menu(Scanner teclado) {
		boolean repetir = true;
		String[] inventario = new String[10];
		for (int i = 0; i < inventario.length; i++) {
			inventario[i] = "";
		}
		do {
			int operacion = 0;
			System.out.printf(
					"\nMENÚ INVENTARIO: \n1.Añadir producto \n2.Mostrar todos los productos \n3.Buscar producto \n4.Eliminar producto \n5.Salir\n> ");
			operacion = teclado.nextInt();
			if (operacion == 5) {
				System.out.printf("Saliendo...");
				repetir = false;
			} else if (operacion >= 1 && operacion <= 4) {
				switch (operacion) {
				case 1:
					inventario = Añadirproducto(teclado, inventario);
					break;
				case 2:
					Mostrartodos(inventario);
					break;
				case 3:
					BuscarProducto(teclado, inventario);
					break;
				case 4:
					inventario = EliminarProducto(teclado, inventario);
					break;
				}
			}

		} while (repetir == true);
	}

	public static String[] Añadirproducto(Scanner teclado, String[] inventario) {
		int valoresusados = calcularnumerodevaloresusados(inventario);
		if (valoresusados + 1 == inventario.length) {
			System.out.printf(
					"El INVENTARIO esta en su MÁXIMA CAPACIDAD. No es posible añadir un producto. Elimina alguno para continuar: \n");
		} else {
			var nombre = pideNombre(teclado);
			inventario[valoresusados + 1] = nombre;
			System.out.printf("\nPRODUCTO con nombre %s AÑADIDO correctamente.\n", nombre);

		}
		return inventario;
	}

	public static void Mostrartodos(String[] inventario) {
		int valoresusados = calcularnumerodevaloresusados(inventario);
		if (valoresusados != -1) {
			for (int i = 0; i < inventario.length; i++) {
				if (inventario[i] != "")
					System.out.printf("%s: %s\n", (i + 1), inventario[i]);
			}
		} else {
			System.out.printf("El INVENTARIO esta VACIO. Añade algún producto para realizar la operación: \n");
		}
	}

	public static void BuscarProducto(Scanner teclado, String[] inventario) {
		String nombreabuscar = pideNombre(teclado);
		boolean buscado = false;

		for (int i = 0; i < inventario.length; i++) {

			if (inventario[i].equals(nombreabuscar)) {
				System.out.printf("\nEncontrado en %s: %s\n", i, inventario[i]);
				buscado = true;
			}
		}
		if (buscado == false) {
			System.out.printf("\nNO se ha ENCONTRADO ningún PRODUCTO con nombre %s \n", nombreabuscar);

		}
	}

	public static String[] EliminarProducto(Scanner teclado, String[] inventario) {
		String nombreaeliminar = pideNombre(teclado);
		boolean eliminado = false;
		for (int i = 0; i < inventario.length; i++) {
			if (inventario[i].equals(nombreaeliminar) && eliminado == false) {
				inventario[i] = "";
				eliminado = true;
			}
		}
		if (eliminado == true) {
			System.out.printf("\nPRODUCTO con nombre %s ELIMINADO correctamente.\n", nombreaeliminar);
		} else {
			System.out.printf("\nNO se ha ENCONTRADO un PRODUCTO con nombre %s para eliminar\n", nombreaeliminar);

		}
		return inventario;
	}

	public static String pideNombre(Scanner teclado) {
		System.out.printf("Introduce el NOMBRE del PRODUCTO: ");
		String v = teclado.next();
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
