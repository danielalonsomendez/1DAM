package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Racional {
	private int numerador;
	private int denominador;

	Racional(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	Racional(int numerador) {
		this.numerador = numerador;
	}

	Racional(Racional c) {
		this.numerador = c.getNumerador();
		this.denominador = c.getDenominador();
	}

	public Racional() {
		this.numerador =0;
		this.denominador =0;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	@Override
	public String toString() {
		return numerador + "/" + denominador ;
	}
	public boolean equals(Racional c) {
		if (this.numerador == c.getNumerador() && this.denominador == c.getNumerador()) {
			return true;
		} else {
			return false;
		}
	}
	public void leer() {
		Scanner teclado = new Scanner(System.in);
		try {
		System.out.printf("Introduce un NUMERADOR:");
		numerador = teclado.nextInt();
		System.out.printf("Introduce un DENOMINADOR:");
		denominador  = teclado.nextInt();
		}catch (InputMismatchException e) {
			leer();
			return;
		}
	}

}
