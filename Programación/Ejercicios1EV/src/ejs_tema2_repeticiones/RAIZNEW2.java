package ejs_tema2_repeticiones;

import java.util.Scanner;

public class RAIZNEW2 {

	public static void main(String[] args) {
		double num, Ractual =0, Ranterior,diferencia,errorv =0.00000001 ;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce un NÚMERO: ");
		num = teclado.nextDouble();
		teclado.close();
		
		Ranterior = num / 2;
		diferencia =1;
		while (diferencia > errorv) {				
			Ractual = (num / Ranterior + Ranterior) / 2;
			diferencia =  Math.abs(Ractual - Ranterior);
			Ranterior = Ractual;
		}
		System.out.printf("La RAIZ CUADRADA es: %s",Ractual );

	}

}
