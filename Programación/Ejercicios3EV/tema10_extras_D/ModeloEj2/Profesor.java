package ModeloEj2;

public class Profesor extends Persona {
	private String departamento;

	public Profesor(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			String departamento) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	@Override
    public void imprimirInformacion() {
        super.imprimirInformacion();
        System.out.println("Departamento: " + departamento);
    }
	@Override
	public String toString() {
		return "Profesor [departamento=" + departamento + "]";
	}

}
