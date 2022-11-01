package clases;

public class Profesor extends Usuarios {
	protected Integer salario;

	public Profesor(String nombre, String apellidos, int edad, String direccion, String nombreUsuario,
			String contraseña, Boolean tipo, Integer salario) {
		super(nombre, apellidos, edad, direccion, nombreUsuario, contraseña, tipo);
		this.salario = salario;
	}
	
	
	public Profesor() {
		super();
		this.salario = 0;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(Integer salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Profesor [salario=" + salario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", email=" + email + "]";
	}
	
	
	
	
	
	
	
}