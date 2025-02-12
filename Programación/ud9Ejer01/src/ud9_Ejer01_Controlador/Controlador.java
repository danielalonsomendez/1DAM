package ud9_Ejer01_Controlador;

import java.util.ArrayList;

import ud9Ejer01_Modelo_Pojos.Alumno;
import ud9_Ejer01_Modelo_BBDD_Gestor.GestorAlumnos;

public class Controlador {

	public void modificarGrupoAlumnoPorDni(String grupo, String dni) {
		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		gestorAlumnos.actualizarAlumno(grupo, dni);
	}

	public ArrayList<Alumno> mostrarTodosAlumnos() {
		ArrayList<Alumno> alumnos = null;
		GestorAlumnos gestorAlumnos = new GestorAlumnos();
		alumnos = gestorAlumnos.buscarTodosAlumnos();
		return alumnos;
	}
}
