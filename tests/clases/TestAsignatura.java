package clases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestAsignatura {
	protected Asignatura asignatura; 
	protected String nombre = "";
	protected int id_profesor =0;
	protected int id = 0;
	
	@Before
	public void SetUp() {
		asignatura = new Asignatura();
		asignatura.setId(id);
		asignatura.setId_profesor(id_profesor);
		asignatura.setNombre(nombre);
	}

	@Test
	public void testAsignatura() {
		Asignatura asignatura2 = new Asignatura();
		assertNotNull(asignatura2);
		assertEquals(asignatura2.getId_profesor(), 0);
		assertEquals(asignatura2.getId(), 0);
		assertEquals(asignatura2.getNombre(), "");
	}

	
	@Test
	public void testGetNombre() {
		assertEquals(asignatura.getNombre(), nombre);
	}

	@Test
	public void testSetNombre() {
		String newNombre = "nombre2";
		assertEquals(asignatura.getNombre(), nombre);
		asignatura.setNombre(newNombre);
		assertEquals(asignatura.getNombre(), newNombre);
	}

	@Test
	public void testGetId() {
		assertEquals(asignatura.getId(), 0);
	}
	
	@Test
	public void testSetId() {
		int newId = 0;
		assertEquals(asignatura.getId(), id);
		asignatura.setId(newId);
		assertEquals(asignatura.getId(), newId);
	}
	
	@Test
	public void testGetId_profesor() {
		assertEquals(asignatura.getId_profesor(), 0);
	}
	
	@Test
	public void testSetId_profesor() {
		int newId_Profesor = 0;
		assertEquals(asignatura.getId_profesor(), id_profesor);
		asignatura.setId(newId_Profesor);
		assertEquals(asignatura.getId(), newId_Profesor);
	}
	
	@Test
	public void testToString() {
		String toString = "Asignatura [id=" + id + ", nombre=" + nombre + ", id_profesor=" + id_profesor + "]";;
		
		assertEquals(asignatura.toString(), toString);
	}

}
