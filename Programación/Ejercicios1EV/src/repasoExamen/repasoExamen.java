package repasoExamen;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class repasoExamen {

	public static void main(String[] args) {
		int filas = pedirCantidad("filas");
		int columnas = pedirCantidad("columnas");

		int[][] numeros = rellenarAleatorio(filas, columnas);
		int[] sumas = sumarNumeros(numeros);
		mostrarSumas(numeros, sumas);
	}

	public static int pedirCantidad(String pedir) {
		int cantidad;
		Scanner teclado = new Scanner(System.in);

		try {
			do {
				if (pedir == "filas") {
					System.out.printf("Introduce el NÚMERO DE FILAS: ");
				} else {
					System.out.printf("Introduce el NÚMERO DE COLUMNAS: ");
				}
				cantidad = teclado.nextInt();
			} while (cantidad <= 0);
		} catch (InputMismatchException e) {
			teclado.nextLine();
			return pedirCantidad(pedir);
		}
		return cantidad;
	}

	public static int[][] rellenarAleatorio(int filas, int columnas) {
		int[][] numeros = new int[filas][columnas];
		Random aleatorio = new Random(System.currentTimeMillis());

		for (int filan = 0; filan < filas; filan++) {
			for (int columnan = 0; columnan < columnas; columnan++) {
				numeros[filan][columnan] = aleatorio.nextInt(101);
			}
		}
		return numeros;
	}

	public static int[] sumarNumeros(int[][] numeros) {
		int[] sumas = new int[numeros.length];
		for (int filan = 0; filan < numeros.length; filan++) {
			int suma = 0;
			for (int columnan = 0; columnan < numeros[filan].length; columnan++) {
				suma = suma + numeros[filan][columnan];
			}
			sumas[filan] = suma;
		}
		return sumas;
	}

	public static void mostrarSumas(int[][] numeros, int[] sumas) {
		for (int filan = 0; filan < numeros.length; filan++) {
			for (int columnan = 0; columnan < numeros[filan].length; columnan++) {
				String simbolo = "+";
				if (columnan == numeros.length - 1) {
					simbolo = "=";
				}
				System.out.printf("%-5s%-5s", numeros[filan][columnan], simbolo);

			}
			System.out.printf("%-5s\n", sumas[filan]);
		}
	}
}
