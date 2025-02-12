package ejs_tema7_Ficheros;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Libro {
	private String titulo;
	private String autor;
	private int año;

	Libro(boolean pedir) {
		if (pedir) {
			leer();
		} else {
			titulo = "";
			autor = "";
			año = 2024;
		}
	}
	Libro(String titulo) {
		this.titulo = titulo;
	
	}

	Libro(String titulo, String autor, int año) {
		this.titulo = titulo;
		this.autor = autor;
		if (año > 0) {
			this.año = año;
		} else {
			año = 0;
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	@Override
	public String toString() {
		return titulo + "-" + autor + "-"+ año;
	}
	public boolean equals(Libro c) {
		if (this.titulo.equals(c.getTitulo())) {
			return true;
		} else {
			return false;
		}
	}
	public void leer() {
		Scanner teclado = new Scanner(System.in);

		try {
			System.out.printf("Introduce el TITULO del LIBRO:");
			titulo = teclado.nextLine();
			System.out.printf("Introduce el AUTOR del LIBRO:");
			autor = teclado.nextLine();
			do {
				System.out.printf("Introduce el AÑO del LIBRO:");
				año = teclado.nextInt();
			} while (año < 0);

		} catch (InputMismatchException e) {
			leer();
			return;
		}

	}
}
