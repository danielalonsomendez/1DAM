package ModeloEj3;

public abstract class Empleado extends Persona {
	protected int numeroDespacho;
	public Empleado() {
		
	}

	public Empleado(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			int numeroDespacho) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil);
		this.numeroDespacho = numeroDespacho;
	}

	public int getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(int numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	@Override
	public void imprimirInformacion() {
		System.out.println("Nombre: " + nombre + " " + apellidos);
		System.out.println("Número de Identificación: " + numeroIdentificacion);
		System.out.println("Estado Civil: " + estadoCivil);
		System.out.println("Número de Despacho: " + numeroDespacho);
	}


    @Override
	public String toString() {
		return "Empleado [numeroDespacho=" + numeroDespacho + "]";
	}

	public abstract double calcularSalario();


}
