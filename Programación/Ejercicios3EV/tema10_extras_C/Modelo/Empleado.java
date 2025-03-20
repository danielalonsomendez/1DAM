package Modelo;

public class Empleado {
	private String nombre;
	private String apellidos;
	private String DNI;
	private String dirección;
	private int antiguedad;
	private int telefono;
	private double salario;
	private Empleado supervisor;
	protected int subidaSalario;
	
	public Empleado(String nombre, String apellidos, String dNI, String dirección, int antiguedad, int telefono,
			double salario, Empleado supervisor) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.dirección = dirección;
		this.antiguedad = antiguedad;
		this.telefono = telefono;
		this.salario = salario;
		this.supervisor = supervisor;
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
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Empleado getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}
	public int getSubidaSalario() {
		return subidaSalario;
	}
	public void setSubidaSalario(int subidaSalario) {
		this.subidaSalario = subidaSalario;
	}
	public void incrementarSalario() {
		this.salario = salario+ ((salario*this.subidaSalario)/100);
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", dirección=" + dirección
				+ ", antiguedad=" + antiguedad + ", telefono=" + telefono + ", salario=" + salario + ", supervisor="
				+ supervisor + ", subidaSalario=" + subidaSalario + "]";
	}


	
}
