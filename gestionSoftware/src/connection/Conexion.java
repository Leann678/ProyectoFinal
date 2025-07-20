package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	
	private static Conexion instancia; //Instancia unica (singleton)
	private Connection conexion; //Objeto de conexion
	
	//Parametros de conexion
	private final String URL = "jdbc:mysql://localhost:3306/vino";
	private final String USER = "root";
	private final String PASSWORD = "diego2006";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//Constructor privado
	
	private Conexion() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexion establecidad con exito.");
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Error al conectar con la base de datos.");
			e.printStackTrace();
		}
	}
	
	//Metodo publico para obtener la instanca unica
	
	public static Conexion getInstance() {
		if(instancia == null) {
			instancia = new Conexion ();
		}
		return instancia;
	}
	
	// Metodo para obtener el objeto connection
	
	public Connection getConexion() {
		return conexion;
	}
	
	//Metodo para cerrar la conexión.
	
	public void cerrarConexion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
				System.out.println("Conexión cerrada correctamente.");
			}
		} catch (SQLException e) {
			System.err.println("Error al cerrar la conexión:");
			e.printStackTrace();
		}
	}
}
