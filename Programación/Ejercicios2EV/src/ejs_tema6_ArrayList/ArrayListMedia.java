package ejs_tema6_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMedia {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		double mediaSuma = 0;
		int numero;
		do {

			System.out.print("Introduce un NÚMERO: ");
			numero = teclado.nextInt();

			if (numero > 0) {
				numeros.add(numero);
			}

		} while (numero > 0);
		teclado.close();

		for (int num : numeros) {
			mediaSuma = mediaSuma + num;
		}
		System.out.printf("La MEDIA es: %.2f", (mediaSuma / numeros.size()));

	}

}
