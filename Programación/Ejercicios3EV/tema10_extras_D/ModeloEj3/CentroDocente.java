package ModeloEj3;

import java.util.ArrayList;

public class CentroDocente {
	private ArrayList<Persona> personas = new ArrayList<>();
    private ArrayList<Empleado> empleados = new ArrayList<>();
    
	public CentroDocente() {

	}

    public CentroDocente(ArrayList<Persona> personas, ArrayList<Empleado> empleados) {
		super();
		this.personas = personas;
		this.empleados = empleados;
	}

	public void altaPersona(Persona persona) {
        personas.add(persona);
        if (persona instanceof Empleado) {
            empleados.add((Empleado) persona);
        }
    }

    public void bajaPersona(String dni) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNumeroIdentificacion().equals(dni)) {
                personas.remove(i);
                break;
            }
        }
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNumeroIdentificacion().equals(dni)) {
                empleados.remove(i);
                break;
            }
        }
    }

    public void imprimirInformacion() {
        for (Persona p : personas) {
            p.imprimirInformacion();
            System.out.println("------------------");
        }
    }

    public void imprimirSalarios() {
        for (Empleado e : empleados) {
            System.out.println(e.nombre + " " + e.apellidos + " - Salario: " + e.calcularSalario());
        }
    }

	@Override
	public String toString() {
		return "CentroDocente [personas=" + personas + ", empleados=" + empleados + "]";
	}
    

}
