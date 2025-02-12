package ejs_tema2_repeticiones;

import java.util.Scanner;

public class EC2GRAIZ {
	public static void main(String[] args) {
		double raiz, a, b, c, ecg1, ecg2, Ractual = 0, Ranterior, diferencia, errorv = 0.00000001;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce el VALOR de a: ");
		a = teclado.nextDouble();
		System.out.printf("Introduce el VALOR de b: ");
		b = teclado.nextDouble();
		System.out.printf("Introduce el VALOR de c: ");
		c = teclado.nextDouble();
		teclado.close();

		raiz = (b * b) - 4 * a * c;
		if (raiz >= 0) {
			Ranterior = raiz / 2;
			diferencia = 1;
			while (diferencia > errorv) {
				Ractual = (raiz / Ranterior + Ranterior) / 2;
				diferencia = Math.abs(Ractual - Ranterior);
				Ranterior = Ractual;
			}
			ecg1 = (-b + Ractual) / (2 * a);
			ecg2 = (-b - Ractual) / (2 * a);

			System.out.printf("Los resultados de la ecuacion son: %s y %s", ecg1, ecg2);
		} else {
			System.out.printf("La ecuación no puede realizarse debido a que la raiz es compleja");

		}
	}
}
