package ejs_tema2_repeticiones;

import java.util.Scanner;

public class TRIANUFA {
	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("n = %s", num);

		for(int i = 0; num>=i;i++) {
			for(int z =1; i>=z;z++) {
		System.out.printf("%s ",z);
			}				System.out.printf("\n");

		}
		teclado.close();

	}

}
