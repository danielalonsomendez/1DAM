package modelo_Repaso2EV;

public class Pais {
	private String ISO = null;
	private String nombre = null;
	private int extension = 0;
	private int poblacion =  0;
	private String capital  = null;
	private String idioma  = null;
	
	public Pais() {
		
	}
	
	public Pais(String iSO, String nombre, int extension, int poblacion, String capital, String idioma) {
		ISO = iSO;
		this.nombre = nombre;
		this.extension = extension;
		this.poblacion = poblacion;
		this.capital = capital;
		this.idioma = idioma;
	}

	public String getISO() {
		return ISO;
	}

	public void setISO(String iSO) {
		ISO = iSO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "ISO=" + ISO + ", Nombre=" + nombre + ", Extension=" + extension + ", Poblacion=" + poblacion
				+ ", Capital=" + capital + ", Idioma=" + idioma  ;
	}
	
	
}
