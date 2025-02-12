package ejs_tema5_OOP;

public class Recuento {
	public static int recuento;

	Recuento() {
		recuento++;
	}

	public static void escribirRecuento() {
		System.out.println("Hay " + recuento + " objectos de la clase.");
	}

	public void finalize() {
		recuento--;
	}
}
