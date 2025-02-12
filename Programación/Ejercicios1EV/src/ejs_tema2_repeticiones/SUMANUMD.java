package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SUMANUMD {

	public static void main(String[] args) {
		int max, n = 0, suma = 0;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.printf("Introduce un NÚMERO ENTERO: ");
			max = teclado.nextInt();
		} while (max < 0);
		teclado.close();
		System.out.printf("La SUMA de todos los NÚMEROS del 1 al %s: \n", max);
		while (n != max) {
			n++;
			suma = suma + n;
			System.out.printf("%s \n", suma);
		}
		System.out.printf("La SUMA TOTAL es: %s ", suma);

	}
}
