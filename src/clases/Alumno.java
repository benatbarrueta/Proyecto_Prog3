package clases;

public class Alumno extends Usuarios {

	protected int curso;

	public Alumno(String nombre, String apellidos, int edad, String direccion, String nombreUsuario, String contraseña, int curso) {
		super(nombre, apellidos, edad, direccion, nombreUsuario, contraseña);
		this.curso = curso;
	}

	public Alumno() {
		super();
		this.curso = 1;
	}

	

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [curso=" + curso + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", id=" + id + ", email=" + email + "]";
	}

	

	





	
}
