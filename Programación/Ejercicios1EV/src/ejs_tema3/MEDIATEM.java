package ejs_tema3;

import java.util.Scanner;

public class MEDIATEM {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numeroActual;
		int veces = 0;
		double sumatodoslosnumeros = 0;
		double media;
		int[] temperaturas = new int[30];

		System.out.printf("Introduce -999 para SALIR.\n");
		do {
			System.out.printf("Introduce un NÚMERO: ");
			numeroActual = teclado.nextInt();
			if ( numeroActual != -999 && veces < temperaturas.length) {
				temperaturas[veces] = numeroActual; 
				veces++;
			}
		} while (numeroActual != -999 && veces < temperaturas.length);
		teclado.close();

		for (int i = 0; i < veces; i++) {
			sumatodoslosnumeros = sumatodoslosnumeros + temperaturas[i];
		}
		media = sumatodoslosnumeros / veces;
		System.out.printf("La MEDIA de TEMPERATURAS es: %s\n", media);
		System.out.printf("TEMPERATURAS MAYORES a la MEDIA:\n");
		for (int i = 0; i < veces; i++) {
			if (media < temperaturas[i]) {
				System.out.printf("%s\n",temperaturas[i]);
			}
		}
		System.out.printf("TEMPERATURAS IGUALES a la MEDIA:\n");
		for (int i = 0; i < veces; i++) {
			if (media == temperaturas[i]) {
				System.out.printf("%s\n",temperaturas[i]);
			}
		}
		System.out.printf("TEMPERATURAS MENORES a la MEDIA:\n");
		for (int i = 0; i < veces; i++) {
			if (media > temperaturas[i]) {
				System.out.printf("%s\n",temperaturas[i]);
			}
		}
	}
}
