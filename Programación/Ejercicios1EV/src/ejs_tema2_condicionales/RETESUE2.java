package ejs_tema2_condicionales;

import java.util.Scanner;

public class RETESUE2 {

	public static void main(String[] args) {
		double sueldo;
		int porcentajeretencion;	
		double retencion;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el SUELDO de un TRABAJADOR: ");
		sueldo = teclado.nextInt();
		
		
		
		if(sueldo < 1000.00) {
			porcentajeretencion = 10;
			}
		else if (sueldo ==  1000.00) {
			porcentajeretencion = 12;
		} else if(sueldo < 2000.00)  {
			porcentajeretencion = 14;
		}else if(sueldo == 2000.00)  {
			porcentajeretencion = 16;
		}else   {
			porcentajeretencion = 18;
		}
		retencion = (sueldo * porcentajeretencion)/100;
		System.out.printf("De un sueldo de %.2f se retiene %.2f (%d%%).",sueldo,retencion,porcentajeretencion);

		
	}
}
