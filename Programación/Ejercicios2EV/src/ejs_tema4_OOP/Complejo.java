package ejs_tema4_OOP;

public class Complejo {
	private double real;
	private double imaginaria;
	
	Complejo(double real, double imaginaria ) {
		this.real = real;
		this.imaginaria = imaginaria;
	}
	
	public void escribir() {
		System.out.println(real+" + "+imaginaria+" + i");
	}
}
