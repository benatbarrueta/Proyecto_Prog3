package clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAlumno {
	protected String email ="email";
	protected String curso="1";
	protected Alumno alumno = new Alumno("Nombre","Apellidos",0,"direccion","nombreUsuario","contraseña",email,curso);

	@Test
	public void testToString() {
		String toString="Usuarios [nombre=" + "Nombre, "+"apellidos=" + "Apellidos"+ ", edad=" + 0 + ", direccion=" + "direccion"
				+ ", nombreUsuario=" + "nombreUsuario" + ", contraseña=" + "contraseña" + "]" + ", email" + email;
	
		assertEquals(alumno.toString(),toString);
	}

	@Test
	public void testAlumnoStringStringIntStringStringStringStringString() {
		assertNotNull(alumno);
		assertEquals(alumno.getNombre(),"Nombre");
		assertEquals(alumno.getApellido(),"Apellidos");
		assertEquals(alumno.getEdad(),0);
		assertEquals(alumno.getDireccion(),"direccion");
		assertEquals(alumno.getNombreUsuario(),"nombreUsuario");
		assertEquals(alumno.getContraseña(),"contraseña");
		assertEquals(alumno.getEmail(),email);
		assertEquals(alumno.getCurso(),curso);
	}
	

	@Test
	public void testAlumno() {
		Alumno alumno2 = new Alumno();
		assertNotNull(alumno2);
		assertEquals(alumno2.getNombre(),"");
		assertEquals(alumno2.getApellido(),"");
		assertEquals(alumno2.getEdad(),0);
		assertEquals(alumno2.getDireccion(),"");
		assertEquals(alumno2.getNombreUsuario(),"");
		assertEquals(alumno2.getContraseña(),"");
		assertEquals(alumno2.getEmail(),"");
		assertEquals(alumno2.getCurso(),"");
		
	}

	@Test
	public void testGetEmail() {
		assertEquals(alumno.getEmail(),email);
	}

	@Test
	public void testSetEmail() {
		String newEmail = "email2";
		assertEquals(alumno.getEmail(),email);
		alumno.setEmail(newEmail);
		assertEquals(alumno.getEmail(),newEmail);
		
	}

	@Test
	public void testGetCurso() {
		assertEquals(alumno.getCurso(),curso);
	}

	@Test
	public void testSetCurso() {
		String newCurso = "2";
		assertEquals(alumno.getCurso(),curso);
		alumno.setCurso(newCurso);
		assertEquals(alumno.getCurso(),newCurso);
	}

}
