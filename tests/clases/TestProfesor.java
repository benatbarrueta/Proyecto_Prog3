package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProfesor {
	private Profesor profesor;
	private int salario =0;
	protected String nombre = "";
	protected String apellidos= "";
	protected int edad = 0;
	protected String direccion = "";
	protected String nombreUsuario = "";
	protected String contraseña = "";
	
	@Before
	public void SetUp() {
		profesor=new Profesor();
		profesor.setSalario(salario);
	}
	

	@Test
	public void testProfesor() {
		Profesor newProfesor2 = new Profesor();
		assertEquals(newProfesor2.getSalario(), 0,0);
	}

	@Test
	public void testGetSalario() {
		assertEquals(profesor.getSalario(), salario,0);
	}

	@Test
	public void testSetSalario() {
		int newSalario =1;
		assertEquals(profesor.getSalario(), salario,0);
		profesor.setSalario(newSalario);
		assertEquals(profesor.getSalario(), newSalario,0);
	}
	
	@Test
	public void testToString() {
		String toString = "Profesor [salario=" + salario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", id=" + profesor.getId() + ", email=" + nombre + apellidos +"]";
	
		assertEquals(profesor.toString(), toString);
	}

}
