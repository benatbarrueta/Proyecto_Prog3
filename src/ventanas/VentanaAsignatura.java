package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
	protected JButton editarTarea;
	protected JButton añadirTarea;
	Calendar calendario = Calendar.getInstance();
	
	
	
	
	protected JButton tareaBoton;
	public VentanaAsignatura(Object objeto, String tipo, Gestor gestor, Asignatura asignatura) {
		
		Container cp = this.getContentPane();
		
		
		
		// CREACIONES
		cp.setLayout(new BorderLayout());
		ArrayList<Tarea> listaTarea = asignatura.getTareas();
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		JPanel south = new JPanel();
		Calendar calendario = new GregorianCalendar();
		
		tareas = new JLabel("Tareas");
		nombreAsig = new JLabel("Asignatura:  " + asignatura.getNombre());
		apuntes = new JLabel("Apuntes");
		

		
		
		
		//DIFERENCIAR SI ENTRA UN ALUMNO O PROFESOR
				if (tipo == "Alumno") {
					modeloTareaLista = new DefaultTableModel(new Object[] { "NOMBRE", "FECHA ENTREGA", "ESTATUS", "CALIFICACION"}, 0);
					tareaLista = new JTable(modeloTareaLista);
					Alumno alumno = (Alumno) objeto;
					String status = "";
					for (Tarea tarea : listaTarea) {
						if (tarea.getCalificacion() >= 5) {
							status = "APROBADO";
						} else if(tarea.getCalificacion()==-1){
							status= "SIN CALIFICAR";
						}else {
							status = "SUSPENDIDO";
						}
						modeloTareaLista.addRow(new Object[] {tarea.getNombre(), tarea.getFecha_fin(), status, tarea.getCalificacion(), alumno.getNombre()});
					}
					
				} else {
					modeloTareaLista = new DefaultTableModel(new Object[] { "NOMBRE ALUMNO", "NOMBRE TAREA","FECHA ENTREGA", "ESTATUS", "CALIFICACION"}, 0);
					tareaLista = new JTable(modeloTareaLista);
					Profesor profesor = (Profesor) objeto;
					String status = "";
					for (Tarea tarea : listaTarea) {
						if (tarea.getCalificacion() >= 5) {
							status = "APROBADO";
						} else if(tarea.getCalificacion().equals(-1.0)){
							status = "SIN CALIFICAR";
						}else {
							status = "SUSPENDIDO";
						}
						
						modeloTareaLista.addRow(new Object[] {"NOMBRE ALUMNO NO SE PONERLO",tarea.getNombre(), tarea.getFecha_fin(), status, tarea.getCalificacion()});
						
					}
					//SUR
					
					
					añadirTarea = new JButton("Añadir Tarea");
					editarTarea = new JButton("Editar Tarea");
					
					south.add(añadirTarea);
					south.add(editarTarea);
					
					
					añadirTarea.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {

						VentanaAñadeTarea v =new VentanaAñadeTarea(asignatura, gestor, objeto);
						dispose();
						}
					});
					
					editarTarea.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int	tareaInt = tareaLista.getSelectedRow();
							
							VentanaEditaTarea v= new VentanaEditaTarea(asignatura,gestor,tareaInt,objeto);
							dispose();
						}
					});
					
				}
		
		
				fecha = new JLabel("Fecha:  "+ hora + ":" + minutos+":" + segundos);
		
		
//		Thread hilo = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				while (true) {
//					hora = calendario.get(Calendar.HOUR_OF_DAY);
//					minutos = calendario.get(Calendar.MINUTE);
//					segundos = calendario.get(Calendar.SECOND);
//					fecha = new JLabel("Fecha:  "+ hora + ":" + minutos+":" + segundos);
//					try {
//						Thread.sleep(1000); 
//						
//
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//				}
//				
//				
//			}
//			
//		});
//		hilo.start();
		
		//ADD
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		cp.add(south, BorderLayout.SOUTH);
		
		norte.setLayout(new GridLayout(1,1));
		centro.setLayout(new GridLayout(4,2));
		south.setLayout(new GridLayout(1,4));
		//NORTE
		norte.add(nombreAsig);
		norte.add(fecha);
		
		
		//CENTRO
		centro.add(apuntes);
		centro.add(new JLabel());
		centro.add(tareas);
		JScrollPane scrollDato = new JScrollPane(tareaLista);
		centro.add(scrollDato);
	
		
		
		
		this.setTitle(asignatura.getNombre());
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		DefaultTableCellRenderer renderSencillo = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				JLabel label = new JLabel(value.toString());
				
				
				//El label se alinea a la izquierda
				if(column == 0 || column == 1) {
					label.setHorizontalAlignment(JLabel.LEFT);
				}else if(column == 2) {
					label.setHorizontalAlignment(JLabel.CENTER);
				}
				label.setBackground(Color.WHITE);
				
				if(isSelected) {
					label.setBackground(Color.CYAN);
				}
				if (listaTarea.get(row).getCalificacion() < 5) {
					label.setForeground(Color.RED);
				}
				
				//Es necesaria esta sentencia para pintar correctamente el color de fondo
				label.setOpaque(true);
				
				return label;
			}
		};

		
		tareaLista.getColumnModel().getColumn(0).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(1).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(2).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(3).setCellRenderer(renderSencillo);
		if(modeloTareaLista.getColumnCount()>4) {
			tareaLista.getColumnModel().getColumn(4).setCellRenderer(renderSencillo);
		}
		
	}
	
	
	
}
