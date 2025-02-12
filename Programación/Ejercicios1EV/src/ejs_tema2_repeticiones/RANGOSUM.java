package ejs_tema2_repeticiones;

import java.util.Scanner;

public class RANGOSUM {

	public static void main(String[] args) {
		int num1, num2, sum = 0;
		Scanner teclado = new Scanner(System.in);

		System.out.printf("Introduce un PRIMER NÚMERO ENTERO: ");
		num1 = teclado.nextInt();
		System.out.printf("Introduce un SEGUNDO NÚMERO ENTERO: ");
		num2 = teclado.nextInt();
		teclado.close();
		if (num1 > num2) {
			for (int i = num1; i >= num2; i--) {
				sum = sum + i;
			}

		} else {
			for (int i = num1; i <= num2; i++) {
				sum = sum + i;

			}
		}
		System.out.printf("La SUMA TOTAL es: %s",sum);

	}

}
