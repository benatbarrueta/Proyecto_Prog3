
public class Usuarios {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String direccion;
	protected boolean alumno;
	
	public Usuarios(String nombre, String apellidos, int edad, String direccion, boolean alumno) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.alumno = alumno;
	}
	
	public Usuarios() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.direccion = "";
		this.alumno = true;
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

	public boolean isAlumno() {
		return alumno;
	}

	public void setAlumno(boolean alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "Usuarios: " + nombre + apellidos + ", " + edad + "años.";
	}
	
	
}
