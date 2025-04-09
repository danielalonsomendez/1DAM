package ModeloRE2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public boolean insertar(String sql) throws SQLException, Exception {
		boolean valido = false;
		Connection conexion = null;
		Statement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(sql);
			valido = true;
		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		} catch (Exception e) {
			throw new Exception(e);
		}

		try {
			sentencia.close();
			conexion.close();
		} catch (SQLException sqle) {
			throw new SQLException(sqle);
		}
		return valido;
	}

	public boolean update(String sql) throws SQLException, Exception {
		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			PreparedStatement sentencia = conexion.prepareStatement(sql);

			sentencia.executeUpdate();

			sentencia.close();
			conexion.close();
			return true;
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
				} else {
					publicaciones.add(new Foto(rs.getInt("id"), rs.getString("usuario"), rs.getLong("instante"),
							rs.getInt("likes"), new ArrayList<String>(), rs.getString("fichero"),
							rs.getString("titulo")));
				}
			}
			rs.close();
			ResultSet rs2 = select(SQLQueries.SELECT_COMENTARIOS);
			String[][] comentarios = new String[900][2];
			int i = 0;
			while (rs2.next()) {
				comentarios[i][0] = rs2.getString("publicacion_id");
				comentarios[i][1] = rs2.getString("texto");
				i++;
			}
			for (int y = 0; y < publicaciones.size(); y++) {
				for (int z = 0; z < i; z++) {
					if (Integer.parseInt(comentarios[z][0]) == publicaciones.get(y).getId()) {
						publicaciones.get(y).AñadirComentario(comentarios[z][1]);
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

	public void like(boolean like, Publicacion publicacion) throws SQLException, Exception {
		if (like)
			update(SQLQueries.UPDATE_LIKE + publicacion.getId());
		else
			update(SQLQueries.UPDATE_UNLIKE + publicacion.getId());

	}

	public void añadirComentario(String texto, Publicacion publicacion) throws SQLException, Exception {
		insertar(SQLQueries.INSERT_COMENTARIO + publicacion.getId() + SQLQueries.SEPARATOR + texto
				+ SQLQueries.END_BLOCK);
	}

	public void añadirPublicacion(Publicacion publicacion) throws SQLException, Exception {
		insertar(SQLQueries.INSERT_PUBLICACION + publicacion.getId() + SQLQueries.SEPARATOR
				+ publicacion.getid_Usuario() + SQLQueries.SEPARATOR + publicacion.getInstante_tiempo()
				+ publicacion.getLikes() + SQLQueries.END_BLOCK);

		if (publicacion instanceof Mensaje) {
			Mensaje mensaje = (Mensaje) publicacion;
			insertar(SQLQueries.INSERT_MENSAJE + mensaje.getId() + SQLQueries.SEPARATOR + mensaje.getContenido()
					+ SQLQueries.END_BLOCK);

		} else {
			Foto foto = (Foto) publicacion;
			insertar(SQLQueries.INSERT_FOTOS + foto.getId() + SQLQueries.SEPARATOR + foto.getNombreArchivo()
					+ SQLQueries.SEPARATOR + foto.getTitulo() + SQLQueries.END_BLOCK);

		}

	}
}
