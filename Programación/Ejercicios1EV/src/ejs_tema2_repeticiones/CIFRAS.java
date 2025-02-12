package ejs_tema2_repeticiones;

import java.util.Scanner;

public class CIFRAS {


	public static void main(String[] args) {
		int cifra,cifraf;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		cifra = teclado.nextInt();
		cifraf = cifra;
		teclado.close();
		System.out.printf("%s diviido por CIFRAS: \n",cifra);
		for(int i=0; i< String.valueOf(cifraf).length();i++) {
			int c = cifra % 10;
			cifra = cifra / 10;
			
			System.out.printf("%s\n",c);
		}

	}
}
