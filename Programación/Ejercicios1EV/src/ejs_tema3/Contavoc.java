package ejs_tema3;

import java.util.Scanner;

public class Contavoc {

	public static void main(String[] args) {
		String texto;
		String[] vocales = { "a", "e", "i", "o", "u" };
		int[] vocales_veces = new int[5];

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un TEXTO con VOCALES: ");
		texto = teclado.nextLine();
		teclado.close();
		for (int i = 0; i < texto.length(); i++) {
			String charat = "" + texto.charAt(i);

			for (int z = 0; z < vocales.length; z++) {
				if (charat.equals(vocales[z])) {
					vocales_veces[z] = vocales_veces[z] + 1;
				}
			}
		}
		for (int z = 0; z < vocales.length; z++) {
			System.out.printf("Vocal %s, %s veces introducida en el texto.\n",vocales[z] ,vocales_veces[z]);

		}

	}

}
