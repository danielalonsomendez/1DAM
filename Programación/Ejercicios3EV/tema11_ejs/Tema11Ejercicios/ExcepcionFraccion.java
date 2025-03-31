package Tema11Ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcepcionFraccion {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int numerador=0, denominador=0;
		boolean valido = true;
		do {
			try {
				System.out.print("Introduce un numerador: ");
				numerador = teclado.nextInt();
				teclado.nextLine();
				System.out.print("Introduce un denominador: ");
				denominador = teclado.nextInt();
			} catch (InputMismatchException e) {
				valido = false;
			}
		} while (valido == false);
		//try {
		System.out.println(numerador/denominador);
		//} catch(ArithmeticException e) {
			//System.out.println("No se ha podido calcular debido a que el denominador es 0");
		//}
		teclado.close();

	}

}
