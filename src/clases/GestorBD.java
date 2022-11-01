package clases;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.deusto.prog3.practica3c.Cliente;

import java.sql.*;
public class GestorBD {

	protected static final String DRIVER_NAME = "lib/sqlite-jdbc";
	protected static final String DATABASE_FILE_ALUMNO = "db/databaseprofesor.db";
	protected static final String DATABASE_FILE_PROFESOR = "db/databasealumno.db";
	protected static final String CONNECTION_STRING_ALUMNO = "jdbc:sqlite:" + DATABASE_FILE_ALUMNO;
	protected static final String CONNECTION_STRING_PROFESOR = "jdbc:sqlite:" + DATABASE_FILE_PROFESOR;
	
	public GestorBD() {		
		try {
			//Cargar el diver SQLite
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			System.err.println(String.format("* Error al cargar el driver de BBDD: %s", ex.getMessage()));
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
	        	System.out.println("- Se ha creado la tabla Alumno");
	        }
		} catch (Exception ex) {
			System.err.println(String.format("* Error al crear la BBDD: %s", ex.getMessage()));
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
	        	System.out.println("- Se ha creado la tabla Profesor");
	        }
		} catch (Exception ex) {
			System.err.println(String.format("* Error al crear la BBDD: %s", ex.getMessage()));
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
	        	System.out.println("- Se ha borrado la tabla Alumno");
	        }
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE_ALUMNO));
			System.out.println("- Se ha borrado el fichero de la BBDD");
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar el archivo de la BBDD: %s", ex.getMessage()));
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
	        	System.out.println("- Se ha borrado la tabla Profesor*");
	        }
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();			
		}
		
		try {
			//Se borra el fichero de la BBDD
			Files.delete(Paths.get(DATABASE_FILE_PROFESOR));
			System.out.println("- Se ha borrado el fichero de la BBDD");
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar el archivo de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}
	}
	
	public void insertarDatosAlumno(Alumno... alumno) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO ALUMNO ( NOMBRE, APELLIDO, CONTRASEÑA, DIRECCION, EDAD, EDAD, CURSO, NOMBRE_USUARIO) VALUES ('%s', '%s', '%s', '%s', '%d', '%s', '%s');";
			
			System.out.println("- Insertando alumnos...");
			
			//Se recorren los clientes y se insertan uno a uno
			for (Alumno c : alumno) {
				if (1 == stmt.executeUpdate(String.format(sql, c.getNombre(), c.getApellidos(), c.getContraseña(), c.getDireccion(),  c.getEdad(), c.getEmail(), c.getCurso(), c.getNombreUsuario()))) {					
					System.out.println(String.format(" - Alumno insertado: %s", c.toString()));
				} else {
					System.out.println(String.format(" - No se ha insertado el alumno: %s", c.toString()));
				}
			}			
		} catch (Exception ex) {
			System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}				
	}
	
	public void insertarDatosProfesor(Profesor... profesor) {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
		     Statement stmt = con.createStatement()) {
			//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO PROFESOR ( NOMBRE, APELLIDO, CONTRASEÑA, DIRECCION, EDAD, EMAIL, SALARIO, NOMBRE_USUARIO) VALUES ('%s', '%s', '%s', '%s', '%d', '%d', '%s');";
			
			System.out.println("- Insertando profesores...");
			
			//Se recorren los clientes y se insertan uno a uno
			for (Profesor c : profesor) {
				if (1 == stmt.executeUpdate(String.format(sql, c.getNombre(), c.getApellidos(), c.getContraseña(), c.getDireccion(),  c.getEdad(), c.getEmail(), c.getSalario(), c.getNombreUsuario()))) {					
					System.out.println(String.format(" - Profesor insertado: %s", c.toString()));
				} else {
					System.out.println(String.format(" - No se ha insertado el profesor: %s", c.toString()));
				}
			}			
		} catch (Exception ex) {
			System.err.println(String.format("* Error al insertar datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}				
	}
	
	
	public ArrayList<Alumno> obtenerDatosAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
		     Statement stmt = con.createStatement()) {
			String sql = "SELECT * FROM ALUMNO WHERE ID >= 0";
			
			
			//Se ejecuta la sentencia y se obtiene el ResultSet con los resutlados
			ResultSet rs = stmt.executeQuery(sql);			
			Alumno alumno;
			
			//Se recorre el ResultSet y se crean objetos Cliente
			while (rs.next()) {
				alumno= new Alumno();
				alumno.setId(rs.getInt("ID"));
				alumno.setNombre(rs.getString("NOMBRE"));
				alumno.setApellidos(rs.getString("NOMBRE"));
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
			
			System.out.println(String.format("- Se han recuperado %d alumnos...", alumnos.size()));			
		} catch (Exception ex) {
			System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
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
				profesor.setApellidos(rs.getString("NOMBRE"));
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
			
			System.out.println(String.format("- Se han recuperado %d profesores...", profesores.size()));			
		} catch (Exception ex) {
			System.err.println(String.format("* Error al obtener datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		
		
		return profesores;
	}


	public void borrarDatosAlumnos() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_ALUMNO);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM ALUMNO;";			
			int result = stmt.executeUpdate(sql);
			
			System.out.println(String.format("- Se han borrado %d alumnos", result));
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		
	}	
	public void actualizarPasswordAlumno(Alumno alumno, String newPassword) {
		//Se abre la conexiÃ³n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE CLIENTE SET PASSWORD = '%s' WHERE ID = %d;";
			
			int result = stmt.executeUpdate(String.format(sql, newPassword, cliente.getId()));
			
			System.out.println(String.format("- Se ha actulizado %d clientes", result));
		} catch (Exception ex) {
			System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		
	}
	public void actualizarPasswordProfesor(Cliente cliente, String newPassword) {
		//Se abre la conexiÃ³n y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "UPDATE CLIENTE SET PASSWORD = '%s' WHERE ID = %d;";
			
			int result = stmt.executeUpdate(String.format(sql, newPassword, cliente.getId()));
			
			System.out.println(String.format("- Se ha actulizado %d clientes", result));
		} catch (Exception ex) {
			System.err.println(String.format("* Error actualizando datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		
	}
	public void borrarDatosProfesores() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING_PROFESOR);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM PROFESOR;";			
			int result = stmt.executeUpdate(sql);
			
			System.out.println(String.format("- Se han borrado %d profesores", result));
		} catch (Exception ex) {
			System.err.println(String.format("* Error al borrar datos de la BBDD: %s", ex.getMessage()));
			ex.printStackTrace();						
		}		
	}
}
