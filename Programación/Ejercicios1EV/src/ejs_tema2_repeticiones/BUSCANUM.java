package ejs_tema2_repeticiones;

import java.util.Scanner;

public class BUSCANUM {

	public static void main(String[] args) {
		int numsecreto, ultimonum, i = 0;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.printf("Introduce un NÚMERO ENTERO entre 1 y 99: ");
			numsecreto = teclado.nextInt();
		} while (!(numsecreto >= 1 && numsecreto <= 99));
		System.out.printf("ACIERTA EL NÚMERO (entre 1 y 99): ");

		do {
			ultimonum = teclado.nextInt();
			i++;

			if (ultimonum != numsecreto) {
				if (ultimonum < numsecreto) {
					System.out.printf(
							"El NÚMERO introducido NO ES CORRECTO, es más elevado (%s intento/s). Vuelve a intentarlo: ",
							i);
				} else {
					System.out.printf(
							"El NÚMERO introducido NO ES CORRECTO, es más pequeño (%s intento/s). Vuelve a intentarlo: ",
							i);
				}
			
			} else {
				System.out.printf("El NÚMERO introducido ES CORRECTO (%s) Te ha costado %s intento/s", numsecreto,i);
			}
		} while (numsecreto != ultimonum);

		teclado.close();
	}

}
