package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProfesor {
	private Profesor profesor;
	private int salario =0;
	
	protected String nombre = "Nombre";
	protected String apellidos = "Apellidos";
	protected int edad = 0;
	protected String direccion = "Direccion";
	protected String nombreUsuario = "Usuario";
	protected String contraseña = "Contraseña";
	protected String email = nombre+apellidos+"@email.com";
	
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
				+ ", id=" + profesor.getId() + ", email=" + email + "]";
	
		assertEquals(profesor.toString(), toString);
	}

	@Test
	public void testProfesorStringStringIntStringStringStringBooleanDouble() {
		Profesor newProfesor = new Profesor(nombre,apellidos,edad,direccion,nombreUsuario,contraseña,salario);
		assertEquals(newProfesor.getNombre(), nombre);
		assertEquals(newProfesor.getApellidos(), apellidos);
		assertEquals(newProfesor.getEdad(), edad,0);
		assertEquals(newProfesor.getDireccion(), direccion);
		assertEquals(newProfesor.getNombreUsuario(), nombreUsuario);
		assertEquals(newProfesor.getContraseña(), contraseña);
		assertEquals(newProfesor.getSalario(),salario ,0);
		
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
