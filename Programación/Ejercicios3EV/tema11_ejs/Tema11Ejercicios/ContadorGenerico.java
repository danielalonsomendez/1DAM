package Tema11Ejercicios;

public class ContadorGenerico {
	private String valor;
	private int contador;

	public ContadorGenerico() {
		this.contador = 0;

	}

	public ContadorGenerico(String valor, int contador) {
		super();
		this.valor = valor;
		this.contador = contador;
	}
	public ContadorGenerico(ContadorGenerico generico) {
		super();
		this.valor = generico.valor;
		this.contador = generico.contador;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "Valor:" +  valor + " Contador:" + contador ;
	}
	
}
