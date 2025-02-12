package ejs_tema2_repeticiones;

import java.util.Scanner;

public class MULTN100 {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		teclado.close();

		for (int i = 1; 100 >= i; i++) {
				System.out.printf("%s x %s = %s \n", i, num,i*num);
			
		}

	}
}
