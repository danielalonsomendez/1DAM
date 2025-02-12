package ejs_tema2_repeticiones;

import java.util.Scanner;
public class TABLAMUL {

	public static void main(String[] args) {
		int mult;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO ENTERO: ");
		mult = teclado.nextInt();
		teclado.close();
		System.out.printf("n = %s\n",mult);
		for(int n =1 ; n<=10;n++){
			System.out.printf("%s x %s = %s\n",mult,n,(mult*n));
		}

	}

}
