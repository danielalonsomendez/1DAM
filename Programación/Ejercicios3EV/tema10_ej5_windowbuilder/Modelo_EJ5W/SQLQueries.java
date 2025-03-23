package Modelo_EJ5W;

public class SQLQueries {
	//SELECTS
	public static final String SELECT_MAX_MASCOTA = "select max(Id) from Mascota";
	public static final String SELECT_MASCOTAS = "select M.Id,Nombre,Edad,DNIDueño,Raza,Pulgas,Color,Pelo from Mascota M left join Perro P on P.Id = M.Id left join Gato G on M.Id = G.Id";
	//INSERTS
	public static final String INSERT_MASCOTA = "insert into Mascota(Nombre,Edad,DNIDueño) values ('";
	public static final String INSERT_GATO = "insert into Gato values ('";
	public static final String INSERT_PERRO = "insert into Perro values ('";

	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
	
	// DELETES
	public static final String DELETE_ID_MASCOTA = "DELETE FROM Mascota WHERE Id=";

}
