package ejs_tema1;

import java.util.Scanner;

public class LEERNUM1 {
	public static void main(String[] args) {
		int numero;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO ENTERO: ");
		numero = teclado.nextInt();
		numero++;
		System.out.println("El NÚMERO FINAL es: ");
		System.out.println(numero);
	
	}
}
