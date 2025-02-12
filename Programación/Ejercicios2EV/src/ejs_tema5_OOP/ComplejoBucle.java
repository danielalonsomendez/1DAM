package ejs_tema5_OOP;

public class ComplejoBucle {

	 public ComplejoBucle() {
		double ultimoReal = 0;
		do {
			Complejo complejoNuevo = new Complejo();
			complejoNuevo.leer();
			ultimoReal = complejoNuevo.getReal();
		} while (ultimoReal > 0);
	}

}
