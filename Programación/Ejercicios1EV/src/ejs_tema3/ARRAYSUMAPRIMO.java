package ejs_tema3;

import java.util.Scanner;

public class ARRAYSUMAPRIMO {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numeroActual;
		int veces = 0;
		int numprimoacalcular = 0;
		int[] numeros = new int[30];

		System.out.printf("Introduce un NÚMERO NEGATIVO para SALIR.\n");
		do {
			System.out.printf("Introduce un NÚMERO: ");
			numeroActual = teclado.nextInt();
			if (numeroActual >= 0 && veces < numeros.length) {
				numeros[veces] = numeroActual;
				veces++;

			}
		} while (numeroActual >= 0 && veces < numeros.length);
		teclado.close();

		for (int i = 0; i < veces; i++) {
			numprimoacalcular = numprimoacalcular + numeros[i];
		}
		if(esPrimo(numprimoacalcular)) {
			System.out.printf("%s es PRIMO", numprimoacalcular);
		}	else {
			System.out.printf("%s NO es PRIMO", numprimoacalcular);
		}		

	}

	public static boolean esPrimo(int num) {
		for (int i = 2; num > i; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
