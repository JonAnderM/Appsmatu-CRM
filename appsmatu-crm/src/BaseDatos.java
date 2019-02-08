import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class BaseDatos {
	private String cadenaConexion;
	private String driver;
	private Connection cn;
	private static BaseDatos mBaseDatos=new BaseDatos();
	private ResultSet rs;

	//CONSTRUCTORES
	private BaseDatos() {
		cadenaConexion="jdbc:mysql://localhost:3306/clientes";
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

	public void insertarDatos(Cliente cliente){
		java.sql.PreparedStatement preparedStmt;
		String strSent="INSERT INTO cliente VALUES (?,?,?,?,?,?,?)";

		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, cliente.getClave());
			preparedStmt.setString(2, cliente.getNombre());
			preparedStmt.setString(3, cliente.getApellido());
			preparedStmt.setInt(4, cliente.getEdad());
			preparedStmt.setString(5, cliente.getCalle());
			preparedStmt.setInt(6, cliente.getNumero());
			preparedStmt.setString(7, cliente.getCodigoPostal());

			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Compruebe que los datos estan insertados correctamente");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void modificarDatos(Cliente cliente){
		java.sql.PreparedStatement preparedStmt;
		String strSent="UPDATE cliente SET Nombre = ?, Apellido = ?, Edad = ?, Calle = ?, Numero = ?, CodigoPostal = ? WHERE Clave = ?";

		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, cliente.getNombre());
			preparedStmt.setString(2, cliente.getApellido());
			preparedStmt.setInt(3, cliente.getEdad());
			preparedStmt.setString(4, cliente.getCalle());
			preparedStmt.setInt(5, cliente.getNumero());
			preparedStmt.setString(6, cliente.getCodigoPostal());
			preparedStmt.setString(7, cliente.getClave());

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

	public void loginUser(){

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

