package ejs_tema2_repeticiones;

import java.util.Scanner;

public class TRIANUWD {

	public static void main(String[] args) {
		int num, i = 0, z = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("n = %s\n", num);
		i = num;
		while (num >= i&& i>0) {
			z = 1;
			while (i>=z) {
				System.out.printf("%s ",z);
				z++;
			}
			System.out.printf("\n");
			i--;
		}

		teclado.close();

	}

}
