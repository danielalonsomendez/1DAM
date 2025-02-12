package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Complejo {
	private double real;
	private double imaginaria;

	Complejo(double real, double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}

	public Complejo() {
	this.real =0;
	this.imaginaria =0;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}

	@Override
	public String toString() {
		return real + " + " + imaginaria + " + i";
	}

	public boolean equals(Complejo c) {
		if (this.real == c.getReal() && this.imaginaria == c.getImaginaria()) {
			return true;
		} else {
			return false;
		}
	}

	public void leer() {
		Scanner teclado = new Scanner(System.in);

		try {
			System.out.printf("Introduce un REAL:");
			real = teclado.nextDouble();
			System.out.printf("Introduce una IMAGINARIA:");
			imaginaria = teclado.nextDouble();
		} catch (InputMismatchException e) {
			leer();
			return;
		}
		
	}
}
