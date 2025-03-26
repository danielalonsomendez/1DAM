package Modelo_Vehiculos;

public class Camion extends Vehiculo {
	protected int cargaToneladas;

	public Camion(int iD, String marca, String modelo, int cargaToneladas) {
		super(iD, marca, modelo);
		this.cargaToneladas = cargaToneladas;
	}

	public int getCargaToneladas() {
		return cargaToneladas;
	}

	public void setCargaToneladas(int cargaToneladas) {
		this.cargaToneladas = cargaToneladas;
	}

	@Override
	public String toString() {
		return super.toString()+"Camion [cargaToneladas=" + cargaToneladas + "]";
	}

}
