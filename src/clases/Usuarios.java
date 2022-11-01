package clases;

import static org.junit.Assert.assertArrayEquals;

public class Usuarios {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String direccion;
	protected String nombreUsuario;
	protected String contraseña;
	protected   int  id = -1;
	private Boolean tipo;
	protected String email;
	

	public Usuarios(String nombre, String apellidos, int edad, String direccion, String nombreUsuario, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		
		this.email= nombre + apellidos + "@email.com";
	
	}
	
	public Usuarios() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.direccion = "";
		this.nombreUsuario = "";
		this.contraseña = "";
	
		this.email="@email.com";
	
	}

	public String getNombre() {
		
		return nombre;
	}

	public void setNombre(String nombre) {
		this.email= nombre + this.apellidos + "@email.com";
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.email= this.nombre + apellidos + "@email.com";
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

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", direccion=" + direccion
				+ ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + ", id=" + id + ", tipo=" + tipo
				+ ", email=" + email + "]";
	}
	



	
	
	
	
}
