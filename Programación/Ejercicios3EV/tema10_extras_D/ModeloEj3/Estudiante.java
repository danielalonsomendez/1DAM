package ModeloEj3;

import java.util.Scanner;

public class Estudiante extends Persona {
	private String cursoMatriculado;
	
	public Estudiante() {
		
	}
	public Estudiante(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			String cursoMatriculado) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil);
		this.cursoMatriculado = cursoMatriculado;
	}

	public String getCursoMatriculado() {
		return cursoMatriculado;
	}

	public void setCursoMatriculado(String cursoMatriculado) {
		this.cursoMatriculado = cursoMatriculado;
	}

	@Override
	public void leer() {
		super.leer();
		Scanner sc = new Scanner(System.in);
		System.out.print("Curso Matriculado: ");
		this.cursoMatriculado = sc.nextLine();
	}

	@Override
	public void imprimirInformacion() {
		System.out.println("Nombre: " + nombre + " " + apellidos);
		System.out.println("Número de Identificación: " + numeroIdentificacion);
		System.out.println("Estado Civil: " + estadoCivil);
		System.out.println("Curso Matriculado: " + cursoMatriculado);
	}

	@Override
	public String toString() {
		return "Estudiante [cursoMatriculado=" + cursoMatriculado + "]";
	}

}
