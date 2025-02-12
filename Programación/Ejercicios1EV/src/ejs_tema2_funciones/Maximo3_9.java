package ejs_tema2_funciones;

import java.util.Scanner;

public class Maximo3_9 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num1 = pideNúmero(teclado, "PRIMER");
		int num2 = pideNúmero(teclado, "SEGUNDO");
		int num3 = pideNúmero(teclado, "TERCER");
		int mayorde3 =  maximo3Numeros(num1, num2,num3);
		System.out.printf("El MAYOR de los 3 NÚMEROS es %s", mayorde3);
		teclado.close();
	}
	public static int pideNúmero(Scanner teclado, String nombre) {
		System.out.printf("Introduce un %s NÚMERO: ", nombre);
		int num = teclado.nextInt();
		return num;
	}
	public static int maximo2Numeros(int num1, int num2) {
		if (num1 < num2) {
			return num2;
		} else {
			return num1;
		}
	}

	public static int maximo3Numeros(int num1, int num2, int num3) {
		int mayorde1y2 = maximo2Numeros(num1, num2);
		if (num3 < mayorde1y2) {
			return mayorde1y2;
		} else {
			return num3;
		}

	}
}
