package Vista;

import java.io.IOException;
import java.util.ArrayList;

import Controlador_Vehiculos.Controlador;
import Modelo_Vehiculos.Vehiculo;

public class Vehiculos {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		ArrayList<Vehiculo> vehiculos = null;
		try {
			vehiculos = controlador.leerArchivo();
		} catch (IOException e) {
		System.out.println("No ha sido posible leer el archivo");
		}
		mostrar(vehiculos);
	}

	public static void mostrar(ArrayList<Vehiculo> vehiculos) {
		for (Vehiculo vehiculo : vehiculos) {
			System.out.println(vehiculo);
		}
	}
}
