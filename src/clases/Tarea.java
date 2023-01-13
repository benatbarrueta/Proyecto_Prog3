package clases;

import java.awt.Point;

public class Tarea {
	protected String id;
	protected String fecha_fin;
	protected Double calificacion;
	protected String nombre;
	protected String emailAlumno;
	protected String id_asignatura;
	protected String id_alumna;
	

	public Tarea() {
		super();
		this.id = "1";
		this.fecha_fin = "1";
		this.calificacion = 0.0;
		this.nombre = "";
		this.emailAlumno = "";
		this.id_asignatura =" 0";
		this.id_alumna = "0";
	}

	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailAlumno() {
		return emailAlumno;
	}

	public void setEmailAlumno(String emailAlumno) {
		this.emailAlumno = emailAlumno;
	}
	
	

	public String getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(String id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public String getId_alumna() {
		return id_alumna;
	}

	public void setId_alumna(String id_alumna) {
		this.id_alumna = id_alumna;
	}

	@Override
	public String toString() {
		return "Tarea de " + emailAlumno + ": Nombre:" +nombre + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion ;
	}
}
