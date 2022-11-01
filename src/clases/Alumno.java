package clases;

public class Alumno extends Usuarios {

	protected String curso;

	public Alumno(String nombre, String apellidos, int edad, String direccion, String nombreUsuario, String contraseña,
			Boolean tipo, String curso) {
		super(nombre, apellidos, edad, direccion, nombreUsuario, contraseña);
		this.curso = curso;
	}

	public Alumno() {
		super();
		this.curso = "Primero";
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [curso=" + curso + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", email=" + email +" id: " + id +"]";
	}





	
}
