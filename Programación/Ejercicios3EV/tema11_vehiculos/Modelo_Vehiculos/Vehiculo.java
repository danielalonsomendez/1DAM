package Modelo_Vehiculos;

public class Vehiculo {
	protected int ID;
	protected String marca;
	protected String modelo;
	public Vehiculo(int iD, String marca, String modelo) {
		super();
		ID = iD;
		this.marca = marca;
		this.modelo = modelo;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return "Vehiculo [ID=" + ID + ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}
