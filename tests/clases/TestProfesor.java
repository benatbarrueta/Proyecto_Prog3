package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProfesor {
	private Profesor profesor;
	private int salario =0;
	
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
		String toString="";
			assertEquals(profesor.toString(), toString);
	}

	@Test
	public void testProfesorStringStringIntStringStringStringBooleanDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testProfesor() {
		fail("Not yet implemented");
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
