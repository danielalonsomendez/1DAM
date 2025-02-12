package ejs_tema5_OOP;

public class RacionalBucleCero {

	public static void main(String[] args) {
		double ultimoDenominador = 0;
		do {
			Racional racionalNuevo = new Racional();
			racionalNuevo.leer();
			ultimoDenominador = racionalNuevo.getDenominador();
		} while (ultimoDenominador != 0);
	}

}
