package ejs_tema2_repeticiones;

import java.util.Scanner;

public class TRIAFIWA {

	public static void main(String[] args) {
		int num, i = 0, z = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("n = %s", num);

		while (num >= i) {
			z = 0;
			while (i > z) {
				System.out.printf("%s ", i);
				z++;
			}
			System.out.printf("\n");
			i++;
		}

		teclado.close();

	}

}
