package Modelo_Vehiculos;

public class Coche  extends Vehiculo {
	private int numeroPuertas;

	public Coche(int iD, String marca, String modelo, int numeroPuertas) {
		super(iD, marca, modelo);
		this.numeroPuertas = numeroPuertas;
	}

	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}

	@Override
	public String toString() {
		return super.toString()+"Coche [numeroPuertas=" + numeroPuertas + "]";
	}

}
