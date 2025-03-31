package Tema11Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListContadorStringMenu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<ContadorGenerico> listaContadores = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			System.out.print("Introduce la palabra " + (i + 1) + ": ");
			String palabra = scanner.nextLine();
			ContadorGenerico contador = new ContadorGenerico(palabra, 1);
			listaContadores.add(contador);
		}
		System.out.println("\nContenido del ArrayList:");
		for (ContadorGenerico contador : listaContadores) {
			System.out.println(contador);
		}
		scanner.close();
	}
}
