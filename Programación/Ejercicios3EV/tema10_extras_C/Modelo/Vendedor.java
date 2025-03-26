package Modelo;

import java.util.ArrayList;

import Modelo_Vehiculos.Coche;

public class Vendedor extends Empleado {
	private Coche coche;
	private String telefonoMovil;
	private String areaVenta;
	private ArrayList<String> clientes;
	private double comision;

	public Vendedor(String nombre, String apellidos, String dNI, String dirección, int antiguedad, int telefono,
			double salario, Empleado supervisor, Coche coche, String telefonoMovil, String areaVenta,
			ArrayList<String> clientes, double comision) {
		super(nombre, apellidos, dNI, dirección, antiguedad, telefono, salario, supervisor);
		this.coche = coche;
		this.telefonoMovil = telefonoMovil;
		this.areaVenta = areaVenta;
		this.clientes = clientes;
		this.comision = comision;
		this.subidaSalario =10;
	}
	
	public void altaCliente(String cliente) {
		clientes.add(cliente);
	}
	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getAreaVenta() {
		return areaVenta;
	}

	public void setAreaVenta(String areaVenta) {
		this.areaVenta = areaVenta;
	}

	public ArrayList<String> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<String> clientes) {
		this.clientes = clientes;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public void bajaCliente(String cliente) {
		clientes.remove(cliente);
	}

	@Override
	public String toString() {
		return "Vendedor [coche=" + coche + ", telefonoMovil=" + telefonoMovil + ", areaVenta=" + areaVenta
				+ ", clientes=" + clientes + ", comision=" + comision + "]";
	}

	


}
