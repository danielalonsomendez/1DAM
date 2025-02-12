package ejs_tema6_ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListCadenasIterator {

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
		Iterator<String> it = cadenas.iterator();
		while(it.hasNext()){
			System.out.println(it.next()); 
		}
	
	}

}
