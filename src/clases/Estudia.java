package clases;

public class Estudia {

	protected int id_alumno;
	protected int id_asignatura;

	public Estudia() {
		super();
		this.id_alumno = 0;
		this.id_asignatura = 0;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(int id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	@Override
	public String toString() {
		return "Estudia [id_alumno=" + id_alumno + ", id_asignatura=" + id_asignatura + "]";
	}
}
