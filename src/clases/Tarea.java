package clases;

public class Tarea {

	protected String fecha_fin;
	protected Double calificacion;
	protected String nombre;
	
	public Tarea() {
		super();
		this.fecha_fin = "1";
		this.calificacion = 0.0;
		this.nombre = "";
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
	
	@Override
	public String toString() {
		return "Tarea: Nombre:" +nombre + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion ;
	}
}
