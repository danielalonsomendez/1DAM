package controlador;

import java.util.ArrayList;
import modelo.GestorPaises;
import modelo.Pais;

public class ControladorPaises {

	public ArrayList<Pais> cargarPaisesFichero() {
		ArrayList<Pais> paises = null;
		GestorPaises gestor = new GestorPaises();
		paises = gestor.cargarPaisesFichero();
		return paises;
	}

	public ArrayList<Pais> cargarPaisesBBDD() {
		ArrayList<Pais> paises = null;
		GestorPaises gestor = new GestorPaises();
		paises = gestor.selectPaises();
		return paises;
	}

	public boolean guardarPaisesBD(ArrayList<Pais> paises) {
		GestorPaises gestor = new GestorPaises();
		boolean guardado = true;
		if (gestor.eliminarPaises() == true) {
			for (Pais pais : paises) {
				if (guardado != false) {
					guardado = gestor.insertarPais(pais);
				}
			}
		}
		return guardado;
	}
}
