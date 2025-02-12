package ejs_tema2_funciones;

import java.util.Scanner;

public class Par_1 {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);

		System.out.printf("Introduce un NÚMERO: ");
		num = teclado.nextInt();
		teclado.close();
		esPar(num);
	}
	public static void esPar(int num) {
		if (num % 2 == 0) {
			System.out.println("El NÚMERO introducido es PAR");
		} else {
			System.out.println("El NÚMERO introducido es IMPAR");
		}
	}

}
