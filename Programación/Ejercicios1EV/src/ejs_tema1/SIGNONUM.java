package ejs_tema1;

import java.util.Scanner;

public class SIGNONUM {

	public static void main(String[] args) {
		int numero;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO ENTERO: ");
		numero = teclado.nextInt();
		numero = -numero;
		System.out.println("El NÚMERO con el SIGNO CONTRARIO es: ");
		System.out.println(numero);

	}

}
