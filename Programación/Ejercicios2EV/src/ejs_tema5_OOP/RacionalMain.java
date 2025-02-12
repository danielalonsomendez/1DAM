package ejs_tema5_OOP;

public class RacionalMain {

	public static void main(String[] args) {
		Racional racional1 = new Racional(1234567891, 123456789);
		Racional racional2 = new Racional(1234567891, 11);

		System.out.println(racional1.toString());
		System.out.println(racional1.equals(racional2));
		racional1.leer();

	}

}
