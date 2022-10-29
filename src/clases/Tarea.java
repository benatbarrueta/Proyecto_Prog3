package clases;

public class Tarea {
	
	protected Integer fecha_inicio;
	protected Integer fecha_fin;
	protected String calificacion;
	protected String nombre;
	public Tarea(Integer fecha_inicio, Integer fecha_fin, String calificacion, String nombre) {
		super();
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.calificacion = calificacion;
		this.nombre = nombre;
	}
	public Integer getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Integer fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Integer getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Integer fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
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
		return "Tarea: Nombre:" +nombre+ "Fecha inicio=" + fecha_inicio + ", Fecha fin:" + fecha_fin + ", Calificacion:" + calificacion ;
	}

}
