package ejs_tema2_funciones;

import java.util.Random;

public class Aleatorio_2 {

	public static void main(String[] args) {
		int pares=0,impares=0;
		for(int i = 0; i<10;i++) {
			int numero = NumAleatorio();
			if(esPar(numero)) {
				pares++;
			} else {
				impares++;
			}
		}
		System.out.printf("Pares:%s \nImpares: %s",pares,impares);
	}
	
	public static int NumAleatorio() {
		Random generador = new Random();
		int numero = generador.nextInt(1000);
		return numero;
	}
	public static boolean esPar(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
