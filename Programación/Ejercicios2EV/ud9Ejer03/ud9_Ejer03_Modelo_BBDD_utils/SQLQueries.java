package ud9_Ejer03_Modelo_BBDD_utils;

public class SQLQueries {
	// SELECTS
	public static final String SELECT_ALUMNOS_APELLIDOS = "select * from Alumnos where apellidos like ?";
	public static final String SELECT_ALUMNOS_EDAD = "select * from Alumnos where ? < timestampdiff(year,fecNacimiento,current_date)";

	//INSERTS
	public static final String INSERT_ALUMNO = "insert into alumnos values ('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "')";
		
}
