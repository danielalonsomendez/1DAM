package ejs_tema3;

import java.util.Random;

public class NUMPRIMOS_2 {

	public static void main(String[] args) {
		int[] numeros = new int[30];
		int[] numeros_primos = new int[30];

		numeros = RellenarArrayAleatorio(numeros);
		numeros_primos = PrimosEnUnArray(numeros);

		System.out.printf("Las SERIE completa es: ");
		ImprimirArray(numeros);
		
		System.out.printf("\nDe la SERIE son primos: ");
		ImprimirArray(numeros_primos);
		
		System.out.printf("\nEl MAYOR NÚMERO PRIMO es %s\nEl MENOR NÚMERO PRIMO es %s", MaximoArray(numeros_primos),
				MinimoArray(numeros_primos));
	}

	public static int[] PrimosEnUnArray(int[] array) {
		int[] primos = new int[array.length];
		for (int i = 0; i < primos.length; i++) {
			primos[i] = -1;
		}
		for (int i = 0; i < array.length; i++) {
			if (esPrimo(array[i])) {
				primos[i] =array[i];
			}
		}
		return primos;
	}

	public static int[] RellenarArrayAleatorio(int[] array) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(99);
		}
		return array;
	}

	public static int MaximoArray(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (max < array[i] && array[i] != -1) {
				max = array[i];
			}
		}
		return max;
	}

	public static int MinimoArray(int[] array) {
		int min = 999999999;
		for (int i = 1; i < array.length; i++) {
			if (min > array[i] && array[i] != -1) {
				min = array[i];
			}
		}
		return min;
	}

	public static void ImprimirArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -1)
				System.out.printf("%s ", array[i]);
		}
	}

	public static boolean esPrimo(int num) {
		for (int i = 2; num > i; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
