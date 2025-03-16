package Controlador_EJ5;

import java.util.ArrayList;

import Modelo_EJ5.Gestor;
import Modelo_EJ5.Mascota;

public class Controlador {
	public boolean eliminarMascotaID(int Id) {
		Gestor gestor = new Gestor();
		return gestor.eliminarMascotaID(Id);
	}
	public boolean eliminarMascotaDNI(String DNI) {
	
		Gestor gestor = new Gestor();
		return gestor.eliminarMascotaDNI(DNI);
	}
	public boolean añadirMascota(Mascota mascota) {
		Gestor gestor = new Gestor();
		return gestor.añadirMascota(mascota);
	}
	public ArrayList<Mascota> todasMascotas() {
		Gestor gestor = new Gestor();
		return gestor.todasMascotas();
	}
	public ArrayList<Mascota> mascotasDNI(String Dni) {
		Gestor gestor = new Gestor();
		return gestor.mascotasDNI(Dni);
	}
}
