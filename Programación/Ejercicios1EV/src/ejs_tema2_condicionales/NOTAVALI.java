package ejs_tema2_condicionales;

import java.util.Scanner;

public class NOTAVALI {
	public static void main(String[] args) {
		int nota;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la NOTA de un ALUMNO: ");
		nota = teclado.nextInt();
		teclado.close();
		if(nota>= 0 && nota <=10) {
			System.out.printf("La NOTA (%d) es VÁLIDA.",nota);
		} else {
			System.out.printf("La NOTA (%d) NO es VÁLIDA.",nota);
		} 
	}

}
