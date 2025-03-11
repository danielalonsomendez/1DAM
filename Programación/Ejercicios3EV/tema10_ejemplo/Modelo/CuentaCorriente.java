package Modelo;

public class CuentaCorriente extends Cuenta {

	private double saldoMedio;
	
	public CuentaCorriente(String numCta, double saldoCta, double saldoM) {
		super(numCta, saldoCta);
		setSaldoMedio(saldoM);
	}

	public double getSaldoMedio() {
		return saldoMedio;
	}

	public void setSaldoMedio(double saldoMedio) {
		this.saldoMedio = saldoMedio;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Saldo medio :"+ getSaldoMedio()+"€";
	}

	
	

}
