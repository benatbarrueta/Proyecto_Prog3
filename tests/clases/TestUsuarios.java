package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUsuarios {
	private Usuarios usuario;
	private String nombre ="nombre";
	private String apellidos ="apellido";
	private int edad =0;
	private String direccion="direccion";
	private String nombreUsuario="nombreUsuario";
	private String contraseña="contraseña";
	private int id=-1;
	@Before
	public void iniciar() throws Exception{
		 usuario = new Usuarios(nombre,apellidos,edad,direccion,nombreUsuario,contraseña);
	}
	
	
	

	
	
	@Test
	public void testUsuariosStringStringIntStringStringString()  {

		
		assertNotNull(usuario);
		
		assertEquals(nombre, usuario.getNombre());
		assertEquals(apellidos, usuario.getApellido());
		assertEquals(edad,usuario.getEdad());
		assertEquals(direccion,usuario.getDireccion());
		assertEquals(nombreUsuario, usuario.getNombreUsuario());
		assertEquals(contraseña,usuario.getContraseña());
	}
	@Test
	public void testUsuarios()  {
		
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
	public void testGetNombre()  {
		
		assertEquals(nombre, usuario.getNombre());
	}

	@Test
	public void testSetNombre()  {
		
		assertEquals(nombre,usuario.getNombre());
		String newNombre = "nombre2";
		
	
		usuario.setNombre(newNombre);
		assertEquals(newNombre, usuario.getNombre());
	}

	@Test
	public void testGetApellido()  {
		
		assertEquals(apellidos, usuario.getApellido());
	}

	@Test
	public void testSetApellido()  {
		
		assertEquals(apellidos,usuario.getApellido());
		String newApellidos = "apellido2";
		usuario.setApellido(newApellidos);
		assertEquals(newApellidos, usuario.getApellido());
	}

	@Test
	public void testGetEdad() {
		
		assertEquals(edad,usuario.getEdad());
	}

	@Test
	public void testSetEdad()  {
		
		assertEquals(edad,usuario.getEdad());
		int newEdad= 1;
		usuario.setEdad(newEdad);
		assertEquals(newEdad, usuario.getEdad());
		
	}

	@Test
	public void testGetDireccion() {
		
		assertEquals(direccion,usuario.getDireccion());
	}

	@Test
	public void testSetDireccion()  {
		
		assertEquals(direccion,usuario.getDireccion());
		String newDireccion = "direccion2";
		usuario.setDireccion(newDireccion);
		assertEquals(newDireccion, usuario.getDireccion());
	}


	@Test
	public void testGetNombreUsuario() {
		
		assertEquals(nombreUsuario, usuario.getNombreUsuario());
	}

	@Test
	public void testSetnombreUsuario()  {
		
		assertEquals(nombreUsuario,usuario.getNombreUsuario());
		String newNombreUsuario = "nombreUsuario2";
		usuario.setnombreUsuario(newNombreUsuario);
		assertEquals(newNombreUsuario, usuario.getNombreUsuario());
		
	}

	@Test
	public void testGetContraseña()  {
	
		assertEquals(contraseña,usuario.getContraseña());
	}

	@Test
	public void testSetContraseña() {
	
		assertEquals(contraseña,usuario.getContraseña());
		String newContraseña ="contraseña2";
		usuario.setContraseña(newContraseña);
		assertEquals(newContraseña, usuario.getContraseña());
		
	}

	@Test
	public void testToString()  {
		
		String toString = "Usuario Nombre=" + nombre + ",Apellidos:" + apellidos + ", Edad:" + edad + ", Direccion=" + direccion
				+ ", NombreUsuario:" + nombreUsuario + ", Contraseña:" + contraseña + ", Id:" + usuario.getId() + "]";
		assertEquals(usuario.toString(),toString );
	}

}
