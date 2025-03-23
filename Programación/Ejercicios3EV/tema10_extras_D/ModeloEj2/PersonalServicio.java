package ModeloEj2;

public class PersonalServicio extends Persona {
	private String seccionAsignada;

	public PersonalServicio(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			String seccionAsignada) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil);
		this.seccionAsignada = seccionAsignada;
	}

	public String getSeccionAsignada() {
		return seccionAsignada;
	}

	public void setSeccionAsignada(String seccionAsignada) {
		this.seccionAsignada = seccionAsignada;
	}

	@Override
	public void imprimirInformacion() {
		super.imprimirInformacion();
		System.out.println("Sección Asignada: " + seccionAsignada);
	}

	@Override
	public String toString() {
		return "PersonalServicio [seccionAsignada=" + seccionAsignada + "]";
	}

}
