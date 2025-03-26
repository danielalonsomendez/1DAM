package Controlador_EJ5W;

import java.sql.SQLException;
import java.util.ArrayList;

import Modelo_EJ5W.Gestor;
import Modelo_EJ5W.Mascota;

public class Controlador {
	public boolean eliminarMascotaID(int Id)throws SQLException,Exception {
		Gestor gestor = new Gestor();
		return gestor.eliminarMascotaID(Id);
	}
	public boolean añadirMascota(Mascota mascota)throws SQLException,Exception {
		Gestor gestor = new Gestor();
		return gestor.añadirMascota(mascota);
	}
	public ArrayList<Mascota> todasMascotas()throws SQLException,Exception {
		Gestor gestor = new Gestor();
		return gestor.todasMascotas();
	}
}
