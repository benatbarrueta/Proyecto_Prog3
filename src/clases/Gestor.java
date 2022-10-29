package clases;
import java.util.ArrayList;

public class Gestor {
	protected ArrayList<Alumno> alumnos;
	protected ArrayList<Profesor> profesor;
	protected ArrayList<Asignatura> asignatura;
	protected ArrayList<Tarea> tarea;
	
	
	
	public Gestor(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesor, ArrayList<Asignatura> asignatura,
			ArrayList<Tarea> tarea) {
		super();
		this.alumnos = alumnos;
		this.profesor = profesor;
		this.asignatura = asignatura;
		this.tarea = tarea;
	}
	public Gestor() {
		super();
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = new ArrayList<Profesor>();
		this.asignatura = new ArrayList<Asignatura>();
		this.tarea = new ArrayList<Tarea>();
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public ArrayList<Profesor> getProfesor() {
		return profesor;
	}
	public void setProfesor(ArrayList<Profesor> profesor) {
		this.profesor = profesor;
	}
	public ArrayList<Asignatura> getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(ArrayList<Asignatura> asignatura) {
		this.asignatura = asignatura;
	}
	public ArrayList<Tarea> getTarea() {
		return tarea;
	}
	public void setTarea(ArrayList<Tarea> tarea) {
		this.tarea = tarea;
	}
	public void leerUsuarios(String fichero){
			
		
	}
	
}
