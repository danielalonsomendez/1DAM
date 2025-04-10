package modelo;

public class Vendedor extends Empleado {
	private float comision;
	private String contrato;
	
	public Vendedor() {

	}
	public Vendedor(String nomEmp, float salario, float comision, String contrato) {
		super(nomEmp, salario);
		this.comision = comision;
		this.contrato = contrato;
	}
	public Vendedor(int numEmp, String nomEmp, float salario, float comision, String contrato) {
		super(numEmp, nomEmp, salario);
		this.comision = comision;
		this.contrato = contrato;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	@Override
	public String toString() {
		return "Vendedor"+ super.toString()+ comision + ": " + contrato;
	}
//
}
