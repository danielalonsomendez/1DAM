package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SUMAPARW {

	public static void main(String[] args) {
		int max, n = 0, suma = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		max = teclado.nextInt();
		teclado.close();
		System.out.printf("La SUMA de todos los NÚMEROS PARES del 1 al %s: \n", max);
		while (n != max) {
			n++;
			if (n % 2 == 0) {
				suma = suma + n;
				System.out.printf("%s \n", suma);
			}
		}
		System.out.printf("La SUMA TOTAL es: %s ", suma);

	}

}
