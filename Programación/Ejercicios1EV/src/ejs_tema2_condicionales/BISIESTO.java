package ejs_tema2_condicionales;

import java.util.Scanner;

public class BISIESTO {

	public static void main(String[] args) {
		int año;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un AÑO: ");
		año = teclado.nextInt();
		teclado.close();
		if(año %4 == 0 && año %100 != 0 || año %400 == 0  ) {
			System.out.printf("El AÑO (%d) es BISIESTO.",año);
		} else {
			System.out.printf("El AÑO (%d) NO es BISIESTO.",año);
		} 
	}
}
