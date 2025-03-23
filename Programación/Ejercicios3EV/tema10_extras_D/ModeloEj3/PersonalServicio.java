package ModeloEj3;

import java.util.Scanner;

public class PersonalServicio extends Empleado {
	private String seccionAsignada;

	public PersonalServicio() {
		
	}
	public PersonalServicio(String nombre, String apellidos, String numeroIdentificacion, String estadoCivil,
			int numeroDespacho, String seccionAsignada) {
		super(nombre, apellidos, numeroIdentificacion, estadoCivil, numeroDespacho);
		this.seccionAsignada = seccionAsignada;
	}
    @Override
    public void leer() {
        super.leer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Sección Asignada: ");
        this.seccionAsignada = sc.nextLine();
    }
	public String getSeccionAsignada() {
		return seccionAsignada;
	}

	public void setSeccionAsignada(String seccionAsignada) {
		this.seccionAsignada = seccionAsignada;
	}
	 @Override
	    public double calcularSalario() {
	        double salarioBase = 1500;
	        if (estadoCivil.equalsIgnoreCase("Casado")) {
	            salarioBase *= 1.05;
	        }
	        return salarioBase;
	    }
	@Override
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellidos);
        System.out.println("Número de Identificación: " + numeroIdentificacion);
        System.out.println("Estado Civil: " + estadoCivil);
        System.out.println("Sección Asignada: " + seccionAsignada);
    }
	@Override
	public String toString() {
		return "PersonalServicio [seccionAsignada=" + seccionAsignada + "]";
	}

}
