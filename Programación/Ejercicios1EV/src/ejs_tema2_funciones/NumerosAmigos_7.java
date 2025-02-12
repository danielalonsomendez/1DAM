package ejs_tema2_funciones;

import java.util.Scanner;

public class NumerosAmigos_7 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num1 = pideNúmero(teclado);
		int num2 = pideNúmero(teclado);
		int suma1 = sumadivisores(num1);
		int suma2 = sumadivisores(num2);
		boolean esamigo = amigo(num1, num2, suma1, suma2);
		if (esamigo) {
			System.out.printf("%s y %s son NÚMEROS AMIGOS ", num1, num2);
		} else {
			System.out.printf("%s y %s NO son NÚMEROS AMIGOS ", num1, num2);
		}
		teclado.close();
	}

	public static int pideNúmero(Scanner teclado) {
		int num;
		do {
			System.out.printf("Introduce un NÚMERO: ");
			num = teclado.nextInt();
			if(num < 0) {
				System.out.printf("Número NO VÁLIDO\n");
	
			}
		} while (num < 0);
		return num;

	}

	public static int sumadivisores(int num) {
		int suma = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				suma = suma + i;
			}
		}
		return suma;
	}

	public static boolean amigo(int num1, int num2, int suma1, int suma2) {
		if (num1 != num2 && suma1 == num2 && suma2 == num1) {
			return true;
		}
		return false;
	}
}
