package ejs_tema6_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMediaTemperaturas {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		double mediaSuma = 0;
		int numero;
		do {

			System.out.print("Introduce un NÚMERO: ");
			numero = teclado.nextInt();

			if (numero > 0) {
				numeros.add(numero);
			}

		} while (numero != -999);
		teclado.close();

		for (int num : numeros) {
			mediaSuma = mediaSuma + num;
		}
		double media = (mediaSuma / numeros.size());
		System.out.printf("La MEDIA es: %.2f", media);
		System.out.printf("\nTemperaturas SUPERIORES a la MEDIA:\n");
		for (int num : numeros) {
			if (num > media) {
				System.out.println(num);
			}
		}
		System.out.printf("Temperaturas IGUALES a la MEDIA:\n");
		for (int num : numeros) {
			if (num == media) {
				System.out.println(num);
			}
		}
		System.out.printf("Temperaturas INFERIORES a la MEDIA:\n");
		for (int num : numeros) {
			if (num < media) {
				System.out.println(num);
			}
		}
	}

}
