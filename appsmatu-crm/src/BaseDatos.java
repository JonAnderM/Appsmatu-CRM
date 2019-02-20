import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BaseDatos {
	private String cadenaConexion;
	private String driver;
	private Connection cn;
	private static BaseDatos mBaseDatos=new BaseDatos();
	private ResultSet rs;

	//CONSTRUCTORES
	BaseDatos() {
		cadenaConexion="jdbc:mysql://localhost:33066/sara_baras?verifyServerCertificate=false&useSSL=true&zeroDateTimeBehavior=convertToNull";
		//cadenaConexion="jdbc:mysql://www.db4free.net:3306/sara_baras?verifyServerCertificate=false&useSSL=true&zeroDateTimeBehavior=convertToNull";
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
			//cn=DriverManager.getConnection(cadenaConexion, "sarabaras", "sarabaras123");
			cn=DriverManager.getConnection(cadenaConexion, "root", "");
			System.out.println(cn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet obtenerDatos(String nombreTabla){
		java.sql.PreparedStatement sentencia;
		//String strSent="SELECT * FROM asignatura INNER JOIN perfiles ON perfiles.idPerfil=asignatura.docente WHERE perfiles.Nombre LIKE 'Virginia'";
		String strSent="SELECT * FROM perfiles WHERE docente IS false";
		conectar();

		try {
			sentencia=cn.prepareStatement(strSent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//sentencia.setString(1, nombreTabla);
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
		String strSent="INSERT INTO perfiles VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, perfil.getNombre());
			preparedStmt.setString(2, perfil.getApellido());
			preparedStmt.setString(3, perfil.getDni());
			preparedStmt.setString(4, perfil.getNacimiento());
			preparedStmt.setInt(5, perfil.getProvincia());
			preparedStmt.setString(6, perfil.getGenero());
			preparedStmt.setInt(7, perfil.getTelefono());
			preparedStmt.setString(8, perfil.getCalle());
			preparedStmt.setString(9, perfil.getAvatar());
			preparedStmt.setBoolean(10, perfil.isDocente());
			preparedStmt.setBoolean(11, perfil.isDelegado());
			preparedStmt.setBoolean(12, perfil.isTutor());
			preparedStmt.setInt(13, perfil.getSueldo());
			preparedStmt.setString(14, perfil.getUsuario());
			preparedStmt.setString(15, perfil.getContraseña());
			preparedStmt.setString(16, perfil.getEmail());
			preparedStmt.setInt(17, perfil.getIdPerfil());

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
			preparedStmt.setString(3, perfil.getDni());
			preparedStmt.setString(4, perfil.getNacimiento());
			preparedStmt.setInt(5, perfil.getProvincia());
			preparedStmt.setString(6, perfil.getGenero());
			preparedStmt.setInt(7, perfil.getTelefono());
			preparedStmt.setString(8, perfil.getCalle());
			preparedStmt.setString(9, perfil.getAvatar());
			preparedStmt.setBoolean(10, perfil.isDocente());
			preparedStmt.setBoolean(11, perfil.isDelegado());
			preparedStmt.setBoolean(12, perfil.isTutor());
			preparedStmt.setInt(13, perfil.getSueldo());
			preparedStmt.setString(14, perfil.getUsuario());
			preparedStmt.setString(15, perfil.getContraseña());
			preparedStmt.setString(16, perfil.getEmail());
			preparedStmt.setInt(17, perfil.getIdPerfil());
			

			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Compruebe que los datos estan insertados correctamente");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void borrarDatos(String id) {
		java.sql.PreparedStatement preparedStmt;
		String strSent="DELETE FROM cliente WHERE Clave = ?";


		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, id);

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean loginUser(String user, String pwd){
		
		java.sql.PreparedStatement sentencia;
		String pass = new String();
		String strSent="SELECT perfiles.password FROM perfiles WHERE perfiles.usuario = ? AND perfiles.docente = true";

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

	public void getAlumnos() {
		// TODO Auto-generated method stub
		
	}
	public void getAsignaturas(){
		
	}
	public void getCursos(){
		
	}
	public void getNoticias(){
		
	}
	public void getDocentes(){
		
	}
	public void setUser(String id){
		
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
