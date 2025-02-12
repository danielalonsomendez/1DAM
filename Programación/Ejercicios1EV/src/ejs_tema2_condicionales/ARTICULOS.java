package ejs_tema2_condicionales;

import java.util.Scanner;

public class ARTICULOS {

	public static void main(String[] args) {
		String codigoart;
		int cantidad;
		double preciounidad;
		double preciototal;
		int descuento = 0;
		double descuentov;

		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el CÓDIGO del ARTÍCULO: ");
		codigoart = teclado.next();
		System.out.println("Introduce la CANTIDAD de ARTÍCULOS: ");
		cantidad = teclado.nextInt();
		System.out.println("Introduce el PRECIO UNITARIO del ARTÍCULO: ");
		preciounidad = teclado.nextDouble();
		teclado.close();
		preciototal = cantidad * preciounidad;
		
		if(preciototal > 100) {
			descuento = 40;
		} else if(preciototal > 25 &&preciototal <= 100) {
			descuento = 20;
		}else if(preciototal > 10 &&preciototal <= 25) {
			descuento = 10;
		}
		descuentov =  (preciototal * descuento)/100;
		preciototal = preciototal - descuentov;
		System.out.printf("%d de %s a %.2f€ cada uno.\nDESCUENTO: %.2f€ (%d%%) \nPRECIO TOTAL: %.2f€ ",cantidad,codigoart,preciounidad,descuentov,descuento,preciototal);

	}

}
