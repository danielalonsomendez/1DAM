package ejs_tema5_OOP;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private Fecha fechanacimiento;

	Persona() {
		dni = "";
		nombre = "";
		apellidos = "";
		fechanacimiento = new Fecha();
	}

	Persona(String dni, String nombre, String apellidos, int dia, int mes, int año) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		fechanacimiento = new Fecha(dia, mes, año);
	}

	Persona(Persona p) {
		dni = p.getDni();
		nombre = p.getNombre();
		apellidos = p.getApellidos();
		fechanacimiento = new Fecha(p.getFechanacimiento());
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Fecha getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Fecha fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	@Override
	public String toString() {
		return dni + " " + nombre + " " + fechanacimiento;
	}

	public boolean equals(Persona p) {
		if (this.dni.equals( p.getDni())) {
			return true;
		} else {
			return false;
		}
	}

	public void leer() {
		Scanner teclado = new Scanner(System.in);

		System.out.printf("Introduce un DNI:");
		dni = teclado.nextLine();
		System.out.printf("Introduce un NOMBRE:");
		nombre = teclado.nextLine();
		System.out.printf("Introduce un APELLIDO:");
		apellidos = teclado.nextLine();
		System.out.printf("FECHA DE NACIMIENTO:\n");
		fechanacimiento.leer();

		teclado.close();
	}

}
