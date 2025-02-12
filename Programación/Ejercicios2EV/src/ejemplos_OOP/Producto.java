package ejemplos_OOP;

public class Producto {

	private String código;
	private String nombre;
	private double precio;
	private int tipo;

	Producto(String código, String nombre, double precio, int tipo) {
		this.código = código;
		this.nombre = nombre;
		this.setPrecio(precio);
		this.setTipo(tipo);
	}

	public void setCódigo(String código) {
		this.código = código;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
		if (precio < 0) {
			this.precio = 0;
		}
	}

	public void setTipo(int tipo) {
		if (tipo < 1 || tipo > 4) {
			this.tipo = 1;
		} else {
			this.tipo = tipo;
		}
	}

	public String getCódigo() {
		return código;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getTipo() {
		return tipo;
	}

	public boolean equals(Producto producto) {
		if (this.tipo == producto.getTipo() && this.código == producto.getCódigo()
				&& this.nombre == producto.getNombre() && this.precio == producto.getPrecio()) {
			return true;
		} else {
			return false;
		}
	}

}
