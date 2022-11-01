package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProfesor {
	private Profesor profesor;
	private int salario =0;
	
	protected String nombre = "nombre";
	protected String apellidos = "apellidos";
	protected int edad = 0;
	protected String direccion = "direccion";
	protected String nombreUsuario = "nombreUsuario";
	protected String contraseña = "contraseña";
	protected String email = "email";
	
	@Before
	public void SetUp() {
		profesor=new Profesor();
		profesor.setApellidos("Apellidos");
		profesor.setContraseña("Contraseña");
		profesor.setSalario(0);
		profesor.setDireccion("Direccion");
		profesor.setEdad(0);
		profesor.setNombre("Nombre");
		profesor.setNombreUsuario("Usuario");
	}
	@Test
	public void testToString() {
		String toString = "Profesor [salario=" + salario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", email=" + email + "]";
			assertEquals(profesor.toString(), toString);
	}

	@Test
	public void testProfesorStringStringIntStringStringStringBooleanDouble() {
		Profesor newProfesor = new Profesor();
		assertEquals(newProfesor.getNombre(), "");
		assertEquals(newProfesor.getApellidos(), "");
		assertEquals(newProfesor.getEdad(), 0,0);
		assertEquals(newProfesor.getDireccion(), "");
		assertEquals(newProfesor.getNombreUsuario(), "");
		assertEquals(newProfesor.getContraseña(), "");
		assertEquals(newProfesor.getSalario(), 0,0);
		
	}

	@Test
	public void testProfesor() {
		Profesor newProfesor2 = new Profesor();
		assertEquals(newProfesor2.getNombre(), "");
		assertEquals(newProfesor2.getApellidos(), "");
		assertEquals(newProfesor2.getEdad(), 0,0);
		assertEquals(newProfesor2.getDireccion(), "");
		assertEquals(newProfesor2.getNombreUsuario(), "");
		assertEquals(newProfesor2.getContraseña(), "");
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

}
