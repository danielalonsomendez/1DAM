package ejs_tema3;

import java.util.Scanner;

public class MEDIANUM {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numeroActual;
		int veces =0;
		double sumatodoslosnumeros = 0;
		double media;
		int[] numeros = new int[30];
	
		System.out.printf("Introduce un NÚMERO NEGATIVO para SALIR.\n");
		do {
			System.out.printf("Introduce un NÚMERO: ");
			numeroActual = teclado.nextInt();
			if (numeroActual >= 0  && veces < numeros.length) {
				numeros[veces] =numeroActual;
				veces++;		
			}
		} while (numeroActual >= 0  && veces  < numeros.length);
		teclado.close();

		for (int i = 0; i < veces; i++) {
			sumatodoslosnumeros = sumatodoslosnumeros + numeros[i];
		}	
		media = sumatodoslosnumeros/veces;
		System.out.printf("La MEDIA es: %s\n",media);

	}

}
