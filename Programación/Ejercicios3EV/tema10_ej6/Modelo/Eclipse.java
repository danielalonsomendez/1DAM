package Modelo;

public class Eclipse extends Figura {
	protected float rMayor;
	protected float rMenor;
	public Eclipse(String color, Punto coordenada, float rMayor, float rMenor) {
		super(color, coordenada);
		this.rMayor = rMayor;
		this.rMenor = rMenor;
	}
	public float getrMayor() {
		return rMayor;
	}
	public void setrMayor(float rMayor) {
		this.rMayor = rMayor;
	}
	public float getrMenor() {
		return rMenor;
	}
	public void setrMenor(float rMenor) {
		this.rMenor = rMenor;
	}
	@Override
	public String toString() {
		return super.toString()+"Radio Mayor:" + rMayor + ", Radio Menor:" + rMenor +", Area:"+Area()+",Perimetro:"+Perimetro();
	}
	@Override
	public float Area() {
		return (float) (Math.PI*rMenor*rMayor);
	}
	@Override
	public float Perimetro() {
		return (float) (2*Math.PI*Math.sqrt(((rMayor*rMayor)*(rMenor*rMenor))/2));
	}

	
}
