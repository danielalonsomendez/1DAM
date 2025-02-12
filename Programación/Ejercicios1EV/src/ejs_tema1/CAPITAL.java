package ejs_tema1;

import java.util.Scanner;

public class CAPITAL {

	public static void main(String[] args) {
		float euros;
		float tipointeres;
		int dias;
		float interesproducido;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce una CANTIDAD en EUROS: ");
		euros = teclado.nextFloat();
		
		System.out.println("Introduce un TIPO de INTERÉS: ");
		tipointeres = teclado.nextFloat();
		
		System.out.println("Introduce un período de TIEMPO en DÍAS: ");
		dias = teclado.nextInt();
		
		interesproducido =(euros*tipointeres*dias)/(360*100);
		System.out.println("El INTERÉS PRODUCIDO es: ");
		System.out.println(interesproducido);

	}

}
