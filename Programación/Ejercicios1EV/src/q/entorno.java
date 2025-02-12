package q;

import java.util.Scanner;

public class entorno {

	public static void main(String[] args) {

		int precioart,cantidad,preciototal;
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Introduce PRECIO ARTICULO: ");
		precioart = teclado.nextInt();
		System.out.printf("Introduce CANTIDAD: ");
		cantidad = teclado.nextInt();
		preciototal = precioart * cantidad;
		teclado.close();
		int[] monedas = {100,50,25,5,1};
	}

}
