package ejs_tema2_condicionales;

import java.util.Scanner;

public class MAYOR3N {

	public static void main(String[] args) {
		int numero1;
		int numero2;
		int numero3;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un PRIMER NÚMERO ENTERO: ");
		numero1 = teclado.nextInt();
		System.out.printf("Introduce un SEGUNDO NÚMERO ENTERO: ");
		numero2 = teclado.nextInt();
		System.out.printf("Introduce un TERCER NÚMERO ENTERO: ");
		numero3 = teclado.nextInt();

		teclado.close();
		if(numero1 == numero2 && numero1 == numero3) {
			System.out.printf("Todos los NÚMEROS son IGUALES");
		} else if(numero1>numero2) {
			if(numero2>numero3) {
				System.out.printf("El NÚMERO mas ALTO es %d seguido de %d y %d ",numero1,numero2,numero3);
			} else {
				if(numero3>numero1) {
					System.out.printf("El NÚMERO mas ALTO es %d seguido de %d y %d ",numero3,numero1,numero2);
				} else {
					System.out.printf("El NÚMERO mas ALTO es %d seguido de %d y %d ",numero1,numero3,numero2);
				}	

			}
		} else {
			if(numero1>numero3) {
				System.out.printf("El NÚMERO mas ALTO es %d seguido de %d y %d ",numero2,numero1,numero3);
			} else {
				if(numero3>numero2) {
					System.out.printf("El NÚMERO mas ALTO es %d seguido de %d y %d ",numero3,numero2,numero1);
				} else {
					System.out.printf("El NÚMERO mas ALTO es %d seguido de %d y %d ",numero2,numero3,numero1);
				}	

			}

		} 
	}
}
