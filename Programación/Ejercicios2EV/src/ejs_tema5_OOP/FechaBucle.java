package ejs_tema5_OOP;

public class FechaBucle {

	 public  FechaBucle() {
		double ultimoAño = 0;
		do {
			Fecha fechaNuevo = new Fecha();
			fechaNuevo.leer();
			ultimoAño = fechaNuevo.getAño();
		} while (ultimoAño != 0);
	}

}
