package ejs_tema2_funciones;

import java.util.Scanner;

public class Mayor_3 {

	public static void main(String[] args) {
		int num1, num2;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un PRIMER NÚMERO ENTERO: ");
		num1 = teclado.nextInt();
		System.out.printf("Introduce un SEGUNDO NÚMERO ENTERO: ");
		num2 = teclado.nextInt();
		teclado.close();
		int mayor = esMayor(num1, num2);
		System.out.printf("%s el NÚMERO más ALTO", mayor);
	}
	public static int esMayor(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
}
