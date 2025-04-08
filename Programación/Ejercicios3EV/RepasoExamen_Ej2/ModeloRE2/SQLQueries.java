package ModeloRE2;

public class SQLQueries {
	//SELECTS
	public static final String SELECT_PUBLICACIONES = "select P.id,P.usuario,P.instante,P.likes,M.texto,F.fichero,F.titulo from publicaciones P left join mensajes M on P.id =M.id left join fotos F on F.id = P.id;";
	public static final String SELECT_COMENTARIOS = "select publicacion_id,texto from comentarios C";

	//INSERTS
	public static final String INSERT_PUBLICACION = "insert into Publicacion values ('";
	public static final String INSERT_MENSAJE = "insert into Mensaje values ('";
	public static final String INSERT_FOTO = "insert into Foto values ('";

	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
	
	// DELETES
	public static final String DELETE_ID_MASCOTA = "DELETE FROM Mascota WHERE Id=";
	public static final String DELETE_DNI_MASCOTA = "DELETE FROM Mascota WHERE DNIDueño=";

}
