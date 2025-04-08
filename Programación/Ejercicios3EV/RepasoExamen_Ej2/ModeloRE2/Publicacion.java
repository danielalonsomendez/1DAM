package ModeloRE2;


import java.util.ArrayList;

import ModeloRE2.Publicacion;

public class Publicacion {
	protected int id;
	protected String id_Usuario;
	protected long instante_tiempo;
	protected int likes;
	protected ArrayList<String> comentarios;
	protected static int cont=1;
	
	public Publicacion(int id,String id_Usuario, long instante_tiempo, int likes, ArrayList<String> comentarios) {
		super();
		this.id = id;
		this.id_Usuario =  id_Usuario;
		this.instante_tiempo = instante_tiempo;
		this.likes = likes;
		this.comentarios = comentarios;
	}

	public Publicacion(String id_Usuario, long instante_tiempo, int likes, ArrayList<String> comentarios) {
		super();
		this.id = cont++;
		this.id_Usuario =  id_Usuario;
		this.instante_tiempo = instante_tiempo;
		this.likes = likes;
		this.comentarios = comentarios;
	}

	public Publicacion(String id_Usuario) {
		super();
		this.id = cont++;
		this.instante_tiempo = System.currentTimeMillis();
		this.likes =0;
		this.id_Usuario = id_Usuario;
		this.comentarios = new ArrayList<String>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getid_Usuario() {
		return  id_Usuario;
	}

	public void setid_Usuario( String id_Usuario) {
		this.id_Usuario =  id_Usuario;
	}

	public long getInstante_tiempo() {
		return instante_tiempo;
	}

	public void setInstante_tiempo(long instante_tiempo) {
		this.instante_tiempo = instante_tiempo;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public ArrayList<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<String> comentarios) {
		this.comentarios = comentarios;
	}

	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		Publicacion.cont = cont;
	}

	public void incrementarLike() {
		likes++;
		}

	public void unLike() {
		likes--;
	}

	public void AñadirComentario(String comentario) {
		comentarios.add(comentario);
	}
	
	public String toStringArchivo() {
		String mensaje = "\nUsuario: " +  id_Usuario+"\nInstante: " + instante_tiempo + "\nLikes: " + likes;;
		if (comentarios.size() != 0) {
			mensaje += "\nComentario: "+ String.join("\nComentario: ", comentarios);
		} else {
			mensaje += "\nNo hay comentarios";
		}
		return mensaje;
	}
	@Override
	public String toString() {
		String mensaje = "\nUsuario: " +  id_Usuario;
		String instantemensaje = "";
		long diferenciaMinutos = (System.currentTimeMillis() - instante_tiempo) / 60000;
		long diferenciaSegundos = (System.currentTimeMillis() - instante_tiempo) / 1000;

		if (diferenciaMinutos >= 1) {
			instantemensaje = "hace " + diferenciaMinutos + " minutos";
		} else {
			instantemensaje = "hace " + diferenciaSegundos + " segundos";
		}

		mensaje += "\nInstante: " + instantemensaje + "\nLikes: " + likes;

		if (comentarios.size() != 0) {
			mensaje += "\nComentario: "+ String.join("\nComentario: ", comentarios);
		} else {
			mensaje += "\nNo hay comentarios.";

		}
		return mensaje;
	}

}
