package Vista_EJ5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controlador_EJ5.Controlador;
import Modelo_EJ5.Gato;
import Modelo_EJ5.Mascota;
import Modelo_EJ5.Perro;

public class Menu {
	Scanner teclado = new Scanner(System.in);
	Controlador controlador = new Controlador();
	ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

	public void verMenu() {
		int opcion = 0;
		do {
			opcion = elegirOpcion(teclado);
			switch (opcion) {
			case 1:
				añadirMascota();
				break;
			case 2:
				mostrarTodasMascotas();
				break;
			case 3:
				eliminarMascota();
				break;
			case 4:
				eliminarMascotaDNI();
				break;
			case 5:
				mostrarMascotasDNI();
				break;

			}
		} while (opcion != 6);
		teclado.close();
	}
	public static ArrayList<Mascota> rellenarMascotas() {
	    Perro p1 = new Perro(1, "Lur", 6, "12345679K", "Pastor alemán", false);
	    Perro p2 = new Perro(2, "Beethove", 6, "56478936G", "San bernardo", true);
	    Perro p3 = new Perro(3, "Pongo", 8, "78965847K", "Dálmata", false);
	    Gato g1 = new Gato(1, "Baltzi", 5, "12345679K", "Blanco", 'L');
	    Gato g2 = new Gato(2, "Bola", 4, "14785469S", "Tricolor", 'C');
	    Gato g3 = new Gato(3, "Garfield", 4, "12345679K", "Marrón", 'M');

	    ArrayList<Mascota> mascotas = new ArrayList<>(Arrays.asList(g2, g1, g3, p3, p1, p2));  // Nuevo orden
	    return mascotas;
	}

	public int elegirOpcion(Scanner teclado) {
		System.out.println("       MENÚ MASCOTA");
		System.out.println("       --------------");
		System.out.println("1. Añadir mascota.");
		System.out.println("2. Mostrar mascotas");
		System.out.println("3. Eliminar mascota");
		System.out.println("4. Eliminar mascota por DNI del dueño");
		System.out.println("5. Mostrar mascotas por dueño");
		System.out.println("6. Salir.");
		System.out.println("");
		boolean opcionCorrecta = false;
		int opcion = 0;
		do {
			try {
				System.out.print("Introduzca una opcion: ");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 7) {
					System.out.println("Debe introducir un número entre 1 y 6.");
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

	public void añadirMascota() {
		String tipoMascota;
		Mascota mascota = null;
		teclado.nextLine();
		System.out.println("Introduce P (Perro) G (Gato)");
		tipoMascota = teclado.nextLine();
		if (tipoMascota.equals("P")) {
			mascota = pedirPerro(teclado);
		} else if (tipoMascota.equals("G")) {
			mascota = pedirGato(teclado);
		}

		controlador.añadirMascota(mascota);
	}

	public void mostrarTodasMascotas() {
		System.out.println("TODAS LOS MASCOTAS\n------------");
		for (Mascota mascota : mascotas) {
			System.out.println(mascota);
		}
	}

	public void mostrarMascotasDNI() {
		String DNI = pedirDNI(teclado);
		System.out.println("TODAS LOS MASCOTAS DE " + DNI + " \n------------");
		for (Mascota mascota : mascotas) {
			if (mascota.getDni().equals(DNI)) {
				System.out.println(mascota);
			}
		}
	}

	public void eliminarMascota() {
		int Identificador = pedirIdentificador(teclado);
		controlador.eliminarMascotaID(mascotas, Identificador);
	}

	public void eliminarMascotaDNI() {
		String DNI = pedirDNI(teclado);
		controlador.eliminarMascotaDNI(mascotas, DNI);
	}


	public static Mascota pedirMascota(Scanner teclado) {
		String Nombre;
		int Edad;
		String DNI;
		System.out.println("Introduce el nombre: ");
		Nombre = teclado.nextLine();
		do {
			System.out.println("Introduce el edad: ");
			Edad = teclado.nextInt();
			teclado.nextLine();
		} while (!Mascota.validarEdad(Edad));
		do {
			System.out.println("Introduce el DNI: ");
			DNI = teclado.nextLine().trim().toUpperCase();
		} while (!Mascota.validarDNI(DNI));
		return new Mascota(Nombre, Edad, DNI);
	}

	public static Perro pedirPerro(Scanner teclado) {
		Mascota mascota = pedirMascota(teclado);
		String raza;
		boolean pulgas;
		String pulgasN;
		System.out.println("Introduce la raza del perro: ");
		raza = teclado.nextLine();
		do {
		System.out.println("Introduce si tiene pulgas (Escribe SI si tiene): ");
		pulgasN = teclado.nextLine().trim().toUpperCase();
		} while (!Perro.validarPulgas(pulgasN));

		if (pulgasN.equals("SI")) {
			pulgas = true;
		} else {
			pulgas = false;
		}

		return new Perro(mascota.getIdentificador(), mascota.getNombre(), mascota.getEdad(), mascota.getDni(), raza,
				pulgas);
	}

	public static Gato pedirGato(Scanner teclado) {
		Mascota mascota = pedirMascota(teclado);
		String color;
		char pelo;
		System.out.println("Introduce la color del gato: ");
		color = teclado.nextLine();
		System.out.println("Introduce el pelo del gato (L (largo), M (medio) o C (corto)): ");
		pelo = teclado.nextLine().trim().toUpperCase().charAt(0);

		return new Gato(mascota.getIdentificador(), mascota.getNombre(), mascota.getEdad(), mascota.getDni(), color,
				pelo);
	}

	private int pedirIdentificador(Scanner teclado) {
		int num = -1;
		do {
			try {
				System.out.print("Identificador de la mascota: ");
				num = teclado.nextInt();
			} catch (InputMismatchException e) {
				teclado.nextLine();
				num = -1;
			}
		} while (num < 0);
		return num;
	}

	private String pedirDNI(Scanner teclado) {
		teclado.nextLine();
		System.out.print("Introduce DNI del dueño: ");
		return teclado.nextLine();
	}
}
