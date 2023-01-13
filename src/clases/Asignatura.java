package clases;

import java.util.ArrayList;

public class Asignatura {
	// protected final String apuntes;
	
	protected int id;
	protected String nombre;
	protected int id_profesor;

	
	
	public Asignatura() {
		super();
		this.id = 0;
		this.nombre = "";
		this.id_profesor = 0;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getId_profesor() {
		return id_profesor;
	}



	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}



	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", id_profesor=" + id_profesor + "]";
	}



	
	
	
	
}
