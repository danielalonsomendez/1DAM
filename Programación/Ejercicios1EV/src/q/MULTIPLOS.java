package q;

import java.util.Scanner;

public class MULTIPLOS {

	public static void main(String[] args) {
		int numeroEntrada1;
		int numeroEntrada2;
		int restoDivision;	
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un PRIMER número ENTERO: ");
		numeroEntrada1 = teclado.nextInt();
		System.out.println("Introduce un SEGUNDO número ENTERO: ");
		numeroEntrada2 = teclado.nextInt();
		
		restoDivision = numeroEntrada1 % numeroEntrada2;
		teclado.close();
		if(restoDivision == 0) {
			System.out.printf("%d ES multiplo de %d",numeroEntrada1,numeroEntrada2);
		} else {
			System.out.printf("%d NO ES multiplo de %d",numeroEntrada1,numeroEntrada2);
		}
	
	}

}
