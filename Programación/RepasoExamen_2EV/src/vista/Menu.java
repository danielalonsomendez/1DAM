package vista;

import controlador.ControladorPaises;
import modelo.Pais;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Scanner teclado = new Scanner(System.in);
	ControladorPaises controlador = new ControladorPaises();
	ArrayList<Pais> paises = new ArrayList<Pais>();

	public int elegirOpcion(Scanner teclado) {
		System.out.println("       MENÚ PAÍSES");
		System.out.println("       ------------");
		System.out.println("1. Cargar países desde fichero.");
		System.out.println("2. Cargar países desde BD.");
		System.out.println("3. Añadir país.");
		System.out.println("4. Mostrar países");
		System.out.println("5. Mostrar país por nombre.");
		System.out.println("6. Eliminar país.");
		System.out.println("7. Guardar países en BD.");
		System.out.println("8. Salir.");
		System.out.println("");
		boolean opcionCorrecta = false;
		int opcion = 0;
		do {
			try {
				System.out.print("Introduce una opcion: ");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 8) {
					System.out.println("Debes introducir un número entre 1 y 8.");
				} else {
					opcionCorrecta = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Se debe introducir un número entero.");
				teclado.nextLine();
			}
		} while (!opcionCorrecta);
		return opcion;
	}

	public void verMenu() {
		int opcion = 0;
		do {
			opcion = elegirOpcion(teclado);
			switch (opcion) {
			case 1:
				cargarPaisesFichero();
				break;
			case 2:
				cargarPaisesBD();
				break;
			case 3:
				añadirPais();
				break;
			case 4:
				mostrarPaises();
				break;
			case 5:
				mostrarPaisesNombre();
				break;
			case 6:
				eliminarPaisNombre();
				break;
			case 7:
				guardarPaisesBD();
				break;
			}
		} while (opcion != 8);
		teclado.close();
	}

	public void cargarPaisesFichero() {
		paises = controlador.cargarPaisesFichero();
		System.out.println("Paises cargados desde el fichero.");
	}

	public void cargarPaisesBD() {
		paises = controlador.cargarPaisesBBDD();
		System.out.println("Paises cargados correctamente desde la base de datos.");
	}

	public void añadirPais() {
		paises.add(pedirDatosPais(teclado));
	}

	public void mostrarPaises() {
		System.out.println("TODOS LOS PAISES");
		System.out.println("------------");
		for (int i = 0; i < paises.size(); i++) {
			System.out.println(i + ": " + paises.get(i).toString());
		}
	}

	public void mostrarPaisesNombre() {
		String nombre = pedirNombre(teclado);
		boolean busqueda = false;
		System.out.println("RESULTADOS DE BÚSQUEDA");
		System.out.println("------------");
		for (int i = 0; i < paises.size(); i++) {
			if (paises.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				System.out.println(i + ": " + paises.get(i).toString());
				busqueda = true;
			}
		}
		if (busqueda == false) {
			System.out.print("No se ha encontrado el pais a encontrar.");
		}
	}

	public void eliminarPaisNombre() {
		String nombre = pedirNombre(teclado);
		boolean eliminado = false;
		for (int i = 0; i < paises.size(); i++) {
			if (paises.get(i).getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				paises.remove(i);
				System.out.println("Pais " + nombre + " eliminado correctamente");
				eliminado = true;
			}
		}
		if (eliminado == false) {
			System.out.print("No se ha encontrado el pais a eliminar.");
		}
	}

	public boolean guardarPaisesBD() {
		boolean guardarPaises = controlador.guardarPaisesBD(paises);
		if (guardarPaises == true) {
			System.out.println("Paises guardados correctamente en la base de datos.");
		} else {
			System.out.println("Los paises no han sido guardados correctamente en la base de datos.");

		}
		return guardarPaises;
	}

	public Pais pedirDatosPais(Scanner teclado) {
		Pais pais = new Pais();
		teclado.nextLine();
		System.out.print("Introduce el código ISO del país: ");
		String ISO = teclado.nextLine();
		pais.setISO(ISO);
		System.out.print("Introduce el nombre del país: ");
		String nombre = teclado.next();
		pais.setNombre(nombre);
		teclado.nextLine();
		System.out.print("Introduce la extensión del país en km2: ");
		int extension = teclado.nextInt();
		pais.setExtension(extension);
		System.out.print("Introduce la población del país (nº habitantes): ");
		int poblacion = teclado.nextInt();
		pais.setPoblacion(poblacion);
		System.out.print("Introduce el nombre de la capital del país: ");
		String capital = teclado.next();
		pais.setCapital(capital);
		teclado.nextLine();
		System.out.print("Introduce el idioma o idiomas del país: ");
		String idioma = teclado.nextLine();
		pais.setIdioma(idioma);
		return pais;
	}

	public String pedirNombre(Scanner teclado) {
		System.out.print("Introduce el nombre del país:");
		String nombre = teclado.next();
		return nombre;
	}

}
