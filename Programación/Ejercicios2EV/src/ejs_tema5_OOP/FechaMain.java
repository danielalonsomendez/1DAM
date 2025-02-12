package ejs_tema5_OOP;

public class FechaMain {

	public static void main(String[] args) {
		Fecha fecha1 = new Fecha(1, 12,2025);
		Fecha fecha2 = new Fecha(6, 11,2009);

		System.out.println(fecha1.toString());
		System.out.println(fecha2.equals(fecha1));
		fecha1.leer();
		
	}

}
