package Reto2Controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;

import Reto2Modelo.Aerolinea;
import Reto2Modelo.Aeropuerto;
import Reto2Modelo.Agencia;
import Reto2Modelo.Alojamiento;
import Reto2Modelo.Gestor;
import Reto2Modelo.Otros;
import Reto2Modelo.Pais;
import Reto2Modelo.SQLQueries;
import Reto2Modelo.Viaje;
import Reto2Modelo.Vuelo;

public class Controlador {

	public Agencia login(String usuario, String contraseña) {
		Gestor gestor = new Gestor();
		return gestor.login(usuario, contraseña);
	}

	public boolean insertarAgencia(Agencia agencia) {

		Gestor gestor = new Gestor();
		return gestor.insertarAgencia(agencia);
	}

	public ArrayList<Viaje> getListaViajes(ArrayList<Pais> paises, Agencia agencia) {
		ArrayList<Viaje> viajes = null;
		Gestor gestor = new Gestor();
		viajes = gestor.buscarTodosViajes(paises, agencia);
		viajes.sort(Comparator.comparing(Viaje::getFechaInicio));
		return viajes;
	}

	public ArrayList<Vuelo> getListaVuelos(Viaje viaje, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		ArrayList<Vuelo> vuelos = null;
		Gestor gestor = new Gestor();
		vuelos = gestor.buscarTodosVuelos(viaje, aeropuertos, aerolineas);
		return vuelos;
	}

	public int getSumaVuelos() {
		Gestor gestor = new Gestor();
		return gestor.getSumaVuelos();

	}

	public ArrayList<Alojamiento> getListaAlojamiento(Viaje viaje) {
		ArrayList<Alojamiento> alojamientos = null;
		Gestor gestor = new Gestor();
		alojamientos = gestor.buscarTodosAlojamiento(viaje);
		return alojamientos;
	}

	public ArrayList<Otros> getListaOtros(Viaje viaje) {
		ArrayList<Otros> otrosLista = null;
		Gestor gestor = new Gestor();
		otrosLista = gestor.buscarTodosOtros(viaje);
		return otrosLista;
	}

	public ArrayList<Pais> getListaPaises() {
		ArrayList<Pais> paises = null;
		Gestor gestor = new Gestor();
		paises = gestor.buscarTodosPaises();
		paises.sort(Comparator.comparing(Pais::getDescripcionPais));
		return paises;
	}

	public ArrayList<Aeropuerto> getListaAeropuertos() {
		ArrayList<Aeropuerto> aeropuertos = null;
		Gestor gestor = new Gestor();
		aeropuertos = gestor.buscarTodosAeropuertos();
		aeropuertos.sort(Comparator.comparing(Aeropuerto::getNombreAeropuerto));
		return aeropuertos;
	}

	public ArrayList<Aerolinea> getListaAerolineas() {
		ArrayList<Aerolinea> aerolineas = null;
		Gestor gestor = new Gestor();
		aerolineas = gestor.buscarTodosAerolineas();
		aerolineas.sort(Comparator.comparing(Aerolinea::getNombreAerolinea));
		return aerolineas;
	}

	public boolean insertarViaje(Viaje viaje) {
		Gestor gestor = new Gestor();
		return gestor.insertarViaje(viaje);
	}

	public boolean insertarAlojamiento(Alojamiento alojamiento) {
		Gestor gestor = new Gestor();
		return gestor.insertarAlojamiento(alojamiento);
	}

	public boolean insertarOtros(Otros otro) {
		Gestor gestor = new Gestor();
		return gestor.insertarOtros(otro);
	}

	public boolean insertarVuelo(Vuelo vuelo) {
		Gestor gestor = new Gestor();
		return gestor.insertarVuelo(vuelo);
	}

