import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BaseDatos {
	private String cadenaConexion;
	private String driver;
	private Connection cn;
	private static BaseDatos mBaseDatos=new BaseDatos();
	private ResultSet rs;

	//CONSTRUCTORES
	BaseDatos() {
		cadenaConexion="jdbc:mysql://localhost:33066/sara_baras";
		driver="com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	//METODOS
	public static BaseDatos getBBDD(){
		return mBaseDatos;
	}
	public void conectar() {
		try {
			cn=DriverManager.getConnection(cadenaConexion, "root", "");
			System.out.println(cn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet obtenerDatos(){
		java.sql.PreparedStatement sentencia;
		String strSent="SELECT * FROM cliente";

		try {
			sentencia=cn.prepareStatement(strSent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs=sentencia.executeQuery();
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void insertarDatos(Perfil perfil){
		java.sql.PreparedStatement preparedStmt;
		String strSent="INSERT INTO perfiles VALUES (?,?,?,?,?,?,?)";

		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, perfil.getClave());
			preparedStmt.setString(2, perfil.getNombre());
			preparedStmt.setString(3, perfil.getApellido());
			preparedStmt.setInt(4, perfil.getEdad());
			preparedStmt.setString(5, perfil.getCalle());
			preparedStmt.setInt(6, perfil.getNumero());
			preparedStmt.setString(7, perfil.getCodigoPostal());

			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Compruebe que los datos estan insertados correctamente");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void modificarDatos(Perfil perfil){
		java.sql.PreparedStatement preparedStmt;
		String strSent="UPDATE perfiles SET nombre = ?, apellido = ?, dni = ?, nacimiento = ?, provincia = ?, genero = ?, telefono = ?, Calle = ?, avatar = ?, docente = ?, delegado = ?, tutor = ?, sueldo = ?, usuario = ?, password = ?, email = ? WHERE idPerfil = ?";

		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, perfil.getNombre());
			preparedStmt.setString(2, perfil.getApellido());
			preparedStmt.setInt(3, perfil.getEdad());
			preparedStmt.setString(4, perfil.getCalle());
			preparedStmt.setInt(5, perfil.getNumero());
			preparedStmt.setString(6, perfil.getCodigoPostal());
			preparedStmt.setString(7, perfil.getClave());

			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Compruebe que los datos estan insertados correctamente");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void borrarDatos(String claveIndex) {
		java.sql.PreparedStatement preparedStmt;
		String strSent="DELETE FROM cliente WHERE Clave = ?";


		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, claveIndex);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean loginUser(String user, String pwd){
		
		java.sql.PreparedStatement sentencia;
		String pass = new String();
		String strSent="SELECT perfiles.password FROM perfiles WHERE perfiles.usuario = ?";

		try {
			sentencia = cn.prepareStatement(strSent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			sentencia.setString(1, user.toString());
			System.out.println(sentencia);
			rs=sentencia.executeQuery();
			rs.first();
			pass = rs.getString(1);
			System.out.println(pass);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pass.equals(pwd);


	}
	public void logoutUser(){

	}

	public void desconectar(){
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



/*
 * import java.sql.Connection;
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
		String strSent = "select * from perfiles";
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

*/
