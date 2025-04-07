package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Gestor {
	public ArrayList<Publicacion> leerArchivo() throws IOException {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		File archivo = new File("Redes.txt");
		try {
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
					if (linea.trim().equals("--------------------------------") == true)
						linea = br.readLine();
					if (linea != null) {
						String Id = "", Texto = "", Fichero = "", Titulo = "", Tipo = "";
						if (linea.split("Mensaje nº").length == 2) {
							Tipo = "Mensaje";
							Id = linea.split("Mensaje nº")[1];
							linea = br.readLine();
							Texto = linea.split("Texto: ")[1];
							linea = br.readLine();
						} else if (linea.split("Foto nº").length == 2) {
							Tipo = "Foto";
							Id = linea.split("Foto nº")[1];
							linea = br.readLine();
							Fichero = linea.split("Fichero: ")[1];
							linea = br.readLine();
							Titulo = linea.split("Título: ")[1];
							linea = br.readLine();
						}
						String Usuario = linea.split("Usuario: ")[1];
						linea = br.readLine();
						Long instante = Long.parseLong(linea.split("Instante: ")[1].trim());
						linea = br.readLine();
						int likes = Integer.parseInt(linea.split("Likes: ")[1].trim());
						linea = br.readLine();
						ArrayList<String> comentarios = new ArrayList<String>();
						if (linea.trim().equals("No hay comentarios") == false) {
							do {
								comentarios.add(linea.split("Comentario: ")[1]);
								linea = br.readLine();
							} while (linea.split("Comentario: ").length == 2);
						}
						if (Tipo.equals("Mensaje")) {
							publicaciones.add(new Mensaje(Usuario, instante, likes, comentarios, Texto));
						} else if (Tipo.equals("Foto")) {
							publicaciones.add(new Foto(Usuario, instante, likes, comentarios, Fichero, Titulo));
						}
					}

				}
			}

		} catch (IOException e) {
			throw new IOException(e);
		}
		return publicaciones;
	}

	public void actualizarArchivo(FuenteNoticias fuentenoticia) throws IOException  {
		try {
			FileWriter fichero = new FileWriter("Redes.txt");
			PrintWriter pw = new PrintWriter(fichero);
			for (Publicacion publicacion : fuentenoticia.getPublicaciones()) {
				pw.print(publicacion.toStringArchivo()+ "\n--------------------------------\n");
			}
			fichero.close();
		} catch (IOException e) {
			throw new IOException(e);
			}
	
	}
}
