package ejs_tema2_repeticiones;

import java.util.Scanner;

public class PRIMOCUB {
	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.printf("Introduce un NÚMERO ENTERO: ");
			num = teclado.nextInt();
			if (num >= 0) {
				if (num % 2 == 0) {
					imprimirsiesprimo(num);
				} else {
					imprimircubo(num);
				}
			}
		} while (num >= 0);
		teclado.close();

	}

	public static void imprimircubo(int num) {
		System.out.printf("El CUBO de %s es %s\n", num, num * num);
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
