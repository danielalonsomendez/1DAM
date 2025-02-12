package ejs_tema1;

import java.util.Scanner;

public class CUBO {

	public static void main(String[] args) {
		float numero;
		double cubo;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO ENTERO: ");
		numero = teclado.nextFloat();
		cubo = Math.pow(numero, 4);
		System.out.println("El numero al CUBO es: ");
		System.out.println(cubo);

	}

}
