package Modelo;

public class Secretario extends Empleado {
	private String despacho;
	private int numFax;
	public Secretario(String nombre, String apellidos, String dNI, String dirección, int antiguedad, int telefono,
			double salario, Empleado supervisor, String despacho, int numFax) {
		super(nombre, apellidos, dNI, dirección, antiguedad, telefono, salario, supervisor);
		this.despacho = despacho;
		this.numFax = numFax;
		this.subidaSalario = 5;
	}
	public String getDespacho() {
		return despacho;
	}
	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}
	public int getNumFax() {
		return numFax;
	}
	public void setNumFax(int numFax) {
		this.numFax = numFax;
	}
	@Override
	public String toString() {
		return "Secretario [despacho=" + despacho + ", numFax=" + numFax + "]";
	}
	
	
	
	
}
