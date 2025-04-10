package modelo;

public class Administrativo extends Empleado{
	private String titulacion;
	
	public Administrativo() {
	}
	public Administrativo(String nomEmp, float salario,String titulacion) {
		super(nomEmp,salario);
		this.titulacion = titulacion;
	}
	public Administrativo(int numEmp, String nomEmp, float salario,String titulacion) {
		super(numEmp, nomEmp,salario);
		this.titulacion = titulacion;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	
	@Override
	public String toString() {
		return "Administrativo" +super.toString()+ titulacion ;
	}

}
