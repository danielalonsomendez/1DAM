package ejs_tema5_OOP;

public class FechaArray {

	public FechaArray() {
		Fecha[] fechas = new Fecha[10];
		double ultimoAño = 0;
		do {
			int contador = 0;
			for (int i = 0; i < fechas.length; i++) {
				if (fechas[i] != null) {
					contador++;
				}
			}
			Fecha fechaNuevo = new Fecha();
			fechaNuevo.leer();
			ultimoAño = fechaNuevo.getAño();
			if (ultimoAño != 0) {
				fechas[contador] = fechaNuevo;
			}
		} while (ultimoAño != 0);
		for (int i = 0; i < fechas.length; i++) {
			if (fechas[i] != null) {
				System.out.println(fechas[i]);
			}
		}
	}

}
