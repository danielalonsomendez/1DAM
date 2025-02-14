package Reto2Modelo;

public class Otros  {
	/* Atributos comunes de todos los eventos */
	private String EventoID;
	private String NombreEvento;
	private String Precio;
	private Viaje ViajeID;
	
	private String Fecha;
	private String Descripcion;
	
	public Otros() {
		
	}
	
	public Otros(String eventoID, String nombreEvento, String precio, Viaje viajeID, String fecha, String descripcion) {
		EventoID = eventoID;
		NombreEvento = nombreEvento;
		Precio = precio;
		ViajeID = viajeID;
		Fecha = fecha;
		Descripcion = descripcion;
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
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Otros [EventoID=" + EventoID + ", NombreEvento=" + NombreEvento + ", Precio=" + Precio + ", ViajeID="
				+ ViajeID + ", Fecha=" + Fecha + ", Descripcion=" + Descripcion + "]";
	}


}
