package Reto2Modelo;

public class Alojamiento {
	/* Atributos comunes de todos los eventos */
	private String EventoID;
	private String NombreEvento;
	private String Precio;
	private Viaje ViajeID;
	
	private String NombreHotel;
	private String Ciudad;
	private String FechaEntrada;
	private String FechaSalida;
	private String TipoHabitacion = "DB";
	
	public Alojamiento() {
		
	}

	public Alojamiento(String eventoID, String nombreEvento, String precio, Viaje viajeID, String nombreHotel,
			String ciudad, String fechaEntrada, String fechaSalida, String tipoHabitacion) {
		EventoID = eventoID;
		NombreEvento = nombreEvento;
		Precio = precio;
		ViajeID = viajeID;
		NombreHotel = nombreHotel;
		Ciudad = ciudad;
		FechaEntrada = fechaEntrada;
		FechaSalida = fechaSalida;
		TipoHabitacion = tipoHabitacion;
	}

	public String getEventoID() {
		return EventoID;
	}

	public void setEventoID(String eventoID) {
		EventoID = eventoID;
	}

	public String getNombreEvento() {
		return NombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		NombreEvento = nombreEvento;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}

	public Viaje getViajeID() {
		return ViajeID;
	}

	public void setViajeID(Viaje viajeID) {
		ViajeID = viajeID;
	}

	public String getNombreHotel() {
		return NombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		NombreHotel = nombreHotel;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getFechaEntrada() {
		return FechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		FechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public String getTipoHabitacion() {
		return TipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		TipoHabitacion = tipoHabitacion;
	}

	@Override
	public String toString() {
		return "Alojamiento [EventoID=" + EventoID + ", NombreEvento=" + NombreEvento + ", Precio=" + Precio
				+ ", ViajeID=" + ViajeID + ", NombreHotel=" + NombreHotel + ", Ciudad=" + Ciudad + ", FechaEntrada="
				+ FechaEntrada + ", FechaSalida=" + FechaSalida + ", TipoHabitacion=" + TipoHabitacion + "]";
	}
	
	

	

}
