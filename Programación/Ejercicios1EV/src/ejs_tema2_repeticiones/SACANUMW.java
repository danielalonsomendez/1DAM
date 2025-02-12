package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SACANUMW {

	public static void main(String[] args) {
		int max,n=0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		max = teclado.nextInt();
		teclado.close();
		System.out.printf("Todos los NÚMEROS del 1 al %s: \n",max);
		while(n!=max) {
			n++;
			System.out.println(n);
		}

	}

}
