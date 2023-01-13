package clases;

import java.awt.Point;

public class Tarea {
	protected Integer Id;
	protected String fecha_fin;
	protected int calificacion;
	protected String nombre;
	protected int id_asignatura;
	protected int id_alumna;
	

	public Tarea() {
		super();
		this.Id = 0;
		this.fecha_fin = "1";
		this.calificacion =0;
		this.nombre = "";
	
		this.id_asignatura =0;
		this.id_alumna = 0;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		this.Id = id;
	}



	public String getFecha_fin() {
		return fecha_fin;
	}



	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}



	public int getCalificacion() {
		return calificacion;
	}



	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getId_asignatura() {
		return id_asignatura;
	}



	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}



	public int getId_alumna() {
		return id_alumna;
	}



	public void setId_alumna(int id_alumna) {
		this.id_alumna = id_alumna;
	}



	@Override
	public String toString() {
		return "Tarea de " +id_alumna+ ": Nombre:" +nombre + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion ;
	}
}
