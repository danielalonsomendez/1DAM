package ejs_tema2_repeticiones;

import java.util.Scanner;

public class RECTANUM {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("Para el número %s: \n", num);
		for (int i = 0; num >= i; i++) {
			int z = 1;
			while (num >= z) {
					System.out.printf("%s ", z-i);
		
					z++;
			}
			System.out.printf("\n");

		}
		teclado.close();

	}

}
