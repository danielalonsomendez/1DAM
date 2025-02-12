package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SACANUDW {

	public static void main(String[] args) {
		int max;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce  un NÚMERO ENTERO: ");
		max = teclado.nextInt();
		teclado.close();
		System.out.printf("Todos los NÚMEROS del %s al 1: \n",max);
		max++;
		while(max !=1) {
			max--;
			System.out.println(max);
		}

	}
}
