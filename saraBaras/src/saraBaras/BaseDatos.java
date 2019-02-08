package saraBaras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDatos {
	private String cadenaConexion;
	private String driver;
	private Connection cn;
	private ResultSet rs;

	//CONSTRUCTOR/ES
	public BaseDatos(String bd){
		cadenaConexion="jdbc:mysql://localhost:3306/"+bd;
		driver="com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	//METODOS
	public void conectar(){
		try {
			cn = DriverManager.getConnection(cadenaConexion,"root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public ResultSet obtenerDatos(){
		//OBTENER TODOS LOS REGISTROS CON TODOS LOS CAMPOS DE LA BD Y DEVUELVO EN UN RESULTSET
		PreparedStatement sentencia;
		String strSent = "select * from sarabaras";
		try {
			sentencia = cn.prepareStatement(strSent,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=sentencia.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	
	
}
