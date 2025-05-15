package modelo;

public class SQLQuerys {
	
	// INSERTS
	public static final String INSERT_ADMINISTRATIVO = "insert into Empleado(NumEmp,NomEmp,Salario,Titulacion)  values ('";
	public static final String INSERT_VENDEDOR = "insert into Empleado(NumEmp,NomEmp,Salario,Comision,Contrato) values ('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
	
	// DELETES 
	public static final String DELETE_TODOS_EMPLEADOS = "delete from empleado";
}
