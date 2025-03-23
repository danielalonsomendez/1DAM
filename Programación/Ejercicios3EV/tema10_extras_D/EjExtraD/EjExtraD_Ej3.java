package EjExtraD;

import ModeloEj3.CentroDocente;
import ModeloEj3.Estudiante;
import ModeloEj3.PersonalServicio;
import ModeloEj3.Profesor;

public class EjExtraD_Ej3 {

	public static void main(String[] args) {
		  CentroDocente centro = new CentroDocente();

	        Estudiante estudiante = new Estudiante("Juan", "Pérez", "12345678A", "Soltero", "Informática");
	        Profesor profesor = new Profesor("Ana", "Gómez", "87654321B", "Casado",1, "Matemáticas", 1995);
	        PersonalServicio personal = new PersonalServicio("Carlos", "López", "11223344C", "Divorciado",2, "Biblioteca");
	        
	        centro.altaPersona(estudiante);
	        centro.altaPersona(profesor);
	        centro.altaPersona(personal);
	        
	        System.out.println("--- Información Inicial ---");
	        centro.imprimirInformacion();
	        
	        System.out.println("\n--- Eliminando a Juan Pérez ---");
	        centro.bajaPersona("12345678A");
	        
	        System.out.println("\n--- Información Actualizada ---");
	        centro.imprimirInformacion();
	        
	        System.out.println("\n--- Salarios de Empleados ---");
	        centro.imprimirSalarios();
	}

}
