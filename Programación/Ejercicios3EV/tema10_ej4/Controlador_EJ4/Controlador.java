package Controlador_EJ4;

import java.util.ArrayList;

import Modelo_EJ4.Mascota;

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
			if (mascota.getDNI().equals(DNI)) {
				mascotas.remove(mascota);
			}
		}
	}
}
