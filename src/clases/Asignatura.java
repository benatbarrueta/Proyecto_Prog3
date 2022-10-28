package clases;

import java.util.ArrayList;

public class Asignatura {
	// protected final String apuntes;
	
	protected String nombre;
	protected Profesor profesor;
	protected ArrayList<Alumno> alumnos;
	protected ArrayList<Tarea> tareas;
	protected double calificacion;
	
	public Asignatura(String nombre, Profesor profesor, ArrayList<Alumno> alumnos, ArrayList<Tarea> tareas,
			double calificacion) {
		super();
		this.nombre = nombre;
		this.profesor = profesor;
		this.alumnos = alumnos;
		this.tareas = tareas;
		this.calificacion = calificacion;
	}
	
	public Asignatura() {
		super();
		this.nombre = "";
		this.profesor = new Profesor();
		this.alumnos = new ArrayList<Alumno>();
		this.tareas = new ArrayList<Tarea>();
		this.calificacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", profesor=" + profesor + ", alumnos=" + alumnos + ", tareas=" + tareas
				+ ", calificacion=" + calificacion + "]";
	}
	
	
	
}
