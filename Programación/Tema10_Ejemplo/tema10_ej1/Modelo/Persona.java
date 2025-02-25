package Modelo;

public class Persona {
	protected String DNI;
	protected String nombre;
	protected String direccion;
	protected int numTel;
	public Persona(String dNI, String nombre, String direccion, int numTel) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numTel = numTel;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", direccion=" + direccion + ", numTel=" + numTel
				 + "]";
	}
	
	

}
