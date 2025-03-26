package Modelo;

import java.util.ArrayList;

import Modelo_Vehiculos.Coche;

public class JefeDeZona extends Empleado{
	private Coche coche;
	private Secretario secretario;
	private ArrayList<Vendedor> vendedores;
	public JefeDeZona(String nombre, String apellidos, String dNI, String dirección, int antiguedad, int telefono,
			double salario, Empleado supervisor, Coche coche, Secretario secretario, ArrayList<Vendedor> vendedores) {
		super(nombre, apellidos, dNI, dirección, antiguedad, telefono, salario, supervisor);
		this.coche = coche;
		this.secretario = secretario;
		this.vendedores = vendedores;
		this.subidaSalario = 20;
	}
	public Coche getCoche() {
		return coche;
	}
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	public Secretario getSecretario() {
		return secretario;
	}
	public void setSecretario(Secretario secretario) {
		this.secretario = secretario;
	}
	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}
	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
	public void altaVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}
	public void bajaVendedor(Vendedor vendedor) {
		vendedores.remove(vendedor);
	}
	@Override
	public String toString() {
		return "JefeDeZona [coche=" + coche + ", secretario=" + secretario + ", vendedores=" + vendedores + "]";
	}

}
