package modelo;

public class SQLQuerys {
	// SELECTS
	public static final String SELECT_TODOS_EMPLEADO = "select * from Empleado";
	public static final String SELECT_PUESTO_EMPLEADO = "select * from Empleado where Puesto = ?";

	// INSERTS
	public static final String INSERT_EMPLEADO = "insert into Empleado values ('";
	public static final String INSERT_EMPLEADO_SINNUMEMP = "insert into Empleado(NomEmp,Puesto,Salario) values ('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
	
	// DELETES 
	public static final String DELETE_TODOS_EMPLEADOS = "delete from empleado";
	public static final String DELETE_EMPLEADO = "delete from empleado where NumEmp =?";

}
