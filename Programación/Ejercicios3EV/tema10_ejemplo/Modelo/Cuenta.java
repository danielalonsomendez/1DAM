package Modelo;

public class Cuenta {
	
	private String numero;
	private double saldo;

	public Cuenta(String numCta, double saldoCta){
	numero= numCta;
	saldo = saldoCta;
	}
	public String getNumero(){
	return numero;
	}
	public double getSaldo(){
	return saldo;
	}
	public void setNumero(String numCta){
	numero = numCta;
	}
	public void setSaldo(double saldoCta){
	saldo = saldoCta;
	}
	public void ingresarDinero(double importe){
	saldo = saldo + importe;
	}
	public void extraerDinero(double importe){
	saldo = saldo - importe;
	}
	public String toString(){
	return "cuenta: "+ getNumero() + " Saldo: "+ getSaldo()+ "€";
	}
}
