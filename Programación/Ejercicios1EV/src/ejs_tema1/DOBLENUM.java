package ejs_tema1;

import java.util.Scanner;

public class DOBLENUM {

	public static void main(String[] args) {
		int numero;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO ENTERO: ");
		numero = teclado.nextInt();
		numero = numero*2;
		System.out.println("El NÚMERO DOBLE es: ");
		System.out.println(numero);

	}

}
