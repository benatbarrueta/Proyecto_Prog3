package clases;

public class Profesor extends Usuarios {
	protected int salario;

	
	
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
		return "Profesor [salario=" + salario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", id=" + id + ", email=" + email + "]";
	}



	


	
	
	
	
	
	
}