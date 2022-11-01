package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlumno {
	private Alumno alumno;
	private String curso ="Primero";
	protected String nombre = "Nombre";
	protected String apellidos= "Apellidos";
	protected int edad = 0;
	protected String direccion = "Direccion";
	protected String nombreUsuario = "Usuario";
	protected String contraseña = "Contraseña";
	protected Boolean tipo = true;
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
		String toString= "Alumno [curso=" + curso + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña
				+ ", id=" + -1 + ", email=" +nombre+apellidos+"@email.com" + "]";;
	
		assertEquals(alumno.toString(), toString);
	}

	@Test
	public void testAlumnoStringStringIntStringStringStringBooleanString() {
		Alumno newAlumno = new Alumno(nombre, apellidos, edad, direccion, nombreUsuario, contraseña, curso);
		assertNotNull(newAlumno);
		assertEquals(newAlumno.getNombre(),nombre);
		assertEquals(newAlumno.getApellidos(), apellidos);
		assertEquals(newAlumno.getEdad(), edad,0);
		assertEquals(newAlumno.getDireccion(), direccion);
		assertEquals(newAlumno.getNombreUsuario(), nombreUsuario);
		assertEquals(newAlumno.getContraseña(), contraseña);
		assertEquals(newAlumno.getCurso(), curso);
		
	}

	@Test
	public void testAlumno() {
		Alumno newAlumno2 = new Alumno();
		assertNotNull(newAlumno2);
		assertEquals(newAlumno2.getNombre(), "");
		assertEquals(newAlumno2.getApellidos(), "");
		assertEquals(newAlumno2.getEdad(), 0,0);
		assertEquals(newAlumno2.getDireccion(), "");
		assertEquals(newAlumno2.getNombreUsuario(), "");
		assertEquals(newAlumno2.getContraseña(), "");
		assertEquals(newAlumno2.getCurso(), "Primero");
		
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
