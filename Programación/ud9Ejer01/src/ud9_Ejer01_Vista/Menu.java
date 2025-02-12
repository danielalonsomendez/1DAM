package ud9_Ejer01_Vista;

import java.util.ArrayList;
import java.util.Scanner;

import ud9Ejer01_Modelo_Pojos.Alumno;
import ud9_Ejer01_Controlador.Controlador;

public class Menu {
	Controlador controlador = new Controlador();
	Scanner teclado = new Scanner(System.in);
	
	public void actualizarAlumno() {
		System.out.println("Introduce el grupo del alumno:");
		String grupo = teclado.next();
		controlador.modificarGrupoAlumnoPorDni(grupo,"11111111A");
		
		ArrayList<Alumno> alumnos = null;
		alumnos = controlador.mostrarTodosAlumnos();
		for(Alumno alumno: alumnos) {
			System.out.println(alumno.toString());
		}
	}
}
