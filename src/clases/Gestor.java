package clases;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Properties;


public class Gestor {
	protected ArrayList<Alumno> alumnos;
	protected ArrayList<Profesor> profesor;
	protected ArrayList<Asignatura> asignaturas;
	protected ArrayList<Tarea> tareas;
	protected Properties properties;
	private static final String PROPERTIES_FILE = "src/config/Properties";
	private static final String INPUT_KEY_TAREA = "leerTarea";
	private static final String OUTPUT_KEY_TAREA = "guardarTarea";
	private static final String KEY_ASIGNATURA = "guardarLeerAsgignatura";
	
	public Gestor(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesor, ArrayList<Asignatura> asignatura,
			ArrayList<Tarea> tareas) {
		super();
		this.alumnos = alumnos;
		this.profesor = profesor;
		this.asignaturas = asignatura;
		this.tareas = tareas;
	}
	public Gestor() {
		super();
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = new ArrayList<Profesor>();
		this.asignaturas = new ArrayList<Asignatura>();
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
		return asignaturas;
	}
	public void setAsignatura(ArrayList<Asignatura> asignatura) {
		this.asignaturas = asignatura;
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
	public void guardarTareaCSV(String filename) {
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
	public void guardarAsignaturaCSV(String filename) {
	
		try  {	 	  	   
		
		     PrintWriter pw = new PrintWriter(filename);
		     pw.println("NOMBRE " + ";" + "PROFESOR" +";" + "ALUMNOS" +";"+ "TAREAS" +"CALIFICACION" +";");

		     for (Asignatura asignatura : asignaturas) {
		    	 pw.println(
		    			 asignatura.getNombre() + ";" + asignatura.getProfesor() + ";" + asignatura.getAlumnos()+ ";" +asignatura.getTareas() +";" +asignatura.getNombre()		+";"    );		
			}
		     
		    pw.close();
		     
		} catch (Exception e) {
			System.err.println(String.format("Error en el main: %s", e.getMessage()));
			e.printStackTrace();
		}
		}
	public void leerAsignaturasCSV(String filename) {

		
		try (BufferedReader in = new BufferedReader(new FileReader(filename))){
		
			String linea;
			StringTokenizer tokenizer;
			Asignatura asignatura;
			asignaturas= new ArrayList<>();
			
			in.readLine(); // Saltar linea cabezera
			while((linea = in.readLine())!= null) {
				tokenizer= new StringTokenizer(linea,";");
			
				asignatura= new Asignatura();	
				asignatura.setNombre(tokenizer.nextToken());		
				asignatura.setProfesor((Profesor)tokenizer.nextElement());			
				asignatura.setAlumnos((ArrayList<Alumno>)tokenizer.nextElement());				
				asignatura.setTareas((ArrayList<Tarea>)tokenizer.nextElement());
				asignatura.setCalificacion(Double.parseDouble(tokenizer.nextToken()));
			
				asignaturas.add(asignatura);
			}
			System.out.println(asignaturas);
			
			
		}catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " +ex);
			ex.printStackTrace();
		}

	}
	public void CrearAsignaturas() {
	Asignatura	asignatura;
		for (int i = 0; i < 10; i++) {
			String name = "asignatura" +i;
			asignatura=new Asignatura(name,new Profesor(),new ArrayList<Alumno>(),new ArrayList<Tarea>(),i);
			asignaturas.add(asignatura);
		}
		//System.out.println(asignaturas);
	}
	public static void main(String[] args) {
		
		 Gestor gestor= new Gestor();
		Properties properties = loadProperties(); 
		gestor.leerTareasCSV(properties.getProperty(INPUT_KEY_TAREA ));
		
		gestor.guardarTareaCSV(properties.getProperty(OUTPUT_KEY_TAREA ));
		gestor.CrearAsignaturas();
		gestor.guardarAsignaturaCSV(KEY_ASIGNATURA);
	//	gestor.leerAsignaturasCSV(KEY_ASIGNATURA);
	//	GestorBD gestorBD = new GestorBD();		
		
		//CREATE DATABASE: Se crea la BBDD
	
	}
	
}
