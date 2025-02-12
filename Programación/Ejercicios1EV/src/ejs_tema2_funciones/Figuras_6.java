package ejs_tema2_funciones;

import java.util.Scanner;

public class Figuras_6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		boolean repetir;
		do {
			menu();
			repetir = pideOpción(teclado);
		} while (repetir == true);
		teclado.close();
	}

	public static void menu() {
		System.out.printf("MENÚ CALCULADORA: \n1.Rectángulo \n2.Cuadrado \n3.Circulo \n4.Salir\n> ");
	}

	public static boolean pideOpción(Scanner teclado) {
		int operacion = 0;
		operacion = teclado.nextInt();

		switch (operacion) {
		case 1:
			rectangulo(teclado);
			break;
		case 2:
			cuadrado(teclado);
			break;
		case 3:
			circulo(teclado);
			break;
		case 4:
			System.out.printf("Saliendo...");
			return false;

		default:
			System.out.printf("Operación no permitida. Vuelve a intentarlo.\n\n");
			return true;
		}
		return true;
	}

	public static double pideNúmero(Scanner teclado, String nombre) {
		System.out.printf("Introduce %s: ", nombre);
		double num = teclado.nextDouble();
		return num;
	}

	public static void rectangulo(Scanner teclado) {
		double base = pideNúmero(teclado, "BASE del RECTÁNGULO");
		double altura = pideNúmero(teclado, "ALTURA del RECTÁNGULO");
		double area = áreaRectángulo(base, altura);
		double perimetro = perímetroRectángulo(base, altura);
		System.out.printf("ÁREA: %s\nPERIMETRO: %s\n", area, perimetro);
	}
	public static double áreaRectángulo(double base, double altura) {
		return base * altura;
	}
	public static double perímetroRectángulo(double base, double altura) {
		return (2 * base) + (2 * altura);
	}

	
	public static void cuadrado(Scanner teclado) {
		double lado = pideNúmero(teclado, "LADO del CUADRADO");
		double area = áreaCuadrado(lado);
		double perimetro = perímetroCuadrado(lado);
		System.out.printf("ÁREA: %s\nPERIMETRO: %s\n", area, perimetro);
	}
	public static double áreaCuadrado(double lado) {
		return lado * lado;
	}

	public static double perímetroCuadrado(double lado) {
		return lado + lado + lado + lado;
	}

	
	public static void circulo(Scanner teclado) {
		double radio = pideNúmero(teclado, "RADIO del CIRCULO");
		double area = áreaCirculo(radio);
		double circunferencia = circunferenciaCirculo(radio);
		System.out.printf("ÁREA: %f\nCIRCUNFERENCIA: %f\n", area, circunferencia);
	}
	public static double áreaCirculo(double radio) {
		return 3.14 * (radio * radio);
	}
	public static double circunferenciaCirculo(double radio) {
		return 2 * 3.14 * radio;
	}



}
