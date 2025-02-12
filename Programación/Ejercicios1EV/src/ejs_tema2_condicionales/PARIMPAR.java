package ejs_tema2_condicionales;

import java.util.Scanner;

public class PARIMPAR {
	public static void main(String[] args) {
		int numeroEntrada;
		int restoDivision;	
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO ENTERO: ");
		numeroEntrada = teclado.nextInt();
		
		restoDivision = numeroEntrada % 2;
		
		if(restoDivision == 0) {
			System.out.println("El NÚMERO introducido es PAR");
		} else {
			System.out.println("El NÚMERO introducido es IMPAR");
		}
		
	}
}
