package Vista;

import java.util.Scanner;

import Modelo.Cola;

public class ColaMain {

	public static void main(String[] args) {
		Cola cola = new Cola();
		String ultimo;
		Scanner teclado = new Scanner(System.in);
		int i =0;
		do {
			System.out.println("Introduce un nombre: ");
			ultimo = teclado.nextLine();
			cola.add(i,ultimo);
			i++;
		}while(ultimo!= "");

		do {
			System.out.println(cola.tratar());
		}while(cola.size() !=0);
		teclado.close();
	}

}
