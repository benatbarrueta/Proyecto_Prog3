package clases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestAsignatura {
	protected Asignatura asignatura = new Asignatura();
	protected String nombre = "";
	private Profesor profesor = new Profesor();
	protected ArrayList<Alumno> alumnos =new ArrayList<Alumno>();
	protected ArrayList<Tarea> tareas= new ArrayList<Tarea>();
	protected double calificacion =0;
	@Test
	public void testAsignaturaStringProfesorArrayListOfAlumnoArrayListOfTareaDouble() {
		assertNotNull(asignatura);
		assertEquals(asignatura.getNombre(), nombre);
		equals( asignatura.getProfesor().equals(profesor));
		assertEquals(asignatura.getAlumnos(), alumnos);
		assertEquals(asignatura.getTareas(), tareas);
		assertEquals(asignatura.getCalificacion(), 0,0);
	}

	@Test
	public void testAsignatura() {
		Asignatura asignatura2 = new Asignatura();
		assertNotNull(asignatura2);
		assertEquals(asignatura2.getNombre(), "");
		equals( asignatura2.getProfesor().equals(profesor));
		assertEquals(asignatura2.getAlumnos(), alumnos);
		assertEquals(asignatura2.getTareas(), new ArrayList<Tarea>());
		assertEquals(asignatura2.getCalificacion(), 0,0.0);
	
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
	public void testGetProfesor() {

	
		equals( asignatura.getProfesor().equals(profesor));
	}

	@Test
	public void testSetProfesor() {
		Profesor newProfesor = new Profesor();
		newProfesor.setNombre("b");
	
		equals( asignatura.getProfesor().equals(profesor));
	//	assertEquals(profesor, asignatura.getProfesor());
		asignatura.setProfesor(newProfesor);
		equals( asignatura.getProfesor().equals(newProfesor));
	}

	@Test
	public void testGetAlumnos() {
		assertEquals(asignatura.getAlumnos(), alumnos);
	}

	@Test
	public void testSetAlumnos() {
		ArrayList<Alumno> newAlumnos = new ArrayList<Alumno>();
		assertEquals(asignatura.getAlumnos(), alumnos);
		asignatura.setAlumnos(newAlumnos);
		assertEquals(asignatura.getAlumnos(), newAlumnos);
	}

	@Test
	public void testGetTareas() {
		assertEquals(asignatura.getTareas(), tareas);
	}

	@Test
	public void testSetTareas() {
		ArrayList<Tarea> newTarea = new ArrayList<Tarea>();
		assertEquals(asignatura.getTareas(), tareas);
		asignatura.setTareas(newTarea);
		assertEquals(asignatura.getTareas(), newTarea);
	}

	@Test
	public void testGetCalificacion() {
		assertEquals(asignatura.getCalificacion(), 0,0);
	}

	@Test
	public void testSetCalificacion() {
		Double newCalificacion = 8.0;
		assertEquals(asignatura.getCalificacion(), 0,0);
		asignatura.setCalificacion(newCalificacion);
		assertEquals(asignatura.getCalificacion(), 8,0);
	}

	@Test
	public void testToString() {
		String toString ="Nombre: " + nombre + ", profesor=" + profesor + ", alumnos=" + alumnos + ", tareas=" + tareas
				+ ", calificacion=" + calificacion + "]";
		
		assertEquals(asignatura.toString(), toString);
	}

}
