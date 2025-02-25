package Modelo;

public class Mascota {
	protected int Identificador;
	protected String Nombre;
	protected int Edad;
	protected String DNI;


	public Mascota(int identificador, String nombre, int edad, String dNI) {
		super();
		Identificador = identificador;
		Nombre = nombre;
		Edad = edad;
		DNI = dNI;
	}
	public int getIdentificador() {
		return Identificador;
	}
	public void setIdentificador(int identificador) {
		Identificador = identificador;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	@Override
	public String toString() {
		return "Mascota [Identificador=" + Identificador + ", Nombre=" + Nombre + ", Edad=" + Edad + ", DNI=" + DNI
				+ "]";
	}
	
	
	
}
