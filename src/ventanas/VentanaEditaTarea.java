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
	public VentanaEditaTarea (Asignatura asignatura, Gestor gestor , int numeroTarea) {
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
		centro.setLayout(new GridLayout(3,2));
		
		
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

		
		
		
		JButton botonAceptar = new JButton("Edita Tarea");
		JButton botonAtras = new JButton("Atras");
		
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Tarea tarea = new Tarea();
				tarea.setNombre(nombre.getText());
				tarea.setFecha_fin(fechaFin.getText());
				tarea.setCalificacion(-1.0);
				
				//EDITAR TAREA A GESTOR 
				for (Asignatura asig: gestor.getAsignatura()) {
					if(asig.equals(asignatura)) {
						asig.getTareas().get(numeroTarea).setCalificacion(Double.parseDouble(calificacion.getText()));
					
						asig.setNombre(nombre.getText());
					}
				}
// NO SE COMO HACER PARA SABER QUE ASIGNATURA ES 				
//			gestor.getAsignatura().get(1).getTareas().get(numeroTarea).setCalificacion(null);
//			gestor.getAsignatura().get(1).getTareas().get(numeroTarea).setFecha_fin(getName());	
//			gestor.getAsignatura().get(1).getTareas().get(numeroTarea).setNombre(getName());
				
				
				
				Properties properties = Gestor.loadProperties();
				gestor.guardarTareaCSV(properties.getProperty("guardarTarea"));
				//REFESCAR LA TABLA DE ASIGNATURAS
				
				//SE CIERRRA LA VENTANA
				dispose();
			}
		});
		
		
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		centro.add(botonAtras);
		centro.add(botonAceptar);
		
		this.setTitle("Editar Tarea");
		
		this.setSize(600, 400);
		this.setVisible(true);
	}
}
