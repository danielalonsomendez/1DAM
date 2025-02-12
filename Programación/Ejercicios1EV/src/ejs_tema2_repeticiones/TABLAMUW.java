package ejs_tema2_repeticiones;

import java.util.Scanner;

public class TABLAMUW {

	public static void main(String[] args) {
		int mult;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.printf("Introduce un NÚMERO ENTERO: ");
			mult = teclado.nextInt();
			if (mult != 0) {
				System.out.printf("n = %s\n", mult);
				ImprimirTablaMultiplicar(mult);
			}
		} while (mult != 0);
		teclado.close();

	}
	public static void ImprimirTablaMultiplicar(int mult) {
		for (int n = 1; n <= 10; n++) {
			System.out.printf("%s x %s = %s\n", mult, n, (mult * n));
		}
	}
}
