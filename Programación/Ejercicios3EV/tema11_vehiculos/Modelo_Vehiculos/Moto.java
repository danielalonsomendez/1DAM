package Modelo_Vehiculos;

public class Moto extends Vehiculo {
	private int cilindrada;

	public Moto(int iD, String marca, String modelo, int cilindrada) {
		super(iD, marca, modelo);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return super.toString()+"Moto [cilindrada=" + cilindrada + "]";
	}

}
