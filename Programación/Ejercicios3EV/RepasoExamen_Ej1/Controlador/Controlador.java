package Controlador;

import java.io.IOException;
import java.util.ArrayList;

import Modelo.FuenteNoticias;
import Modelo.Gestor;
import Modelo.Publicacion;


public class Controlador {
	public ArrayList<Publicacion> leerArchivo() throws IOException {
		ArrayList<Publicacion> publicaciones = null;
		Gestor gestor = new Gestor();
		publicaciones = gestor.leerArchivo();
		return publicaciones;
	}

	public void actualizarArchivo(FuenteNoticias fuentenoticias) throws IOException  {
		Gestor gestor = new Gestor();
		gestor.actualizarArchivo(fuentenoticias);
		
	}
}
