package clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProfesor {
	protected double salario = 0;
	protected String email = "email";
	private Profesor profesor= new Profesor("Nombre","Apellidos",0,"direccion","nombreUsuario","contraseña",salario,email);
	
	
	@Test
	public void testToString() {
		String toString="Usuarios [nombre=" +"Nombre" + ", apellidos=" +"Apellidos" + ", edad=" + 0 + ", direccion=" + "direccion"
				+ ", nombreUsuario=" + "nombreUsuario"+ ", contraseña=" +"contraseña"+ "]"+ ", email:" + email + "";
		System.out.println(toString);
		System.out.println(profesor.toString());
		assertEquals(profesor.toString(), toString);
	}

	@Test
	public void testProfesorStringStringIntStringStringStringDoubleString() {
	assertNotNull(profesor);
	
	assertEquals(profesor.getNombre(), "Nombre");
	assertEquals(profesor.getApellido(), "Apellidos");
	assertEquals(profesor.getEdad(), 0);
	assertEquals(profesor.getDireccion(), "direccion");
	assertEquals(profesor.getNombreUsuario(), "nombreUsuario");
	assertEquals(profesor.getContraseña(), "contraseña");
	assertEquals(profesor.getSalario(),0,0.0);
	assertEquals(profesor.getEmail(), email);
	}

	@Test
	public void testProfesor() {
	 Profesor profesor2 = new Profesor();
		assertEquals(profesor2.getNombre(), "");
		assertEquals(profesor2.getApellido(), "");
		assertEquals(profesor2.getEdad(), 0);
		assertEquals(profesor2.getDireccion(), "");
		assertEquals(profesor2.getNombreUsuario(), "");
		assertEquals(profesor2.getContraseña(), "");
		assertEquals(profesor2.getSalario(), 0,0.0);
		assertEquals(profesor2.getEmail(), "");
		
	}

	@Test
	public void testGetSalario() {
		assertEquals(profesor.getSalario(), salario,0.0);
	}

	@Test
	public void testSetSalario() {
		Double newSalario = 1.0;
		assertEquals(profesor.getSalario(), salario,0.0);
		profesor.setSalario(newSalario);
		assertEquals(profesor.getSalario(), newSalario,0.0);
		
	}

	@Test
	public void testGetEmail() {
		assertEquals(profesor.getEmail(), email);
	}

	@Test
	public void testSetEmail() {
		String newEmail = "email2";	
		assertEquals(profesor.getEmail(), email);
		profesor.setEmail(newEmail);
		assertEquals(profesor.getEmail(), newEmail);
		
	}

}
