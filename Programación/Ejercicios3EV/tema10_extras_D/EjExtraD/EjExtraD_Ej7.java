package EjExtraD;

import java.util.Scanner;

import ModeloEj3.CentroDocente;
import ModeloEj3.Estudiante;
import ModeloEj3.Persona;
import ModeloEj3.PersonalServicio;
import ModeloEj3.Profesor;

public class EjExtraD_Ej7 {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        CentroDocente centro = new CentroDocente();

	        while (true) {
	            System.out.println("Elija una operación:");
	            System.out.println("1. Alta Persona");
	            System.out.println("2. Baja Persona");
	            System.out.println("3. Imprimir Listado");
	            System.out.println("4. Imprimir Nóminas");
	            System.out.println("5. Salir");
	            int opcion = sc.nextInt();
	            sc.nextLine();  // Limpiar el buffer

	            if (opcion == 1) {
	                System.out.println("Seleccione el tipo de persona:");
	                System.out.println("1. Estudiante");
	                System.out.println("2. Profesor");
	                System.out.println("3. Personal de Servicio");
	                int tipo = sc.nextInt();
	                sc.nextLine();  // Limpiar el buffer

	                Persona persona = null;

	                if (tipo == 1) {
	                    persona = new Estudiante();
	                    persona.leer();
	                } else if (tipo == 2) {
	                    persona = new Profesor();
	                    persona.leer();
	                } else if (tipo == 3) {
	                    persona = new PersonalServicio();
	                    persona.leer();
	                }

	                if (persona != null) {
	                    centro.altaPersona(persona);
	                    System.out.println("Persona dada de alta.");
	                }

	            } else if (opcion == 2) {
	                System.out.print("Introduzca el DNI de la persona a eliminar: ");
	                String dni = sc.nextLine();
	                centro.bajaPersona(dni);
	                System.out.println("Persona dada de baja.");

	            } else if (opcion == 3) {
	                System.out.println("--- Listado de Personas ---");
	                centro.imprimirInformacion();

	            } else if (opcion == 4) {
	                System.out.println("--- Nóminas de Empleados ---");
	                centro.imprimirSalarios();

	            } else if (opcion == 5) {
	                System.out.println("Saliendo...");
	                break;
	            } else {
	                System.out.println("Opción no válida. Intente nuevamente.");
	            }
	        }
	        sc.close();
	    }

}
