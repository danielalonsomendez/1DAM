package Controlador_Vehiculos;

import java.io.IOException;
import java.util.ArrayList;

import Modelo_Vehiculos.Gestor;
import Modelo_Vehiculos.Vehiculo;

public class Controlador {

	public ArrayList<Vehiculo> leerArchivo() throws IOException {
		ArrayList<Vehiculo> vehiculos = null;
		Gestor gestor = new Gestor();
		vehiculos = gestor.leerArchivo();
		return vehiculos;
	}

	
}
