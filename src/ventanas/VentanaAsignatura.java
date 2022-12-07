package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import clases.*;

public class VentanaAsignatura extends JFrame{
	protected JButton cerrar_sesion;
	protected JLabel tareas;
	protected JLabel nombreAsig;
	protected JLabel apuntes;
	protected JLabel fecha;
	protected JTable tareaLista;
	protected DefaultTableModel modeloTareaLista;
	protected int hora;
	protected int minutos;
	protected int segundos;
	
	
	Calendar calendario = Calendar.getInstance();
	
	
	
	
	protected JButton tareaBoton;
	public VentanaAsignatura(Object objeto, String tipo, Gestor gestor, Asignatura asignatura) {
		Container cp = this.getContentPane();
		
		
		
		// CREACIONES
		cp.setLayout(new BorderLayout());
		ArrayList<Tarea> listaTarea = gestor.getTarea();
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		tareas = new JLabel("Tareas");
		nombreAsig = new JLabel("Asignatura:  " + asignatura.getNombre());
		apuntes = new JLabel("Apuntes");
		Calendar calendario = new GregorianCalendar();
		modeloTareaLista = new DefaultTableModel(
				new Object[] { "NOMBRE", "FECHA ENTREGA", "ESTATUS", "CALIFICACION", objeto}, 0);
		tareaLista = new JTable(modeloTareaLista);
//		boolean ventana = true;
		
		
		
		//DIFERENCIAR SI ENTRA UN ALUMNO O PROFESOR
				if (tipo == "Alumno") {
					Alumno alumno = (Alumno) objeto;
					String status = "";
					for (Tarea tarea : listaTarea) {
						if (tarea.getCalificacion() >= 5) {
							status = "APROBADO";
						} else {
							status = "SUSPENDIDO";
						}
						modeloTareaLista.addRow(new Object[] {tarea.getNombre(), tarea.getFecha_fin(), status, tarea.getCalificacion(), alumno.getNombre()});
					}
					
				} else {
					Profesor profesor = (Profesor) objeto;
					
				}
		
		
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		fecha = new JLabel("Fecha:  "+ hora + ":" + minutos+":" + segundos);
		
		
//		Thread hilo = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				fecha = new JLabel("Fecha:  "+ hora + ":" + minutos+":" + segundos);
//				
//			}
//			
//		});
//		hilo.start();
		 
		
		
		
		//ADD
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
