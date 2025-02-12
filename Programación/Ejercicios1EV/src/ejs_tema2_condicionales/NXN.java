package ejs_tema2_condicionales;

import java.util.Scanner;

public class NXN {
	public static void main(String[] args) {
		int numero;
		
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO: ");
		numero = teclado.nextInt();
		numero = (numero * numero);
		
		if(numero >= 100) {
		numero = numero -100;
		System.out.printf("El CUADRADO restando 100 es %d",numero);

			}
		else {
			numero = 100-numero;
			System.out.printf("Te faltan %d para que el CUADRADO llegue a 100",numero);

		}


		
	}
}
