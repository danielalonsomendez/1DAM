package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SACAPADW {

	public static void main(String[] args) {
		int max,suma =0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce  un NÚMERO ENTERO: ");
		max = teclado.nextInt();
		teclado.close();
		System.out.printf("Todos los NÚMEROS PARES del %s al 1: \n",max);
		max++;
		while(max !=1) {
			max--;
			if(max % 2 == 0) {
				suma = suma +max;
				System.out.printf("%s es PAR \n",max);
			}
		}
		System.out.printf("SUMA TOTAL: %s",suma);

	}

}
