package ejemplos_OOP;

public class Coche {

	private String marca;
	private String modelo;
	private String matricula;
	private int direccion;
	private int velocidad;

	public Coche() {
		marca = "";
		modelo = "";
		matricula = "";
		direccion = 0;
		velocidad = 0;
	}

	public Coche(String marca, String modelo, String matricula, int direccion, int velocidad) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		
		if (velocidad < 0) {
			this.velocidad = 0;
		} else {
			this.velocidad = velocidad;
		}

		if (direccion < -45) {
			this.direccion = -45;
		} else if (direccion > 45) {
			this.direccion = 45;
		} else {
			this.direccion = direccion;
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void acelerar(int velAceleracion) {
		velocidad = velocidad + velAceleracion;
	}

	public void frenar(int velFrenado) {
		velocidad = velocidad - velFrenado;
		if (velocidad < 0) {
			velocidad = 0;
		}
	}

	public void girar(int grados) {
		direccion = direccion + grados;
		if (direccion < -45) {
			direccion = -45;
		}
		if (direccion > 45) {
			direccion = 45;
		}
	}

	public void setMatricula(String matriculaNueva) {
		matricula = matriculaNueva;
	}

	public String getMatricula() {
		return matricula;
	}
	public int getDireccion() {
		return direccion;
	}
	public int getVelocidad() {
		return velocidad;
	}

}
