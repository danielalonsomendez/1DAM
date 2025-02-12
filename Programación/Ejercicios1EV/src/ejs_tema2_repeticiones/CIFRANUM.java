package ejs_tema2_repeticiones;

import java.util.Scanner;

public class CIFRANUM {
	public static void main(String[] args) {
		int numero,suma=1;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("\nIntroduce un NÚMERO: ");
			numero = teclado.nextInt();
			if(numero>0 && numero <=9){
				suma = suma*10 +numero;
				System.out.printf("La SUMA es: %s",suma );
			}
		} while (numero > 0);
		teclado.close();


	}

}
