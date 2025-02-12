package ejs_tema2_condicionales;

import java.util.Scanner;

public class UNDECEN {

	public static void main(String[] args) {
		int numero;
		int unidades, decenas, centenas;

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce  un NÚMERO ENTERO: ");
		numero = teclado.nextInt();
		teclado.close();
		if (numero >= 0 && numero <= 999) {
			unidades = numero % 10;
			numero = numero / 10;
			
			decenas = numero % 10;
			numero = numero / 10;
			
			centenas = numero % 10;

			System.out.printf("Centena: %s\n", centenas);
			System.out.printf("Decena: %s\n", decenas);
			System.out.printf("Unidad: %s", unidades);
		} else {
			System.out.printf("El NÚMERO (%d) NO es VÁLIDO.", numero);
		}
	}

}
