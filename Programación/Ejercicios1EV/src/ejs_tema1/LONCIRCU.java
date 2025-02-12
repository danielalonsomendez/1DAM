package ejs_tema1;

import java.util.Scanner;

public class LONCIRCU {

	public static void main(String[] args) {
		float radio;
		float circunferencia;
		float pi = (float)3.14;
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el RADIO de un CIRCULO: ");
		radio = teclado.nextFloat();
		circunferencia = radio*(pi*2);
		System.out.println("El VALOR de la CIRCUNFERENCIA es: ");
		System.out.println(circunferencia);


	}

}
