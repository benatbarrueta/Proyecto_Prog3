package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Asignatura;
import clases.Gestor;
import clases.Tarea;

public class VentanaEditaTarea extends JFrame{
	public VentanaEditaTarea (Asignatura asignatura, Gestor gestor , int numeroTarea, Object object) {
		Container cp = this.getContentPane();
		
		
		
		// CREACIONES
		cp.setLayout(new BorderLayout());
		//NORTE
		JPanel norte = new JPanel();
		cp.add(norte, BorderLayout.NORTH);
		JLabel labelAsig = new JLabel (asignatura.getNombre());
		//CENTRO
		JPanel centro = new JPanel();
		cp.add(centro, BorderLayout.CENTER);
		centro.setLayout(new GridLayout(4,2));
		
		JPanel sur = new JPanel();
		cp.add(sur, BorderLayout.SOUTH);
		
		
		JTextField nombre = new JTextField();
		JLabel labelNombre = new JLabel ("Nombre*: ");
		JTextField fechaFin = new JTextField();
		JLabel labefechaFin = new JLabel("Fecha finalizar tarea: ");
		
		
		JTextField calificacion = new JTextField();
		JLabel labeCalificacion= new JLabel("Calificacion: ");
		
		centro.add(labelNombre);
		centro.add(nombre);
		centro.add(labefechaFin);
		centro.add(fechaFin);
		centro.add(labeCalificacion);
		centro.add(calificacion);
		
		nombre.setText(asignatura.getTareas().get(numeroTarea).getNombre());
		fechaFin.setText(asignatura.getTareas().get(numeroTarea).getFecha_fin());
		calificacion.setText("" + asignatura.getTareas().get(numeroTarea).getCalificacion());
		
		
		JButton botonAceptar = new JButton("Edita Tarea");
		JButton botonAtras = new JButton("Atras");
		
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Tarea tarea = new Tarea();
				tarea.setNombre(nombre.getText());
				tarea.setFecha_fin(fechaFin.getText());
				if (calificacion.getText().equals("")) {
					tarea.setCalificacion(-1.0);
				} else {
					tarea.setCalificacion(Double.parseDouble(calificacion.getText()));
				}
				
				
				//EDITAR TAREA A GESTOR 
				for (Asignatura asig: gestor.getAsignatura()) {
					if(asig.equals(asignatura)) {
						asig.getTareas().get(numeroTarea).setNombre(nombre.getText());
						asig.getTareas().get(numeroTarea).setFecha_fin(fechaFin.getText());
						if (calificacion.getText().equals("")) {
							asig.getTareas().get(numeroTarea).setCalificacion(-1.0);
						} else {
							asig.getTareas().get(numeroTarea).setCalificacion(Double.parseDouble(calificacion.getText()));
						}
						
					}
				}
			
				
				
				Properties properties = Gestor.loadProperties();
				gestor.guardarTareaCSV(properties.getProperty("guardarTarea"));
			
			
				//SE CIERRRA LA VENTANA
				VentanaAsignatura v = new VentanaAsignatura(object, "Profesor",gestor,asignatura);
				dispose();
			}
		});
		
		
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAsignatura v = new VentanaAsignatura(object, "Profesor",gestor,asignatura);
				dispose();
			}
		});
		sur.add(botonAtras);
		sur.add(botonAceptar);
		
		this.setTitle("Editar Tarea");
		
		this.pack();
		this.setVisible(true);
	}
}
