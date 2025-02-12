package ejs_tema2_funciones;

import java.util.Scanner;

public class Primo_4 {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO: ");
		num = teclado.nextInt();
		teclado.close();
		if(esPrimo(num)) {
			System.out.printf("%s es PRIMO", num);
		}	else {
			System.out.printf("%s NO es PRIMO", num);
		}
		System.out.printf("\nPrimeros %s números primos:", num);

		ImprimeNPrimos(num);
	}
	public static void ImprimeNPrimos(int num) {
		int i = 0;
		for(int x = 2; i<num;x++) {
			if(esPrimo(x)) {
				i++;
				System.out.printf("\n%s es PRIMO", x);
			}
		}
	}
	public static boolean esPrimo(int num) {
		for (int i = 2; num > i; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
