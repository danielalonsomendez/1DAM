package ejs_tema2_repeticiones;

import java.util.Scanner;

public class N10PARES {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);

		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		teclado.close();

		for (var i = 0; i <= 10;) {
			num++;
			if (num % 2 == 0) {
				i++;
				System.out.printf("%s es PAR\n", num);

			}
		}

	}

}
