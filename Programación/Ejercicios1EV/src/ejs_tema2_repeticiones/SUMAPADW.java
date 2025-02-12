package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SUMAPADW {
	public static void main(String[] args) {
		int max,  suma = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		max = teclado.nextInt();
		teclado.close();
		System.out.printf("La SUMA de todos los NÚMEROS PARES del 0 al %s: \n", max);
		while (max>=1) {
			if (max % 2 == 0) {
				suma = suma + max;
				System.out.printf("%s\n", suma);
			}
			max--;

		}

	}

}
