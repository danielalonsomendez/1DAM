package ejs_tema2_repeticiones;

import java.util.Scanner;

public class MAXIMINI {

	public static void main(String[] args) {
		int num;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.printf("Introduce un NÚMERO ENTERO: ");
			num = teclado.nextInt();
			if (num >= 0) {
				System.out.printf("DEL %s AL %s: \n", -num, num);
				for (var i = -num; i <= num; i++) {
					System.out.println(i);
				}
			}
		} while (num >= 0);
		teclado.close();

	}
}
