package Reto2Modelo;

public class Vuelo  {
	/* Atributos comunes de todos los eventos */
	private String EventoID;
	private String NombreEvento;
	private String Precio;
	private Viaje ViajeID;
	
	private String CodigoVuelo;
	private String FechaSalida;
	private String HoraSalida;
	private String DuracionVuelo;
	private Aeropuerto AeropuertoOrigen;
	private Aeropuerto AeropuertoDestino;
	private Aerolinea Aerolinea;
	
	private Vuelo EventoVueltaID;

	public Vuelo() {
	}

	public Vuelo(String eventoID, String nombreEvento, String precio, Viaje viajeID, String codigoVuelo,
			String fechaSalida, String horaSalida, String duracionVuelo, Aeropuerto aeropuertoOrigen,
			Aeropuerto aeropuertoDestino, Aerolinea aerolinea, Vuelo eventoVueltaID) {
		super();
		EventoID = eventoID;
		NombreEvento = nombreEvento;
		Precio = precio;
		ViajeID = viajeID;
		CodigoVuelo = codigoVuelo;
		FechaSalida = fechaSalida;
		HoraSalida = horaSalida;
		DuracionVuelo = duracionVuelo;
		AeropuertoOrigen = aeropuertoOrigen;
		AeropuertoDestino = aeropuertoDestino;
		Aerolinea = aerolinea;
		EventoVueltaID = eventoVueltaID;
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

	public String getCodigoVuelo() {
		return CodigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		CodigoVuelo = codigoVuelo;
	}

	public String getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(String horaSalida) {
		HoraSalida = horaSalida;
	}

	public String getDuracionVuelo() {
		return DuracionVuelo;
	}

	public void setDuracionVuelo(String duracionVuelo) {
		DuracionVuelo = duracionVuelo;
	}

	public Aeropuerto getAeropuertoOrigen() {
		return AeropuertoOrigen;
	}

	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		AeropuertoOrigen = aeropuertoOrigen;
	}

	public Aeropuerto getAeropuertoDestino() {
		return AeropuertoDestino;
	}

	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		AeropuertoDestino = aeropuertoDestino;
	}

	public Aerolinea getAerolinea() {
		return Aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		Aerolinea = aerolinea;
	}

	public Vuelo getEventoVueltaID() {
		return EventoVueltaID;
	}

	public void setEventoVueltaID(Vuelo eventoVueltaID) {
		EventoVueltaID = eventoVueltaID;
	}

	@Override
	public String toString() {
		return "Vuelo [EventoID=" + EventoID + ", NombreEvento=" + NombreEvento + ", Precio=" + Precio + ", ViajeID="
				+ ViajeID + ", CodigoVuelo=" + CodigoVuelo + ", FechaSalida=" + FechaSalida + ", HoraSalida="
				+ HoraSalida + ", DuracionVuelo=" + DuracionVuelo + ", AeropuertoOrigen=" + AeropuertoOrigen
				+ ", AeropuertoDestino=" + AeropuertoDestino + ", Aerolinea=" + Aerolinea + ", EventoVueltaID="
				+ EventoVueltaID + "]";
	}

	


}
	
	
	



