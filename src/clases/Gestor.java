package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.SwingUtilities;

import ventanas.*;

import java.util.Properties;
import clases.GestorBD;

public class Gestor {

	protected Properties properties;
	public static final String PROPERTIES_FILE = "src/config/Properties";
	public static  String TAREA = "";
	public static  String PROFESOR = "";
	public static  String ALUMNO = ""; 
	public static  String ESTUDIA = "";
	public static  String ASIGNATURA = "";
	


	public static Properties loadProperties() {
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

	public static ArrayList<Tarea> leerTareasCSV() {
		ArrayList<Tarea> tareas = null;
		try (BufferedReader in = new BufferedReader(new FileReader(TAREA))) {
			String linea;
			StringTokenizer tokenizer;
			Tarea tarea;
			tareas = new ArrayList<>();
			in.readLine(); // Saltar linea cabezera
			while ((linea = in.readLine()) != null) {
				tokenizer = new StringTokenizer(linea, ";");
				tarea = new Tarea();
				tarea.setId(Integer.parseInt(tokenizer.nextToken()));
				tarea.setNombre(tokenizer.nextToken());
				tarea.setFecha_fin(tokenizer.nextToken());
				tarea.setCalificacion(Integer.parseInt(tokenizer.nextToken()));
				tarea.setId_asignatura(Integer.parseInt(tokenizer.nextToken()));
				tarea.setId_alumna(Integer.parseInt(tokenizer.nextToken()));
				tarea.setPorcentaje(Integer.parseInt(tokenizer.nextToken()));
				tareas.add(tarea);
			}

		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " + ex);
			ex.printStackTrace();
		}

		return tareas;
	}

	public static void guardarTareaCSV(ArrayList<Tarea> tareas) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(TAREA);

		pw.println("ID;NOMBRE;FECHA_FIN;CALIFICACION;ID_ASIGNATURA;ID_ALUMNO;PORCENTAJE");

		for (Tarea t : tareas) {

			pw.println(t.getId() + ";" + t.getNombre() + ";" + t.getFecha_fin() + ";" + t.getCalificacion() + ";"
					+ t.getId_asignatura() + ";" + t.getId_alumna() + ";" + t.getPorcentaje() + ";");
		}
		pw.close();
	}

	public static ArrayList<Alumno> leerAlumnosCSV() {
		ArrayList<Alumno> alumnos = null;
		try (BufferedReader in = new BufferedReader(new FileReader(ALUMNO))) {
			String linea;
			StringTokenizer tokenizer;
			Alumno alumno;
			alumnos = new ArrayList<Alumno>();
			in.readLine(); // Saltar linea cabezera
			while ((linea = in.readLine()) != null) {
				tokenizer = new StringTokenizer(linea, ";");
				alumno = new Alumno();

				alumno.setId(Integer.parseInt(tokenizer.nextToken()));
				alumno.setNombre(tokenizer.nextToken());
				alumno.setApellidos(tokenizer.nextToken());
				alumno.setContraseña(tokenizer.nextToken());
				alumno.setDireccion(tokenizer.nextToken());
				tokenizer.nextToken();
				// alumno.setEdad(Integer.parseInt(tokenizer.nextToken()));
				alumno.setEmail(tokenizer.nextToken());
				alumno.setCurso(Integer.parseInt(tokenizer.nextToken()));
				alumno.setNombreUsuario(tokenizer.nextToken());

				alumnos.add(alumno);
			}

		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " + ex);
			ex.printStackTrace();
		}
		return alumnos;
	}

	public static void guardarAlumnosCSV(ArrayList<Alumno> alumnos) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(ALUMNO);

		pw.println("ID;NOMBRE;APELLIDO;CONTRASEÑA;DIRECCION;EDAD;EMAIL;CURSO;NOMBRE_USUARIO");

