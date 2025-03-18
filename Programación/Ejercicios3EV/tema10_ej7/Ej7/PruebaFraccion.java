package Ej7;

import Modelo.Fraccion;

public class PruebaFraccion {

	public static void main(String[] args) {
		Fraccion f1 = new Fraccion(10, 4);
		Fraccion f2 = new Fraccion(10, 1);
		System.out.println(f1.suma(f2));
		System.out.println(f1.resta(f2));
		System.out.println(f1.multiplicar(f2));
		System.out.println(f1.dividir(f2));
		System.out.println(f1.suma(f2).simplificar());
		System.out.println(f2.esMayorQue(f1));

	}

}