	public boolean eliminarVuelo(Vuelo vuelo) {
		Gestor gestor = new Gestor();
		boolean valido = true;
		valido = gestor.eliminarVuelo(vuelo);

		if (vuelo.getEventoVueltaID() != null && valido == true) {
			valido = gestor.eliminarVuelo(vuelo.getEventoVueltaID());
		}
		return valido;
	}

	public boolean eliminarAlojamiento(Alojamiento alojamiento) {
		Gestor gestor = new Gestor();
		return gestor.eliminarAlojamiento(alojamiento);
	}

	public boolean eliminarOtros(Otros otro) {
		Gestor gestor = new Gestor();
		return gestor.eliminarOtros(otro);
	}

	public boolean eliminarViaje(Viaje viaje) {
		Gestor gestor = new Gestor();
		boolean valido = true;
		ArrayList<Vuelo> vuelosArray = viaje.getVuelos();
		for (int z = 0; z < vuelosArray.size(); z++) {
			if (valido == true) {
				valido = eliminarVuelo(vuelosArray.get(z));
			}
		}
		ArrayList<Alojamiento> alojamientosArray = viaje.getAlojamientos();
		for (int e = 0; e < alojamientosArray.size(); e++) {
			if (valido == true) {
				valido = eliminarAlojamiento(alojamientosArray.get(e));
			}
		}
		ArrayList<Otros> otrosArray = viaje.getOtros();
		for (int d = 0; d < otrosArray.size(); d++) {
			if (valido == true) {
				valido = eliminarOtros(otrosArray.get(d));
			}
		}

		if (valido == true) {
			valido = gestor.eliminarViaje(viaje);
		}
		return valido;
	}

