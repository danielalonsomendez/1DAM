package Tema11Ejercicios;

import java.util.Scanner;

public class LeerRealRobusto {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número real robusto: ");
		String RealRobusto = teclado.next().replaceAll(",", ".").replaceAll("[^\\d.]", "");
		boolean contienepunto = false;
        StringBuilder nuevoRealRobusto = new StringBuilder();

        // Recorremos cada carácter de la cadena
        for (int i = 0; i < RealRobusto.length(); i++) {
            char c = RealRobusto.charAt(i);

            if (c == '.' && !contienepunto) {
                // Si encontramos el primer punto, lo añadimos
                contienepunto = true;
                nuevoRealRobusto.append(c);
            } else if (c != '.') {
                // Añadimos todos los caracteres que no son punto
                nuevoRealRobusto.append(c);
            }
        }


		System.out.println(nuevoRealRobusto);
		teclado.close();

	}

}
