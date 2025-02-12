package ejs_tema2_repeticiones;

import java.util.Scanner;

public class FACTONEG {


	public static void main(String[] args) {
		int num;
		long factorial;
		Scanner teclado = new Scanner(System.in);
		do {
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
	
		if(num!=0) {
			factorial = 1;
			if(num<0) {
				num = -num;
			}
			for (long i=num;i >= 1;i--) {
				factorial *= i;
			}
			System.out.printf("El FACTORIAL es: %s \n", factorial);

		}

		} while (num != 0);
		teclado.close();

	}

}
