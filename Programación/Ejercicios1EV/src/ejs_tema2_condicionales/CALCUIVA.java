package ejs_tema2_condicionales;

import java.util.Scanner;

public class CALCUIVA {
	public static void main(String[] args) {
		double euros;
		int iva;	
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un NÚMERO en EUROS: ");
		euros = teclado.nextInt();
		
		
		
		if(euros < 2000) {
			iva =  7;		
			}
		else {
			iva = 16;
		}
		euros = (euros * iva)/100;
		System.out.printf("El IVA (%d%%) es %.2f.",iva,euros);

		
	}
}
