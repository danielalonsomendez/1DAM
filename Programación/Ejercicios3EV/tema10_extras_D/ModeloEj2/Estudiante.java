package ModeloEj2;

public class Estudiante extends Persona {
	private String cursoMatriculado;

	public Estudiante(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			String cursoMatriculado) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil);
		this.cursoMatriculado = cursoMatriculado;
	}

	public String getCursoMatriculado() {
		return cursoMatriculado;
	}

	public void setCursoMatriculado(String cursoMatriculado) {
		this.cursoMatriculado = cursoMatriculado;
	}

	@Override
	public void imprimirInformacion() {
		super.imprimirInformacion();
		System.out.println("Curso Matriculado: " + cursoMatriculado);
	}

	@Override
	public String toString() {
		return "Estudiante [cursoMatriculado=" + cursoMatriculado + "]";
	}

}
