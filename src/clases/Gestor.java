package clases;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;



import java.util.Properties;


public class Gestor {
	protected ArrayList<Alumno> alumnos;
	protected ArrayList<Profesor> profesor;
	protected ArrayList<Asignatura> asignaturas;
	protected ArrayList<Tarea> tareas;
	protected ArrayList<Usuarios> usuarios;
	protected Properties properties;
	private static final String PROPERTIES_FILE = "src/config/Properties";
	private static final String INPUT_KEY_TAREA = "leerTarea";
	private static final String OUTPUT_KEY_TAREA = "guardarTarea";
	private static final String KEY_ASIGNATURA = "guardarLeerAsgignatura";
	

	public Gestor(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesor, ArrayList<Asignatura> asignaturas,
			ArrayList<Tarea> tareas, ArrayList<Usuarios> usuarios) {
		super();
		this.alumnos = alumnos;
		this.profesor = profesor;
		this.asignaturas = asignaturas;
		this.tareas = tareas;
		this.usuarios = usuarios;
		
	}
	public Gestor() {
		super();
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = new ArrayList<Profesor>();
		this.asignaturas = new ArrayList<Asignatura>();
		this.tareas = new ArrayList<Tarea>();
		this.usuarios = new ArrayList<Usuarios>();
		
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
	 
	try  {	 	  	   
		System.out.println(filename);
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
	public void guardarAsignaturaBinario(String filename) {
		try {
			FileOutputStream fos= new FileOutputStream(filename);
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Asignatura asignatura : asignaturas) {
				oos.writeObject(asignatura);
			}
			
			oos.close();
			fos.close();
			
			
		} catch (IOException e ) {
			// TODO: handle exception
			System.err.println("Error guardar datos ");
		}
	}

	
	

		
		
	public void leerAsignaturasBinario(String filename) {
		try {
			FileInputStream fis= new FileInputStream(filename);
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			this.asignaturas= (ArrayList<Asignatura>) ois.readObject();
			ois.close();
			fis.close();
								
			
		} catch (IOException  | ClassNotFoundException e ) {
			// TODO: handle exception
			System.err.println("Error cargar datos");
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
	public ArrayList<Usuarios> initUsuarios() {
		Usuarios	usuario;
			for (int i = 0; i < 10; i++) {
			String name = i +"";
			String username="nombreUsuario"+i;
		
				usuario= new Usuarios(name,"apellidos",0,"direccion",username,username);
			usuarios.add(usuario);
			}
			System.out.println(usuarios);
			return usuarios;
			//System.out.println(asignaturas);
		}
	public static void main(String[] args) {
		
		 Gestor gestor= new Gestor();
		Properties properties = loadProperties(); 
		gestor.leerTareasCSV(properties.getProperty(INPUT_KEY_TAREA ));
		
		gestor.guardarTareaCSV(properties.getProperty(OUTPUT_KEY_TAREA ));
		gestor.CrearAsignaturas();
		
	
	//	gestor.leerAsignaturasBinario(KEY_ASIGNATURA);
		
		GestorBD gestorBD = new GestorBD();	
		gestorBD.crearBBDDAlumno();
		gestorBD.crearBBDDProfesor();
		for (int i = 0; i < 1; i++) {
		Profesor profesor = new Profesor();
		profesor.setId(-1);
		gestor.profesor.add(profesor);
		}
		for (int i = 0; i < 1; i++) {
			Alumno alumno= new Alumno();
			gestor.alumnos.add(alumno);
		}
		gestorBD.insertarDatosAlumno(gestor.alumnos.toArray(new Alumno[gestor.alumnos.size()]));
		gestorBD.insertarDatosProfesor(gestor.profesor.toArray(new Profesor[gestor.profesor.size()]));
		gestor.profesor= gestorBD.obtenerDatosProfesor();
		
		String newPassword = "hWaPvd6R28%1";
	  gestor.alumnos= gestorBD.obtenerDatosAlumnos();

		gestor.alumnos.get(0).getId();

		gestorBD.actualizarPasswordAlumno(gestor.alumnos.get(0), newPassword);
		gestorBD.actualizarPaswordProfesor(gestor.profesor.get(0), "1234");
		System.out.println(gestorBD.obtenerDatosAlumnos());
		System.out.println(gestorBD.obtenerDatosProfesor());
		

		
		gestorBD.borrarDatosAlumnos();
		gestorBD.borrarDatosProfesores();
		gestorBD.borrarBBDDAlumno();
		gestorBD.borrarBBDDProfesor();
		//
		
	//	System.out.println(	gestorBD.obtenerDatos());
	//	gestorBD.obtenerDatos();
		//CREATE DATABASE: Se crea la BBDD
	
	}
	
}
