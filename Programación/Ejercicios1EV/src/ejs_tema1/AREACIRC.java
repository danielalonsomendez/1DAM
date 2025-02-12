package ejs_tema1;

import java.util.Scanner;

public class AREACIRC {

	public static void main(String[] args) {
		float radio;
		float area;
		float pi = (float)3.14;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el RADIO de un CIRCULO: ");
		radio = teclado.nextFloat();
		
		area = pi* (radio*radio);
		System.out.println("El ÁREA del CIRCULO es: ");
		System.out.println(area);


	}

}
