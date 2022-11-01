package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlumno {
	private Alumno alumno;
	private String curso ="Primero";
	
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
		String toString= "Alumno [curso=" + curso + ", nombre=" + "Nombre" + ", apellidos=" + "Apellidos" + ", edad=" + "0"
				+ ", direccion=" + "Direccion" + ", nombreUsuario=" + "Usuario" + ", contraseña=" + "Contraseña"
				+ ", email=" + "NombreApellidos@email.com"+ "]";

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
