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
	protected static final String DATABASE_FILE = "db/s_1.db";
	protected static final String CONNECTION_STRING= "jdbc:sqlite:" + DATABASE_FILE;

	private Logger logger = null;
	public static GestorBD gestorBD = new GestorBD();	
	
	
	public void GestorBD() {		
		try {
			//Cargar el diver SQLite
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException ex) {
			
			log( Level.SEVERE, "Error al cargar el driver de BBDD", ex);
			ex.printStackTrace();
		}
	}
		

	// FUNCIONES DE INSERCION
	

	
	public void insertarDatosAlumno(Alumno a) {
		
		//Se define la plantilla de la sentencia SQL
				String sql = "INSERT INTO ALUMNO  ( ID, NOMBRE, APELLIDO, CONTRASÑEA, DIRECCION, EDAD, EMAIL, CURSO, NOMBRE_USUARIO)  VALUES (?, ?, ?, ?,?, ?, ?, ?,?);";
				
				//Se abre la conexiÃ³n y se crea el PreparedStatement con la sentencia SQL
				try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
					 PreparedStatement pStmt = con.prepareStatement(sql)) {
											
					//Se recorren los clientes y se insertan uno a uno
						//Se definen los parÃ¡metros de la sentencia SQL
						pStmt.setInt(1, a.getId());
						pStmt.setString(2, a.getNombre());
						pStmt.setString(3, a.getApellidos());
						pStmt.setString(4, a.getContraseña());
						pStmt.setString(5, a.getDireccion());
						pStmt.setInt(6, a.getEdad());
						pStmt.setString(7, a.getEmail());
						pStmt.setInt(8, a.getCurso());
						pStmt.setString(9, a.getNombreUsuario());
					
						
						if (pStmt.executeUpdate() != 1) {					
							log( Level.INFO,"Alumno insertado", null);
						} else {
							//Se actualiza el ID del personaje haciendo un Select									
							log( Level.INFO,"No se ha insertado el aluno", null);
						}
					
					log( Level.INFO,"Alumnos insertado", null);
				} catch (Exception ex) {
					log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
				}		
						
					
				
	}
public void insertarDatosProfesor(Profesor a) {
		
		//Se define la plantilla de la sentencia SQL
				String sql = "INSERT INTO PROFESOR  ( ID, NOMBRE, APELLIDO, CONTRASEÑA, DIRECCION, EDAD, EMAIL, SALARIO, NOMBRE_USUARIO)  VALUES (?, ?, ?, ?,?, ?, ?, ?,?);";
				
				//Se abre la conexiÃ³n y se crea el PreparedStatement con la sentencia SQL
				try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
					 PreparedStatement pStmt = con.prepareStatement(sql)) {
											
					//Se recorren los clientes y se insertan uno a uno
						//Se definen los parÃ¡metros de la sentencia SQL
						pStmt.setInt(1, a.getId());
						pStmt.setString(2, a.getNombre());
						pStmt.setString(3, a.getApellidos());
						pStmt.setString(4, a.getContraseña());
						pStmt.setString(5, a.getDireccion());
						pStmt.setInt(6, a.getEdad());
						pStmt.setString(7, a.getEmail());
						pStmt.setInt(8, a.getSalario());
						pStmt.setString(9, a.getNombreUsuario());
					
						
						if (pStmt.executeUpdate() != 1) {					
							log( Level.INFO,"Alumno insertado", null);
						} else {
							//Se actualiza el ID del personaje haciendo un Select									
							log( Level.INFO,"No se ha insertado el aluno", null);
						}
					
					log( Level.INFO,"Alumnos insertado", null);
				} catch (Exception ex) {
					log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
				}		
						
					
				
	}
