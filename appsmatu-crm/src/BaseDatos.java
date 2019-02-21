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
		cadenaConexion="jdbc:mysql://localhost:3306/sara_baras1?verifyServerCertificate=false&useSSL=true&zeroDateTimeBehavior=convertToNull";
		//cadenaConexion="jdbc:mysql://localhost:33066/sara_baras1?verifyServerCertificate=false&useSSL=true&zeroDateTimeBehavior=convertToNull";
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

	public ResultSet obtenerDatos(JTable tabla){
		java.sql.PreparedStatement sentencia;
		//String strSent="SELECT * FROM asignatura INNER JOIN perfiles ON perfiles.idPerfil=asignatura.docente WHERE perfiles.Nombre LIKE 'Virginia'";
		String strSent="SELECT * FROM perfiles";

		try {

			sentencia=cn.prepareStatement(strSent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=sentencia.executeQuery();
			System.out.println(rs);
			return rs;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void insertarDatos(String columna, String valor, String tabla){

		java.sql.PreparedStatement preparedStmt;
		String strSent="INSERT INTO "+tabla+" ("+columna+") VALUES ('"+valor+"')";
		System.out.println(strSent);
		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Compruebe que los datos estan insertados correctamente");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	public void modificarDatos(JTable tabla, String columna, String valor, String idTabla, String id){

		java.sql.PreparedStatement preparedStmt;
		String sql = "UPDATE "+tabla.getName()+" SET "+columna+"='"+valor+"' WHERE "+idTabla+"='"+id+"'";
		try {
			preparedStmt=cn.prepareStatement(sql);
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void borrarDatos(String columna, String valor, String tabla) {

		java.sql.PreparedStatement preparedStmt;
		String strSent="DELETE FROM "+tabla+" WHERE "+columna+" = ?";

		try {
			preparedStmt = cn.prepareStatement(strSent);
			preparedStmt.setString(1, valor);
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
	public void desconectar(){
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getAlumnos() {
		java.sql.PreparedStatement sentencia;
		//String strSent="SELECT * FROM asignatura INNER JOIN perfiles ON perfiles.idPerfil=asignatura.docente WHERE perfiles.Nombre LIKE 'Virginia'";
		String strSent="SELECT idPerfil, nombre, apellido, dni, telefono, calle, usuario, email FROM perfiles WHERE docente IS false";
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
	public ResultSet getAsignaturas(){
		java.sql.PreparedStatement sentencia;
		//String strSent="SELECT * FROM asignatura INNER JOIN perfiles ON perfiles.idPerfil=asignatura.docente WHERE perfiles.Nombre LIKE 'Virginia'";
		String strSent="SELECT idAsignatura, cursos.nombre AS cursos, asignatura.nombre AS asignaturas, dias.nombre, cursoasignatura.hora  FROM cursos INNER JOIN cursoasignatura ON cursos.idCurso=cursoasignatura.curso INNER JOIN asignatura ON asignatura.idAsignatura=cursoasignatura.asignatura INNER JOIN dias ON dias.idDia=cursoasignatura.dia ORDER BY dias.idDia";

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
	public ResultSet getCursos(){
		java.sql.PreparedStatement sentencia;
		//String strSent="SELECT * FROM asignatura INNER JOIN perfiles ON perfiles.idPerfil=asignatura.docente WHERE perfiles.Nombre LIKE 'Virginia'";
		String strSent="SELECT idCurso, cursos.nombre, cursos.precio, cursos.comienzo, cursos.fin, cursos.horas, modalidades.nombre, aulas.nombre FROM cursos INNER JOIN modalidades ON cursos.modalidad=modalidades.idModalidad INNER JOIN aulas ON aulas.idAula=cursos.aula";
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
	public ResultSet getNoticias(){
		java.sql.PreparedStatement sentencia;
		//String strSent="SELECT * FROM asignatura INNER JOIN perfiles ON perfiles.idPerfil=asignatura.docente WHERE perfiles.Nombre LIKE 'Virginia'";
		String strSent="SELECT idNoticia, fecha, titulo, texto,autor FROM noticias";

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
	public ResultSet getDocentes(){
		java.sql.PreparedStatement sentencia;
		//String strSent="SELECT * FROM asignatura INNER JOIN perfiles ON perfiles.idPerfil=asignatura.docente WHERE perfiles.Nombre LIKE 'Virginia'";
		String strSent="SELECT nombre, apellido, dni, telefono, calle, sueldo, usuario, email FROM perfiles WHERE docente IS true";
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
}