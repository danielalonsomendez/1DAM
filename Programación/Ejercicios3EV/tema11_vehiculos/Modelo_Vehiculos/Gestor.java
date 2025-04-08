package Modelo_Vehiculos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gestor {

	public ArrayList<Vehiculo> leerArchivo() throws IOException {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		File archivo = new File("vehiculos.txt");
		try {
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String linea;
				while ((linea = br.readLine()) != null) {
						if (linea.equals("")  == true)
							linea = br.readLine();
						String Tipo = linea.split("Tipo: ")[1];
						linea = br.readLine();
						int Id = Integer.parseInt(linea.split("Id: ")[1]);
						linea = br.readLine();
						String Marca = linea.split("Marca: ")[1];
						linea = br.readLine();
						String Modelo = linea.split("Modelo: ")[1];
						linea = br.readLine();
						if (Tipo.equals("Coche")) {
							int Puertas = Integer.parseInt(linea.split("Puertas: ")[1]);
							vehiculos.add(new Coche(Id, Marca, Modelo, Puertas));
						} else if (Tipo.equals("Moto")) {
							int Cilindrada = Integer.parseInt(linea.split("Cilindrada: ")[1]);
							vehiculos.add(new Moto(Id, Marca, Modelo, Cilindrada));
						} else if (Tipo.equals("Camion")) {
							int Carga = Integer.parseInt(linea.split("Carga: ")[1]);
							vehiculos.add(new Camion(Id, Marca, Modelo, Carga));
						}
					
				}
			}

		} catch (IOException e) {
			throw new IOException(e);
		}
		return vehiculos;
	}

}
