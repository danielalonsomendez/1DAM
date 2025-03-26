package Vista;

import java.util.ArrayList;

import Controlador_Vehiculos.Controlador;
import Modelo_Vehiculos.Vehiculo;

public class Vehiculos {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		ArrayList<Vehiculo> vehiculos = controlador.leerArchivo();
		mostrar(vehiculos);
	}

	public static void mostrar(ArrayList<Vehiculo> vehiculos) {
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo);
		}
	}
}
