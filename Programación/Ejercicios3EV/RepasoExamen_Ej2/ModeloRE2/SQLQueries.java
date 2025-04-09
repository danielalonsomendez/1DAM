package ModeloRE2;

public class SQLQueries {
	//SELECTS
	public static final String SELECT_PUBLICACIONES = "select P.id,P.usuario,P.instante,P.likes,M.texto,F.fichero,F.titulo from publicaciones P left join mensajes M on P.id =M.id left join fotos F on F.id = P.id;";
	public static final String SELECT_COMENTARIOS = "select publicacion_id,texto from comentarios";

	//INSERTS
	public static final String INSERT_PUBLICACION= "INSERT into Publicacion values('";
	public static final String INSERT_MENSAJE= "INSERT into Mensaje values('";
	public static final String INSERT_FOTOS= "INSERT into Foto values('";
	public static final String INSERT_COMENTARIO= "INSERT into comentarios(publicacion_id,texto) values('";
	public static final String SEPARATOR = "' , '";
	public static final String END_BLOCK = "' )";
	
	//UPDATES
	public static final String UPDATE_LIKE= "Update publicaciones set likes= likes+1 where id=";
	public static final String UPDATE_UNLIKE= "Update publicaciones set likes= likes-1 where id=";

}
