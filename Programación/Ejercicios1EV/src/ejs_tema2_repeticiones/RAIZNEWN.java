package ejs_tema2_repeticiones;

import java.util.Scanner;

public class RAIZNEWN {

	public static void main(String[] args) {
		double num, Ractual =0, Ranterior,diferencia,errorv =0.00000001 ;
		Scanner teclado = new Scanner(System.in);
		do {
		System.out.printf("Introduce un NÚMERO: ");
		num = teclado.nextDouble();
	
		if(num>0) {
		Ranterior = num / 2;
		diferencia =1;
		
		while (diferencia > errorv) {				
			Ractual = (num / Ranterior + Ranterior) / 2;
			diferencia =  Math.abs(Ractual - Ranterior);
			Ranterior = Ractual;
		}
		System.out.printf("La RAIZ CUADRADA es: %s\n",Ractual );
		} } while (num > 0);
		teclado.close();
	}


}
