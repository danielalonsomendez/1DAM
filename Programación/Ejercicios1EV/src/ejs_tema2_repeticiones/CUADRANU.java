package ejs_tema2_repeticiones;

import java.util.Scanner;

public class CUADRANU {

	public static void main(String[] args) {
		int num,start =0;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("n = %s\n", num);
		for (int i = num; num >= i && i > 0; i--) {
			for (int z = 1; num >= z; z++) {
				int c = start+z;
				if(c>num) {
					c = 0;
				}
				System.out.printf("%s ", c);
			}
			start++;
			System.out.printf("\n");

		}
		teclado.close();

	}

}
