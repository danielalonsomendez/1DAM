package ejemplos_OOP;

public class ejemplo1 {

	public static void main(String[] args) {
		Coche miCoche = new Coche();
		Coche tuCoche = new Coche("Seat","Ibiza","1234-HZW",200,-50);
		miCoche.acelerar(100);
		miCoche.frenar(50);
		miCoche.girar(90);
		miCoche.setMatricula("AA");
		System.out.println(miCoche.getMatricula());
		System.out.println(tuCoche.getMatricula());
		System.out.println(tuCoche.getVelocidad());
		System.out.println(tuCoche.getDireccion());

	}

}
