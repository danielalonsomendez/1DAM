package ejs_tema2_condicionales;

import java.util.Scanner;

public class VALORABS {

	public static void main(String[] args) {
		int numero;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO ENTERO: ");
		numero = teclado.nextInt();
		teclado.close();
		if(numero >= 0) {
			System.out.printf("El VALOR ABSOLUTO del NÚMERO introducido es %d.",numero);
		} else {
			numero = -numero;
			System.out.printf("El VALOR ABSOLUTO del NÚMERO introducido es %d.",numero);

		} 
	}

}