	public boolean crearFichero(String urlArchivo, ArrayList<String> cadenas) {
		boolean valido = false;
		try {

			FileWriter fichero = new FileWriter(urlArchivo);

			PrintWriter pw = new PrintWriter(fichero);
			for (int i = 0; i < cadenas.size(); i++) {
				pw.println(cadenas.get(i));
			}
			fichero.close();
			valido = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valido;
	}
	public void generarOfertaViaje(Viaje viaje) {
		String nombreArchivo = viaje.getNombreViaje().replaceAll(" ", "") + ".txt";
		String urlArchivo = System.getProperty("user.home") + "/Desktop/" + nombreArchivo;
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas = generarViaje(viaje);
		cadenas.addAll(generarEventos(viaje, null));
		if (crearFichero(urlArchivo, cadenas) == true) {
			JOptionPane.showMessageDialog(null,
					"¡El informe del viaje " + viaje.getNombreViaje()
							+ " se ha creado correctamente en el escritorio con el nombre " + nombreArchivo + "!",
					viaje.getNombreViaje(), JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public String generarViajes(Agencia agencia) {
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add("\n------------- VIAJES DE LA AGENCIA - " + agencia.getNombreAgencia() + "-------------\n");
		for (Viaje viaje : agencia.getViajes()) {
			cadenas.addAll(generarViaje(viaje));
			cadenas.add("\n");

		}
		String nombreArchivo = "informes-viajes-" + agencia.getNombreAgencia().replaceAll(" ", "") + ".txt";
		String urlArchivo = System.getProperty("user.home") + "/Desktop/" + nombreArchivo;
		crearFichero(urlArchivo, cadenas);
		return nombreArchivo;
	}

	public String generarViajesPais(Agencia agencia) {
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add("\n------------- VIAJES DE LA AGENCIA - " + agencia.getNombreAgencia() + "-------------\n");
		ArrayList<Viaje> viajes = agencia.getViajes();
		ArrayList<String> paisesrecorridos = new ArrayList<String>();
		viajes.sort(Comparator.comparing(viaje -> viaje.getPaisDestino().getDescripcionPais()));
		for (Viaje viaje : agencia.getViajes()) {
			if (!paisesrecorridos.contains(viaje.getPaisDestino().getDescripcionPais())) {
				cadenas.add(
						"\n------------- VIAJES EN " + viaje.getPaisDestino().getDescripcionPais() + "-------------\n");
				paisesrecorridos.add(viaje.getPaisDestino().getDescripcionPais());
			}
			cadenas.addAll(generarViaje(viaje));
			cadenas.add("\n");

		}
		String nombreArchivo = "informes-viajes-pais-" + agencia.getNombreAgencia().replaceAll(" ", "") + ".txt";
		String urlArchivo = System.getProperty("user.home") + "/Desktop/" + nombreArchivo;
		crearFichero(urlArchivo, cadenas);
		return nombreArchivo;
	}

	public String generarViajesEventos(Agencia agencia) {
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add(
				"\n------------- VIAJES y EVENTOS DE LA AGENCIA - " + agencia.getNombreAgencia() + "-------------\n");
		for (Viaje viaje : agencia.getViajes()) {
			cadenas.addAll(generarViaje(viaje));
			cadenas.addAll(generarEventos(viaje, null));
			cadenas.add("\n");
		}
		String nombreArchivo = "informes-viajes-eventos-" + agencia.getNombreAgencia().replaceAll(" ", "") + ".txt";
		String urlArchivo = System.getProperty("user.home") + "/Desktop/" + nombreArchivo;
		crearFichero(urlArchivo, cadenas);
		return nombreArchivo;
	}

	public String generarEventosPrecio(Agencia agencia) {
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add("\n------------- VIAJES y EVENTOS DE LA AGENCIA ORDENADOS POR PRECIO - "
				+ agencia.getNombreAgencia() + "-------------\n");
		for (Viaje viaje : agencia.getViajes()) {
			cadenas.addAll(generarViaje(viaje));
			cadenas.addAll(generarEventos(viaje, "precio"));
			cadenas.add("\n");
		}
		String nombreArchivo = "informes-eventos-precio-" + agencia.getNombreAgencia().replaceAll(" ", "") + ".txt";
		String urlArchivo = System.getProperty("user.home") + "/Desktop/" + nombreArchivo;
		crearFichero(urlArchivo, cadenas);
		return nombreArchivo;
	}

	public ArrayList<String> generarViaje(Viaje viaje) {
		ArrayList<String> cadenas = new ArrayList<String>();
		cadenas.add("Nombre: " + viaje.getNombreViaje());
		cadenas.add("Fechas del viaje: " + viaje.getFechaInicio() + " al " + viaje.getFechaFin());
		cadenas.add("Tipo del viaje: " + viaje.getTipoViaje());
		cadenas.add("Pais: " + viaje.getPaisDestino().getDescripcionPais());
		cadenas.add("Descripción: " + viaje.getDescripciónViaje());
		cadenas.add("Servicios no incluidos: " + viaje.getServiciosNoIncluidos());
		return cadenas;
	}

	public ArrayList<String> generarEventos(Viaje viaje, String ordenar) {
		double precioTotal = 0;
		String[][] eventos = new String[1000][2];
		int i = 0;

		for (Alojamiento alojamiento : viaje.getAlojamientos()) {
			ArrayList<String> cadenas = new ArrayList<String>();
			cadenas.add("\n------------- ALOJAMIENTO - " + alojamiento.getNombreEvento() + " -------------");
			cadenas.add("Fechas de estancia: " + alojamiento.getFechaEntrada() + " al " + alojamiento.getFechaSalida());
			String Tipo = "";
			if (alojamiento.getTipoHabitacion().equals("DB")) {
				Tipo = "Doble";
			} else if (alojamiento.getTipoHabitacion().equals("DUI")) {
				Tipo = "Doble con uso individual";
			} else if (alojamiento.getTipoHabitacion().equals("SIN")) {
				Tipo = "Individual";
			} else if (alojamiento.getTipoHabitacion().equals("TPL")) {
				Tipo = "Triple";
			}
			cadenas.add("Estancia en " + alojamiento.getNombreHotel() + " (" + alojamiento.getCiudad()
					+ ") en una habitación " + Tipo);
			cadenas.add("Precio de la estancia: " + alojamiento.getPrecio() + "€");
			precioTotal = precioTotal + Double.parseDouble(alojamiento.getPrecio());
			eventos[i][0] = alojamiento.getPrecio();
			eventos[i][1] = String.join("\n", cadenas);
			i++;
		}
		for (Otros otro : viaje.getOtros()) {
			ArrayList<String> cadenas = new ArrayList<String>();
			cadenas.add("\n------------- " + otro.getNombreEvento() + "-------------");
			cadenas.add("Fecha: " + otro.getFecha());
			cadenas.add("Precio: " + otro.getPrecio() + "€");
			cadenas.add("Descripción: " + otro.getDescripcion());
			precioTotal = precioTotal + Double.parseDouble(otro.getPrecio());
			eventos[i][0] = otro.getPrecio();
			eventos[i][1] = String.join("\n", cadenas);
			i++;
		}
		for (Vuelo vuelo : viaje.getVuelos()) {
			ArrayList<String> cadenas = new ArrayList<String>();
			cadenas.add("\n------------- VUELO -- " + vuelo.getNombreEvento() + "-------------");
			cadenas.add("Precio: " + vuelo.getPrecio() + "€");
			precioTotal = precioTotal + Double.parseDouble(vuelo.getPrecio());

			cadenas.add("\n------------- VUELO DE IDA -------------");
			cadenas.add(vuelo.getAeropuertoOrigen().getNombreAeropuerto() + " a "
					+ vuelo.getAeropuertoDestino().getNombreAeropuerto());
			cadenas.add("Código de vuelo: " + vuelo.getCodigoVuelo());
			cadenas.add("Aerolinea: " + vuelo.getAerolinea().getNombreAerolinea());
			cadenas.add("Fecha y hora: " + vuelo.getFechaSalida() + " a las " + vuelo.getHoraSalida()
					+ " y el vuelo dura " + vuelo.getDuracionVuelo());
			if (vuelo.getEventoVueltaID() != null) {
				cadenas.add("\n------------- VUELO DE VUELTA -------------");
				cadenas.add(vuelo.getEventoVueltaID().getAeropuertoOrigen().getNombreAeropuerto() + " a "
						+ vuelo.getEventoVueltaID().getAeropuertoDestino().getNombreAeropuerto());
				cadenas.add("Código de vuelo: " + vuelo.getEventoVueltaID().getCodigoVuelo());
				cadenas.add("Aerolinea: " + vuelo.getEventoVueltaID().getAerolinea().getNombreAerolinea());
				cadenas.add("Fecha y hora: " + vuelo.getEventoVueltaID().getFechaSalida() + " a las "
						+ vuelo.getEventoVueltaID().getHoraSalida() + " y el vuelo dura "
						+ vuelo.getEventoVueltaID().getDuracionVuelo());
			}
			eventos[i][0] = vuelo.getPrecio();
			eventos[i][1] = String.join("\n", cadenas);
			i++;
		}
		ArrayList<String> cadenas = new ArrayList<String>();
		if (ordenar == "precio") {
			Arrays.sort(eventos, (a, b) -> {
				if (a[0] != null) {
					double precioA = Double.parseDouble(a[0]);
					double precioB = Double.parseDouble(b[0]);
					return Double.compare(precioB, precioA);
				}
				return 0;
			});
		}
		if (i != 0) {
			cadenas.add("\n------------- EVENTOS -------------\n");
			for (int z = 0; z < eventos.length; z++) {
				if (eventos[z][0] != null) {
					cadenas.add(eventos[z][1]);
				}
			}
			cadenas.add("---------------PRECIO TOTAL: " + precioTotal + "€ ---------------");

		} else {
			cadenas.add("\n------------- NO HAY NINGÚN EVENTO -------------\n");

		}
		return cadenas;
	}

}
