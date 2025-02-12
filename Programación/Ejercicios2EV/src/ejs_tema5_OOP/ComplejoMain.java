package ejs_tema5_OOP;

public class ComplejoMain {
	public static void main(String[] args) {
		new ComplejoBucle();

		Complejo complejo1 = new Complejo(1234567891, 123456789);
		Complejo complejo2 = new Complejo(1234567891, 11);

		System.out.println(complejo1.toString());
		System.out.println(complejo1.equals(complejo2));

		complejo1.leer();
	}
}
