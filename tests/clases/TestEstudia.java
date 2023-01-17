package clases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEstudia {
	private Estudia estudia;
	private int id_alumno = 0;
	private int id_asignatura = 0;
	
	@Before
	public void setUp() throws Exception {
		estudia = new Estudia();
		estudia.setId_alumno(id_alumno);
		estudia.setId_asignatura(id_asignatura);
	}

	@Test
	public void testEstudia() {
		Estudia estudia2 = new Estudia();
		assertNotNull(estudia2);
		assertEquals(estudia2.getId_alumno(), 0);
		assertEquals(estudia2.getId_asignatura(), 0);
	}
	
	@Test
	public void testGetId_alumno() {
		assertEquals(estudia.getId_alumno(), id_alumno);
	}
	
	@Test
	public void testSetId_alumno() {
		int newId_alumno = 1;
		assertEquals(estudia.getId_alumno(), id_alumno);
		estudia.setId_alumno(newId_alumno);
		assertEquals(estudia.getId_alumno(), newId_alumno);
	}
	
	@Test
	public void testGetId_asignatura() {
		assertEquals(estudia.getId_asignatura(), id_asignatura);
	}
	
	@Test
	public void testSetId_asignatura() {
		int newId_asignatura = 1;
		assertEquals(estudia.getId_asignatura(), id_asignatura);
		estudia.setId_asignatura(newId_asignatura);
		assertEquals(estudia.getId_asignatura(), newId_asignatura);
	}
	
	@Test
	public void testToString() {
		String toString = "Estudia [id_alumno=" + id_alumno + ", id_asignatura=" + id_asignatura + "]";
		
		assertEquals(estudia.toString(), toString);
	}

}
