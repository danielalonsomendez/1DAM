package ud9_Ejer05_Modelo_BBDD_utils;

public class SQLQueries {
	// SELECTS
	public static final String SELECT_TODOS_ALUMNOS = "select DNI,Nombre,Apellidos,Grupo from Alumnos";

	//INSERTS
	public static final String INSERT_ALUMNO = "insert into alumnos values ('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "')";
		
}
