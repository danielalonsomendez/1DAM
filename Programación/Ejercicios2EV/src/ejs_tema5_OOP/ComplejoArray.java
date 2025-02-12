package ejs_tema5_OOP;

public class ComplejoArray {

	public ComplejoArray() {
		Complejo[] complejos = new Complejo[10];
		double ultimoReal = 0;
		do {
			int contador = 0;
			for (int i = 0; i < complejos.length; i++) {
				if (complejos[i] != null) {
					contador++;
				}
			}
			Complejo complejoNuevo = new Complejo();
			complejoNuevo.leer();
			ultimoReal = complejoNuevo.getReal();
			if (ultimoReal > 0) {
				complejos[contador] = complejoNuevo;
			}
		} while (ultimoReal > 0);
		for (int i = 0; i < complejos.length; i++) {
			if (complejos[i] != null) {
				System.out.println(complejos[i]);
			}
		}
	}

}
