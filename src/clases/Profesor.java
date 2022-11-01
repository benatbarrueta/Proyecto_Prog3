package clases;

public class Profesor extends Usuarios {
	protected double salario;
	protected String email;
	

	
	public Profesor(String nombre, String apellidos, int edad, String direccion, String nombreUsuario,
			String contraseña, double salario, String email) {
		super(nombre, apellidos, edad, direccion, nombreUsuario, contraseña);
		this.salario = salario;
		this.email = email;
	}

	public Profesor() {
		super();
		this.salario = 0;
		this.email = "";
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString() + ", email:" + email;
	}
	
	
	
	
}