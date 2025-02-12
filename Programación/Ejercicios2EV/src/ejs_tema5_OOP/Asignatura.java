package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Asignatura {
	private String codigo;
	private String descripcion;
	private double nota;

	Asignatura() {
		codigo = "";
		descripcion = "";
		nota = 0.0;
	}

	Asignatura(String codigo, String descripcion, double nota) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nota = nota;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	Asignatura(Asignatura a) {
		this.codigo = a.getCodigo();
		this.descripcion = a.getDescripcion();
		this.nota = a.getNota();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return codigo + " - " + nota;
	}

	public boolean equals(Asignatura p) {
		if (this.codigo.equals(p.getCodigo()) && this.nota == p.getNota()) {
			return true;
		} else {
			return false;
		}
	}

	public void leer() {
		Scanner teclado = new Scanner(System.in);

		System.out.printf("Introduce un CODIGO de ASIGNATURA:");
		codigo = teclado.nextLine();
		System.out.printf("Introduce una DESCRIPCION de ASIGNATURA:");
		descripcion = teclado.nextLine();
		System.out.printf("Introduce una NOTA:");
		nota = teclado.nextDouble();

		teclado.nextLine();
	}
}
