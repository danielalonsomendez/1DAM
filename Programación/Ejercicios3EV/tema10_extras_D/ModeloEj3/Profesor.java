package ModeloEj3;

import java.util.Scanner;

public class Profesor extends Empleado {
	private String departamento;
	private int añoIncorporacion;
	public Profesor() {
		
	}
	public Profesor(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			int numeroDespacho, String departamento, int añoIncorporacion) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil, numeroDespacho);
		this.departamento = departamento;
		this.añoIncorporacion = añoIncorporacion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getAñoIncorporacion() {
		return añoIncorporacion;
	}

	public void setAñoIncorporacion(int añoIncorporacion) {
		this.añoIncorporacion = añoIncorporacion;
	}

	@Override
	public void leer() {
		super.leer();
		Scanner sc = new Scanner(System.in);
		System.out.print("Departamento: ");
		this.departamento = sc.nextLine();
		System.out.print("Año de Incorporación: ");
		this.añoIncorporacion = sc.nextInt();
	}

	@Override
	public double calcularSalario() {
		double salarioBase = 2000;
		if (añoIncorporacion < 2000) {
			salarioBase *= 1.08;
		}
		return salarioBase;
	}

	@Override
	public void imprimirInformacion() {
		System.out.println("Nombre: " + nombre + " " + apellidos);
		System.out.println("Número de Identificación: " + numeroIdentificacion);
		System.out.println("Estado Civil: " + estadoCivil);
		System.out.println("Departamento: " + departamento);
	}

	@Override
	public String toString() {
		return "Profesor [departamento=" + departamento + ", añoIncorporacion=" + añoIncorporacion + "]";
	}

}
