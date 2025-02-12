package ejs_tema6_ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListCadenasOrdenadoDescendente {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		ArrayList<String> cadenas = new ArrayList<String>();
		String texto;
		do {
			System.out.print("Introduce un TEXTO: ");
			texto = teclado.nextLine();
			cadenas.add(texto);
		} while (texto != "");
		teclado.close();
		Comparator<String> comparador = Collections.reverseOrder();
		Collections.sort(cadenas, comparador);
		for (int i = 0; i < cadenas.size(); i++) {
			System.out.println(cadenas.get(i));
		}
	}

}
