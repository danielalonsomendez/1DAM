package ejs_tema3;

import java.util.Scanner;

public class NUMVECES {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numeroActual;
		int[] cantidadcadanumero = new int[10];
		for (int i = 0; i < cantidadcadanumero.length; i++) {
			cantidadcadanumero[i] = 0;
		}
		System.out.printf("Introduce un NÚMERO NEGATIVO para SALIR.\n");
		do {
			System.out.printf("Introduce un NÚMERO (0-9): ");
			numeroActual = teclado.nextInt();
			if (numeroActual >= 0 && numeroActual <= 9) {
				cantidadcadanumero[numeroActual]++;
			}
			else if (numeroActual > 9) {
				System.out
						.printf("\nSolo se permiten NÚMEROS del 0 al 9.\nIntroduce un NÚMERO NEGATIVO para SALIR.\n\n");
			}
		} while (numeroActual >= 0);
		teclado.close();

		System.out.printf("\nCANTIDAD de VECES que has introducido CADA NÚMERO:\n");
		for (int i = 0; i < cantidadcadanumero.length; i++) {
			System.out.printf("%s: %s \n", i, cantidadcadanumero[i]);
		}

	}

}
