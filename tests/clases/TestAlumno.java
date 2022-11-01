package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlumno {
	private Alumno alumno;
	private String curso ="Primero";
	protected String nombre = "nombre";
	protected String apellidos= "apellido";
	protected int edad = 0;
	
	@Before
	public void SetUp() {
		alumno = new Alumno();
		alumno.setApellidos("Apellidos");
		alumno.setContraseña("Contraseña");
		alumno.setCurso(curso);
		alumno.setDireccion("Direccion");
		alumno.setEdad(0);
		alumno.setNombre("Nombre");
		alumno.setNombreUsuario("Usuario");
		
	}

	@Test
	public void testToString() {
		String toString= "Alumno: " + nombre + apellidos + ", " + edad + " años";

		assertEquals(alumno.toString(), toString);
	}

	@Test
	public void testAlumnoStringStringIntStringStringStringBooleanString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlumno() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurso() {
		assertEquals(alumno.getCurso(), curso);
	}

	@Test
	public void testSetCurso() {
		String newCurso ="Segundo";
		assertEquals(alumno.getCurso(), curso);
		alumno.setCurso(newCurso);
		assertEquals(alumno.getCurso(), newCurso);
	}

}
