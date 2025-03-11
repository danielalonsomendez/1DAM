package Vista;

import java.util.Scanner;

import Modelo.Alumno;

public class AlumnoMain {
	
	public static void main(String[] args) {
	System.out.println(pedirAlumno().toString());
	}
	public static  Alumno pedirAlumno() {
		String DNI;
		String nombre;
		String direccion;
		int numTel;
		String grupo;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el DNI del alumno: ");
		DNI = teclado.nextLine();
		System.out.println("Introduce el nombre del alumno: ");
		nombre = teclado.nextLine();
		System.out.println("Introduce el direccion del alumno: ");
		direccion = teclado.nextLine();
		System.out.println("Introduce el numero de telefono del alumno: ");
		numTel = teclado.nextInt();
		System.out.println("Introduce el grupo del alumno: ");
		teclado.nextLine();
		grupo = teclado.nextLine();
		teclado.close();
		return new Alumno(DNI, nombre,direccion,numTel,grupo);

	}

}
