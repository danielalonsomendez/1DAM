package ud9_Ejer03_Controlador;

import java.util.ArrayList;

import ud9Ejer03_Modelo_Pojos.Alumno;
import ud9_Ejer03_Modelo_BBDD_Gestor.GestorAlumnos;

public class Controlador {


	public void insertarAlumno(Alumno alumno) {
		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		gestorAlumnos.insertarAlumno(alumno);
	}
	public ArrayList<Alumno> obtenerAlumnosApellido(char letra) {
		ArrayList<Alumno> alumnos = null;
		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		alumnos = gestorAlumnos.buscarAlumnosApellido(letra);
		return alumnos;
	}
	public ArrayList<Alumno> obtenerAlumnosEdad(int num) {
		ArrayList<Alumno> alumnos = null;
		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		alumnos = gestorAlumnos.buscarAlumnosEdad(num);
		return alumnos;
	}
}
