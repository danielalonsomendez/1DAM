package Vista;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ControladorEJ2.Controlador;
import ModeloRE2.Foto;
import ModeloRE2.FuenteNoticias;
import ModeloRE2.Mensaje;
import ModeloRE2.Publicacion;

public class MenuRE2 {
	Scanner teclado = new Scanner(System.in);
	Controlador controlador = new Controlador();
	FuenteNoticias fuentenoticias = new FuenteNoticias();

	public void verMenu() {
		int opcion = 0;

		do {
			try {
				fuentenoticias.setPublicaciones(controlador.selectPublicaciones());
			} catch (SQLException e) {
				System.out.println("No se ha podido cargar los datos de la BD"+e);
			} catch (Exception e) {
				System.out.println("No se ha podido cargar los datos de la BD"+e);
			}
			opcion = elegirOpcion(teclado);
			teclado.nextLine();
			switch (opcion) {
			case 1:
				añadir(pedirMensajeTexto());
				System.out.println("Se ha añadido el mensaje correctamente.");
				break;
			case 2:
				añadir(pedirFoto());
				System.out.println("Se ha añadido la foto correctamente.");
				break;
			case 3:
				mostrarMensajes();
				break;
			case 4:
				mostrarMensajesUsuario();
				break;
			case 5:
				comentarMensaje();
				break;
			case 6:
				like(true);
				break;
			case 7:
				like(false);
				break;
			case 8:
				try {
					controlador.actualizarArchivo(fuentenoticias);
				} catch (IOException e) {
					System.out.println("No se ha podido actualizar el archivo.");
				}
			}

		} while (opcion != 8);
		teclado.close();
	}

	public int elegirOpcion(Scanner teclado) {
		System.out.println("       MENÚ PUBLICACIONES");
		System.out.println("       --------------");
		System.out.println("1. Añadir mensaje de texto.");
		System.out.println("2. Añadir foto");
		System.out.println("3. Mostrar mensajes");
		System.out.println("4. Mostrar mensajes de usuario");
		System.out.println("5. Comentar un mensaje");
		System.out.println("6. Dar likes a mensajes:");
		System.out.println("7. Dar unlikes a mensajes");
		System.out.println("8. Salir.");

		System.out.println("");
		boolean opcionCorrecta = false;
		int opcion = 0;

		do {
			try {
				System.out.print("Introduzca una opcion: ");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 8) {
					System.out.println("Debe introducir un número entre 1 y 8.");
				} else {
					opcionCorrecta = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Se debe introducir un número entero.");
				teclado.nextLine();
			}
		} while (!opcionCorrecta);
		return opcion;
	}

	public void añadir(Publicacion publicacion) {
		try {
			controlador.añadirPublicacion(publicacion);
		} catch (SQLException e) {
			System.out.println("No se ha podido añadir la publicación");
		} catch (Exception e) {
			System.out.println("No se ha podido añadir la publicación");
		}
	}

	public void mostrarMensajes() {
		for (Publicacion publicacion : fuentenoticias.getPublicaciones()) {
			System.out.println(publicacion + "\n--------------------------------");
		}
	}

	public void mostrarMensajesUsuario() {
		String usuario = pedirUsuario();
		for (Publicacion publicacion : fuentenoticias.getPublicaciones()) {
			if (publicacion.getid_Usuario().equals(usuario)) {
				System.out.println(publicacion + "\n--------------------------------");
			}
		}
	}

	public void like(boolean like) {
		try {
			controlador.like(like, seleccionarPublicacion());
		} catch (SQLException e) {
			System.out.println("No se ha podido hacer/deshacer el like");
		} catch (Exception e) {
			System.out.println("No se ha podido hacer/deshacer el like");
		}
	}

	public void comentarMensaje() {
		teclado.nextLine();
		System.out.print("Introduce el comentario: ");
		try {
			controlador.añadirComentario(teclado.nextLine(), seleccionarPublicacion());
		} catch (SQLException e) {
			System.out.println("No se ha podido añadir el comentario a la base de datos... " + e);
		} catch (Exception e) {
			System.out.println("No se ha podido añadir el comentario a la base de datos... ");
		}
	}

	public Publicacion seleccionarPublicacion() {
		mostrarMensajes();
		int id = pedirMensajeId();
		return fuentenoticias.getPublicaciones().get(id - 1);
	}

	public int pedirMensajeId() {
		System.out.print("Introduce el ID del mensaje: ");
		return teclado.nextInt();
	}

	public String pedirUsuario() {
		System.out.print("Introduce el nombre del usuario: ");
		return teclado.nextLine();
	}

	public Mensaje pedirMensajeTexto() {
		System.out.print("Introduce el texto a publicar: ");
		String contenido = teclado.nextLine();
		return new Mensaje(pedirUsuario(), contenido);
	}

	public Foto pedirFoto() {
		System.out.print("Introduce el nombre del archivo: ");
		String nombreArchivo = teclado.nextLine();
		System.out.print("Introduce el titulo: ");
		String titulo = teclado.nextLine();
		return new Foto(pedirUsuario(), nombreArchivo, titulo);
	}

}
