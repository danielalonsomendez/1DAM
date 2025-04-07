package Modelo;

import java.util.ArrayList;

public class Foto extends Publicacion {
	private String nombreArchivo;
	private String titulo;

	public Foto(String id_Usuario, long instante_tiempo, int likes, ArrayList<String> comentarios, String nombreArchivo,
			String titulo) {
		super(id_Usuario, instante_tiempo, likes, comentarios);
		this.nombreArchivo = nombreArchivo;
		this.titulo = titulo;
	}

	public Foto(String id_Usuario, String nombreArchivo, String titulo) {
		super(id_Usuario);
		this.nombreArchivo = nombreArchivo;
		this.titulo = titulo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toStringArchivo() {
		return "Foto nº" + id +"\nFichero: " + nombreArchivo + "\nTítulo: " + titulo+ super.toStringArchivo() ;
	}
	@Override
	public String toString() {
		return "Foto nº" + id + super.toString()+"\nFichero: " + nombreArchivo + "\nTítulo: " + titulo;
	}

}
