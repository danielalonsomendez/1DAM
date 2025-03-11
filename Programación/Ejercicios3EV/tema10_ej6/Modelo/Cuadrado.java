package Modelo;

public class Cuadrado extends Rectangulo {
	
	public Cuadrado(String color, Punto coordenada, float ancho) {
		super(color, coordenada, ancho, ancho);
	}

	private static boolean validarCuadrado(float ancho,float alto) {
		if(ancho == alto) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public float Area() {
	    return (float) (ancho*2);
	}
	@Override
	public float Perimetro() {
	    return (float) (4*ancho);
	}
}
