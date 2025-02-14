package Reto2Modelo;

import java.util.ArrayList;

public class Viaje {
	private String ViajeID;
	private String NombreViaje;
	private String DescripciónViaje;
	private String TipoViaje;
	private String FechaInicio;
	private String FechaFin;
	private String DuracionViaje;
	private String ServiciosNoIncluidos;
	private Pais PaisDestino;
	private Agencia NombreAgencia;
	private ArrayList<Vuelo> Vuelos;
	private ArrayList<Alojamiento> Alojamientos;
	private ArrayList<Otros> Otros;
	
	public Viaje() {
		
	}

	public Viaje(String viajeID, String nombreViaje, String descripciónViaje, String tipoViaje, String fechaInicio,
			String fechaFin, String duracionViaje, String serviciosNoIncluidos, Pais paisDestino, Agencia nombreAgencia,
			ArrayList<Vuelo> vuelos, ArrayList<Alojamiento> alojamientos, ArrayList<Reto2Modelo.Otros> otros) {
		super();
		ViajeID = viajeID;
		NombreViaje = nombreViaje;
		DescripciónViaje = descripciónViaje;
		TipoViaje = tipoViaje;
		FechaInicio = fechaInicio;
		FechaFin = fechaFin;
		DuracionViaje = duracionViaje;
		ServiciosNoIncluidos = serviciosNoIncluidos;
		PaisDestino = paisDestino;
		NombreAgencia = nombreAgencia;
		Vuelos = vuelos;
		Alojamientos = alojamientos;
		Otros = otros;
	}

	public String getViajeID() {
		return ViajeID;
	}

	public void setViajeID(String viajeID) {
		ViajeID = viajeID;
	}

	public String getNombreViaje() {
		return NombreViaje;
	}

	public void setNombreViaje(String nombreViaje) {
		NombreViaje = nombreViaje;
	}

	public String getDescripciónViaje() {
		return DescripciónViaje;
	}

	public void setDescripciónViaje(String descripciónViaje) {
		DescripciónViaje = descripciónViaje;
	}

	public String getTipoViaje() {
		return TipoViaje;
	}

	public void setTipoViaje(String tipoViaje) {
		TipoViaje = tipoViaje;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	public String getDuracionViaje() {
		return DuracionViaje;
	}

	public void setDuracionViaje(String duracionViaje) {
		DuracionViaje = duracionViaje;
	}

	public String getServiciosNoIncluidos() {
		return ServiciosNoIncluidos;
	}

	public void setServiciosNoIncluidos(String serviciosNoIncluidos) {
		ServiciosNoIncluidos = serviciosNoIncluidos;
	}

	public Pais getPaisDestino() {
		return PaisDestino;
	}

	public void setPaisDestino(Pais paisDestino) {
		PaisDestino = paisDestino;
	}

	public Agencia getNombreAgencia() {
		return NombreAgencia;
	}

	public void setNombreAgencia(Agencia nombreAgencia) {
		NombreAgencia = nombreAgencia;
	}

	public ArrayList<Vuelo> getVuelos() {
		return Vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		Vuelos = vuelos;
	}

	public ArrayList<Alojamiento> getAlojamientos() {
		return Alojamientos;
	}

	public void setAlojamientos(ArrayList<Alojamiento> alojamientos) {
		Alojamientos = alojamientos;
	}

	public ArrayList<Otros> getOtros() {
		return Otros;
	}

	public void setOtros(ArrayList<Otros> otros) {
		Otros = otros;
	}

	@Override
	public String toString() {
		return "Viaje [ViajeID=" + ViajeID + ", NombreViaje=" + NombreViaje + ", DescripciónViaje=" + DescripciónViaje
				+ ", TipoViaje=" + TipoViaje + ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin
				+ ", DuracionViaje=" + DuracionViaje + ", ServiciosNoIncluidos=" + ServiciosNoIncluidos
				+ ", PaisDestino=" + PaisDestino + ", NombreAgencia=" + NombreAgencia + ", Vuelos=" + Vuelos
				+ ", Alojamientos=" + Alojamientos + ", Otros=" + Otros + "]";
	}
		
	
}
