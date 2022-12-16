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
	protected JButton editarTarea;
	protected JButton añadirTarea;
	protected JComboBox comboTareas;
	protected ArrayList<String> nombreTareas;
	Calendar calendario = Calendar.getInstance();
	
	
	
	
	protected JButton tareaBoton;
	public VentanaAsignatura(Object objeto, String tipo, Gestor gestor, Asignatura asignatura) {
		
		Container cp = this.getContentPane();
		
		
		
		// CREACIONES
		cp.setLayout(new BorderLayout());
		ArrayList<Tarea> listaTarea = asignatura.getTareas();
		ArrayList<String> nombreTareas = new ArrayList<String>();
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		JPanel south = new JPanel();
		JPanel panelComboTareas = new JPanel();
		Calendar calendario = new GregorianCalendar();
		
		tareas = new JLabel("Tareas");
		nombreAsig = new JLabel("Asignatura:  " + asignatura.getNombre());
		apuntes = new JLabel("Apuntes");
		

		hora = calendario.get(Calendar.HOUR_OF_DAY);
 		minutos = calendario.get(Calendar.MINUTE);
 		fecha = new JLabel("Ultima entrada:  "+ hora + ":" + minutos);
		
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
				
				if (listaTarea.get(row).getCalificacion() < 5 && listaTarea.get(row).getCalificacion() > 0) {
					label.setForeground(Color.RED);
				} else if (listaTarea.get(row).getCalificacion() < 0) {
					label.setForeground(Color.GRAY);
				}
				
				//Es necesaria esta sentencia para pintar correctamente el color de fondo
				label.setOpaque(true);
				
				return label;
			}
		};
		
		//DIFERENCIAR SI ENTRA UN ALUMNO O PROFESOR
				if (tipo == "Alumno") {
					modeloTareaLista = new DefaultTableModel(new Object[] { "NOMBRE", "FECHA ENTREGA", "ESTATUS", "CALIFICACION"}, 0);
					tareaLista = new JTable(modeloTareaLista);
					Alumno alumno = (Alumno) objeto;
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
						
						if (tarea.getEmailAlumno().equals(alumno.getEmail())) {
							modeloTareaLista.addRow(new Object[] {tarea.getNombre(), tarea.getFecha_fin(), status, calificacion, alumno.getNombre()});
						}
					}
					
				} else {
					modeloTareaLista = new DefaultTableModel(new Object[] { "EMAIL ALUMNO", "FECHA ENTREGA", "ESTATUS", "CALIFICACION"}, 0);
					tareaLista = new JTable(modeloTareaLista);
					Profesor profesor = (Profesor) objeto;
					String status = "";
					String calificacion = "";
					for (Tarea tarea : listaTarea) {
						if(tarea.getNombre().equals("Actividad 1")) {
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
							
							modeloTareaLista.addRow(new Object[] {tarea.getEmailAlumno(), tarea.getFecha_fin(), status, calificacion});
						}
						
					}
					
						

					
					for (Tarea tarea : listaTarea) {
						if (!nombreTareas.contains(tarea.getNombre())) {
							nombreTareas.add(tarea.getNombre());
						}
					}
					
					comboTareas = new JComboBox();
					for (String s : nombreTareas) {
						comboTareas.addItem(s);
					}
					
					comboTareas.setSelectedItem("Clicka para ver las tareas");
					
					panelComboTareas.setLayout(new GridLayout(1, 2));
					panelComboTareas.add(comboTareas);
					panelComboTareas.add(new JLabel());
					
					comboTareas.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							String nombreTarea = (String) comboTareas.getSelectedItem();
							String status = "";
							String calificacion = "";
							
							while (modeloTareaLista.getRowCount() > 0) {
								modeloTareaLista.removeRow(0);
							}
							for (Tarea tarea : listaTarea) {
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
									modeloTareaLista.addRow(new Object[] {asignatura.getTareas().get(0).getEmailAlumno(), asignatura.getTareas().get(0).getFecha_fin(), status, calificacion});

								}
							}
							tareaLista.repaint();
						}
					});
					
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
							try {
								int	tareaInt = tareaLista.getSelectedRow();
							
								VentanaEditaTarea v= new VentanaEditaTarea(asignatura,gestor,tareaInt,objeto);
								dispose();
						
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "No hay ninguna tarea seleccionada");
							}	
						}
					});
					
				}
		
		//ADD
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		cp.add(south, BorderLayout.SOUTH);
		
		norte.setLayout(new GridLayout(1,1));
		centro.setLayout(new GridLayout(5, 1));
		south.setLayout(new GridLayout(1,4));
		//NORTE
		norte.add(nombreAsig);
		norte.add(fecha);
		
		
		//CENTRO
		centro.add(apuntes);
		centro.add(new JLabel());
		centro.add(tareas);
		centro.add(panelComboTareas);
		JScrollPane scrollDato = new JScrollPane(tareaLista);
		centro.add(scrollDato);
	
		
		
		
		this.setTitle(asignatura.getNombre());
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		tareaLista.getColumnModel().getColumn(0).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(1).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(2).setCellRenderer(renderSencillo);
		tareaLista.getColumnModel().getColumn(3).setCellRenderer(renderSencillo);
		if(modeloTareaLista.getColumnCount()>4) {
			tareaLista.getColumnModel().getColumn(4).setCellRenderer(renderSencillo);
		}
		
	}
	
	
	
}
