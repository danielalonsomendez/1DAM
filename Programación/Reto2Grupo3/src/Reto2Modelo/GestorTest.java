package Reto2Modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestorTest {
	Agencia agencia;
	Viaje viaje;
	Gestor gestor;
	String hola;
	ArrayList<Pais> paises;
	ArrayList<Aeropuerto> aeropuertos;
	ArrayList<Aerolinea> aerolineas;

	@Before
	public void iniciarGestor() {
		gestor = new Gestor();
		agencia = new Agencia();
		paises = gestor.buscarTodosPaises();
		aeropuertos = gestor.buscarTodosAeropuertos();
		aerolineas = gestor.buscarTodosAerolineas();
		agencia.setNombreAgencia("Agencia Test");
		agencia.setColorMarca("#ff5733");
		agencia.setLogo("https://google.com");
		agencia.setNumeroEmpleados("Entre 2 y 10 empleados");
		agencia.setTipoAgencia("mayorista");
		agencia.setContraseña("3421");
		viaje = new Viaje();
		viaje.setNombreAgencia(agencia);
		viaje.setNombreViaje("Viaje a Madrid");
		viaje.setTipoViaje("Novios");
		for (Pais pais : paises) {
			if (pais.getDescripcionPais().equals("ALEMANIA")) {
				viaje.setPaisDestino(pais);
			}
		}
		viaje.setFechaInicio("2025/03/01");
		viaje.setFechaFin("2023/03/05");
		viaje.setDescripciónViaje("Viaje a Barcelona de 4 dias");
		viaje.setServiciosNoIncluidos("No incluye alojamiento.");
	}

	@Test
	public void test1_InsertarAgencia() {
		boolean agenciaNueva = gestor.insertarAgencia(agencia);
		assertTrue("La agencia no se crea correctamente", agenciaNueva);
	}

	@Test
	public void test2_Login() {
		agencia = gestor.login("Agencia Test", "3421");
		assertTrue("El login no es correcto", agencia instanceof Agencia);
	}

	@Test
	public void test3_InsertarViaje() {
		boolean viajeCreado = gestor.insertarViaje(viaje);
		assertTrue("El viaje no se crea correctamente", viajeCreado);
	}

	@Test
	public void test4_InsertarAlojamiento() {
		Alojamiento alojamiento = new Alojamiento();
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean alojamientoCreado = false;
		if (viajes.size() != 0) {
			alojamiento.setViajeID(viajes.get(0));
			alojamiento.setNombreEvento("Alojamiento Madrid");
			alojamiento.setPrecio("100");
			alojamiento.setNombreHotel("Hotel 1");
			alojamiento.setFechaEntrada("2025/03/01");
			alojamiento.setFechaSalida("2025/03/05");
			alojamiento.setCiudad("Madrid");
			alojamiento.setTipoHabitacion("DB");
			alojamientoCreado = gestor.insertarAlojamiento(alojamiento);
		}
		assertTrue("El alojamiento no se crea correctamente", alojamientoCreado);

	}

	@Test
	public void test4_InsertarOtros() {
		Otros otros = new Otros();
		boolean OtroCreado = false;
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		if (viajes.size() != 0) {
			otros.setViajeID(viajes.get(0));
			otros.setNombreEvento("Buceos Madrid");
			otros.setPrecio("100");
			otros.setFecha("2025/03/03");
			otros.setDescripcion("Es muy divertido poder bucear en la fuente de la ciudad");
			OtroCreado = gestor.insertarOtros(otros);
		}
		assertTrue("El evento  no se crea correctamente", OtroCreado);
	}

	@Test
	public void test4_InsertarVuelo() {
		Vuelo vuelo = new Vuelo();
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean VueloCreado = false;

		if (viajes.size() != 0) {
			vuelo.setViajeID(viajes.get(0));
			vuelo.setNombreEvento("Vuelo a Madrid");
			vuelo.setPrecio("200");
			vuelo.setDuracionVuelo("1:30");
			for (Aerolinea aerolinea : aerolineas) {
				if (aerolinea.getNombreAerolinea().equals("RYNAIR")) {
					vuelo.setAerolinea(aerolinea);
				}
			}
			vuelo.setCodigoVuelo("4352f");
			vuelo.setHoraSalida("07:33");
			vuelo.setFechaSalida("2025/03/01");
			for (Aeropuerto aeropuerto : aeropuertos) {
				if (aeropuerto.getNombreAeropuerto().equals("Santiago de Compostela")) {
					vuelo.setAeropuertoOrigen(aeropuerto);

				}
				if (aeropuerto.getNombreAeropuerto().equals("Madrid")) {
					vuelo.setAeropuertoDestino(aeropuerto);
				}
			}
			VueloCreado = gestor.insertarVuelo(vuelo);
		}
		assertTrue("El vuelo no se crea correctamente", VueloCreado);

	}

	@Test
	public void test5_BuscarTodosViajes() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		assertTrue("La lista de viajes no se carga correctamente", viajes.size() != 0);
	}

	@Test
	public void test5_BuscarTodosVuelos() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean busquedaCorrecta = false;
		if (viajes.size() != 0) {
			ArrayList<Vuelo> vuelos = gestor.buscarTodosVuelos(viajes.get(0), aeropuertos, aerolineas);
			busquedaCorrecta = vuelos.size() != 0;
		}

		assertTrue("La lista de vuelos no se carga correctamente", busquedaCorrecta);

	}

	@Test
	public void test5_BuscarTodosAlojamiento() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean busquedaCorrecta = false;
		if (viajes.size() != 0) {
			ArrayList<Alojamiento> alojamientos = gestor.buscarTodosAlojamiento(viajes.get(0));
			busquedaCorrecta = alojamientos.size() != 0;
		}
		assertTrue("La lista de viajes no se carga correctamente", busquedaCorrecta);
	}

	@Test
	public void test5_BuscarTodosOtros() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean busquedaCorrecta = false;
		if (viajes.size() != 0) {
			ArrayList<Otros> otros = gestor.buscarTodosOtros(viajes.get(0));
			busquedaCorrecta = otros.size() != 0;

		}
		assertTrue("La lista de otros no se carga correctamente", busquedaCorrecta);

	}

	@Test
	public void test5_BuscarTodosPaises() {
		assertTrue("La lista de paises no se carga correctamente", paises.size() != 0);
	}

	@Test
	public void test5_BuscarTodosAeropuertos() {
		assertTrue("La lista de aeropuertos no se carga correctamente", aeropuertos.size() != 0);
	}

	@Test
	public void test5_BuscarTodosAerolineas() {
		assertTrue("La lista de aerolineas no se carga correctamente", aerolineas.size() != 0);
	}

	@Test
	public void test5_GetVuelo() {
		Vuelo vueloObtenido = gestor.getVuelo(gestor.getSumaVuelos() + "", aeropuertos, aerolineas, viaje);
		assertTrue("El vuelo no se ha obtenido correctamente", vueloObtenido instanceof Vuelo);
	}

	@Test
	public void test5_EliminarVuelo() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean eliminar = false;
		if (viajes.size() != 0) {
			ArrayList<Vuelo> vuelos = gestor.buscarTodosVuelos(viajes.get(0), aeropuertos, aerolineas);
			if (vuelos.size() != 0) {
				eliminar = gestor.eliminarVuelo(vuelos.get(0));
			}
		}
		assertTrue("El vuelo no se elimina correctamente", eliminar);
	}

	@Test
	public void test5_EliminarAlojamiento() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean eliminar = false;
		if (viajes.size() != 0) {
			ArrayList<Alojamiento> alojamientos = gestor.buscarTodosAlojamiento(viajes.get(0));
			if (alojamientos.size() != 0) {
				eliminar = gestor.eliminarAlojamiento(alojamientos.get(0));
			}
		}
		assertTrue("El alojamiento no se elimina correctamente", eliminar);
	}

	@Test
	public void test5_EliminarOtros() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean eliminar = false;
		if (viajes.size() != 0) {
			ArrayList<Otros> otros = gestor.buscarTodosOtros(viajes.get(0));
			if (otros.size() != 0) {
				eliminar = gestor.eliminarOtros(otros.get(0));
			}
		}
		assertTrue("El servicio otros no se elimina correctamente", eliminar);
	}

	@Test
	public void test6_EliminarViaje() {
		ArrayList<Viaje> viajes = gestor.buscarTodosViajes(paises, agencia);
		boolean eliminar = false;
		if (viajes.size() != 0) {
			eliminar = gestor.eliminarViaje(viajes.get(0));
		}
		assertTrue("El viaje no se elimina correctamente", eliminar);

	}

}
