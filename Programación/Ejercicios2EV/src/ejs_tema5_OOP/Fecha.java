package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fecha {
	private int dia;
	private int mes;
	private int año;

	Fecha() {
		this.dia = 1;
		this.mes = 1;
		this.año = 2016;

	}

	Fecha(int dia, int mes, int año) {
		if (dia >= 1 && dia <= 31) {
			this.dia = dia;
		} else {
			this.dia = 1;
		}
		;
		if (mes >= 1 && mes <= 12) {
			this.mes = mes;
		} else {
			this.mes = 1;
		}
		if (mes >= 1) {
			this.año = año;
		} else {
			this.año = 2024;
		}

	}

	Fecha(Fecha f) {
		this.dia = f.getDia();
		this.mes = f.getMes();
		this.año = f.getAño();

	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + año;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public boolean equals(Fecha c) {
		if (this.dia == c.getDia() && this.mes == c.getMes() && this.año == c.getAño()) {
			return true;
		} else {
			return false;
		}
	}

	public void leer() {
		Scanner teclado = new Scanner(System.in);

		try {
			do {
				System.out.printf("Introduce un DÍA:");
				dia = teclado.nextInt();
			} while (dia < 1 || dia > 31);
			do {
				System.out.printf("Introduce un MES:");
				mes = teclado.nextInt();
			} while (mes < 1 || mes > 12);
			do {
				System.out.printf("Introduce un AÑO:");
				año = teclado.nextInt();
			} while (año < 0);
		} catch (InputMismatchException e) {
			leer();
			return;
		}
	}
}
