

public class Perfil {

	//DATOS
	private int idPerfil;
	private String nombre;
	private String apellido;
	private String dni;
	private String nacimiento;
	private int provincia;
	private String genero;
	private int telefono;
	private String calle;
	private String avatar;
	private boolean docente;

	private boolean delegado;
	private boolean tutor;
	private int sueldo;
	private String usuario;
	private String contraseña;
	private String email;

	//CONSTRUCTORES
	public Perfil(){
		idPerfil = -1;
		nombre = "";
		apellido = "";
		dni = "";
		nacimiento = "";
		provincia = -1;
		genero = "";
		telefono = -1;
		calle = "";
		avatar = "";
		docente = false;

		delegado = false;
		tutor = false;
		sueldo = -1;
		usuario = "";
		contraseña = "";
		email = "";
	}

	public Perfil(int idPerfil, String nombre, String apellido, String dni, String nacimiento, int provincia, String genero, int telefono, String calle, String avatar, boolean docente, boolean delegado, boolean tutor, int sueldo, String usuario, String contraseña, String email) {
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacimiento = nacimiento;
		this.provincia = provincia;
		this.genero = genero;
		this.telefono = telefono;
		this.calle = calle;
		this.avatar = avatar;
		this.docente = docente;

		this.delegado = delegado;
		this.tutor = tutor;
		this.sueldo = sueldo;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.email = email;
	}

	//GETTERS Y SETTERS
	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getProvincia() {
		return provincia;
	}

	public void setProvincia(int provincia) {
		this.provincia = provincia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isDocente() {
		return docente;
	}

	public void setDocente(boolean docente) {
		this.docente = docente;
	}

	public boolean isDelegado() {
		return delegado;
	}

	public void setDelegado(boolean delegado) {
		this.delegado = delegado;
	}

	public boolean isTutor() {
		return tutor;
	}

	public void setTutor(boolean tutor) {
		this.tutor = tutor;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//METODOS


}