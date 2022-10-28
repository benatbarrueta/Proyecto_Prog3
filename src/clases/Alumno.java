package clases;

public class Alumno extends Usuarios {
	protected String email;
	protected String curso;


	public Alumno(String nombre, String apellidos, int edad, String direccion, String nombreUsuario, String contraseña,
			String email, String curso) {
		super(nombre, apellidos, edad, direccion, nombreUsuario, contraseña);
		this.email = email;
		this.curso = curso;
	}

	public Alumno() {
		super();
		this.email = email;
		this.curso = curso;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return super.toString() + ", email" + email;
	}
	
	
}
