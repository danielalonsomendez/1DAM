package ejs_tema5_OOP;

public class PersonaMain {

	public static void main(String[] args) {
		Persona persona1 = new Persona("10001a", "aa","bb",11,5,2005);
		Persona persona2 = new Persona("10001b", "bb","cc",15,5,2005);
		Persona personacopia = new Persona(persona1);

		System.out.println(persona1.toString());
		System.out.println(persona1.equals(personacopia));
		persona1.leer();
		System.out.println(persona1.toString());

	}

}
