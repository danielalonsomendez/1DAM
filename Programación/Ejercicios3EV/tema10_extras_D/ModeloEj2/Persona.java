package ModeloEj2;

public class Persona {
	protected String nombre;
	protected String apellidos;
	protected String numeroIdentificacion;
	protected String estadoCivil;

	public Persona(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numeroIdentificacion = numeroIdentificacion;
		this.estadoCivil = estadoCivil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void imprimirInformacion() {
		System.out.println("Nombre: " + nombre + " " + apellidos);
		System.out.println("Número de Identificación: " + numeroIdentificacion);
		System.out.println("Estado Civil: " + estadoCivil);
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", numeroIdentificacion="
				+ numeroIdentificacion + ", estadoCivil=" + estadoCivil + "]";
	}

}
