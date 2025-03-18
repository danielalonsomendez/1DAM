package Modelo;

public class Fraccion {
	private int numerador;
	private int denominador;

	public Fraccion() {
		numerador = 0;
		denominador = 0;
	}

	public Fraccion(int numerador, int denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public Fraccion suma(Fraccion f1) {
		int numerador = (this.getNumerador() * f1.getDenominador()) + (f1.getNumerador() * this.getDenominador());
		int denominador = this.getDenominador() * f1.getDenominador();
		return new Fraccion(numerador, denominador);
	}

	public Fraccion resta(Fraccion f1) {
		int numerador = (this.getNumerador() * f1.getDenominador()) - (f1.getNumerador() * this.getDenominador());
		int denominador = this.getDenominador() * f1.getDenominador();
		return new Fraccion(numerador, denominador);
	}

	public Fraccion multiplicar(Fraccion f1) {
		int numerador = this.getNumerador() * f1.getNumerador();
		int denominador = this.getDenominador() * f1.getDenominador();
		return new Fraccion(numerador, denominador);
	}

	public Fraccion dividir(Fraccion f1) {
		int numerador = this.getNumerador() * f1.getDenominador();
		int denominador = this.getDenominador() * f1.getNumerador();
		return new Fraccion(numerador, denominador);
	}

	public static int mcd(int x, int y) {
		while (y != 0) {
			int r = x % y;
			x = y;
			y = r;
		}
		return x;
	}

	public Fraccion simplificar() {
		int numerador = this.getNumerador();
		int denominador = this.getDenominador();
		int mcd = mcd(numerador, denominador);

		numerador = numerador / mcd;
		denominador = denominador / mcd;

		if (denominador < 0) {
			numerador = -numerador;
			denominador = -denominador;
		}

		return new Fraccion(numerador, denominador);
	}

	public int esMayorQue(Fraccion f1) {
		int numerador1 = this.numerador * f1.denominador;
		int numerador2 = f1.numerador * this.denominador;

		if (numerador1 > numerador2) {
			return 1;
		} else if (numerador1 < numerador2) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return numerador + "/" + denominador;
	}

}
