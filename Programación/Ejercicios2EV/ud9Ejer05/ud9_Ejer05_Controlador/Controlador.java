package ud9_Ejer05_Controlador;

import java.util.ArrayList;

import ud9Ejer05_Modelo_Pojos.Alumno;
import ud9_Ejer05_Modelo_BBDD_Gestor.GestorAlumnos;

public class Controlador {

	public ArrayList<Alumno> mostrarTodosAlumnos() {
		ArrayList<Alumno> alumnos = null;
		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		alumnos = gestorAlumnos.buscarTodosAlumnos();
		return alumnos;
	}
	public void insertarAlumno(Alumno alumno) {
		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		gestorAlumnos.insertarAlumno(alumno);
	}
	
}
