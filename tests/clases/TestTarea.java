package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTarea {
	private Tarea tarea;

	protected String fecha_fin = "1";
	protected double calificacion = 0;
	protected String nombre = "nombre";
	protected String emailAlumno = "emailAlumno";
	protected int id = -1;
	
	@Before
	public void setUp() throws Exception {
		tarea = new Tarea();
		tarea.setFecha_fin(fecha_fin);
		tarea.setCalificacion(calificacion);
		tarea.setNombre(nombre);
		tarea.setEmailAlumno(emailAlumno);
		tarea.setId(id);
	}

	@Test
	public void testTarea() {
	Tarea tarea2=new Tarea();
	assertNotNull(tarea2);
	assertEquals(tarea2.getCalificacion(), 0,0.0);
	assertEquals(tarea2.getFecha_fin(), "1");
	assertEquals(tarea2.getNombre(), "");
	assertEquals(tarea2.getEmailAlumno(), "");
	}

	@Test
	public void testGetFecha_fin() {
		assertEquals(tarea.getFecha_fin(), fecha_fin);
	}

	@Test
	public void testSetFecha_fin() {
		String newFecha_fin= "25";
		assertEquals(tarea.getFecha_fin(), fecha_fin);
		tarea.setFecha_fin(newFecha_fin);
		assertEquals(tarea.getFecha_fin(), newFecha_fin);
	}

	@Test
	public void testGetCalificacion() {
		assertEquals(tarea.getCalificacion(), calificacion,0.0);
	}

	@Test
	public void testSetCalificacion() {
		double newCalificacion=10;
		assertEquals(tarea.getCalificacion(), calificacion,0.0);
		tarea.setCalificacion(newCalificacion);
		assertEquals(tarea.getCalificacion(), newCalificacion,0.0);
	}

	@Test
	public void testGetNombre() {
		assertEquals(tarea.getNombre(), nombre);
	}

	@Test
	public void testSetNombre() {
		String newNombre= "nombre2";
		assertEquals(tarea.getNombre(), nombre);
		tarea.setNombre(newNombre);
		assertEquals(tarea.getNombre(), newNombre);
	}
	
	@Test
	public void testGetId() {
		assertEquals(tarea.getId(), -1);
	}
	
	@Test
	public void testSetId() {
		int newId = 0;
		assertEquals(tarea.getId(), id);
		tarea.setId(newId);
		assertEquals(tarea.getId(), newId);
	}

	@Test
	public void testToString() {
	String toString="Tarea de " + tarea.getEmailAlumno()+ ": Nombre:" +nombre + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion;
	assertEquals(tarea.toString(),toString);
	
	}

}
