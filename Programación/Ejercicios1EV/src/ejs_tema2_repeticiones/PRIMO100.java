package ejs_tema2_repeticiones;

import java.util.Scanner;

public class PRIMO100 {

	public static void main(String[] args) {
		int max = 100, cantidadprimos = 0;
		System.out.printf("Los PRIMEROS 100 NÚMEROS PRIMOS: ");
		for (var num = 1; max > cantidadprimos; num++) {
			if (comprobarprimo(num)) {
				cantidadprimos++;
				System.out.printf("\n %s es PRIMO", num);
			}
		}
	}

	public static boolean comprobarprimo(int num) {
		for (int i = 2; num > i; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
