package Vista;

import java.util.ArrayList;

import Modelo.Cuenta;
import Modelo.CuentaCorriente;
import Modelo.CuentaDeAhorro;

public class Vista {

	static ArrayList<Cuenta> cuentas = new ArrayList<>();
	
	public static void main(String[] args) {
		 generarLista();
		 mostrarInfo();
		 
		 incrementarSaldo();
		 mostrarInfo();
		 
		 SacarDinero();
		 mostrarInfo();
	}

	private static void generarLista() {
		
		  // Creando 3 objetos de CuentaCorriente
        cuentas.add(new CuentaCorriente("CC001", 5000, 1000));
        cuentas.add(new CuentaCorriente("CC002", 10000, 1500));
        cuentas.add(new CuentaCorriente("CC003", 7500, 1200));

        // Creando 3 objetos de CuentaDeAhorro
        
        cuentas.add(new CuentaDeAhorro("CA001", 8000, 3.5));
        cuentas.add(new CuentaDeAhorro("CA002", 12000, 4.0));
        cuentas.add(new CuentaDeAhorro("CA003", 5000, 2.80));
		
	}
	
	private static void incrementarSaldo() {
		for (Cuenta cuenta : cuentas) {
            cuenta.ingresarDinero(10000);
        }
	}
	
	private static void SacarDinero() {
		for (Cuenta cuenta : cuentas) {
            cuenta.extraerDinero(10000);
        }
		
	}

	private static void mostrarInfo() {
		System.out.println("----------Cuentas y saldos actuales----------");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }
		System.out.println("");
	}
}
