package Modelo;

public class Circulo extends Eclipse{


	public Circulo(String color, Punto coordenada, float rMayor) {
		super(color, coordenada, rMayor, rMayor);
	}
	
	public static boolean validarCirculo(float rMayor,float rMenor) {
		if(rMayor == rMenor) {
			return true;
		}
		return false;
	}
	
	@Override
	public float Area() {
		return (float) (Math.PI*(rMayor*rMayor));
	}
	@Override
	public float Perimetro() {
		return (float) (2*Math.PI*rMayor);
	}
}
