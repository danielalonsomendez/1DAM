package ModeloRE2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ModeloRE2.Foto;
import ModeloRE2.FuenteNoticias;
import ModeloRE2.Mensaje;
import ModeloRE2.Publicacion;
import Modelo_EJ5.DBUtils;
import Modelo_EJ5.Gato;
import Modelo_EJ5.Mascota;
import Modelo_EJ5.Perro;

public class Gestor {
	public ResultSet select(String sql) throws SQLException, Exception {
		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultSet = sentencia.executeQuery();
			return resultSet;
		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public ArrayList<Publicacion> selectPublicaciones() throws SQLException, Exception {
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

		try {
			ResultSet rs = select(SQLQueries.SELECT_PUBLICACIONES);
			while (rs.next()) {
				if (rs.getString("texto") != null) {
					publicaciones.add(new Mensaje(rs.getInt("id"), rs.getString("usuario"), rs.getLong("instante"),
							rs.getInt("likes"), new ArrayList<String>(), rs.getString("texto")));
				} else if (rs.getString("Color") != null) {
					publicaciones.add(new Foto(rs.getInt("id"), rs.getString("usuario"), rs.getLong("instante"),
							rs.getInt("likes"), new ArrayList<String>(), rs.getString("fichero"),
							rs.getString("titulo")));
				}
			}
			rs.close();
			ResultSet rs2 = select(SQLQueries.SELECT_COMENTARIOS);
			for (Publicacion publicacion : publicaciones) {
				while (rs2.next()) {
					if (rs2.getInt("id") == publicacion.getId()) {
						publicacion.AñadirComentario(rs2.getString("texto"));
					}
				}
			}
			rs2.close();
		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} catch (Exception e) {
			throw new Exception(e);
		}

		return publicaciones;
	}

	public void actualizarArchivo(FuenteNoticias fuentenoticia) throws IOException {
		try {
			FileWriter fichero = new FileWriter("Redes.txt");
			PrintWriter pw = new PrintWriter(fichero);
			for (Publicacion publicacion : fuentenoticia.getPublicaciones()) {
				pw.print(publicacion.toStringArchivo() + "\n--------------------------------\n");
			}
			fichero.close();
		} catch (IOException e) {
			throw new IOException(e);
		}

	}
}
