package ejemplos_OOP;

public class ejemplo2 {
	public static void main(String[] args) {
		Producto producto1 = new Producto("1001", "Coca-Cola", 5, 5);
	System.out.printf("%s %s %s %s",producto1.getCódigo(),producto1.getNombre(),producto1.getPrecio(),producto1.getTipo());

	}
}
