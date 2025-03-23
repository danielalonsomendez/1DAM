package ModeloEj2;

import java.util.ArrayList;

public class CentroDocente {
	    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	    private ArrayList<Profesor> profesores = new ArrayList<>();
	    private ArrayList<PersonalServicio> personalServicios = new ArrayList<>();
	    
	    public CentroDocente() {
	    	
	    }
	    public CentroDocente(ArrayList<Estudiante> estudiantes, ArrayList<Profesor> profesores,
				ArrayList<PersonalServicio> personalServicios) {
			super();
			this.estudiantes = estudiantes;
			this.profesores = profesores;
			this.personalServicios = personalServicios;
		}

		public ArrayList<Estudiante> getEstudiantes() {
			return estudiantes;
		}

		public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
			this.estudiantes = estudiantes;
		}

		public ArrayList<Profesor> getProfesores() {
			return profesores;
		}

		public void setProfesores(ArrayList<Profesor> profesores) {
			this.profesores = profesores;
		}

		public ArrayList<PersonalServicio> getPersonalServicios() {
			return personalServicios;
		}

		public void setPersonalServicios(ArrayList<PersonalServicio> personalServicios) {
			this.personalServicios = personalServicios;
		}

		public void altaPersona(Estudiante estudiante) {
	        estudiantes.add(estudiante);
	    }

	    public void altaPersona(Profesor profesor) {
	        profesores.add(profesor);
	    }

	    public void altaPersona(PersonalServicio personalServicio) {
	        personalServicios.add(personalServicio);
	    }

	    public void bajaPersona(String dni) {
	        for (int i = 0; i < estudiantes.size(); i++) {
	            if (estudiantes.get(i).getNumeroIdentificacion().equals(dni)) {
	                estudiantes.remove(i);
	                return;
	            }
	        }
	        for (int i = 0; i < profesores.size(); i++) {
	            if (profesores.get(i).getNumeroIdentificacion().equals(dni)) {
	                profesores.remove(i);
	                return;
	            }
	        }
	        for (int i = 0; i < personalServicios.size(); i++) {
	            if (personalServicios.get(i).getNumeroIdentificacion().equals(dni)) {
	                personalServicios.remove(i);
	                return;
	            }
	        }
	    }

	    public void imprimirInformacion() {
	        System.out.println("--- Estudiantes ---");
	        for (Estudiante e : estudiantes) e.imprimirInformacion();
	        System.out.println("\n--- Profesores ---");
	        for (Profesor p : profesores) p.imprimirInformacion();
	        System.out.println("\n--- Personal de Servicio ---");
	        for (PersonalServicio ps : personalServicios) ps.imprimirInformacion();
	    }

		@Override
		public String toString() {
			return "CentroDocente [estudiantes=" + estudiantes + ", profesores=" + profesores + ", personalServicios="
					+ personalServicios + "]";
		}
	
}
