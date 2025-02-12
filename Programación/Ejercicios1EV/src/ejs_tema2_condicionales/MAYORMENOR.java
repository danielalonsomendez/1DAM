package ejs_tema2_condicionales;

import java.util.Scanner;

public class MAYORMENOR {

	public static void main(String[] args) {
		int numero1;
		int numero2;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un PRIMER NÚMERO ENTERO: ");
		numero1 = teclado.nextInt();
		System.out.println("Introduce un SEGUNDO NÚMERO ENTERO: ");
		numero2 = teclado.nextInt();
			
		if(numero1 == numero2) {
			System.out.printf("Ambos números son IGUALES: %d",numero1);
		} else if(numero1 > numero2) {
			System.out.printf("%d es MAYOR que %d",numero1,numero2);
		} else {
			System.out.printf("%d es MAYOR que %d",numero2,numero1);
		}
		
	}

}
