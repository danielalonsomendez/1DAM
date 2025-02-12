package ejs_tema2_condicionales;

import java.util.Scanner;

public class MENUIF {

	public static void main(String[] args) {
		int numero1;
		int numero2;
		int noperacion;
		int resultado;

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un PRIMER NÚMERO ENTERO: ");
		numero1 = teclado.nextInt();
		System.out.printf("Introduce un SEGUNDO NÚMERO ENTERO: ");
		numero2 = teclado.nextInt();
		System.out.printf("\nELIGE UNA OPCIÓN: \n1.Sumar \n2.Restar \n3.Multiplicar \n4.Dividir \n5.Resto (%%) \n0.Salir\n");
		noperacion = teclado.nextInt();
		
		switch (noperacion) {
			case 1:
				resultado = numero1 + numero2;
				System.out.printf("Ambos NÚMEROS SUMADOS: %d",resultado);
				break;
			case 2:
				resultado = numero1 - numero2;
				System.out.printf("Ambos NÚMEROS RESTADOS: %d",resultado);
				break;		
			case 3:
				resultado = numero1 * numero2;
				System.out.printf("Ambos NÚMEROS MULTIPLICADOS: %d",resultado);
				break;	
			case 4:
				resultado = numero1 / numero2;
				System.out.printf("Ambos NÚMEROS DIVIDIDOS: %d",resultado);
				break;	
			case 5:
				resultado = numero1 % numero2;
				System.out.printf("El RESTO de ambos NÚMEROS: %d",resultado);
				break;	
			default:
		}
	}
}
