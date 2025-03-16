package Modelo_EJ5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gestor {
	public boolean insertar(String sql) {
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
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}

		try {
			sentencia.close();
			conexion.close();
		} catch (SQLException sqle) {
			System.out.println(" Error al cerrar la conexion.");
		}
		return valido;
	}

	public ResultSet select(String sql) {
		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultSet = sentencia.executeQuery();
			return resultSet;
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos" + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error génerico" + e.getMessage());
		}

		return null;
	}

	public boolean eliminar(String sql) {
		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASSWORD);
			PreparedStatement sentencia = conexion.prepareStatement(sql);

			sentencia.executeUpdate();

			sentencia.close();
			conexion.close();
			return true;
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico " + e.getMessage());
		}
		return false;

	}

	public int maxMascota() {
		try {
			ResultSet resultSet = select(SQLQueries.SELECT_MAX_MASCOTA);
			if (resultSet.isBeforeFirst() && resultSet.next()) {
				return Integer.parseInt(resultSet.getString("max(Id)"));
			}
			resultSet.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean añadirMascota(Mascota mascota) {
		boolean valido = insertar(SQLQueries.INSERT_MASCOTA + mascota.getNombre() + SQLQueries.SEPARATOR
				+ mascota.getEdad() + SQLQueries.SEPARATOR + mascota.getDni() + SQLQueries.END_BLOCK);
		if (valido) {
			int id_mascota = maxMascota();
			if (mascota instanceof Perro) {
				Perro perro = (Perro) mascota;
				valido = insertar(SQLQueries.INSERT_PERRO + id_mascota + SQLQueries.SEPARATOR + perro.getRaza() + "' , "
						+ perro.isPulgas() + ")");
			} else {
				Gato gato = (Gato) mascota;
				valido = insertar(SQLQueries.INSERT_GATO + id_mascota + SQLQueries.SEPARATOR + gato.getColor()
						+ SQLQueries.SEPARATOR + gato.getPelo() + SQLQueries.END_BLOCK);
			}
		}
		return valido;
	}

	public ArrayList<Mascota> selectMascotas(String sql) {
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		;

		try {
			ResultSet rs = select(sql);
			while (rs.next()) {
				if (rs.getString("Raza") != null) {
					mascotas.add(new Perro(rs.getInt("Id"), rs.getString("Nombre"), rs.getInt("Edad"),
							rs.getString("DNIDueño"), rs.getString("Raza"), rs.getBoolean("Pulgas")));
				} else if (rs.getString("Color") != null) {
					mascotas.add(new Gato(rs.getInt("Id"), rs.getString("Nombre"), rs.getInt("Edad"),
							rs.getString("DNIDueño"), rs.getString("Color"), rs.getString("Pelo").toCharArray()[0]));
				}
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error con la base de datos" + e.getMessage());
		}
		return mascotas;
	}

	public ArrayList<Mascota> todasMascotas() {
		return selectMascotas(SQLQueries.SELECT_MASCOTAS);
	}

	public ArrayList<Mascota> mascotasDNI(String dni) {
		return selectMascotas(SQLQueries.SELECT_MASCOTAS_DNI + "'" + dni + "'");
	}

	public boolean eliminarMascotaID(int Id) {
		return eliminar(SQLQueries.DELETE_ID_MASCOTA + "'" + Id + "'");
	}

	public boolean eliminarMascotaDNI(String dni) {
		return eliminar(SQLQueries.DELETE_DNI_MASCOTA + "'" + dni + "'");
	}
}
