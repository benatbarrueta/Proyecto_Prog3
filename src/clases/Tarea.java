package clases;

import java.awt.Point;

public class Tarea {

	protected String fecha_fin;
	protected Double calificacion;
	protected String nombre;
	protected String emailAlumno;
	protected int id = -1;
	
	public Tarea() {
		super();
		this.fecha_fin = "1";
		this.calificacion = 0.0;
		this.nombre = "";
		this.emailAlumno = "";
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
	
	public String getEmailAlumno() {
		return emailAlumno;
	}

	public void setEmailAlumno(String emailAlumno) {
		this.emailAlumno = emailAlumno;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Tarea de " + emailAlumno + ": Nombre:" +nombre + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion ;
	}
}
