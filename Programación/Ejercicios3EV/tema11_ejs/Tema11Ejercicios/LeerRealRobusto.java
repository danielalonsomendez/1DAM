package Tema11Ejercicios;

import java.util.Scanner;

public class LeerRealRobusto {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un número real robusto: ");
		String RealRobusto = teclado.next().replaceAll(",", ".").replaceAll("[^\\d.]", "");
		boolean contienepunto = false;
        StringBuilder nuevoRealRobusto = new StringBuilder();

        for (int i = 0; i < RealRobusto.length(); i++) {
            char c = RealRobusto.charAt(i);
            if (c == '.' && !contienepunto) {
                contienepunto = true;
                nuevoRealRobusto.append(c);
            } else if (c != '.') {
                nuevoRealRobusto.append(c);
            }
        }


		System.out.println(nuevoRealRobusto);
		teclado.close();

	}

}
