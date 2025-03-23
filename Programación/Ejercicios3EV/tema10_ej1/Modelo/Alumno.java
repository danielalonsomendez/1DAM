package Modelo;

import Modelo.Persona;

public class Alumno extends Persona {

	private String grupo;

	public Alumno(String dNI, String nombre, String direccion, int numTel, String grupo) {
		super(dNI, nombre, direccion, numTel);
		this.grupo = grupo;
	}

	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" grupo = "+getGrupo();
	}
}
