package Modelo_EJ5W;

import Modelo_EJ5W.Mascota;

public class Mascota {
	protected int identificador;
	protected String nombre;
	protected int edad;
	protected String dni;
	static int cont;

	public Mascota(String nombre, int edad, String dni) {
		super();
		this.identificador = cont++;
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}
	public Mascota(int identificador, String nombre, int edad, String dni) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}

	public static boolean validarEdad(int edad) {
		return edad>0;
	}
	
	public static boolean validarDNI(String dni) {
		return dni.matches("\\d{8}[A-Z]");
	}
	
	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public static int getCont() {
		return cont;
	}


	public static void setCont(int cont) {
		Mascota.cont = cont;
	}


	@Override
	public String toString() {
		return "Mascota [identificador=" + identificador + ", nombre=" + nombre + ", edad=" + edad + ", dni=" + dni
				+ "]";
	}
	
	
	
}
