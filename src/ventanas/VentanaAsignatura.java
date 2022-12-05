package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.*;

public class VentanaAsignatura extends JFrame{
	protected JButton cerrar_sesion;
	protected JLabel tareas;
	protected JLabel nombreAsig;
	protected JLabel apuntes;
	protected JLabel fecha;
	protected int hora;
	protected int minutos;
	protected int segundos;
	
	
	Calendar calendario = Calendar.getInstance();
	
	
	
	
	protected JButton tareaBoton;
	public VentanaAsignatura(Object objeto, String tipo, Gestor gestor, Asignatura asignatura) {
		Container cp = this.getContentPane();
		
		
		//DIFERENCIAR SI ENTRA UN ALUMNO O PROFESOR
		if (tipo == "Alumno") {
			Alumno alumno = (Alumno) objeto;
			
		} else {
			Profesor profesor = (Profesor) objeto;
			
		}
		// CREACIONES
		cp.setLayout(new BorderLayout());
		
		
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		tareas = new JLabel("Tareas");
		nombreAsig = new JLabel("Asignatura:  " + asignatura.getNombre());
		apuntes = new JLabel("Apuntes");
		Calendar calendario = new GregorianCalendar();
		boolean ventana = true;
		
			
		
		
		
		
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		
		
		
		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				fecha = new JLabel("Fecha:  "+ hora + ":" + minutos+":" + segundos);
				
			}
			
		});
		hilo.start();
		 
		
		
		
		//ADDS
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		
		
		norte.setLayout(new GridLayout(1,1));
		centro.setLayout(new GridLayout(8,2));
		
		//NORTE
		norte.add(nombreAsig);
		norte.add(fecha);
		
		
		//CENTRO
		centro.add(apuntes);
		centro.add(tareas);
	
		
		
		
		
		this.setTitle(asignatura.getNombre());
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
