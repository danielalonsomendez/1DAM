package ejs_tema2_repeticiones;

import java.util.Scanner;

public class NUMPRIMOIMPAR {

	public static void main(String[] args) {
		int num;
		boolean primo = true;

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		teclado.close();

		if (num != 2 && (num % 2 == 0 || num <= 1)) {
			primo = false;
		}
		for (int i = 3; num > i; i = i + 2) {
			if (num % i == 0) {
				primo = false;
			}
		}

		if (primo == true) {
			System.out.printf("%s ES PRIMO", num);
		} else {
			System.out.printf("%s NO ES PRIMO", num);
		}

	}

}
