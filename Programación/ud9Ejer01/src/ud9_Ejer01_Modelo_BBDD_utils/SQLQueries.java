package ud9_Ejer01_Modelo_BBDD_utils;

public class SQLQueries {
	// SELECTS
	public static final String SELECT_TODOS_ALUMNOS = "select * from Alumnos";
	
	//UPDATES
	public static final String UPDATE_GRUPO_ALUMNO = "update Alumnos set grupo = ? where dni = ?";
}
