package ejs_tema5_OOP;

public class AsignaturaMain {

	public static void main(String[] args) {
		Asignatura asignatura1 = new Asignatura("10001a", "aa",3);
		Asignatura asignatura2 = new Asignatura("10001b", "bb",5);
		Asignatura asignaturacopia = new Asignatura(asignatura1);

		System.out.println(asignatura1.toString());
		System.out.println(asignatura1.equals(asignaturacopia));
		asignatura1.leer();
		asignatura2.leer();
System.out.println(asignatura1.toString());


	}

}
