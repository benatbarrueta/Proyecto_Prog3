package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProfesor {
	private Profesor profesor;
	private Integer salario =0;
	
	@Before
	public void SetUp() {
		
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
		Integer newSalario =1;
		assertEquals(profesor.getSalario(), salario,0);
		profesor.setSalario(newSalario);
		assertEquals(profesor.getSalario(), newSalario,0);
	}

}
