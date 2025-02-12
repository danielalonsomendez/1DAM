package ejs_tema5_OOP;

public class AsignaturaBucle {

	public AsignaturaBucle() {
		double ultimoNota = 0;
		do {
			Asignatura asignaturaNuevo = new Asignatura();
			asignaturaNuevo.leer();
			ultimoNota = asignaturaNuevo.getNota();
		} while (ultimoNota > 0);
	}


}
