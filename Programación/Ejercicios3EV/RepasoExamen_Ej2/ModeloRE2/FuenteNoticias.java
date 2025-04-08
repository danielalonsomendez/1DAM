package ModeloRE2;

import java.util.ArrayList;

import ModeloRE2.Publicacion;

public class FuenteNoticias {
private ArrayList<Publicacion> publicaciones;

public FuenteNoticias() {

}
public FuenteNoticias(ArrayList<Publicacion> publicaciones) {
	super();
	this.publicaciones = publicaciones;
}
//

public ArrayList<Publicacion> getPublicaciones() {
	return publicaciones;
}

public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
	this.publicaciones = publicaciones;
}
public void añadirMensaje(Publicacion publicacion) {
	publicaciones.add(publicacion);
}
@Override
public String toString() {
	String publicacionesTexto ="";
	for(Publicacion publicacion: publicaciones) {
		publicacionesTexto += publicacion.toString()+"----------------------------------";
	}
	return publicacionesTexto;
}

}
