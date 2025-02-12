package ejs_tema3;

import java.util.Scanner;

public class Contrase {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nombre_pred = "Dani";
		String contraseña_pred = "1234";
		int intentos = 0;
		String nombre;
		String contraseña;
		do {
			System.out.printf("Introduce el NOMBRE: ");
			nombre = teclado.nextLine();
			System.out.printf("Introduce una CONTRASEÑA: ");
			contraseña = teclado.nextLine();
			if (nombre.equals(nombre_pred) && contraseña.equals(contraseña_pred)) {
				System.out.printf("¡Bienvenido a tu cuenta!\n");
				intentos = 0;
			} else {
				intentos++;
				System.out.printf("\nEl nombre o la contraseña son incorrectos. Vuelve a intentarlo (%s intentos)\n\n",
						intentos);
			}
			
		} while (intentos < 3 && intentos != 0);
		teclado.close();
		if (intentos == 3) {
			System.out.printf("Te has quedado sin intentos.", intentos);
		}
		
	}

}
