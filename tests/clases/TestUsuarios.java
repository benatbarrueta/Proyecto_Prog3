package clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsuarios {
	private Usuarios usuario;
	private String nombre ="nombre";
	private String apellidos ="apellido";
	private int edad =0;
	private String direccion="direccion";
	private String nombreUsuario="nombreUsuario";
	private String contraseña="contraseña";
	
	public void iniciar() throws Exception{
		 usuario = new Usuarios(nombre,apellidos,edad,direccion,nombreUsuario,contraseña);
	}
	
	
	

	
	
	@Test
	public void testUsuariosStringStringIntStringStringString() throws Exception {
	iniciar();
		
		assertNotNull(usuario);
		
		assertEquals(nombre, usuario.getNombre());
		assertEquals(apellidos, usuario.getApellido());
		assertEquals(edad,usuario.getEdad());
		assertEquals(direccion,usuario.getDireccion());
		assertEquals(nombreUsuario, usuario.getNombreUsuario());
		assertEquals(contraseña,usuario.getContraseña());
	}
	@Test
	public void testUsuarios() throws Exception {
		
		Usuarios usuario2 = new Usuarios();
		
		assertNotNull(usuario2);
		
		assertEquals("", usuario2.getNombre());
		assertEquals("", usuario2.getApellido());
		assertEquals(0,usuario2.getEdad());
		assertEquals("",usuario2.getDireccion());
		assertEquals("", usuario2.getNombreUsuario());
		assertEquals("",usuario2.getContraseña());
	}

	@Test
	public void testGetNombre() throws Exception {
		iniciar();
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	public void testSetNombre() throws Exception {
		iniciar();
		String newNombre = "nombre2";
		
	
		usuario.setNombre(newNombre);
		assertEquals(newNombre, usuario.getNombre());
	}

	@Test
	public void testGetApellido() throws Exception {
		iniciar();
		assertEquals(apellidos, usuario.getApellido());
	}

	@Test
	public void testSetApellido() throws Exception {
		iniciar();
		String newApellidos = "apellido2";
		usuario.setApellido(newApellidos);
		assertEquals(newApellidos, usuario.getApellido());
	}

	@Test
	public void testGetEdad() throws Exception {
		iniciar();
		assertEquals(edad,usuario.getEdad());
	}

	@Test
	public void testSetEdad() throws Exception {
		iniciar();
		int newEdad= 1;
		usuario.setEdad(newEdad);
		assertEquals(newEdad, usuario.getEdad());
		
	}

	@Test
	public void testGetDireccion() throws Exception {
		iniciar();
		assertEquals(direccion,usuario.getDireccion());
	}

	@Test
	public void testSetDireccion() throws Exception {
		iniciar();
		String newDireccion = "direccion2";
		usuario.setDireccion(newDireccion);
		assertEquals(newDireccion, usuario.getDireccion());
	}


	@Test
	public void testGetNombreUsuario() throws Exception {
		iniciar();
		assertEquals(nombreUsuario, usuario.getNombreUsuario());
	}

	@Test
	public void testSetnombreUsuario() throws Exception {
		iniciar();
		String newNombreUsuario = "nombreUsuario2";
		usuario.setnombreUsuario(newNombreUsuario);
		assertEquals(newNombreUsuario, usuario.getNombreUsuario());
		
	}

	@Test
	public void testGetContraseña() throws Exception {
		iniciar();
		assertEquals(contraseña,usuario.getContraseña());
	}

	@Test
	public void testSetContraseña() throws Exception {
		iniciar();
		String newContraseña ="contraseña2";
		usuario.setContraseña(newContraseña);
		assertEquals(newContraseña, usuario.getContraseña());
		
	}

	@Test
	public void testToString() throws Exception {
		iniciar();
		String toString = "Usuario " + nombre + apellidos + ", " + edad + "años.";
		assertEquals(usuario.toString(),toString );
	}

}
