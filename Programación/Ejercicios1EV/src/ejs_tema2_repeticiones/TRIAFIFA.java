package ejs_tema2_repeticiones;

import java.util.Scanner;

public class TRIAFIFA {
	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("n = %s", num);

		for(int i = 0; num>=i;i++) {
			for(int z = 0; i>z;z++) {
				System.out.printf("%s ",i);
			}				System.out.printf("\n");

		}
		teclado.close();

	}

}
