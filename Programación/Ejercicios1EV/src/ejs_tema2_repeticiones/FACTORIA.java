package ejs_tema2_repeticiones;

import java.util.Scanner;

public class FACTORIA {

	public static void main(String[] args) {
		int max; 
		long factorial = 1;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		max = teclado.nextInt();
		teclado.close();
		while (max >= 1) {
			factorial = factorial * max;
			max--;
		}
		System.out.printf("El FACTORIAL es: %s ", factorial);

	}

}
