package Modelo;

public class Rectangulo extends Figura {
	protected float ancho;
	protected float alto;
	
	public Rectangulo(String color, Punto coordenada, float ancho, float alto) {
		super(color, coordenada);
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	@Override
	public float Area() {
	    return (float) (ancho*alto);
	}
	@Override
	public float Perimetro() {
	    return (float) (2*(ancho+alto));
	}
	
	@Override
	public String toString() {
		return super.toString()+"Ancho:" + ancho + ", Alto:" + alto+", Area:"+Area()+",Perimetro:"+Perimetro();
	}
}
