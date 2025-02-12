package ejs_tema2_condicionales;

import java.util.Scanner;

public class SEGUNDOI {

	public static void main(String[] args) {
		int h;
		int m;
		int s;

		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce las HORAS: ");
		h = teclado.nextInt();
		System.out.printf("Introduce los MINUTOS: ");
		m = teclado.nextInt();
		System.out.printf("Introduce los SEGUNDOS: ");
		s = teclado.nextInt();
		teclado.close();
		if (s <= 60 && m <= 60) {
			s++;
			if (s == 60) {
				s = 0;
				m++;
				if (m == 60) {
					m = 0;
					h++;
				}
			}
			System.out.printf("El tiempo es: %dh %dm %ds ", h, m, s);
		} else {
			System.out.printf("Introduce los valores bien.", h, m, s);

		}
	}

}
