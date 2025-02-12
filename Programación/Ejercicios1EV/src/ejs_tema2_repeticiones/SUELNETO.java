package ejs_tema2_repeticiones;

import java.util.Scanner;

public class SUELNETO {
	public static void main(String[] args) {
		
		
		int bruto,neto,milp,retencionporcentaje =0;
		Scanner teclado = new Scanner(System.in);

		do {
			System.out.printf("Introduce un SUELDO BRUTO: ");
			bruto = teclado.nextInt();
			if(bruto >1000) { 
			milp = bruto-1000;
			for(var i = 0; (150 * i) <= milp;) {
				i++;
				
				if(milp <= 150 * i && milp> 150 * (i-1) ) {
					retencionporcentaje = i;			
				}
			}
			if(retencionporcentaje > 56) {
				retencionporcentaje = 56;
			}
			}
			neto = bruto - ((bruto*retencionporcentaje)/100);
			System.out.printf("El SUELDO NETO es %s (Retencion: %s%%) \n",neto,retencionporcentaje);

		} while (bruto>0);
		teclado.close();


	}


}
