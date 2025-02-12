package ejs_tema2_funciones;

import java.util.Scanner;

public class Calculadora_5 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean repetir;
		do {
			repetir = menu(teclado);
		} while (repetir == true);
		teclado.close();

	}

	public static boolean menu(Scanner teclado) {
		int operacion = 0;
		double resultado = 0;
		System.out.printf("MENÚ CALCULADORA: \n1.Sumar \n2.Restar \n3.Multiplicar \n4.Dividir \n5.Salir\n> ");
		operacion = teclado.nextInt();
		if (operacion == 5) {
			System.out.printf("Saliendo...");
			return false;
		} else if (operacion >= 1 && operacion <= 4) {
			switch (operacion) {
			case 1:
				resultado = suma(teclado);
				break;
			case 2:
				resultado = restar(teclado);
				break;
			case 3:
				resultado = multiplicar(teclado);
				break;
			case 4:
				resultado = dividir(teclado);
				break;
			}
			System.out.printf("El RESULTADO es %f\n", resultado);

		}
		return true;
	}

	public static double suma(Scanner teclado) {
		double num1 = pideNúmero(teclado);
		double num2 = pideNúmero(teclado);
		return num1 + num2;
	}

	public static double restar(Scanner teclado) {
		double num1 = pideNúmero(teclado);
		double num2 = pideNúmero(teclado);
		return num1 - num2;
	}

	public static double multiplicar(Scanner teclado) {
		double num1 = pideNúmero(teclado);
		double num2 = pideNúmero(teclado);
		return num1 * num2;
	}

	public static double dividir(Scanner teclado) {
		double num1 = pideNúmero(teclado);
		double num2 = pideNúmero(teclado);
		return num1 / num2;
	}

	public static double pideNúmero(Scanner teclado) {
		System.out.printf("Introduce un NÚMERO: ");
		double num = teclado.nextDouble();
		return num;
	}
}
