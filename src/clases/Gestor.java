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

import javax.swing.SwingUtilities;

import ventanas.*;

import java.util.Properties;
import clases.GestorBD;

public class Gestor {
	protected ArrayList<Alumno> alumnos;
	protected ArrayList<Profesor> profesor;
	protected ArrayList<Asignatura> asignaturas;
	protected ArrayList<Usuarios> usuarios;
	protected Properties properties;
	public static final String PROPERTIES_FILE = "src/config/Properties";
	public static final String INPUT_KEY_TAREA = "leerTarea";
	public static final String OUTPUT_KEY_TAREA = "guardarTarea";
	public static final String KEY_ASIGNATURA = "guardarLeerAsgignatura";
	
	public Gestor(ArrayList<Alumno> alumnos, ArrayList<Profesor> profesor, ArrayList<Asignatura> asignaturas,
			ArrayList<Usuarios> usuarios) {
		super();
		this.alumnos = alumnos;
		this.profesor = profesor;
		this.asignaturas = asignaturas;
		this.usuarios = usuarios;
		
	}
	public Gestor() {
		super();
		this.alumnos = new ArrayList<Alumno>();
		this.profesor = new ArrayList<Profesor>();
		this.asignaturas = new ArrayList<Asignatura>();
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
	public ArrayList<Asignatura> getAsignatura() { 
		return asignaturas;
	}
	public void setProfesor(ArrayList<Profesor> profesor) {
		this.profesor = profesor;
	}
	public void setAsignatura(ArrayList<Asignatura> asignatura) {
		this.asignaturas = asignatura;
	}
	public void leerUsuarios(String fichero){
			
		
	}
	
	public  static Properties loadProperties() {
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
			
			in.readLine(); // Saltar linea cabezera
			while((linea = in.readLine())!= null) {
				tokenizer= new StringTokenizer(linea,";");
			
				tarea= new Tarea();
				tarea.setEmailAlumno(tokenizer.nextToken());
				tarea.setNombre(tokenizer.nextToken());		
				tarea.setFecha_fin(tokenizer.nextToken());				
				tarea.setCalificacion(Double.parseDouble(tokenizer.nextToken()));
				String nomAsig = tokenizer.nextToken();
				for (Asignatura a : asignaturas) {
					if (a.getNombre().equals(nomAsig)) {
						a.getTareas().add(tarea);
					}
				}
			}
			//System.out.println(tareas);
			
			
		}catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " +ex);
			ex.printStackTrace();
		}

	}
	public void guardarTareaCSV(String filename) {
	 
	try  {	 	  	   
		//System.out.println(filename);
	     PrintWriter pw = new PrintWriter(filename);
	     pw.println("Email Alumno" + ";" +"Nombre" + ";" + "Fecha" +";" + "Calificacion" + ";" + "Asignatura");
	     
	     for (Asignatura a : asignaturas) {
			for (Tarea tarea : a.getTareas()) {
	    	 pw.println(
	    			 tarea.getEmailAlumno() + ";" + tarea.getNombre() + ";" + tarea.getFecha_fin()+ ";" +tarea.getCalificacion() +";" + a.nombre + ";"
	    			 );		
			}
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
			//System.out.println(usuarios);
			return usuarios;
			//System.out.println(asignaturas);
		}
	public static void main(String[] args) {
		
		Gestor gestor= new Gestor();
		Properties properties = loadProperties();
		gestor.CrearAsignaturas();
		gestor.leerTareasCSV(properties.getProperty(INPUT_KEY_TAREA ));
		gestor.guardarTareaCSV(properties.getProperty(OUTPUT_KEY_TAREA ));
		
		
	
		//CREAR BASE DE DATOS
		
		GestorBD.gestorBD = new GestorBD();	
		//GestorBD.gestorBD.borrarBBDDAlumno();
		//GestorBD.gestorBD.borrarBBDDProfesor();
		GestorBD.gestorBD.crearBBDDProfesor();
		GestorBD.gestorBD.crearBBDDAlumno();
	
		
		
		//CREAR PROFESORES Y ALUMNOS
		ArrayList<Profesor> profesores = GestorBD.gestorBD.obtenerDatosProfesor();
		
		//System.out.println(profesores);
		ArrayList<Alumno> alumnos = GestorBD.gestorBD.obtenerDatosAlumnos();

		
		if (profesores.size() == 0) {
			for (int i = 0; i < 2; i++) {
				Profesor profesor = new Profesor();
				profesor.setContraseña(i+"");
				profesor.setApellidos("Apellido"+i);
				profesor.setDireccion("dir");
				profesor.setEdad(i);
				profesor.setNombre("nombre"+i);
				profesor.setSalario(i);
				profesor.setNombreUsuario("Profe");
				gestor.profesor.add(profesor);		
			}
			
			Profesor profesor = new Profesor("Borja", "OM", 5, "DIR","NU","", 0);
			gestor.profesor.add(profesor);
		}
		if (alumnos.size() == 0) {
			for (int i = 0; i < 5; i++) {
				Alumno alumno= new Alumno("Alumno", "" + i, i*10, "", "Alumno"+i, "1", "PRIMERO");
				
				GestorBD.gestorBD.insertarDatosAlumno(alumno);
				
				gestor.alumnos.add(alumno);
			}
		}
		//INSERTAS ALUMNOS Y PROFESORES EN LAS TABLAS DE DATOS 
		GestorBD.gestorBD.insertarDatosAlumno(gestor.alumnos.toArray(new Alumno[gestor.alumnos.size()]));
		GestorBD.gestorBD.insertarDatosProfesor(gestor.profesor.toArray(new Profesor[gestor.profesor.size()]));

		// VENTANAS
		
		//System.out.println(GestorBD.gestorBD.obtenerDatosProfesor());
		gestor.alumnos=GestorBD.gestorBD.obtenerDatosAlumnos();
        gestor.profesor= GestorBD.gestorBD.obtenerDatosProfesor();
        
        for (int i = 0; i < gestor.asignaturas.size(); i++) {
        	gestor.asignaturas.get(i).setProfesor(gestor.profesor.get(0));
		}
        
		gestor.asignaturas.get(0).getAlumnos().add(alumnos.get(0));
		gestor.asignaturas.get(1).getAlumnos().add(alumnos.get(0));
		gestor.asignaturas.get(2).getAlumnos().add(alumnos.get(0));
		gestor.asignaturas.get(3).getAlumnos().add(alumnos.get(0));
		gestor.asignaturas.get(4).getAlumnos().add(alumnos.get(0));
		gestor.asignaturas.get(2).getAlumnos().add(alumnos.get(1));
		gestor.asignaturas.get(3).getAlumnos().add(alumnos.get(1));
		gestor.asignaturas.get(4).getAlumnos().add(alumnos.get(1));
		gestor.asignaturas.get(1).getAlumnos().add(alumnos.get(2));
		gestor.asignaturas.get(2).getAlumnos().add(alumnos.get(2));
		gestor.asignaturas.get(5).getAlumnos().add(alumnos.get(2));
		gestor.asignaturas.get(1).getAlumnos().add(alumnos.get(3));
		gestor.asignaturas.get(6).getAlumnos().add(alumnos.get(3));
		gestor.asignaturas.get(7).getAlumnos().add(alumnos.get(3));
        
		VentanaLogIn v = new VentanaLogIn(gestor);
		


	
	}

	
}
