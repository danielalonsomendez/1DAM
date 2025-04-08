package ControladorEJ2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import ModeloRE2.FuenteNoticias;
import ModeloRE2.Gestor;
import ModeloRE2.Publicacion;


public class Controlador {
	public ArrayList<Publicacion> selectPublicaciones() throws SQLException, Exception {
		ArrayList<Publicacion> publicaciones = null;
		Gestor gestor = new Gestor();
		publicaciones = gestor.selectPublicaciones();
		return publicaciones;
	}

	public void actualizarArchivo(FuenteNoticias fuentenoticias) throws IOException  {
		Gestor gestor = new Gestor();
		gestor.actualizarArchivo(fuentenoticias);
		
	}
}
