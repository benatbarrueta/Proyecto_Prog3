package clases;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


import ventanas.VentanaEdita;

import java.sql.*;
public class GestorBD {

	protected static final String DRIVER_NAME = "lib/sqlite-jdbc";
	protected static final String DATABASE_FILE = "db/bd.db";
	protected static final String CONNECTION_STRING= "jdbc:sqlite:" + DATABASE_FILE;

	private Logger logger = null;
	public static GestorBD gestorBD;	
	
	
	public GestorBD() {		
		try {
			//Cargar el diver SQLite
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			
			log( Level.SEVERE, "Error al cargar el driver de BBDD", ex);
			ex.printStackTrace();
		}
	}
		
	// CREACION TABLAS
	/*
	public void crearBBDDAlumno() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "CREATE TABLE IF NOT EXISTS ALUMNO(\n"
	        		   + " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
	                   + " NOMBRE TEXT NOT NULL,\n"
	                   + " APELLIDO TEXT NOT NULL,\n"
	                   + " CONTRASEÑA TEXT NOT NULL,\n"
	                   + " DIRECCION TEXT NOT NULL,\n"
	                   + " EDAD TEXT NOT NULL,\n"
	                   + " EMAIL TEXT NOT NULL,\n"
	                   + " CURSO TEXT NOT NULL,\n"
	                   + " NOMBRE_USUARIO TEXT NOT NULL\n"
	                   + ");";
	   
		
	        if (!stmt.execute(sql)) {
	        	log( Level.INFO,"Se ha creado la tabla alumno", null);
	        }
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al crear la  BBDD alumno", ex);
			ex.printStackTrace();			
		}
	}
	public void crearBBDDProfesor() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "CREATE TABLE IF NOT EXISTS PROFESOR(\n"
	        		   + " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
	                   + " NOMBRE TEXT NOT NULL,\n"
	                   + " APELLIDO TEXT NOT NULL,\n"
	                   + " CONTRASEÑA TEXT NOT NULL,\n"
	                   + " DIRECCION TEXT NOT NULL,\n"
	                   + " EDAD TEXT NOT NULL,\n"
	                   + " EMAIL TEXT NOT NULL,\n"
	                   + " SALARIO TEXT NOT NULL,\n"
	                   + " NOMBRE_USUARIO TEXT NOT NULL\n"
	                   + ");";
	   
		
	        if (!stmt.execute(sql)) {
	        	log( Level.INFO,"Se ha creado la tabla profesor", null);
	        }
		} catch (Exception ex) {
			
			
			log( Level.SEVERE,"Error al crear la  BBDD profesor", ex);
			ex.printStackTrace();			
		}
	}
	
	public void crearBBDDTarea() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = " CREATE TABLE IF NOT EXISTS TAREA(\n"
	        		   + " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
	                   + " NOMBRE TEXT NOT NULL,\n"
	                   + " EMAIL TEXT NOT NULL,\n"
	                   + " FECHA_FIN TEXT NOT NULL,\n"
	                   + " CALIFICACION DOUBLE NOT NULL,\n"
	                   + " );";
		
	        //if (!stmt.execute(sql)) {
	        	log( Level.INFO,"Se ha creado la tabla tarea", null);
	        //}
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al crear la  BBDD tarea", ex);
			ex.printStackTrace();			
		}
	}
	
	public void crearBBDDAsignatura() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "CREATE TABLE IF NOT EXISTS ASIGNATURA(\n"
	        		   + " ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
	                   + " NOMBRE TEXT NOT NULL,\n"
	                   + " PROFESOR TEXT NOT NULL,\n"
	                   + " ALUMNOS TEXT NOT NULL,\n"
	                   + " TAREAS TEXT NOT NULL,\n"
	                   + " CALIFICACION DOUBLE, \n"
	                   + ");";
		
	        // if (!stmt.execute(sql)) {
	        	log( Level.INFO,"Se ha creado la tabla asignatura", null);
	        // }
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al crear la  BBDD asignatura", ex);
			ex.printStackTrace();			
		}
	}
	*/
	// FUNCIONES BORRADO
/*	
	public void borrarBBDDAlumno() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "DROP TABLE IF EXISTS ALUMNO";
			
	        //Se ejecuta la sentencia de creación de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        
	        	log( Level.INFO,"Se ha borrado la tabla ALUMNO", null);
	        }
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al borrar la  BBDD", ex);
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE));
			
			log( Level.INFO,"Se ha borrado el fichero de la BD", null);
		} catch (Exception ex) {
		
			
			log( Level.SEVERE,"Error al borrar el archivo de la  BBDD", ex);
			ex.printStackTrace();						
		}
	}
	
	public void borrarBBDDProfesor() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "DROP TABLE IF EXISTS PROFESOR";
			
	        //Se ejecuta la sentencia de creación de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        	
				log( Level.INFO,"Se ha borrado la tabla profesor", null);
	        
	        }
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al borrar la  BBDD", ex);
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE));
			log( Level.INFO,"Se ha borrado el fichero de la BBDD", null);
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al borrar el archivo de la  BBDD", ex);
	
			ex.printStackTrace();						
		}
	}
	
	public void borrarBBDDTarea() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "DROP TABLE IF EXISTS TAREA";
			
	        //Se ejecuta la sentencia de creación de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        	
				log( Level.INFO,"Se ha borrado la tabla tarea", null);
	        
	        }
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al borrar la  BBDD", ex);
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE));
			log( Level.INFO,"Se ha borrado el fichero de la BBDD", null);
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al borrar el archivo de la  BBDD", ex);
	
			ex.printStackTrace();						
		}
	}
	
	public void borrarBBDDAsignatura() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "DROP TABLE IF EXISTS ASIGNATURA";
			
	        //Se ejecuta la sentencia de creación de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        	
				log( Level.INFO,"Se ha borrado la tabla asignatura", null);
	        
	        }
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al borrar la  BBDD", ex);
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE));
			log( Level.INFO,"Se ha borrado el fichero de la BBDD", null);
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al borrar el archivo de la  BBDD", ex);
	
			ex.printStackTrace();						
		}
	}
	*/
	// FUNCIONES DE INSERCION
	
