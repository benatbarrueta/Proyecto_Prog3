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
	protected static final String DATABASE_FILE_ALUMNO = "db/databaseprofesor.db";
	protected static final String DATABASE_FILE_PROFESOR = "db/databasealumno.db";
	protected static final String CONNECTION_STRING_ALUMNO = "jdbc:sqlite:" + DATABASE_FILE_ALUMNO;
	protected static final String CONNECTION_STRING_PROFESOR = "jdbc:sqlite:" + DATABASE_FILE_PROFESOR;
	
	private Logger logger = null;
	public static GestorBD gestorBD;	
	
	
	public GestorBD() {		
		try {
			//Cargar el diver SQLite
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			
			log( Level.WARNING, "Error al cargar el driver de BBDD", ex);
			ex.printStackTrace();
		}
	}
		
	public void crearBBDDAlumno() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
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
	      
	        	log( Level.INFO,"Se ha creado la tabla ALUMNO", null);
	        }
		} catch (Exception ex) {
		
			log( Level.WARNING,"Error al crear la  BBDD", ex);
			ex.printStackTrace();			
		}
	}
	public void crearBBDDProfesor() {
		//Se abre la conexión y se obtiene el Statement
		//Al abrir la conexión, si no existía el fichero, se crea la base de datos
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
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
	        
	        	log( Level.INFO,"Se ha creado la tabla PROFESOR", null);
				
	        }
		} catch (Exception ex) {
			
			
			log( Level.WARNING,"Error al crear la  BBDD", ex);
			ex.printStackTrace();			
		}
	}
	
	public void borrarBBDDAlumno() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "DROP TABLE IF EXISTS ALUMNO";
			
	        //Se ejecuta la sentencia de creación de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        
	        	log( Level.INFO,"Se ha borrado la tabla ALUMNO", null);
	        }
		} catch (Exception ex) {
			log( Level.WARNING,"Error al borrar la  BBDD", ex);
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE_ALUMNO));
			
			log( Level.INFO,"Se ha borrado el fichero de la BD", null);
		} catch (Exception ex) {
		
			
			log( Level.WARNING,"Error al borrar el archivo de la  BBDD", ex);
			ex.printStackTrace();						
		}
	}
	public void borrarBBDDProfesor() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
		     Statement stmt = con.createStatement()) {
			
	        String sql = "DROP TABLE IF EXISTS PROFESOR";
			
	        //Se ejecuta la sentencia de creación de la tabla Estudiantes
	        if (!stmt.execute(sql)) {
	        	
				log( Level.INFO,"Se ha borrado la tabla profesor", null);
	        
	        }
		} catch (Exception ex) {
			log( Level.WARNING,"Error al borrar la  BBDD", ex);
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE_PROFESOR));
			log( Level.INFO,"Se ha borrado el fichero de la BBDD", null);
		} catch (Exception ex) {
		
			log( Level.WARNING,"Error al borrar el archivo de la  BBDD", ex);
	
			ex.printStackTrace();						
		}
	}
	
	public void insertarDatosAlumno(Alumno... alumno) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO ALUMNO ( NOMBRE, APELLIDO, CONTRASEÑA, DIRECCION, EDAD, EMAIL, CURSO, NOMBRE_USUARIO) VALUES ( '%s', '%s', '%s', '%s', '%d','%s', '%s', '%s');";
			
			log( Level.INFO,"Insertando alumnos...", null);

		
			//Se recorren los clientes y se insertan uno a uno
			for (Alumno c : alumno) {
				
				if (1 == stmt.executeUpdate(String.format(sql, c.getNombre(), c.getApellidos(), c.getContraseña(), c.getDireccion(),  c.getEdad(), c.getEmail(), c.getCurso(), c.getNombreUsuario()))) {					
					
					log( Level.INFO,"Alumno insertado", null);
				} else {
				
					log( Level.INFO,"No se ha insertado el aluno", null);
				}
			}			
		} catch (Exception ex) {

			log( Level.WARNING,"Error al insertar datos en la  BBDD", ex);
			ex.printStackTrace();						
		}				
	}
	
	public void insertarDatosProfesor(Profesor... profesor) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO PROFESOR ( NOMBRE, APELLIDO, CONTRASEÑA, DIRECCION, EDAD, EMAIL, SALARIO, NOMBRE_USUARIO) VALUES ('%s', '%s', '%s', '%s', '%d','%s', '%f', '%s');";
			
		
			log( Level.INFO, "Insertando profesores...", null);
			//Se recorren los clientes y se insertan uno a uno
			for (Profesor c : profesor) {
				if (1 == stmt.executeUpdate(String.format(sql, c.getNombre(), c.getApellidos(), c.getContraseña(), c.getDireccion(),  c.getEdad(), c.getEmail(), c.getSalario(), c.getNombreUsuario()))) {					
					System.out.println(String.format(" - Profesor insertado: %s", c.toString()));

					log( Level.INFO, "Profesor insertado "+c.toString(), null);
				} else {
					
					log( Level.INFO, "No se ha insertado el profesor "+c.toString(), null);
				}
			}			
		} catch (Exception ex) {
		
			log( Level.WARNING,"Error al insertar datos en la  BBDD", ex);
			ex.printStackTrace();						
		}				
	}
	
	
	public ArrayList<Alumno> obtenerDatosAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
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
				alumno.setCurso(rs.getString("CURSO"));
				alumno.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
			
				
				//Se inserta cada nuevo cliente en la lista de clientes
				alumnos.add(alumno);
			}
			
			//Se cierra el ResultSet
			rs.close();
		
			log( Level.INFO,"Se han recuperado alunos", null);
		} catch (Exception ex) {
		
			log( Level.WARNING,"Error al obtener datos de la  BBDD", ex);
			ex.printStackTrace();						
		}		
		
		return alumnos;
	}
	public ArrayList<Profesor> obtenerDatosProfesor() {
		ArrayList<Profesor> profesores = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
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
			log( Level.WARNING,"Error al obtener datos de la  BBDD", ex);
		
			ex.printStackTrace();						
		}		
		//System.out.println(profesores);
		return profesores;
	}


	public void borrarDatosAlumnos() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM ALUMNO;";			
			int result = stmt.executeUpdate(sql);
			
			log( Level.INFO,"Se han borrado alumnos ", null);
		} catch (Exception ex) {
		
			log( Level.WARNING,"Error al borrar datos de la  BBDD", ex);
			
			ex.printStackTrace();						
		}		
	}	
	public void actualizarPasswordAlumno(Alumno alumno, String newPassword) {
		//Se abre la conexiÃ³n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE ALUMNO SET CONTRASEÑA = '%s' WHERE ID = %d;";
	
			
			int result = stmt.executeUpdate(String.format(sql, newPassword, alumno.getId()));
			log( Level.INFO,"Se han actualizado alumnos ", null);
		
			
			//	System.out.println();
		} catch (Exception ex) {
		
			log( Level.WARNING,"Error al actualizando datos de la  BBDD", ex);
			ex.printStackTrace();						
		}		
	}
	public void actualizarPaswordProfesor(Profesor profesor, String newPassword) {
		//Se abre la conexiÃ³n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE PROFESOR SET CONTRASEÑA = '%s' WHERE ID = %d;";
			
			int result = stmt.executeUpdate(String.format(sql, newPassword, profesor.getId()));
			
			log( Level.INFO,"Se ha actulizado la contraseña del profesor",null);
		} catch (Exception ex) {
			log( Level.WARNING,"Error al actualizando datos de la  BBDD", ex);
			ex.printStackTrace();						
		}		
	}
	public void actualizarAlumno(Alumno alumno, String newNombre, String newApellido, String newEmail, String newDirection, String newNombreUsuario, String newContraseña) {
		//Se abre la conexion y obtenemos el statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
			 Statement stmt = con.createStatement()){
			//Se ejecuta la sentencia de actualizar datos
			String sql = "UPDATE ALUMNO SET NOMBRE = '%s', APELLIDO = '%s', EMAIL = '%s', DIRECCION = '%s', NOMBRE_USUARIO = '%s', CONTRASEÑA = '%s' WHERE ID = %d;";
			int result = stmt.executeUpdate(String.format(sql, newNombre, newApellido, newEmail, newDirection, newNombreUsuario, newContraseña, alumno.getId()));
			
			log( Level.INFO,"Se ha actulizado los datos de " + result + "alumno",null);
			
		} catch (Exception e) {
			log( Level.WARNING,"Error al actualizar datos de la  BBDD", e);
			e.printStackTrace();
		}
	}
	
	public void actualizarProfesor(Profesor profesor, String newNombre, String newApellido, String newEmail, String newDirection, String newNombreUsuario, String newContraseña) {
		//Se abre la conexion y obtenemos el statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
			 Statement stmt = con.createStatement()){
			//Se ejecuta la sentencia de actualizar datos
			String sql = "UPDATE PROFESOR SET NOMBRE = '%s', APELLIDO = '%s', EMAIL = '%s', DIRECCION = '%s', NOMBRE_USUARIO = '%s', CONTRASEÑA = '%s' WHERE ID = %d;";
			int result = stmt.executeUpdate(String.format(sql, newNombre, newApellido, newEmail, newDirection, newNombreUsuario, newContraseña, profesor.getId()));
			
		
			log( Level.INFO,"Se ha actulizado datos de " + result + "profesor", null);
		} catch (Exception e) {
			log( Level.WARNING,"Error al actualizar datos de la  BBDD", e);
			//e.printStackTrace();
		}
	}
	public void borrarDatosProfesores() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM PROFESOR;";			
			int result = stmt.executeUpdate(sql);
			
			log( Level.INFO,"Se ha borrado los profesores",null);
		} catch (Exception ex) {
			log( Level.WARNING,"Error al actualizando datos de la  BBDD", ex);
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
