package clases;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Properties;


public class Gestor {
	protected ArrayList<Alumno> alumnos;
	protected ArrayList<Profesor> profesor;
	protected ArrayList<Asignatura> asignatura;
	protected ArrayList<Tarea> tareas;
	protected Properties properties;
	private static final String PROPERTIES_FILE = "src/config/Properties";
	private static final String INPUT_KEY_TAREA = "leerTarea";
	private static final String OUTPUT_KEY_TAREA = "guardarTarea";
	
	
	public Gestor(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesor, ArrayList<Asignatura> asignatura,
			ArrayList<Tarea> tareas) {
		super();
		this.alumnos = alumnos;
		this.profesor = profesor;
		this.asignatura = asignatura;
		this.tareas = tareas;
	}
	public Gestor() {
		super();
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = new ArrayList<Profesor>();
		this.asignatura = new ArrayList<Asignatura>();
		this.tareas = new ArrayList<Tarea>();
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
		return tareas;
	}
	public void setTarea(ArrayList<Tarea> tarea) {
		this.tareas = tarea;
	}
	public void leerUsuarios(String fichero){
			
		
	}
	
	private  static Properties loadProperties() {
		Properties properties = new Properties();

		try {
			// Se carga el fichero Properties
			properties.load(new FileReader(PROPERTIES_FILE));
			
		} catch (Exception ex) {
			System.err.println(String.format("Error leyendo propiedades: %s", ex.getMessage()));
			ex.printStackTrace();
		}

		return properties;
		}
	
	
	public void leerTareasCSV(String filename) {

	
		try (BufferedReader in = new BufferedReader(new FileReader(filename))){
		
			String linea;
			StringTokenizer tokenizer;
			Tarea tarea;
			tareas= new ArrayList<>();
			
			in.readLine(); // Saltar linea cabezera
			while((linea = in.readLine())!= null) {
				tokenizer= new StringTokenizer(linea,";");
			
				tarea= new Tarea();	
				tarea.setNombre(tokenizer.nextToken());		
				tarea.setFecha_inicio(Integer.parseInt((tokenizer.nextToken())));			
				tarea.setFecha_fin(Integer.parseInt((tokenizer.nextToken())));				
				tarea.setCalificacion(tokenizer.nextToken());
			
				tareas.add(tarea);
			}
			System.out.println(tareas);
			
			
		}catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " +ex);
			ex.printStackTrace();
		}

	}
	public void guardarDatosCSV(String filename) {
	 System.out.println(filename);
	try  {	 	  	   
	
	     PrintWriter pw = new PrintWriter(filename);
	     pw.println("Compania" + ";" + "Fecha" +";" + "Estatus" +";"+ "calificacion");
	     
	     for (Tarea tarea : tareas) {
	    	 pw.println(
	    			 tarea.getNombre() + ";" + tarea.getFecha_inicio() + ";" + tarea.getFecha_fin()+ ";" +tarea.getCalificacion() +";"
	    			 );		
		}
	     
	    pw.close();
	     
	} catch (Exception e) {
		System.err.println(String.format("Error en el main: %s", e.getMessage()));
		e.printStackTrace();
	}
	}

	
	public static void main(String[] args) {
		 Gestor gestor= new Gestor();
		Properties properties = loadProperties(); 
		gestor.leerTareasCSV(properties.getProperty(INPUT_KEY_TAREA ));
		gestor.guardarDatosCSV(properties.getProperty(OUTPUT_KEY_TAREA ));
	}
	
}
