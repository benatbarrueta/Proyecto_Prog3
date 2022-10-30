package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTarea {
	private Tarea tarea;
	protected Integer fecha_inicio =0;
	protected Integer fecha_fin=1;
	protected String calificacion="Sin Calificar";
	protected String nombre ="nombre";
	
	@Before
	public void setUp() throws Exception {
		tarea = new Tarea();
		tarea.setFecha_fin(fecha_fin);
		tarea.setCalificacion(calificacion);
		tarea.setFecha_inicio(fecha_inicio);
		tarea.setNombre(nombre);
	}

	@Test
	public void testTarea() {
	Tarea tarea2=new Tarea();
	assertNotNull(tarea2);
	assertEquals(tarea2.getCalificacion(), "");
	assertEquals(tarea2.getFecha_fin(), 0,0.0);
	assertEquals(tarea2.getFecha_inicio(), 0,0.0);
	assertEquals(tarea2.getNombre(), "");
	
	
	}

	@Test
	public void testGetFecha_inicio() {
		assertEquals(tarea.getFecha_inicio(), fecha_inicio,0.0);
	}

	@Test
	public void testSetFecha_inicio() {
		Integer newFecha_inicio= 25;
		assertEquals(tarea.getFecha_inicio(), fecha_inicio,0.0);
		tarea.setFecha_inicio(newFecha_inicio);
		assertEquals(tarea.getFecha_inicio(), newFecha_inicio,0.0);
	}

	@Test
	public void testGetFecha_fin() {
		assertEquals(tarea.getFecha_fin(), fecha_fin,0.0);
	}

	@Test
	public void testSetFecha_fin() {
		Integer newFecha_fin= 25;
		assertEquals(tarea.getFecha_fin(), fecha_fin,0.0);
		tarea.setFecha_inicio(newFecha_fin);
		assertEquals(tarea.getFecha_inicio(), newFecha_fin,0.0);
	}

	@Test
	public void testGetCalificacion() {
		assertEquals(tarea.getCalificacion(), calificacion);
	}

	@Test
	public void testSetCalificacion() {
		String newCalificacion="10";
		assertEquals(tarea.getCalificacion(), calificacion);
		tarea.setCalificacion(newCalificacion);
		assertEquals(tarea.getCalificacion(), newCalificacion);
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
	public void testToString() {
	String toString="Tarea: Nombre:" +nombre+ "Fecha inicio=" + fecha_inicio + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion;
	assertEquals(tarea.toString(),toString);
	
	}

}
