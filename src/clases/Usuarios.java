package clases;

import static org.junit.Assert.assertArrayEquals;

public class Usuarios {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String direccion;
	protected String nombreUsuario;
	protected String contraseña;
	private int id = -1;
	private Boolean tipo;
	public Usuarios(String nombre, String apellidos, int edad, String direccion, String nombreUsuario, String contraseña, Boolean tipo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.tipo =tipo;
		
	}
	
	public Usuarios() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.direccion = "";
		this.nombreUsuario = "";
		this.contraseña = "";
		this.tipo= true;
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean profesor) {
		this.tipo= profesor;
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

	public void setApellido(String apellidos) {
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

	
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", direccion=" + direccion
				+ ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + "]";
	}



	
	
	
	
}
