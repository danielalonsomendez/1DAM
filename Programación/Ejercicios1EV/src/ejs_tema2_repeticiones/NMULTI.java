package ejs_tema2_repeticiones;

import java.util.Scanner;

public class NMULTI {
	public static void main(String[] args) {
		int num,maxmultiplos;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		num = teclado.nextInt();
		System.out.printf("¿Cuántos MULTIPLOS quieres CALCULAR?: ");
		maxmultiplos = teclado.nextInt();
		teclado.close();
		ImprimirMultiplosNum(maxmultiplos,num);

	}
	public static void ImprimirMultiplosNum(int maxmultiplos,int num) {
		for (int i = 1; maxmultiplos >= i; i++) {
			System.out.printf("%s x %s = %s \n", i, num,i*num);
	}
	}
	
}
