package Modelo;

import java.util.ArrayList;

public class Mensaje extends Publicacion {
	private String contenido;

	public Mensaje(String id_Usuario, long instante_tiempo, int likes, ArrayList<String> comentarios, String contenido) {
		super(id_Usuario, instante_tiempo, likes, comentarios);
		this.contenido = contenido;
	}
	public Mensaje(String id_Usuario, String contenido) {
		super(id_Usuario);
		this.contenido = contenido;
	}
	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	@Override
	public String toStringArchivo() {
		return "Mensaje nº" + id + "\nTexto: " + contenido+ super.toStringArchivo() ;
	}
	@Override
	public String toString() {
		return "Mensaje nº" + id + super.toString() + "\nTexto: " + contenido;
	}

}
