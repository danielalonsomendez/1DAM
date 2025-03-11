package Controlador_EJ5;

import java.util.ArrayList;

import Modelo_EJ5.Gestor;
import Modelo_EJ5.Mascota;

public class Controlador {
	public void eliminarMascotaID(ArrayList<Mascota> mascotas,int Identificador) {
		for (Mascota mascota : mascotas) {
			if (mascota.getIdentificador() == Identificador) {
				mascotas.remove(mascota);
			}
		}
	}
	public void eliminarMascotaDNI(ArrayList<Mascota> mascotas,String DNI) {
		for (Mascota mascota : mascotas) {
			if (mascota.getDni().equals(DNI)) {
				mascotas.remove(mascota);
			}
		}
	}
	public boolean añadirMascota(Mascota mascota) {
		Gestor gestor = new Gestor();
		return gestor.añadirMascota(mascota);
	}
}
