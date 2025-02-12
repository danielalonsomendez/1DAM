package ejs_tema6_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListNumveces {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		int numero;
		do {
			do {
				System.out.print("Introduce un NÚMERO(1-5): ");
				numero = teclado.nextInt();
			} while (numero < 0 || numero > 5);

			if (numero != 0) {
				numeros.add(numero);
			}

		} while (numero != 0);
		teclado.close();
		int[] cantidades = new int[5];

		for (int num : numeros) {
			cantidades[num - 1]++;
		}
		for (int i = 0; i < cantidades.length; i++) {
			System.out.println((i + 1) + ": " + cantidades[i]);
		}

	}

}
