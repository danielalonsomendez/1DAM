package ejs_tema5_OOP;

public class RacionalBucle {

	public RacionalBucle() {
		double ultimoNumerador = 0;
		do {
			Racional racionalNuevo = new Racional();
			racionalNuevo.leer();
			ultimoNumerador = racionalNuevo.getNumerador();
		} while (ultimoNumerador > 0);
	}

}
