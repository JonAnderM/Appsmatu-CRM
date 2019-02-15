

public class Perfil {

	//DATOS
	private String clave;
	private String nombre;
	private String apellido;
	private int edad;
	private String calle;
	private int numero;
	private String codigoPostal;

	//CONSTRUCTORES
	public Perfil(){
		clave = "";
		nombre = "";
		apellido = "";
		edad = -1;
		calle = "";
		numero = -1;
		codigoPostal = "";
	}

	public Perfil(String clave, String nombre, String apellido, int edad, String calle, int numero, String codigoPostal) {
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
	}

	//GETTERS Y SETTERS
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	//METODOS


}