package ejs_tema3;

import java.util.Scanner;

public class Caracmay {

	public static void main(String[] args) {
		String texto;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un TEXTO: ");
		texto = teclado.nextLine();
		char maxChar = texto.charAt(0);

		for (int i = 0; i < texto.length(); i++) {
			char CharActual = texto.charAt(i);
			if (maxChar < CharActual) {
				maxChar = CharActual;
			} 
		}
		System.out.printf("El CARÁCTER MAYOR es %s y está en la/s posición/es ", maxChar);
		for (int i = 0; i < texto.length(); i++) {
			if ( texto.charAt(i) == maxChar) {
				System.out.printf("%s ",(i+1));
			}
		}
		teclado.close();
	}

}
