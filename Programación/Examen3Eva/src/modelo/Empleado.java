package modelo;

public abstract class Empleado {
	protected int numEmp;
	protected String nomEmp;
	protected float salario;
	protected static int cont =0;
	
	public Empleado() {
		cont++;
		numEmp = cont;
	}
	public Empleado(String nomEmp, float salario) {
		super();
		cont++;
		numEmp = cont;
		this.nomEmp = nomEmp;
		this.salario = salario;
	}
	
	public Empleado(int numEmp, String nomEmp, float salario) {
		super();
		this.numEmp = numEmp;
		this.nomEmp = nomEmp;
		this.salario = salario;
		cont++;
	}


	public int getNumEmp() {
		return numEmp;
	}

	public void setNumEmp(int numEmp) {
		this.numEmp = numEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public static int getCont() {
		return cont;
	}

	public static void setCont(int cont) {
		Empleado.cont = cont;
	}

	@Override
	public String toString() {
		return  ": " + nomEmp + ": " + salario+": ";
	}
	
}
