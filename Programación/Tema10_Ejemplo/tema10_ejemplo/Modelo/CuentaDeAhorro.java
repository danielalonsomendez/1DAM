package Modelo;

public class CuentaDeAhorro extends Cuenta {
	
	private double interes;

	public CuentaDeAhorro(String numCta, double saldoCta, double inte) {
		super(numCta, saldoCta);
		setInteres(inte);
		// TODO Auto-generated constructor stub
	}
	
	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ " Interes: "+ getInteres()+"%";
	}

}
