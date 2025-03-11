package Modelo;


public class Perro extends Mascota {
	protected String raza;
	protected boolean pulgas;
	
	public Perro(int identificador, String nombre, int edad, String dNI, String raza, boolean pulgas) {
		super(identificador, nombre, edad, dNI);
		this.raza = raza;
		this.pulgas = pulgas;
	}
	
	public static boolean validarPulgas(String pulgas) {
		return pulgas.equals("SI") ||  pulgas.equals("NO");
	}
	
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean isPulgas() {
		return pulgas;
	}
	public void setPulgas(boolean pulgas) {
		this.pulgas = pulgas;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +" raza: "+ getRaza()+" pulgas:"+ isPulgas();
	}
	
	  
}
