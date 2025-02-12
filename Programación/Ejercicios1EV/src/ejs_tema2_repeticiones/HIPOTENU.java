package ejs_tema2_repeticiones;

import java.util.Scanner;

public class HIPOTENU {

	public static void main(String[] args) {
		double num, cat1,cat2,Ractual =0, Ranterior,diferencia,errorv =0.00000001 ;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce el VALOR de UN CATETO: ");
		cat1 = teclado.nextDouble();
		System.out.printf("Introduce el VALOR de UN CATETO: ");
		cat2 = teclado.nextDouble();
		teclado.close();
		
		num = (cat1*cat1)+ (cat2*cat2);
		Ranterior = num / 2;
		diferencia =1;
		while (diferencia > errorv) {				
			Ractual = (num / Ranterior + Ranterior) / 2;
			diferencia =  Math.abs(Ractual - Ranterior);
			Ranterior = Ractual;
		}
		System.out.printf("La HIPOTENUSA es: %s",Ractual );

	}


}
