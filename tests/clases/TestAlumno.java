package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlumno {
	private Alumno alumno;
	private int curso = 1;
	protected String nombre = "";
	protected String apellidos= "";
	protected int edad = 0;
	protected String direccion = "";
	protected String nombreUsuario = "";
	protected String contraseña = "";
	@Before
	public void SetUp() {
		alumno = new Alumno();
		alumno.setCurso(curso);
		
	}

	@Test
	public void testToString() {
		String toString= "Alumno [curso=" + curso + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", id=" + 0 + ", email=" + nombre + apellidos + "]";
	
		assertEquals(alumno.toString(), toString);
	}

	@Test
	public void testAlumnoInt() {
		Alumno newAlumno = new Alumno(curso);
		assertNotNull(newAlumno);
		assertEquals(newAlumno.getCurso(), curso);
		
	}
	@Test
	public void testAlumno() {
		Alumno newAlumno2 = new Alumno();
		assertNotNull(newAlumno2);
		assertEquals(newAlumno2.getCurso(), 1);
		
	}

	@Test
	public void testGetCurso() {
		assertEquals(alumno.getCurso(), curso);
	}

	@Test
	public void testSetCurso() {
		int newCurso = 2;
		assertEquals(alumno.getCurso(), curso);
		alumno.setCurso(newCurso);
		assertEquals(alumno.getCurso(), newCurso);
	}
}