public void insertarDatosEstudia(Estudia a) {
	
	//Se define la plantilla de la sentencia SQL
			String sql = "INSERT INTO ESTUDIA  ( ID_ALUMNO, ID_ASIGNATURA)  VALUES (?, ?);";
			
			//Se abre la conexiÃ³n y se crea el PreparedStatement con la sentencia SQL
			try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
				 PreparedStatement pStmt = con.prepareStatement(sql)) {
										
				//Se recorren los clientes y se insertan uno a uno
					//Se definen los parÃ¡metros de la sentencia SQL
					pStmt.setInt(1, a.getId_alumno());
					pStmt.setInt(2, a.getId_asignatura());
				
					
					if (pStmt.executeUpdate() != 1) {					
						log( Level.INFO,"Alumno insertado", null);
					} else {
						//Se actualiza el ID del personaje haciendo un Select									
						log( Level.INFO,"No se ha insertado el aluno", null);
					}
				
				log( Level.INFO,"Alumnos insertado", null);
			} catch (Exception ex) {
				log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
			}		
					
				
			
}
	
	public void insertarDatosTarea(Tarea... tarea) {
		//Se define la plantilla de la sentencia SQL
		String sql = "INSERT INTO TAREA ( ID, NOMBRE,  FECHA_FIN, CALIFICACION, ID_ASIGNATURA, ID_ALUMNO, PORCENTAJE) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		//Se abre la conexiÃ³n y se crea el PreparedStatement con la sentencia SQL
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			 PreparedStatement pStmt = con.prepareStatement(sql)) {
									
			//Se recorren los clientes y se insertan uno a uno
			for (Tarea t : tarea) {
				//Se definen los parÃ¡metros de la sentencia SQL
				pStmt.setInt(1, t.getId());
				pStmt.setString(2, t.getNombre());
				pStmt.setString(3, t.getFecha_fin());
				pStmt.setInt(4, t.getCalificacion());
				pStmt.setInt(5, t.getId_asignatura());
				pStmt.setInt(6, t.getId_alumna());
				pStmt.setInt(7, t.getPorcentaje());
				
				if (pStmt.executeUpdate() != 1) {					
					logger.warning(String.format("No se ha insertado la tarea: %s", t));
				} else {
					//Se actualiza el ID del personaje haciendo un Select									
					logger.info(String.format("Se ha insertado la tarea: %s", t));
				}
			}
			
			logger.info(String.format("%d Tareas insertadas en la BBDD", tarea.length));
		} catch (Exception ex) {
			logger.warning(String.format("Error al insertar Tareas: %s", ex.getMessage()));
		}			
	}
	
	public void insertarDatosAsignatura(Asignatura a) {
		
		//Se define la plantilla de la sentencia SQL
				String sql = "INSERT INTO ASIGNATURA  (ID , NOMBRE, ID_PROFESOR)  VALUES (?, ?, ?);";
				
				//Se abre la conexiÃ³n y se crea el PreparedStatement con la sentencia SQL
				try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
					 PreparedStatement pStmt = con.prepareStatement(sql)) {
											
					//Se recorren los clientes y se insertan uno a uno
						//Se definen los parÃ¡metros de la sentencia SQL
						pStmt.setInt(1, a.getId());
						pStmt.setString(2, a.getNombre());
						pStmt.setInt(3, a.getId_profesor());
					
						
						if (pStmt.executeUpdate() != 1) {					
							log( Level.INFO,"Alumno insertado", null);
						} else {
							//Se actualiza el ID del personaje haciendo un Select									
							log( Level.INFO,"No se ha insertado el aluno", null);
						}
					
					log( Level.INFO,"Alumnos insertado", null);
				} catch (Exception ex) {
					log( Level.SEVERE,"Error al insertar datos en la  BBDD", ex);
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
				alumno.setContraseña(rs.getString("CONTRASÑEA"));
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
				tarea.setPorcentaje(Integer.parseInt(rs.getString("PORCENTAJE")));
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
				asignatura.setId_profesor(rs.getInt("ID_PROFESOR"));
				
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
			String sql = "UPDATE ALUMNO SET NOMBRE = '%s', APELLIDO = '%s', EMAIL = '%s', DIRECCION = '%s', NOMBRE_USUARIO = '%s', CONTRASÑEA = '%s' WHERE ID = %d;";
			int result = stmt.executeUpdate(String.format(sql, newNombre, newApellido, newEmail, newDirection, newNombreUsuario, newContraseña, alumno.getId()));
			
			log( Level.INFO,"Se ha actulizado los datos de " + result + " alumno",null);
			
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
	
	public void actualizarTarea(Tarea tarea, String newNombre, String fechaFin, String Calificacion, int porcentaje) {
		//Se abre la conexion y obtenemos el statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			 Statement stmt = con.createStatement()){
			//Se ejecuta la sentencia de actualizar datos
			String sql = "UPDATE TAREA SET NOMBRE = '%s', FECHA_FIN = '%s', CALIFICACION = '%D', PORCENTAJE = '%s';";
			int result = stmt.executeUpdate(String.format(sql, newNombre, fechaFin, Calificacion, porcentaje, tarea.getId()));
			
		
			log( Level.INFO,"Se ha actulizado datos de " + result + "tarea", null);
		} catch (Exception e) {
			log( Level.SEVERE,"Error al actualizar datos de la  BBDD", e);
			e.printStackTrace();
		} 
	}
	
	
	public void actualizarAsignatura(Asignatura asignatura, String newNombre, int id_profesor) {
		//Se abre la conexion y obtenemos el statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
			 Statement stmt = con.createStatement()){
			//Se ejecuta la sentencia de actualizar datos
			String sql = "UPDATE ASIGNATURA SET NOMBRE = '%s', ID_PROFESOR = '%d' WHERE ID = %d;";
			int result = stmt.executeUpdate(String.format(sql, newNombre, id_profesor, asignatura.getId()));
			
		
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
	public void borrarDatosTareas() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM TAREA;";			
			int result = stmt.executeUpdate(sql);
			
			log( Level.INFO,"Se ha borrado las tarea",null);
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al actualizando datos de la  BBDD en tareas", ex);
			ex.printStackTrace();						
		}		
	}
	public void borrarDatosAsignaturas() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM ASIGNATURA;";			
			int result = stmt.executeUpdate(sql);
			
			log( Level.INFO,"Se ha borrado las asignaturas",null);
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al actualizando datos de la  BBDD en asignaturas", ex);
			ex.printStackTrace();						
		}		
	}
	public void borrarDatosEstudia() {
		//Se abre la conexión y se obtiene el Statement
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING);
		     Statement stmt = con.createStatement()) {
			//Se ejecuta la sentencia de borrado de datos
			String sql = "DELETE FROM ESTUDIA;";			
			int result = stmt.executeUpdate(sql);
			
			log( Level.INFO,"Se ha borrado los datos de la tabla estudia",null);
		} catch (Exception ex) {
			log( Level.SEVERE,"Error al actualizando datos de la  BBDD en estudia", ex);
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