	public void insertarDatosAlumno(Alumno... alumno) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO ALUMNO ( ID, NOMBRE, APELLIDO, CONTRASEÑA, DIRECCION, EDAD, EMAIL, CURSO, NOMBRE_USUARIO) VALUES ( '%d','%s', '%s', '%s', '%s', '%d','%s', '%s', '%s');";
			
			log( Level.INFO,"Insertando alumnos...", null);

		
			//Se recorren los alumnos y se insertan uno a uno
			for (Alumno c : alumno) {
				
				if (1 == stmt.executeUpdate(String.format(sql,c.getId(), c.getNombre(), c.getApellidos(), c.getContraseña(), c.getDireccion(),  c.getEdad(), c.getEmail(), c.getCurso(), c.getNombreUsuario()))) {					
					
					log( Level.INFO,"Alumno insertado", null);
				} else {
				
					log( Level.INFO,"No se ha insertado el aluno", null);
				}
			}			
		} catch (Exception ex) {

			log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
			ex.printStackTrace();						
		}				
	}
	
	public void insertarDatosProfesor(Profesor... profesor) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO PROFESOR ( ID, NOMBRE, APELLIDO, CONTRASEÑA, DIRECCION, EDAD, EMAIL, SALARIO, NOMBRE_USUARIO) VALUES ('%d','%s', '%s', '%s', '%s', '%d','%s', '%d', '%s');";
			
		
			log( Level.INFO, "Insertando profesores...", null);
			//Se recorren los profesores y se insertan uno a uno
			for (Profesor c : profesor) {
				if (1 == stmt.executeUpdate(String.format(sql,c.getId(), c.getNombre(), c.getApellidos(), c.getContraseña(), c.getDireccion(),  c.getEdad(), c.getEmail(), c.getSalario(), c.getNombreUsuario()))) {					
					//System.out.println(String.format(" - Profesor insertado: %s", c.toString()));

					log( Level.INFO, "Profesor insertado "+c.toString(), null);
				} else {
					
					log( Level.INFO, "No se ha insertado el profesor "+c.toString(), null);
				}
			}			
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
			ex.printStackTrace();						
		}				
	}
	
	public void insertarDatosTarea(Tarea... tarea) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO TAREA ( NOMBRE, EMAIL, FECHA_FIN, CALIFICACION) VALUES ('%s', '%s', '%s', '%s');";
			
		
			log( Level.INFO, "Insertando tareas...", null);
			//Se recorren las tareas y se insertan uno a uno
			for (Tarea t : tarea) {
				if (1 == stmt.executeUpdate(String.format(sql, t.getNombre(), t.getEmailAlumno(), t.getFecha_fin(), "" + t.getCalificacion()))) {					

					log( Level.INFO, "Tarea insertada "+ t.toString(), null);
				} else {
					
					log( Level.INFO, "No se ha insertado el profesor "+t.toString(), null);
				}
			}			
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
			ex.printStackTrace();						
		}				
	}
	
	public void insertarDatosAsignatura(Tarea... tarea) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO ASIGNATURA ( ID, NOMBRE, FECHA_INI , CALIFICACION, ID_ASIGNATURA, ID_ALUMNO ) VALUES ('%s', '%s', '%s'. '%d');";
			
		
			log( Level.INFO, "Insertando asignaturas...", null);
			//Se recorren las asignaturas y se insertan uno a uno
			for (Tarea t : tarea) {
				if (1 == stmt.executeUpdate(String.format(sql, t.getNombre(), t.getEmailAlumno(), t.getFecha_fin(), t.getCalificacion()))) {					

					log( Level.INFO, "Asignatura insertada "+ t.toString(), null);
				} else {
					
					log( Level.INFO, "No se ha insertado el profesor " + t.toString(), null);
				}
			}			
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
			ex.printStackTrace();						
		}				
	}
	
	// OBTENCION DE DATOS
	
	public ArrayList<Alumno> obtenerDatosAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			String sql = "SELECT * FROM ALUMNO WHERE ID >= 0";
	//		System.out.println(sql);
			
			//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
			ResultSet rs = stmt.executeQuery(sql);		
			
			
			Alumno alumno;
			
			//Se recorre el ResultSet y se crean objetos Cliente
			while (rs.next()) {
				alumno= new Alumno();
				alumno.setId(rs.getInt("ID"));
				alumno.setNombre(rs.getString("NOMBRE"));
				alumno.setApellidos(rs.getString("APELLIDO"));
				alumno.setContraseña(rs.getString("CONTRASEÑA"));
				alumno.setDireccion(rs.getString("DIRECCION"));
				alumno.setEdad(rs.getInt("EDAD"));
				alumno.setEmail(rs.getString("EMAIL"));
				alumno.setCurso(rs.getInt("CURSO"));
				alumno.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
			
				
				//Se inserta cada nuevo cliente en la lista de clientes
				alumnos.add(alumno);
			}
			
			//Se cierra el ResultSet
			rs.close();
		
			log( Level.INFO,"Se han recuperado alumnos", null);
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al obtener datos de la  BBDD", ex);
			ex.printStackTrace();						
		}		
		
		return alumnos;
	}
	
	public ArrayList<Profesor> obtenerDatosProfesor() { // DEBERIA FUNCIONAR
		ArrayList<Profesor> profesores = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			String sql = "SELECT * FROM PROFESOR WHERE ID >= 0";
			
			
			//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
			ResultSet rs = stmt.executeQuery(sql);			
			Profesor profesor;
			
			//Se recorre el ResultSet y se crean objetos Cliente
			while (rs.next()) {
				profesor= new Profesor();
				profesor.setId(rs.getInt("ID"));
				profesor.setNombre(rs.getString("NOMBRE"));
				profesor.setApellidos(rs.getString("APELLIDO"));
				profesor.setContraseña(rs.getString("CONTRASEÑA"));
				profesor.setDireccion(rs.getString("DIRECCION"));
				profesor.setEdad(rs.getInt("EDAD"));
				profesor.setEmail(rs.getString("EMAIL"));
				profesor.setSalario(rs.getInt("SALARIO"));
				profesor.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
			
			
				
				//Se inserta cada nuevo cliente en la lista de clientes
				profesores.add(profesor);
			}
			
			//Se cierra el ResultSet
			rs.close();
			
			
			log( Level.INFO,"Se han recuperado profesores", null);;
			
			
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al obtener datos de la  BBDD", ex);
		
			ex.printStackTrace();						
		}		
		//System.out.println(profesores);
		return profesores;
	}
	public ArrayList<Estudia> obtenerDatosEstudia() { // DEBERIA FUNCIONAR
		ArrayList<Estudia> estudiar = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			String sql = "SELECT * FROM ESTUDIA";
			
			
			//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
			ResultSet rs = stmt.executeQuery(sql);			
			Estudia estudai;
			
			//Se recorre el ResultSet y se crean objetos Cliente
			while (rs.next()) {
				Estudia estudia= new Estudia ();
				estudia.setId_alumno(rs.getInt("ID_ALUMNO"));
				estudia.setId_asignatura(rs.getInt("ID_ASIGNATURA"));
			
			
			
				
				//Se inserta cada nuevo cliente en la lista de clientes
				estudiar.add(estudia);
			}
			
			//Se cierra el ResultSet
			rs.close();
			
			
			log( Level.INFO,"Se han recuperado profesores", null);;
			
			
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al obtener datos de la  BBDD", ex);
		
			ex.printStackTrace();						
		}		
		//System.out.println(profesores);
		return estudiar;
	}


	public ArrayList<Tarea> obtenerDatosTareas() { //DEBERIA FUNCIONAR
		ArrayList<Tarea> tareas = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		    Statement stmt = con.createStatement()) {
			String sql = "SELECT * FROM TAREA WHERE ID >= 0";
			
			
			//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
			ResultSet rs = stmt.executeQuery(sql);			
			Tarea tarea;
			
			//Se recorre el ResultSet y se crean objetos Cliente
			while (rs.next()) {
				tarea= new Tarea();
				tarea.setId(rs.getInt("ID"));
				tarea.setNombre(rs.getString("NOMBRE"));
				tarea.setFecha_fin(rs.getString("FECHA_FIN"));
				tarea.setCalificacion(rs.getInt("CALIFICACION"));
				tarea.setId_asignatura(rs.getInt("ID_ASIGNATURA"));
				tarea.setId_alumna(rs.getInt("ID_ALUMNO"));
				//Se inserta cada nuevo cliente en la lista de clientes
				tareas.add(tarea);
			}
			
			//Se cierra el ResultSet
			rs.close();
			
			
			log( Level.INFO,"Se han recuperado tareas", null);;
			
			
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al obtener datos de la  BBDD", ex);
		
			ex.printStackTrace();						
		}		
		//System.out.println(profesores);
		return tareas;
	}
	
	public ArrayList<Asignatura> obtenerDatosAsignaturas() {
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		    Statement stmt = con.createStatement()) {
			String sql = "SELECT * FROM ASIGNATURA WHERE ID >= 0";
			
			
			//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
			ResultSet rs = stmt.executeQuery(sql);			
			Asignatura asignatura;
			
			//Se recorre el ResultSet y se crean objetos Cliente
			while (rs.next()) {
				asignatura = new Asignatura();
				asignatura.setId(rs.getInt("ID"));
				asignatura.setNombre(rs.getString("NOMBRE"));
				asignatura.setNombre(rs.getString("ID_PROFESOR"));
				
				//Se inserta cada nuevo cliente en la lista de clientes
				asignaturas.add(asignatura);
			}
			
			//Se cierra el ResultSet
			rs.close();
			
			
			log( Level.INFO,"Se han recuperado asignaturas", null);;
			
			
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al obtener datos de la  BBDD", ex);
		
			ex.printStackTrace();						
		}		
		//System.out.println(profesores);
		return asignaturas;
	}

	public void borrarDatosAlumnos() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM ALUMNO;";			
			int result = stmt.executeUpdate(sql);
			
			log( Level.INFO,"Se han borrado alumnos ", null);
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al borrar datos de la  BBDD", ex);
			
			ex.printStackTrace();						
		}		
	}	
	//ACTUALIZACIONES HAY QUE CAMBIAR TODAS
	// ACTUALIZACION DE CONTRASEÑAS
	
	public void actualizarPasswordAlumno(Alumno alumno, String newPassword) {
		//Se abre la conexiÃ³n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE ALUMNO SET CONTRASEÑA = '%s' WHERE ID = %d;";
	
			
			int result = stmt.executeUpdate(String.format(sql, newPassword, alumno.getId()));
			log( Level.INFO,"Se han actualizado alumnos ", null);
		
			
			//	System.out.println();
		} catch (Exception ex) {
		
			log( Level.SEVERE,"Error al actualizando datos de la  BBDD", ex);
			ex.printStackTrace();						
		}		
	}
	public void actualizarPaswordProfesor(Profesor profesor, String newPassword) {
		//Se abre la conexiÃ³n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE PROFESOR SET CONTRASEÑA = '%s' WHERE ID = %d;";
			
			int result = stmt.executeUpdate(String.format(sql, newPassword, profesor.getId()));
			
			log( Level.INFO,"Se ha actulizado la contraseña del profesor",null);
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al actualizando datos de la  BBDD", ex);
			ex.printStackTrace();						
		}		
	}
	
	// ACTUALIZACION DE DATOS
	
	public void actualizarAlumno(Alumno alumno, String newNombre, String newApellido, String newEmail, String newDirection, String newNombreUsuario, String newContraseña) {
		//Se abre la conexion y obtenemos el statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			 Statement stmt = con.createStatement()){
			//Se ejecuta la sentencia de actualizar datos
			String sql = "UPDATE ALUMNO SET NOMBRE = '%s', APELLIDO = '%s', EMAIL = '%s', DIRECCION = '%s', NOMBRE_USUARIO = '%s', CONTRASEÑA = '%s' WHERE ID = %d;";
			int result = stmt.executeUpdate(String.format(sql, newNombre, newApellido, newEmail, newDirection, newNombreUsuario, newContraseña, alumno.getId()));
			
			log( Level.INFO,"Se ha actulizado los datos de " + result + "alumno",null);
			
		} catch (Exception e) {
			log( Level.SEVERE,"Error al actualizar datos de la  BBDD", e);
			e.printStackTrace();
		}
	}
	
	public void actualizarProfesor(Profesor profesor, String newNombre, String newApellido, String newEmail, String newDirection, String newNombreUsuario, String newContraseña) {
		//Se abre la conexion y obtenemos el statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			 Statement stmt = con.createStatement()){
			//Se ejecuta la sentencia de actualizar datos
			String sql = "UPDATE PROFESOR SET NOMBRE = '%s', APELLIDO = '%s', EMAIL = '%s', DIRECCION = '%s', NOMBRE_USUARIO = '%s', CONTRASEÑA = '%s' WHERE ID = %d;";
			int result = stmt.executeUpdate(String.format(sql, newNombre, newApellido, newEmail, newDirection, newNombreUsuario, newContraseña, profesor.getId()));
			
		
			log( Level.INFO,"Se ha actulizado datos de " + result + "profesor", null);
		} catch (Exception e) {
			log( Level.SEVERE,"Error al actualizar datos de la  BBDD", e);
			e.printStackTrace();
		}
	}
	public void borrarDatosProfesores() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM PROFESOR;";			
			int result = stmt.executeUpdate(sql);
			
			log( Level.INFO,"Se ha borrado los profesores",null);
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al actualizando datos de la  BBDD", ex);
			ex.printStackTrace();						
		}		
	}
	
	private void log( Level level, String msg, Throwable excepcion ) {
	
		if (logger==null) {  // Logger por defecto local:
		
			logger = Logger.getLogger( "BD-local" );  // Nombre del logger
			logger.setLevel( Level.ALL );  // Loguea todos los niveles
			try {
				logger.addHandler( new FileHandler( "log/bd.log.xml", true ) );  // Y saca el log a fichero xml
			} catch (Exception e) {
				logger.log( Level.SEVERE, "No se pudo crear fichero de log", e );
			}
		}	
		if (excepcion==null)
			logger.log( level, msg );
		else
			logger.log( level, msg, excepcion );
	}
}
