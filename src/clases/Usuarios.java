package clases;

import static org.junit.Assert.assertArrayEquals;

public class Usuarios {
	protected String nombre;
	protected String apellidos;
	protected Integer edad;
	protected String direccion;
	protected String nombreUsuario;
	protected String contraseña;
	protected Integer id;
	protected String email;

	public Usuarios() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.direccion = "";
		this.nombreUsuario = "";
		this.contraseña = "";
		this.id = 0;
		this.email = "";
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {
		this.email = nombre + this.apellidos + "@email.com";
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.email = this.nombre + apellidos + "@email.com";
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario: " + nombre + apellidos + ", " + edad + " años";
	}

}
