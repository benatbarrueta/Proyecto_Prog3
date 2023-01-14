package clases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTarea {
	private Tarea tarea;
	protected String fecha_fin = "1";
	protected int calificacion = 0;
	protected String nombre = "nombre";
	protected int id_alumna = 0;
	protected int id_asignatura = 0;
	protected int id = 0;
	protected int porcentaje = 0;
	
	@Before
	public void setUp() throws Exception {
		tarea = new Tarea();
		tarea.setFecha_fin(fecha_fin);
		tarea.setCalificacion(calificacion);
		tarea.setNombre(nombre);
		tarea.setId(id);
		tarea.setId_alumna(id_alumna);
		tarea.setId_asignatura(id_asignatura);
		tarea.setPorcentaje(porcentaje);
	}

	@Test
	public void testTarea() {
	Tarea tarea2=new Tarea();
	assertNotNull(tarea2);
	assertEquals(tarea2.getCalificacion(), 0,0.0);
	assertEquals(tarea2.getFecha_fin(), "1");
	assertEquals(tarea2.getNombre(), "");
	assertEquals(tarea2.getId(), 0);
	assertEquals(tarea2.getId_alumna(), 0);
	assertEquals(tarea2.getId_asignatura(), 0);
	assertEquals(tarea2.getPorcentaje(), 0);
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
		int newCalificacion=10;
		assertEquals(tarea.getCalificacion(), calificacion,0);
		tarea.setCalificacion(newCalificacion);
		assertEquals(tarea.getCalificacion(), newCalificacion,0);
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
		assertEquals(tarea.getId(), 0);
	}
	
	@Test
	public void testSetId() {
		int newId = 0;
		assertEquals(tarea.getId(), id);
		tarea.setId(newId);
		assertEquals(tarea.getId(), newId);
	}
	
	@Test
	public void getId_asignatura() {
		assertEquals(tarea.getId_asignatura(), 0);
	}


	@Test
	public void setId_asignatura() {
		int newId_asignatura = 0;
		assertEquals(tarea.getId(), id);
		tarea.setId(newId_asignatura);
		assertEquals(tarea.getId_asignatura(), newId_asignatura);
	}


	@Test
	public void getId_alumna() {
		assertEquals(tarea.getId_alumna(), 0);
	}


	@Test
	public void setId_alumna() {
		int newId_alumna = 0;
		assertEquals(tarea.getId(), id);
		tarea.setId(newId_alumna);
		assertEquals(tarea.getId_alumna(), newId_alumna);
	}

	
	@Test
	public void getPorcentaje() {
		assertEquals(tarea.getId(), 0);
	}


	@Test
	public void setPorcentaje() {
		int newPorcentaje = 0;
		assertEquals(tarea.getId(), id);
		tarea.setId(newPorcentaje);
		assertEquals(tarea.getPorcentaje(), newPorcentaje);
	}

	@Test
	public void testToString() {
	String toString="Tarea de " +id_alumna+ ": Nombre:" +nombre + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion ;
	assertEquals(tarea.toString(),toString);
	
	}

}
