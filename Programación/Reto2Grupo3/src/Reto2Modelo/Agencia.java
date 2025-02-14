package Reto2Modelo;

import java.util.ArrayList;

public class Agencia {
	private String NombreAgencia;
	private String Logo;
	private String ColorMarca;
	private String NumeroEmpleados;
	private String TipoAgencia;
	private ArrayList<Viaje> Viajes;
	private String Contraseña;

	

	public Agencia() {
		
	}

	

	public Agencia(String nombreAgencia, String logo, String colorMarca, String numeroEmpleados, String tipoAgencia,
			ArrayList<Viaje> viajes, String contraseña) {
		super();
		NombreAgencia = nombreAgencia;
		Logo = logo;
		ColorMarca = colorMarca;
		NumeroEmpleados = numeroEmpleados;
		TipoAgencia = tipoAgencia;
		Viajes = viajes;
		Contraseña = contraseña;
	}



	public ArrayList<Viaje> getViajes() {
		return Viajes;
	}

	public void setViajes(ArrayList<Viaje> viajes) {
		Viajes = viajes;
	}
	public String getNombreAgencia() {
		return NombreAgencia;
	}
	public void setNombreAgencia(String nombreAgencia) {
		NombreAgencia = nombreAgencia;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public String getColorMarca() {
		return ColorMarca;
	}
	public void setColorMarca(String colorMarca) {
		ColorMarca = colorMarca;
	}
	public String getNumeroEmpleados() {
		return NumeroEmpleados;
	}
	public void setNumeroEmpleados(String numeroEmpleados) {
		NumeroEmpleados = numeroEmpleados;
	}
	public String getTipoAgencia() {
		return TipoAgencia;
	}
	public void setTipoAgencia(String tipoAgencia) {
		TipoAgencia = tipoAgencia;
	}
	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}



	@Override
	public String toString() {
		return "Agencia [NombreAgencia=" + NombreAgencia + ", Logo=" + Logo + ", ColorMarca=" + ColorMarca
				+ ", NumeroEmpleados=" + NumeroEmpleados + ", TipoAgencia=" + TipoAgencia + ", Viajes=" + Viajes
				+ ", Contraseña=" + Contraseña + "]";
	}
}
	
