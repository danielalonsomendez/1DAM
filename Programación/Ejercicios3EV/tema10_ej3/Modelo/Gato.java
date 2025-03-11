package Modelo;

import Modelo_EJ4.Mascota;

public class Gato extends Mascota {

	protected String color;
	protected char pelo;
	
	public Gato(int identificador, String nombre, int edad, String dNI, String color, char pelo) {
		super(identificador, nombre, edad, dNI);
		this.color = color;
		this.pelo = pelo;
	}
	public static boolean validarPelo(String pelo) {
		return pelo.equals("L")||pelo.equals("M")||pelo.equals("C") ;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getPelo() {
		return pelo;
	}
	public void setPelo(char pelo) {
		this.pelo = pelo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" color: "+getColor()+" pelo: "+getPelo();
	}
	
	
}
