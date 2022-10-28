package clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsuarios {
	private Usuarios usuario;
	private String nombre ="";
	private String apellidos ="";
	private int edad =0;
	private String direccion="";
	private String nombreUsuario="";
	private String contraseña="";
	
	public void iniciar() throws Exception{
		Usuarios unuario = new Usuarios(nombre,apellidos,edad,direccion,nombreUsuario,contraseña);
	}
	
	
	
	
	@Test
	public void testUsuariosStringStringIntStringBooleanString() throws Exception {
		iniciar();
		
		fail("Not yet implemented");
	}

	@Test
	public void testUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNombre() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetApellido() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetApellido() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEdad() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDireccion() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDireccion() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsAlumno() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAlumno() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNombreUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetnombreUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContraseña() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetContraseña() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
