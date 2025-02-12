package ejs_tema2_funciones;

import java.util.Scanner;

public class Potencia_8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int exponente = 0;
		int base;
		do {
			base = pideNúmero(teclado, "la BASE");
			exponente = pideNúmero(teclado, "el EXPONENTE");
			if (exponente > 0) {
				int potencia = potencia(base, exponente);
				System.out.printf("La POTENCIA es %s\n",potencia);
			}
		} while (exponente > 0);
		teclado.close();
	}

	public static int potencia(int base, int exponente) {
		int potencia = 1;
		for (int i = 0; i < exponente; i++) {
			potencia = potencia * base;
		}
		return potencia;
	}

	public static int pideNúmero(Scanner teclado, String nombre) {
		System.out.printf("Introduce %s: ", nombre);
		int num = teclado.nextInt();
		return num;
	}
}