		for (Alumno t : alumnos) {

			pw.println(t.getId() + ";" + t.getNombre() + ";" + t.getApellidos() + ";" + t.getContraseña() + ";"
					+ t.getDireccion() + ";" + t.getEdad() + ";" + t.getEmail() + ";" + t.getCurso() + ";"
					+ t.getNombreUsuario() + ";");

		}
		pw.close();
	}

	public static ArrayList<Estudia> leerEstudiaCSV() {
		ArrayList<Estudia> estudias = null;
		try (BufferedReader in = new BufferedReader(new FileReader(ESTUDIA))) {
			String linea;
			StringTokenizer tokenizer;
			Estudia estudia;
			estudias = new ArrayList<Estudia>();
			in.readLine(); // Saltar linea cabezera
			while ((linea = in.readLine()) != null) {
				tokenizer = new StringTokenizer(linea, ";");
				estudia = new Estudia();
				estudia.setId_alumno(Integer.parseInt(tokenizer.nextToken()));
				estudia.setId_asignatura(Integer.parseInt(tokenizer.nextToken()));

				estudias.add(estudia);
			}

		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " + ex);
			ex.printStackTrace();
		}

		return estudias;
	}

	public static void guardarEstudiaCSV(ArrayList<Estudia> estudias) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(ESTUDIA);

		pw.println("ID_ALUMNO;ID_ASIGNATURA");

		for (Estudia t : estudias) {

			pw.println(t.getId_alumno() + ";" + t.getId_asignatura() + ";");

		}
		pw.close();
	}

	public static ArrayList<Profesor> leerProfesorCSV() {
		ArrayList<Profesor> profesores = null;
		try (BufferedReader in = new BufferedReader(new FileReader(PROFESOR))) {
			String linea;
			StringTokenizer tokenizer;
			Profesor profesor;
			profesores = new ArrayList<>();
			in.readLine(); // Saltar linea cabezera
			while ((linea = in.readLine()) != null) {
				tokenizer = new StringTokenizer(linea, ";");
				profesor = new Profesor();
				profesor.setId(Integer.parseInt(tokenizer.nextToken()));
				profesor.setNombre(tokenizer.nextToken());
				profesor.setApellidos(tokenizer.nextToken());
				profesor.setContraseña(tokenizer.nextToken());
				profesor.setDireccion(tokenizer.nextToken());
				profesor.setEdad(Integer.parseInt(tokenizer.nextToken()));
				profesor.setEmail(tokenizer.nextToken());
				profesor.setSalario((int) (Float.parseFloat(tokenizer.nextToken())));
				profesor.setNombreUsuario(tokenizer.nextToken());

				profesores.add(profesor);
			}

		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " + ex);
			ex.printStackTrace();
		}
		return profesores;
	}

	public static void guardarProfesorCSV(ArrayList<Profesor> profesores) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(PROFESOR);

		pw.println("ID;NOMBRE;APELLIDO;CONTRASEÑA;DIRECCION;EDAD;EMAIL;SALARIO;NOMBRE_USUARIO");

		for (Profesor t : profesores) {

			pw.println(t.getId() + ";" + t.getNombre() + ";" + t.getApellidos() + ";" + t.getContraseña() + ";"
					+ t.getDireccion() + ";" + t.getEdad() + ";" + t.getEmail() + ";" + t.getSalario() + ";"
					+ t.getNombreUsuario()

					+ ";");

		}

		pw.close();
	}

	public static ArrayList<Asignatura> leerAsignaturaCSV() {
		ArrayList<Asignatura> asignaturas = null;
		try (BufferedReader in = new BufferedReader(new FileReader(ASIGNATURA))) {
			String linea;
			StringTokenizer tokenizer;
			Asignatura asignatura;
			asignaturas = new ArrayList<>();
			in.readLine(); // Saltar linea cabezera
			while ((linea = in.readLine()) != null) {
				tokenizer = new StringTokenizer(linea, ";");
				asignatura = new Asignatura();
				asignatura.setId(Integer.parseInt(tokenizer.nextToken()));
				asignatura.setNombre(tokenizer.nextToken());
				asignatura.setId_profesor(Integer.parseInt(tokenizer.nextToken()));

				asignaturas.add(asignatura);
			}

		} catch (Exception ex) {
			// TODO: handle exception
			System.err.println("Error en el main: " + ex);
			ex.printStackTrace();
		}
		return asignaturas;
	}

	public static void guardarAsignaturaCSV(ArrayList<Asignatura> asignaturas) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(ASIGNATURA);
		
		

		pw.println("ID;NOMBRE;ID_PROFESOR");

		for (Asignatura t : asignaturas) {

			pw.println(t.getId() + ";" + t.getNombre() + ";" + t.getId_profesor()

					+ ";");

		}
		pw.close();
	}

	public static void main(String[] args) throws FileNotFoundException {

		Properties properties = loadProperties();
		TAREA = (String) properties.get("Tarea");
		ASIGNATURA= (String) properties.get("Asignatura");
		ALUMNO= (String) properties.get("Alumno");
		ESTUDIA = (String) properties.get("Estudia");
		PROFESOR= (String) properties.get("Profesor");
	
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		ArrayList<Estudia> estudias = new ArrayList<Estudia>();
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();

		alumnos = leerAlumnosCSV();
		asignaturas = leerAsignaturaCSV();
		estudias = leerEstudiaCSV();
		profesores = leerProfesorCSV();
		tareas = leerTareasCSV();
//		guardarAlumnosCSV(alumnos);
//		guardarAsignaturaCSV(asignaturas);
//		guardarEstudiaCSV(estudias);
//		guardarProfesorCSV(profesores);
//		guardarTareaCSV(tareas);
		GestorBD.gestorBD.borrarDatosAlumnos();
		GestorBD.gestorBD.borrarDatosProfesores();
		GestorBD.gestorBD.borrarDatosAsignaturas();
		GestorBD.gestorBD.borrarDatosEstudia();
		GestorBD.gestorBD.borrarDatosTareas();
		for (Alumno a : alumnos) {
			GestorBD.gestorBD.insertarDatosAlumno(a);
		}
		for (Profesor p : profesores) {
			GestorBD.gestorBD.insertarDatosProfesor(p);
		}

		for (Asignatura a : asignaturas) {
			GestorBD.gestorBD.insertarDatosAsignatura(a);
		}
		for (Estudia e : estudias) {
			GestorBD.gestorBD.insertarDatosEstudia(e);
		}

		for (Tarea t : tareas) {
			GestorBD.gestorBD.insertarDatosTarea(t);
		}

		VentanaLogIn v = new VentanaLogIn();

	}

}