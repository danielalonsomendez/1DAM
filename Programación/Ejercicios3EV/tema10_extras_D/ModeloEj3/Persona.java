package ModeloEj3;

import java.util.Scanner;

public abstract class Persona {
	protected String nombre;
	protected String apellidos;
	protected String numeroIdentificacion;
	protected String estadoCivil;
	public Persona() {
		
	}
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

    public abstract void imprimirInformacion();
    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        this.nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        this.apellidos = sc.nextLine();
        System.out.print("Número de Identificación: ");
        this.numeroIdentificacion = sc.nextLine();
        System.out.print("Estado Civil: ");
        this.estadoCivil = sc.nextLine();
    }
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", numeroIdentificacion="
				+ numeroIdentificacion + ", estadoCivil=" + estadoCivil + "]";
	}

}
