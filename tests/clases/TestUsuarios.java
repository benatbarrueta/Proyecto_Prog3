package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUsuarios {
	private Usuarios usuario;
	private String nombre ="Nombre";
	private String apellidos ="Apellidos";
	private int edad =0;
	private String direccion ="Direccion";
	private String nombreUsuario ="Usuario";
	private String contraseña ="contraseña";
	private   int  id = -1;
	private Boolean tipo =true;
	private String email ="@email.com";

	@Before
	public void setUp() throws Exception {
		usuario = new Usuarios();
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setEdad(edad);
		usuario.setDireccion(direccion);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setContraseña(contraseña);
		usuario.setId(id);
		usuario.setTipo(tipo);
		usuario.setEmail(email);
		
	}
	
	@Test
	public void testUsuariosStringStringIntStringStringStringBoolean() {
		Usuarios newUsuario = new Usuarios();
		assertEquals(newUsuario.getNombre(), "");
		assertEquals(newUsuario.getApellidos(), "");
		assertEquals(newUsuario.getEdad(), 0);
		assertEquals(newUsuario.getDireccion(), "");
		assertEquals(newUsuario.getNombreUsuario(), "");
		assertEquals(newUsuario.getContraseña(), "");
		assertEquals(newUsuario.getTipo(), true);
		assertEquals(newUsuario.getEmail(), "");
	}

	@Test
	public void testUsuarios() {
		Usuarios newUsuario2 = new Usuarios();
		assertEquals(newUsuario2.getNombre(), "");
		assertEquals(newUsuario2.getApellidos(), "");
		assertEquals(newUsuario2.getEdad(), 0);
		assertEquals(newUsuario2.getDireccion(), "");
		assertEquals(newUsuario2.getNombreUsuario(), "");
		assertEquals(newUsuario2.getContraseña(), "");
		assertEquals(newUsuario2.getTipo(), true);
		assertEquals(newUsuario2.getEmail(), "");
	}

	@Test
	public void testGetNombre() {
		assertEquals(usuario.getNombre(), nombre);
	}

	@Test
	public void testSetNombre() {
		String newNombre = "newNombre";
		assertEquals(usuario.getNombre(), nombre);
		usuario.setNombre(newNombre);
		assertEquals(usuario.getNombre(), newNombre);
	}

	@Test
	public void testGetApellidos() {
		assertEquals(usuario.getApellidos(), apellidos);	
	}

	@Test
	public void testSetApellidos() {
		String newApellido = "newApellido";
		assertEquals(usuario.getApellidos(), apellidos);
		usuario.setApellidos(newApellido);
		assertEquals(usuario.getApellidos(), newApellido);
	}

	@Test
	public void testGetEdad() {
		assertEquals(usuario.getEdad(), edad);
	}

	@Test
	public void testSetEdad() {
		Integer newEdad = 2;
		assertEquals(usuario.getEdad(), edad);
		usuario.setEdad(newEdad);
		assertEquals(usuario.getEdad(), newEdad, 0);
	}

	@Test
	public void testGetDireccion() {
		assertEquals(usuario.getDireccion(), direccion);
	}

	@Test
	public void testSetDireccion() {
		String newDireccion = "newDireccion";
		assertEquals(usuario.getDireccion(), direccion);
		usuario.setDireccion(newDireccion);
		assertEquals(usuario.getDireccion(), newDireccion);
	}

	@Test
	public void testGetNombreUsuario() {
		assertEquals(usuario.getNombreUsuario(), nombreUsuario);
	}

	@Test
	public void testSetNombreUsuario() {
		String newNombreUsuario = "newNombreUsuario";
		assertEquals(usuario.getNombre(), nombre);
		usuario.setNombreUsuario(newNombreUsuario);
		assertEquals(usuario.getNombreUsuario(), newNombreUsuario);
	}

	@Test
	public void testGetContraseña() {
		assertEquals(usuario.getContraseña(), contraseña);
	}

	@Test
	public void testSetContraseña() {
		String newContraseña = "newContraseña";
		assertEquals(usuario.getContraseña(), contraseña);
		usuario.setContraseña(newContraseña);
		assertEquals(usuario.getContraseña(), newContraseña);
	}

	@Test
	public void testGetId() {
		assertEquals(usuario.getId(), id);
	}

	@Test
	public void testSetId() {
		Integer newId = 1;
		assertEquals(usuario.getId(), id);
		usuario.setId(newId);
		assertEquals(usuario.getId(), newId, 0);
	}

	@Test
	public void testGetTipo() {
		assertEquals(usuario.getTipo(), tipo);
	}

	@Test
	public void testSetTipo() {
		Boolean newTipo = true;
		assertEquals(usuario.getTipo(), tipo);
		usuario.setTipo(newTipo);
		assertEquals(usuario.getTipo(), newTipo);
	}

	@Test
	public void testGetEmail() {
		assertEquals(usuario.getEmail(), email);
	}

	@Test
	public void testSetEmail() {
		String newEmail = "newEmail";
		assertEquals(usuario.getEmail(), email);
		usuario.setEmail(newEmail);
		assertEquals(usuario.getEmail(), newEmail);
	}

	@Test
	public void testToString() {
		String toString = "Usuario: " + nombre + apellidos + ", " + edad + " años";
		assertEquals(usuario.toString(), toString);
	}

}
