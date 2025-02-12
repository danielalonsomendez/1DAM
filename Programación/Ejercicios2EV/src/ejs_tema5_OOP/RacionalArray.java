package ejs_tema5_OOP;

public class RacionalArray {

	public RacionalArray() {
		Racional[] racionales = new Racional[10];
		double ultimoNumerador = 0;
		do {
			int contador = 0;
			for (int i = 0; i < racionales.length; i++) {
				if (racionales[i] != null) {
					contador++;
				}
			}
			Racional racionalNuevo = new Racional();
			racionalNuevo.leer();
			ultimoNumerador = racionalNuevo.getNumerador();
			if (ultimoNumerador > 0) {
				racionales[contador] = racionalNuevo;
			}
		} while (ultimoNumerador > 0);
		for (int i = 0; i < racionales.length; i++) {
			if (racionales[i] != null) {
				System.out.println(racionales[i]);
			}
		}
	}

}
