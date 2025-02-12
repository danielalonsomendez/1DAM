package ejs_tema1;

import java.util.Scanner;

public class LEERNUM {

	public static void main(String[] args) {
		int numero;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO ENTERO: ");
		numero = teclado.nextInt();
		System.out.println("El NÚMERO INTRODUCIDO es: ");
		System.out.println(numero);
	}

}
