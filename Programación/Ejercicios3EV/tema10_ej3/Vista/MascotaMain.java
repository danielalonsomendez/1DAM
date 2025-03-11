package Vista;

import java.util.Scanner;

import Modelo.Gato;
import Modelo.Mascota;
import Modelo.Perro;

public class MascotaMain {

	public static void main(String[] args) {
		String tipoMascota;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.print("Introduce P (Perro) G (Gato) o N (Parar): ");
			tipoMascota = teclado.nextLine().trim().toUpperCase();;
			if (tipoMascota.equals("P")) {
				System.out.println(pedirPerro(teclado));
			} else if (tipoMascota.equals("G")) {
				System.out.println(pedirGato(teclado));

			}
		} while (tipoMascota.equals("N") == false);

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
}
