package Modelo;

public abstract class Figura {
	private String color;
	private Punto coordenada;
	
	public abstract float Area();
	public abstract float Perimetro();
	
	
	public Figura(String color, Punto coordenada) {
		super();
		this.color = color;
		this.coordenada = coordenada;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Punto getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Punto coordenada) {
		this.coordenada = coordenada;
	}
	
	@Override
	public String toString() {
		return "Centro: x: "+ coordenada.getX()+ "y: "+coordenada.getY()+", Color: "+color+ ",";
	}

}
