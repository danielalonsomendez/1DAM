package ModeloEj2;

public class Empleado extends Persona {
	protected int anioIncorporacion;
	protected int numeroDespacho;

	public Empleado(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			int anioIncorporacion, int numeroDespacho) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil);
		this.anioIncorporacion = anioIncorporacion;
		this.numeroDespacho = numeroDespacho;
	}

	public int getAnioIncorporacion() {
		return anioIncorporacion;
	}

	public void setAnioIncorporacion(int anioIncorporacion) {
		this.anioIncorporacion = anioIncorporacion;
	}

	public int getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(int numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	@Override
	public void imprimirInformacion() {
		super.imprimirInformacion();
		System.out.println("Año de Incorporación: " + anioIncorporacion);
		System.out.println("Número de Despacho: " + numeroDespacho);
	}

	@Override
	public String toString() {
		return "Empleado [anioIncorporacion=" + anioIncorporacion + ", numeroDespacho=" + numeroDespacho + "]";
	}

}
