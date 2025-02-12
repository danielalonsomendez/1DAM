package ejs_tema2_repeticiones;

import java.util.Scanner;

public class CUADRANI {
	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("n = %s\n", num);
		for (int i = 1; num >= i; i++) {
			for (int z = 1; num >= z; z++) {
				if (num - z < i) {
					System.out.printf("%s ", z);
				} else {
					System.out.printf("%s ", 0);

				}
			}
			System.out.printf("\n");

		}
		teclado.close();

	}
}
