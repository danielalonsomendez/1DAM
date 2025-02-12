package ejs_tema3;

import java.util.Random;

public class ARRAYOPERACIONES {

	public static void main(String[] args) {
		int[] numeros1 = new int[30];
		int[] numeros2 = new int[30];
		int[] resultado = new int[30];
		Random r = new Random();

		numeros1 = RellenarArrayAleatorio(numeros1);
		numeros2 = RellenarArrayAleatorio(numeros2);
		ImprimirArrayint(numeros1);
		System.out.printf("\n");
		ImprimirArrayint(numeros2);
		System.out.printf("\n");

		for (int i = 0; i < numeros1.length; i++) {
			int operacionrandom = r.nextInt(4) + 1;
			switch (operacionrandom) {
			case 1:
				resultado[i] = numeros1[i] + numeros2[i];
				System.out.printf("%s + %s = %s\n", numeros1[i], numeros2[i], resultado[i]);
				break;
			case 2:
				resultado[i] = numeros1[i] - numeros2[i];
				System.out.printf("%s - %s = %s\n", numeros1[i], numeros2[i], resultado[i]);
				break;
			case 3:
				resultado[i] = numeros1[i] * numeros2[i];
				System.out.printf("%s x %s = %s\n", numeros1[i], numeros2[i], resultado[i]);
				break;
			case 4:
				if(numeros2[i] ==0) {
					numeros2[i] =1;
				}
				resultado[i] = numeros1[i] / numeros2[i];
				System.out.printf("%s / %s = %s\n", numeros1[i], numeros2[i], resultado[i]);
				break;
			}
		}
		System.out.printf("\n");
		ImprimirArrayint(resultado);

	}

	public static void ImprimirArrayint(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%s ", array[i]);
		}
	}

	public static int[] RellenarArrayAleatorio(int[] array) {
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(99);
		}
		return array;
	}
}
