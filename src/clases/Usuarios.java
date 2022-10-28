package clases;

public class Usuarios {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String direccion;
	protected String nombreUsuario;
	protected String contraseña;
	
	public Usuarios(String nombre, String apellidos, int edad, String direccion, boolean alumno, String nombreUsuario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}
	
	public Usuarios() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.direccion = "";
		this.nombreUsuario = "";
		this.contraseña = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellidos;
	}

	public void setApellido(String apellido) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setnombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario " + nombre + apellidos + ", " + edad + "años.";
	}
	
	
	
}
