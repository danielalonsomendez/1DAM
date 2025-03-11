package Vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import Modelo.Punto;
import Modelo.Rectangulo;
import Modelo.Triangulo;
import Modelo.Circulo;
import Modelo.Cuadrado;
import Modelo.Eclipse;
import Modelo.Figura;

import Modelo_EJ5.Mascota;

public class FigurasMenu {
	Scanner teclado = new Scanner(System.in);

	public void verMenu() {
		int opcion = 0;
		do {
			opcion = elegirOpcion(teclado);
			switch (opcion) {
			case 1:
				Punto coordenada = pedirPunto(teclado);
				String color = pedirColor(teclado);
				System.out.print("Introduce el lado 1: ");
				float l1 = teclado.nextFloat();
				teclado.nextLine();
				System.out.print("Introduce el lado 2: ");
				float l2 = teclado.nextFloat();
				teclado.nextLine();
				System.out.print("Introduce el lado 3: ");
				float l3 = teclado.nextFloat();
				teclado.nextLine();
				Triangulo triangulo = new Triangulo(color, coordenada, l1, l2, l3);
				System.out.println(triangulo);
				break;
			case 2:
				Punto coordenada1 = pedirPunto(teclado);
				String color1 = pedirColor(teclado);
				System.out.print("Introduce el ancho: ");
				float ancho = teclado.nextFloat();
				teclado.nextLine();
				System.out.print("Introduce el alto: ");
				float alto = teclado.nextFloat();
				teclado.nextLine();
				Rectangulo rectangulo = new Rectangulo(color1, coordenada1, ancho, alto);
				System.out.println(rectangulo);
				break;
			case 3:
				Punto coordenada2 = pedirPunto(teclado);
				String color2 = pedirColor(teclado);
				System.out.print("Introduce el ancho y alto: ");
				float ancho2 = teclado.nextFloat();
				teclado.nextLine();
				Cuadrado cuadrado = new Cuadrado(color2, coordenada2, ancho2);
				System.out.println(cuadrado);
				break;
			case 4:
				Punto coordenada3 = pedirPunto(teclado);
				String color3 = pedirColor(teclado);
				System.out.print("Introduce el radio mayor: ");
				float rMayor = teclado.nextFloat();
				teclado.nextLine();
				System.out.print("Introduce el radio menor: ");
				float rMenor = teclado.nextFloat();
				teclado.nextLine();
				Eclipse elipse = new Eclipse(color3, coordenada3, rMayor, rMenor);
				System.out.println(elipse);
				break;
			case 5:
				Punto coordenada4 = pedirPunto(teclado);
				String color4 = pedirColor(teclado);
				System.out.print("Introduce el radio: ");
				float radio = teclado.nextFloat();
				teclado.nextLine();
				Circulo circulo = new Circulo(color4, coordenada4, radio);
				System.out.println(circulo);
				break;

			}
		} while (opcion != 6);
		teclado.close();
	}

	public int elegirOpcion(Scanner teclado) {
		System.out.println("       MENÚ MASCOTA");
		System.out.println("       --------------");
		System.out.println("1. Triángulo");
		System.out.println("2. Rectángulo");
		System.out.println("3. Cuadrado");
		System.out.println("4. Elipse");
		System.out.println("5. Círculo");
		System.out.println("6. Salir.");
		System.out.println("");
		boolean opcionCorrecta = false;
		int opcion = 0;
		do {
			try {
				System.out.print("Introduzca una opcion: ");
				opcion = teclado.nextInt();
				if (opcion < 1 || opcion > 7) {
					System.out.println("Debe introducir un número entre 1 y 6.");
				} else {
					opcionCorrecta = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Se debe introducir un número entero.");
				teclado.nextLine();
			}
		} while (!opcionCorrecta);
		return opcion;
	}

	public static Punto pedirPunto(Scanner teclado) {
		System.out.print("Introduce el punto X: ");
		float x = teclado.nextFloat();
		teclado.nextLine();

		System.out.print("Introduce el punto Y: ");
		float y = teclado.nextFloat();
		teclado.nextLine();
		return new Punto(x, y);
	}

	public static String pedirColor(Scanner teclado) {
		System.out.print("Introduce el color: ");
		return teclado.nextLine();
	}
}
