package ejs_tema2_condicionales;

import java.util.Scanner;

public class DECEMIL {
	public static void main(String[] args) {
		int numero;
		int unidades, decenas, centenas, unidadmillar, decenamillar;

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce  un NÚMERO ENTERO: ");
		numero = teclado.nextInt();
		teclado.close();
		if (numero >= 0 && numero <= 99999) {
			unidades = numero % 10;
			numero = numero / 10;

			decenas = numero % 10;
			numero = numero / 10;

			centenas = numero % 10;
			numero = numero / 10;

			unidadmillar = numero % 10;
			numero = numero / 10;
			
			decenamillar = numero % 10;

			System.out.printf("Decenas de millar: %s\n", decenamillar);
			System.out.printf("Unidades de millar: %s\n", unidadmillar);
			System.out.printf("Centena: %s\n", centenas);
			System.out.printf("Decena: %s\n", decenas);
			System.out.printf("Unidad: %s\n", unidades);

		} else {
			System.out.printf("El NÚMERO (%d) NO es VÁLIDO.", numero);
		}
	}
}
