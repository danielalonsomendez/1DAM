package Reto2Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Gestor {
	public Agencia login(String usuario, String contraseña) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		Agencia agencia = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_AGENCIA_NOMBRE_CONTRASEÑA;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, usuario);
			sentencia.setString(2, contraseña);
			resultSet = sentencia.executeQuery();

			if (resultSet.isBeforeFirst() && resultSet.next()) {
				agencia = new Agencia();
				agencia.setNombreAgencia(resultSet.getString("NombreAgencia"));
				agencia.setLogo(resultSet.getString("Logo"));
				agencia.setColorMarca(resultSet.getString("ColorMarca"));
				agencia.setNumeroEmpleados(resultSet.getString("NumeroEmpleados"));
				agencia.setTipoAgencia(resultSet.getString("TipoAgencia"));

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return agencia;
	}

	public boolean insertarAgencia(Agencia agencia) {

		String sql = SQLQueries.INSERT_AGENCIA + agencia.getNombreAgencia() + SQLQueries.SEPARATOR + agencia.getLogo()
				+ SQLQueries.SEPARATOR + agencia.getColorMarca() + SQLQueries.SEPARATOR + agencia.getNumeroEmpleados()
				+ SQLQueries.SEPARATOR + agencia.getTipoAgencia() + SQLQueries.SEPARATOR + agencia.getContraseña()
				+ SQLQueries.END_BLOCK;
		return insertar(sql);

	}

	public ArrayList<Viaje> buscarTodosViajes(ArrayList<Pais> paises, Agencia agencia) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Viaje> viajes = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_VIAJES_AGENCIA;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, agencia.getNombreAgencia());
			resultSet = sentencia.executeQuery();
			viajes = new ArrayList<Viaje>();
			while (resultSet.next()) {
				Viaje viaje = new Viaje();
				viaje.setViajeID(resultSet.getString("ViajeID"));
				viaje.setNombreViaje(resultSet.getString("NombreViaje"));
				viaje.setDescripciónViaje(resultSet.getString("DescripcionViaje"));
				viaje.setTipoViaje(resultSet.getString("TipoViaje"));
				viaje.setFechaInicio(resultSet.getString("FechaInicio"));
				viaje.setFechaFin(resultSet.getString("FechaFin"));
				viaje.setDuracionViaje(resultSet.getString("DuracionViaje"));
				viaje.setServiciosNoIncluidos(resultSet.getString("ServiciosNoIncluidos"));

				for (Pais pais : paises) {
					if (resultSet.getString("PaisDestino").equals(pais.getPaisCodigo()) == true) {
						viaje.setPaisDestino(pais);
					}
				}
				viaje.setNombreAgencia(agencia);
				viajes.add(viaje);

			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return viajes;
	}

	public ArrayList<Vuelo> buscarTodosVuelos(Viaje viaje, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Vuelo> vuelos = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_VUELOS_VIAJE;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, viaje.getViajeID());
			resultSet = sentencia.executeQuery();
			vuelos = new ArrayList<Vuelo>();
			while (resultSet.next()) {
				Vuelo vuelo = new Vuelo();
				vuelo.setViajeID(viaje);
				vuelo.setEventoID(resultSet.getString("EventoID"));
				vuelo.setNombreEvento(resultSet.getString("NombreEvento"));
				vuelo.setPrecio(resultSet.getString("Precio"));
				vuelo.setCodigoVuelo(resultSet.getString("CodigoVuelo"));
				vuelo.setFechaSalida(resultSet.getString("FechaSalida"));
				vuelo.setHoraSalida(resultSet.getString("HoraSalida"));
				vuelo.setDuracionVuelo(resultSet.getString("DuracionVuelo"));
				vuelo.setEventoVueltaID(
						getVuelo(resultSet.getString("EventoVueltaID"), aeropuertos, aerolineas, viaje));
				for (Aerolinea aerolinea : aerolineas) {
					if (resultSet.getString("Aerolinea").equals(aerolinea.getCodigoAerolinea()) == true) {
						vuelo.setAerolinea(aerolinea);
					}
				}
				for (Aeropuerto aerolinea : aeropuertos) {
					if (resultSet.getString("AeropuertoOrigen").equals(aerolinea.getCodigoAeropuerto()) == true) {
						vuelo.setAeropuertoOrigen(aerolinea);
					}
					if (resultSet.getString("AeropuertoDestino").equals(aerolinea.getCodigoAeropuerto()) == true) {
						vuelo.setAeropuertoDestino(aerolinea);
					}
				}
				vuelos.add(vuelo);

			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return vuelos;
	}

	public ArrayList<Alojamiento> buscarTodosAlojamiento(Viaje viaje) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Alojamiento> alojamientos = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_ALOJAMIENTO_VIAJE;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, viaje.getViajeID());
			resultSet = sentencia.executeQuery();
			alojamientos = new ArrayList<Alojamiento>();
			while (resultSet.next()) {
				Alojamiento alojamiento = new Alojamiento();
				alojamiento.setViajeID(viaje);
				alojamiento.setEventoID(resultSet.getString("EventoID"));
				alojamiento.setNombreEvento(resultSet.getString("NombreEvento"));
				alojamiento.setPrecio(resultSet.getString("Precio"));
				alojamiento.setNombreHotel(resultSet.getString("NombreHotel"));
				alojamiento.setCiudad(resultSet.getString("Ciudad"));
				alojamiento.setFechaEntrada(resultSet.getString("FechaEntrada"));
				alojamiento.setFechaSalida(resultSet.getString("FechaSalida"));
				alojamiento.setTipoHabitacion(resultSet.getString("TipoHabitacion"));

				alojamientos.add(alojamiento);

			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return alojamientos;
	}

	public ArrayList<Otros> buscarTodosOtros(Viaje viaje) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Otros> otrosLista = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_OTROS_VIAJE;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, viaje.getViajeID());
			resultSet = sentencia.executeQuery();
			otrosLista = new ArrayList<Otros>();
			while (resultSet.next()) {
				Otros otro = new Otros();
				otro.setViajeID(viaje);
				otro.setEventoID(resultSet.getString("EventoID"));
				otro.setNombreEvento(resultSet.getString("NombreEvento"));
				otro.setPrecio(resultSet.getString("Precio"));
				otro.setFecha(resultSet.getString("Fecha"));
				otro.setDescripcion(resultSet.getString("Descripcion"));

				otrosLista.add(otro);

			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return otrosLista;
	}

	public ArrayList<Pais> buscarTodosPaises() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Pais> paises = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_TODOS_PAISES;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			paises = new ArrayList<Pais>();
			while (resultSet.next()) {
				Pais pais = new Pais(resultSet.getString("PaisCodigo"), resultSet.getString("DescripcionPais"));
				paises.add(pais);

			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return paises;
	}

	public ArrayList<Aeropuerto> buscarTodosAeropuertos() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Aeropuerto> aeropuertos = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_TODOS_AEROPUERTOS;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			aeropuertos = new ArrayList<Aeropuerto>();
			while (resultSet.next()) {
				Aeropuerto aeropuerto = new Aeropuerto(resultSet.getString("CodigoAeropuerto"),
						resultSet.getString("NombreAeropuerto"));
				aeropuertos.add(aeropuerto);

			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return aeropuertos;
	}

	public ArrayList<Aerolinea> buscarTodosAerolineas() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		ArrayList<Aerolinea> aerolineas = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_TODOS_AEROLINEAS;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();
			aerolineas = new ArrayList<Aerolinea>();
			while (resultSet.next()) {
				Aerolinea aerolinea = new Aerolinea(resultSet.getString("CodigoAerolinea"),
						resultSet.getString("NombreAerolinea"));
				aerolineas.add(aerolinea);

			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar el resultset.");
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return aerolineas;
	}

	public Vuelo getVuelo(String EventoID, ArrayList<Aeropuerto> aeropuertos, ArrayList<Aerolinea> aerolineas,
			Viaje viaje) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		Vuelo vuelo = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_VUELOS_EVENTOID;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, EventoID);
			resultSet = sentencia.executeQuery();

			if (resultSet.isBeforeFirst() && resultSet.next()) {
				vuelo = new Vuelo();
				vuelo.setViajeID(viaje);
				vuelo.setEventoID(resultSet.getString("EventoID"));
				vuelo.setNombreEvento(resultSet.getString("NombreEvento"));
				vuelo.setPrecio(resultSet.getString("Precio"));
				vuelo.setCodigoVuelo(resultSet.getString("CodigoVuelo"));
				vuelo.setFechaSalida(resultSet.getString("FechaSalida"));
				vuelo.setHoraSalida(resultSet.getString("HoraSalida"));
				vuelo.setDuracionVuelo(resultSet.getString("DuracionVuelo"));
				for (Aerolinea aerolinea : aerolineas) {
					if (resultSet.getString("Aerolinea").equals(aerolinea.getCodigoAerolinea()) == true) {
						vuelo.setAerolinea(aerolinea);
					}
				}
				for (Aeropuerto aerolinea : aeropuertos) {
					if (resultSet.getString("AeropuertoOrigen").equals(aerolinea.getCodigoAeropuerto()) == true) {
						vuelo.setAeropuertoOrigen(aerolinea);
					}
					if (resultSet.getString("AeropuertoDestino").equals(aerolinea.getCodigoAeropuerto()) == true) {
						vuelo.setAeropuertoDestino(aerolinea);
					}
				}

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return vuelo;
	}

	public int getSumaVuelos() {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		int suma = 0;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			String sql = SQLQueries.SELECT_SUMA_VUELO;
			sentencia = conexion.prepareStatement(sql);
			resultSet = sentencia.executeQuery();

			if (resultSet.isBeforeFirst() && resultSet.next()) {
				suma = Integer.parseInt(resultSet.getString("max(EventoID)"));

			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		try {
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar el resultSet" + e.getMessage());
		}
		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la sentencia" + sqle.getMessage());
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println("Error al cerrar la conexión" + sqle.getMessage());
		}
		return suma;
	}

	public boolean insertar(String sql) {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(sql);
			valido = true;
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return valido;
	}

	public boolean insertarViaje(Viaje viaje) {
		String sql = SQLQueries.INSERT_VIAJE + viaje.getNombreViaje() + SQLQueries.SEPARATOR
				+ viaje.getDescripciónViaje() + SQLQueries.SEPARATOR + viaje.getTipoViaje() + SQLQueries.SEPARATOR
				+ viaje.getFechaInicio() + SQLQueries.SEPARATOR + viaje.getFechaFin() + SQLQueries.SEPARATOR
				+ viaje.getServiciosNoIncluidos() + SQLQueries.SEPARATOR + viaje.getNombreAgencia().getNombreAgencia()
				+ SQLQueries.SEPARATOR + viaje.getPaisDestino().getPaisCodigo() + SQLQueries.END_BLOCK;
		return insertar(sql);
	}

	public boolean insertarAlojamiento(Alojamiento alojamiento) {

		String sql = SQLQueries.INSERT_ALOJAMIENTO + alojamiento.getViajeID().getViajeID() + SQLQueries.SEPARATOR
				+ alojamiento.getNombreEvento() + SQLQueries.SEPARATOR + alojamiento.getPrecio() + SQLQueries.SEPARATOR
				+ alojamiento.getNombreHotel() + SQLQueries.SEPARATOR + alojamiento.getCiudad() + SQLQueries.SEPARATOR
				+ alojamiento.getFechaEntrada() + SQLQueries.SEPARATOR + alojamiento.getFechaSalida()
				+ SQLQueries.SEPARATOR + alojamiento.getTipoHabitacion() + SQLQueries.END_BLOCK;

		return insertar(sql);
	}

	public boolean insertarOtros(Otros otro) {

		String sql = SQLQueries.INSERT_OTROS + otro.getViajeID().getViajeID() + SQLQueries.SEPARATOR
				+ otro.getNombreEvento() + SQLQueries.SEPARATOR + otro.getPrecio() + SQLQueries.SEPARATOR
				+ otro.getFecha() + SQLQueries.SEPARATOR + otro.getDescripcion() + SQLQueries.END_BLOCK;

		return insertar(sql);
	}

	public boolean insertarVuelo(Vuelo vuelo) {
		String sql;
		if (vuelo.getEventoVueltaID() != null) {
			sql = SQLQueries.INSERT_VUELOIDAVUELTA + vuelo.getViajeID().getViajeID() + SQLQueries.SEPARATOR
					+ vuelo.getNombreEvento() + SQLQueries.SEPARATOR + vuelo.getPrecio() + SQLQueries.SEPARATOR
					+ vuelo.getCodigoVuelo() + SQLQueries.SEPARATOR + vuelo.getFechaSalida() + SQLQueries.SEPARATOR
					+ vuelo.getHoraSalida() + SQLQueries.SEPARATOR + vuelo.getDuracionVuelo() + SQLQueries.SEPARATOR
					+ vuelo.getAerolinea().getCodigoAerolinea() + SQLQueries.SEPARATOR
					+ vuelo.getAeropuertoOrigen().getCodigoAeropuerto() + SQLQueries.SEPARATOR
					+ vuelo.getAeropuertoDestino().getCodigoAeropuerto() + SQLQueries.SEPARATOR
					+ vuelo.getEventoVueltaID().getEventoID() + SQLQueries.END_BLOCK;
		} else {
			sql = SQLQueries.INSERT_VUELOIDA + vuelo.getViajeID().getViajeID() + SQLQueries.SEPARATOR
					+ vuelo.getNombreEvento() + SQLQueries.SEPARATOR + vuelo.getPrecio() + SQLQueries.SEPARATOR
					+ vuelo.getCodigoVuelo() + SQLQueries.SEPARATOR + vuelo.getFechaSalida() + SQLQueries.SEPARATOR
					+ vuelo.getHoraSalida() + SQLQueries.SEPARATOR + vuelo.getDuracionVuelo() + SQLQueries.SEPARATOR
					+ vuelo.getAerolinea().getCodigoAerolinea() + SQLQueries.SEPARATOR
					+ vuelo.getAeropuertoOrigen().getCodigoAeropuerto() + SQLQueries.SEPARATOR
					+ vuelo.getAeropuertoDestino().getCodigoAeropuerto() + SQLQueries.END_BLOCK;

		}

		return insertar(sql);
	}

	public boolean eliminar(String sql, ArrayList<String> atributos) {
		boolean valido = false;
		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.prepareStatement(sql);

			for (int i = 0; i < atributos.size(); i++) {
				sentencia.setString(i + 1, atributos.get(i));
			}
			sentencia.executeUpdate();
			valido = true;
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			sentencia.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la sentencia.");
		}
		try {
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return valido;

	}

	public boolean eliminarVuelo(Vuelo vuelo) {
		String sql = SQLQueries.DELETE_EVENTOID_VUELO;
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add(vuelo.getEventoID());
		return eliminar(sql, atributos);

	}

	public boolean eliminarAlojamiento(Alojamiento alojamiento) {
		String sql = SQLQueries.DELETE_EVENTOID_ALOJAMIENTO;
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add(alojamiento.getEventoID());
		return eliminar(sql, atributos);
	}

	public boolean eliminarOtros(Otros otros) {
		String sql = SQLQueries.DELETE_EVENTOID_OTROS;
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add(otros.getEventoID());
		return eliminar(sql, atributos);
	}

	public boolean eliminarViaje(Viaje viaje) {
		String sql = SQLQueries.DELETE_VIAJESID_VIAJES;
		ArrayList<String> atributos = new ArrayList<String>();
		atributos.add(viaje.getViajeID());
		return eliminar(sql, atributos);

	}

}
