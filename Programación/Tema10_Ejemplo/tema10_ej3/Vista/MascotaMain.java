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
			System.out.println("Introduce P (Perro) G (Gato) o N (Parar)");
			tipoMascota = teclado.nextLine();
			if (tipoMascota.equals("P")) {
				System.out.println(pedirPerro(teclado));
			} else if (tipoMascota.equals("G")) {
				System.out.println(pedirGato(teclado));

			}
		} while (tipoMascota.equals("N") ==false);

	}

	public static Mascota pedirMascota(Scanner teclado) {
		int Identificador;
		String Nombre;
		int Edad;
		String DNI;
		System.out.println("Introduce el Identificador: ");
		Identificador = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el nombre: ");
		Nombre = teclado.nextLine();
		System.out.println("Introduce el Edad: ");
		Edad = teclado.nextInt();
		teclado.nextLine();
		System.out.println("Introduce el DNI: ");
		DNI = teclado.nextLine();
		return new Mascota(Identificador, Nombre, Edad, DNI);
	}

	public static Perro pedirPerro(Scanner teclado) {
		Mascota mascota = pedirMascota(teclado);
		String raza;
		boolean pulgas;
		System.out.println("Introduce la raza del perro: ");
		raza = teclado.nextLine();
		System.out.println("Introduce si tiene pulgas (Escribe SI si tiene): ");

		String pulgasN = teclado.nextLine();
		if (pulgasN.equals("SI")) {
			pulgas = true;
		} else {
			pulgas = false;
		}

		return new Perro(mascota.getIdentificador(), mascota.getNombre(), mascota.getEdad(), mascota.getDNI(), raza,
				pulgas);
	}

	public static Gato pedirGato(Scanner teclado) {
		Mascota mascota = pedirMascota(teclado);
		String color;
		char pelo;
		System.out.println("Introduce la color del gato: ");
		color = teclado.nextLine();
		System.out.println("Introduce el pelo del gato (L (largo), M (medio) o C (corto)): ");
		pelo = teclado.nextLine().charAt(0);

		return new Gato(mascota.getIdentificador(), mascota.getNombre(), mascota.getEdad(), mascota.getDNI(), color,
				pelo);
	}
}
