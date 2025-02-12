package ejs_tema2_repeticiones;

import java.util.Scanner;

public class TRIACOFD {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("n = %s\n", num);
		for (int i = num; num >= i && i > 0; i--) {
			for (int z = 0; i > z; z++) {
				System.out.printf("%s ", i- z);
			}
			System.out.printf("\n");

		}
		teclado.close();

	}

}
