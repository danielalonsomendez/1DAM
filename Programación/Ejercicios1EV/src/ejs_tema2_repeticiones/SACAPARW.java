package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SACAPARW {

	public static void main(String[] args) {
		int max,n =0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		max = teclado.nextInt();
		teclado.close();
		System.out.printf("Todos los NÚMEROS PARES del 1 al %s: \n",max);
		while(n!=max) {
			n++;
			if(n % 2 == 0) {
				System.out.printf("%s es PAR \n",n);

			}
		}

	}

}
