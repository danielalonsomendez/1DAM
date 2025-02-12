package ejs_tema2_repeticiones;

import java.util.Scanner;

public class TRIANFLO {
	public static void main(String[] args) {
		int numFilas,t=1;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO de FILAS: ");
		numFilas = teclado.nextInt();
		System.out.printf("numFilas = %s\n", numFilas);
		for (int i = 1; numFilas >= i ; i++) {
			for (int j = t; j <= t + i - 1; ++j) {
				System.out.printf("%s ",j);
			}
			System.out.printf("\n");
t = t+i;
		}
		teclado.close();

	}


}
