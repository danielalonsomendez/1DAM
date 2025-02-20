package modelo;

public class Empleado {
	private int NumEmp = 0;
	private String NomEmp = null;
	private String Puesto = null;
	private double Salario =  0;
	
	public Empleado() {		
	}

	public Empleado(int numEmp, String nomEmp, String puesto, double salario) {
		NumEmp = numEmp;
		NomEmp = nomEmp;
		Puesto = puesto;
		Salario = salario;
	}

	public int getNumEmp() {
		return NumEmp;
	}

	public void setNumEmp(int numEmp) {
		NumEmp = numEmp;
	}

	public String getNomEmp() {
		return NomEmp;
	}

	public void setNomEmp(String nomEmp) {
		NomEmp = nomEmp;
	}

	public String getPuesto() {
		return Puesto;
	}

	public void setPuesto(String puesto) {
		Puesto = puesto;
	}

	public double getSalario() {
		return Salario;
	}

	public void setSalario(double salario) {
		Salario = salario;
	}

	@Override
	public String toString() {
		return "NumEmp=" + NumEmp + ", NomEmp=" + NomEmp + ", Puesto=" + Puesto + ", Salario=" + Salario + "€";
	}
	
}
