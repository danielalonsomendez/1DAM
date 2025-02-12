package ejs_tema2_repeticiones;

import java.util.Scanner;

public class NUMPRIMO {

	public static void main(String[] args) {
		int num;
		boolean primo = true;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		teclado.close();

		imprimirsiesprimo(num);
	}
	public static void imprimirsiesprimo(int num) {
		boolean primo = true;
		for (int i = 2; num > i; i++) {
			if (num % i == 0) {
				primo = false;
			}
		}
		if (primo == true) {
			System.out.printf("%s ES PRIMO\n", num);
		} else {
			System.out.printf("%s NO ES PRIMO\n", num);
		}
	}
}
