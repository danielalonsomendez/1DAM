package ejs_tema5_OOP;

public class AsignaturaArray {

	public AsignaturaArray() {
		Asignatura[] asignaturas = new Asignatura[10];
		double ultimaNota = 0;
		do {
			int contador = 0;
			for (int i = 0; i < asignaturas.length; i++) {
				if (asignaturas[i] != null) {
					contador++;
				}
			}
			Asignatura asignaturaNueva = new Asignatura();
			asignaturaNueva.leer();
			ultimaNota = asignaturaNueva.getNota();
			if (ultimaNota > 0) {
				asignaturas[contador] = asignaturaNueva;
			}
		} while (ultimaNota > 0);
		for (int i = 0; i < asignaturas.length; i++) {
			if (asignaturas[i] != null) {
				System.out.println(asignaturas[i]);
			}
		}
	}


}
