package clases;

public class Profesor extends Usuarios {
	protected int salario;

	public Profesor(String nombre, String apellidos, int edad, String direccion, String nombreUsuario,
			String contraseña, int salario) {
		super(nombre, apellidos, edad, direccion, nombreUsuario, contraseña);
		this.salario = salario;
	}
	
	
	public Profesor() {
		super();
		this.salario = 0;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Profesor: " + nombre + apellidos + ", " + edad + " años";
	}
	
	
	
	
	
	
	
}