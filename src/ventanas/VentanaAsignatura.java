package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

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
	protected JButton editarTarea;
	protected JButton añadirTarea;
	protected JComboBox comboTareas;
	protected ArrayList<String> nombreTareas;
	protected TreeMap<String, ArrayList<Tarea>> actividadesPorNombre;
	Calendar calendario = Calendar.getInstance();
	protected JButton tareaBoton;
	
	
	public VentanaAsignatura(Object objeto, String tipo, Asignatura asignatura) {
		ArrayList<Tarea> tareasEnTabla = new ArrayList<Tarea>();
		Container cp = this.getContentPane();
		ArrayList<Tarea> listaTarea = new ArrayList<>();
		ArrayList<String> listaTareaCombo = new ArrayList<String>();
	
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		JPanel south = new JPanel();
		cp.setLayout(new BorderLayout());
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		cp.add(south, BorderLayout.SOUTH);
		
		norte.setLayout(new GridLayout(1,1));
		centro.setLayout(new GridLayout(5, 1));
		south.setLayout(new GridLayout(1,4));
		

		
		
		


		
		
		if(tipo.equals("Alumno")) {
			Alumno alumno = (Alumno)objeto;
			for (Tarea t : GestorBD.gestorBD.obtenerDatosTareas()) {
				if(t.getId_alumna()==alumno.getId() && (t.getId_asignatura() == asignatura.getId())) {
					listaTarea.add(t);
				}
			}
			
			modeloTareaLista = new DefaultTableModel(new Object[] { "NOMBRE", "FECHA ENTREGA", "ESTATUS", "CALIFICACION"}, 0);
			tareaLista = new JTable(modeloTareaLista);
		
			String status = "";
			String calificacion = "";
		
				for (Tarea tarea : listaTarea) {
					if (tarea.getCalificacion() >= 5) {
						status = "APROBADO";
						calificacion = "" + tarea.getCalificacion();
					} else if(tarea.getCalificacion() == -1) {
						status = "SIN CALIFICAR";
						calificacion = "";
					} else {
						status = "SUSPENDIDO";
						calificacion = "" + tarea.getCalificacion();
					}
				
				
						modeloTareaLista.addRow(new Object[] {tarea.getNombre(), tarea.getFecha_fin(), status, calificacion, alumno.getNombre()});
					}

				Calendar calendario = new GregorianCalendar();
				
				tareas = new JLabel("Tareas");
				nombreAsig = new JLabel("Asignatura:  " + asignatura.getNombre());
				apuntes = new JLabel("Apuntes");
				
				hora = calendario.get(Calendar.HOUR_OF_DAY);
		 		minutos = calendario.get(Calendar.MINUTE);
				
		 		String	texto=("Hora:  "+ hora + ":" + minutos);
		 		fecha = new JLabel(texto);
				
				centro.add(apuntes);
				centro.add(new JLabel());
				centro.add(tareas);	
				JScrollPane scrollDato = new JScrollPane(tareaLista);
				centro.add(scrollDato);
			
				
		} else {
			ArrayList<String> nombreTareas = new ArrayList<String>();
		
			Profesor profesor = (Profesor) objeto;
			for (Tarea t : GestorBD.gestorBD.obtenerDatosTareas()) {
				if(t.getId_asignatura()== asignatura.getId()) {
					listaTarea.add(t);
				}			
		}
			modeloTareaLista = new DefaultTableModel(new Object[] { "NOMBRE TAREA", "FECHA ENTREGA", "NOMBRE ALUMNO", "CALIFICACION"}, 0);
			tareaLista = new JTable(modeloTareaLista);
		
			String status = "";
			String calificacion = "";
			comboTareas = new JComboBox();
			for (Tarea s : listaTarea) {
			
						if (s.getCalificacion() >= 5) {
							status = "APROBADO";
							calificacion = "" + s.getCalificacion();
						} else if(s.getCalificacion() == -1) {
							status = "SIN CALIFICAR";
							calificacion = "";
						} else {
							status = "SUSPENDIDO";
							calificacion = "" + s.getCalificacion();
						}
						for (Alumno a : GestorBD.gestorBD.obtenerDatosAlumnos()) {
							
							if(a.getId()==s.getId_alumna()) {
								
								modeloTareaLista.addRow(new Object[] {s.getNombre(), s.getFecha_fin(), a.getNombre(), calificacion});				
							}
							
							
						}
						
						
					
				

		
		}
			
		for (Tarea t : GestorBD.gestorBD.obtenerDatosTareas()) {
			if (!listaTareaCombo.contains(t.getNombre())) {
				if (t.getId_asignatura() == asignatura.getId()) {
					listaTareaCombo.add(t.getNombre());
					
				}
			}
		}
		
		for (String t : listaTareaCombo) {
			comboTareas.addItem(t);
		}
			
		añadirTarea = new JButton("Añadir Tarea");
		editarTarea = new JButton("Editar Tarea");
		
			
			
		
	
		
			comboTareas.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String nombreTarea = (String) comboTareas.getSelectedItem();
					String status = "";
					String calificacion = ""; 
					
					while (modeloTareaLista.getRowCount() > 0) {
						modeloTareaLista.removeRow(0);
					}
			
				tareasEnTabla.clear();
					for (Tarea tarea : GestorBD.gestorBD.obtenerDatosTareas()) {
						if (tarea.getNombre().equals(nombreTarea)) {
							
						
						
								if (tarea.getCalificacion() >= 5) {
									status = "APROBADO";
									calificacion = "" + tarea.getCalificacion();
								} else if(tarea.getCalificacion() == -1) {
									status = "SIN CALIFICAR";
									calificacion = "";
								} else {
									status = "SUSPENDIDO";
									calificacion = "" + tarea.getCalificacion();
								}
								tareasEnTabla.add(tarea);
								for (Alumno a : GestorBD.gestorBD.obtenerDatosAlumnos()) {
									if(a.getId()==tarea.getId_alumna()) {
										
										modeloTareaLista.addRow(new Object[] {tarea.getNombre(), tarea.getFecha_fin(), a.getNombre(), calificacion});				
										System.out.println(a);
									}
								}
						}
							}
							tareaLista.repaint();
						}
			});
			
			
			
			añadirTarea.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

				VentanaAñadeTarea v =new VentanaAñadeTarea(asignatura, objeto);
				dispose();
				}
			});
			
			editarTarea.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						int	tareaInt = tareaLista.getSelectedRow();
					tareaLista.getSelectedRow();
					Tarea tarea = tareasEnTabla.get(tareaLista.getSelectedRow());
						VentanaEditaTarea v= new VentanaEditaTarea(asignatura,tarea,  objeto);
						dispose();
				
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "No hay ninguna tarea seleccionada");
					}	
				}
			});	
			

			

			Calendar calendario = new GregorianCalendar();
			
			tareas = new JLabel("Tareas");
			nombreAsig = new JLabel("Asignatura:  " + asignatura.getNombre());
			apuntes = new JLabel("Apuntes");
			
			hora = calendario.get(Calendar.HOUR_OF_DAY);
	 		minutos = calendario.get(Calendar.MINUTE);
			
	 		String	texto=("Hora:  "+ hora + ":" + minutos);
	 		fecha = new JLabel(texto);
			

			south.add(añadirTarea);
			south.add(editarTarea);
			
			JButton crearGrupos = new JButton("Crear Grupos");
			
			south.add(crearGrupos);
			
			
			crearGrupos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					VentanaGrupos v =new VentanaGrupos(asignatura);
				}
			});
			
			
			JPanel panelComboTareas = new JPanel();
			panelComboTareas.setLayout(new GridLayout(1, 2));
			panelComboTareas.add(comboTareas);
			panelComboTareas.add(new JLabel());
			 
			
			centro.add(apuntes);
			centro.add(new JLabel());
			centro.add(tareas);	
			JScrollPane scrollDato = new JScrollPane(tareaLista);
			centro.add(panelComboTareas);
			centro.add(scrollDato);
		
			


			
}
		
	
		
		
		
		
	
		

 		Thread hilo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
				
					
					// TODO Auto-generated method stub
					
				
	
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					minutos=minutos+1;
					if(minutos==60) {
						minutos=0;
						hora=hora+1;
						if(hora==24) {
							hora=0;
						}
					}
				String texto2=("Hora:  "+ hora + ":" + minutos);
					fecha.setText(texto2);
				//	System.out.println(texto2);
					
				}
			
			
		
			}
			
		});
 		
 		hilo.start();
 		
 		

		

		
					
 		
					
			
					
					
			
		
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
				
			
	if (column==2) {

				if (value.toString().equals("SUSPENDIDO")) {
					label.setForeground(Color.RED);
				} else if (value.toString().equals("SIN CALIFICAR")) {
					label.setForeground(Color.GRAY);
				}
	}
				//Es necesaria esta sentencia para pintar correctamente el color de fondo
				label.setOpaque(true);
				
				return label;
			}
		};
	
		
	
		norte.add(nombreAsig);
		norte.add(fecha);
		
		
		this.setTitle(asignatura.getNombre());
		this.setSize(600, 400);
		this.setVisible(true); 
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		tareaLista.getColumnModel().getColumn(0).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(1).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(2).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(3).setCellRenderer(renderSencillo);
		
		

		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
				if (modeloTareaLista.getColumnCount()>4) {
					tareaLista.getColumnModel().getColumn(4).setCellRenderer(renderSencillo);
				}
			}
			
		});
 	
	}
	
	
}
