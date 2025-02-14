package Reto2Modelo;

public class Aerolinea {
	private String CodigoAerolinea;
	private String NombreAerolinea;
	
	public Aerolinea() {
		
	}
	public Aerolinea(String codigoAerolinea, String nombreAerolinea) {
		CodigoAerolinea = codigoAerolinea;
		NombreAerolinea = nombreAerolinea;
	}
	public String getCodigoAerolinea() {
		return CodigoAerolinea;
	}
	public void setCodigoAerolinea(String codigoAerolinea) {
		CodigoAerolinea = codigoAerolinea;
	}
	public String getNombreAerolinea() {
		return NombreAerolinea;
	}
	public void setNombreAerolinea(String nombreAerolinea) {
		NombreAerolinea = nombreAerolinea;
	}
	@Override
	public String toString() {
		return "Aerolinea [CodigoAerolinea=" + CodigoAerolinea + ", NombreAerolinea=" + NombreAerolinea + "]";
	}


}
