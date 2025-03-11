package Modelo;

public class Triangulo extends Figura{
	private float lado1,lado2,lado3;

	public Triangulo(String color, Punto coordenada, float lado1, float lado2, float lado3) {
		super(color, coordenada);
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	public float getLado1() {
		return lado1;
	}

	public void setLado1(float lado1) {
		this.lado1 = lado1;
	}

	public float getLado2() {
		return lado2;
	}

	public void setLado2(float lado2) {
		this.lado2 = lado2;
	}

	public float getLado3() {
		return lado3;
	}

	public void setLado3(float lado3) {
		this.lado3 = lado3;
	}

	@Override
	public String toString() {
		return super.toString()+"Lado 1: " + lado1 + ", Lado 2:" + lado2 + ", Lado 3:" + lado3 +", Area:"+Area()+",Perimetro:"+Perimetro();
	}

	@Override
	public float Area() {
		float s = (lado1+lado2+lado3)/2;
		return (float) Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
	}

	@Override
	public float Perimetro() {
		return lado1+lado2+lado3;
	}
	
}
