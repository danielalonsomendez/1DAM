package EjExtraD;

import ModeloEj2.CentroDocente;
import ModeloEj2.Estudiante;
import ModeloEj2.PersonalServicio;
import ModeloEj2.Profesor;

public class EjExtraD_Ej2 {

	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("Juan", "Pérez", "12345678A", "Soltero", "Informática");
		Profesor profesor = new Profesor("Ana", "Gómez", "87654321B", "Casado", "Matemáticas");
		PersonalServicio personal = new PersonalServicio("Carlos", "López", "11223344C", "Divorciado", "Biblioteca");

		System.out.println("--- Información ---");
		estudiante.imprimirInformacion();
		profesor.imprimirInformacion();
		personal.imprimirInformacion();

		System.out.println("\n--- Modificaciones ---");
		estudiante.setCursoMatriculado("Biología");
		profesor.setDepartamento("Física");
		personal.setSeccionAsignada("Secretaría");

		System.out.println("\n--- Actualizado ---");
		estudiante.imprimirInformacion();
		profesor.imprimirInformacion();
		personal.imprimirInformacion();

		CentroDocente centro = new CentroDocente();
		centro.altaPersona(estudiante);
		centro.altaPersona(profesor);
		centro.altaPersona(personal);
		centro.imprimirInformacion();
	}

}
