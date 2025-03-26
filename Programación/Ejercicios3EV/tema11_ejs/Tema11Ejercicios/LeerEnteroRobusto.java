package Tema11Ejercicios;

import java.util.Scanner;

public class LeerEnteroRobusto {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número entero robusto: ");
		String EnteroRobusto = teclado.next().replace("l", "1").replace("o", "0").replace("O", "0").replaceAll("[^\\d.]", "");
		System.out.println(EnteroRobusto);
		teclado.close();
	}
}
