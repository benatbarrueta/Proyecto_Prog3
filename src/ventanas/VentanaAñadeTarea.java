package ventanas;

import static org.junit.Assert.assertThrows;

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

import clases.Alumno;
import clases.Asignatura;
import clases.Gestor;
import clases.Tarea;

public class VentanaAñadeTarea extends JFrame {

public VentanaAñadeTarea (Asignatura asignatura , Object object) {
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
	centro.setLayout(new GridLayout(3, 2));
	
	//SUR
	JPanel sur = new JPanel();
	cp.add(sur, BorderLayout.SOUTH);
	
	
	// CENTRO
	
	JTextField nombre = new JTextField();
	JLabel labelNombre = new JLabel ("Nombre*: ");
	JTextField fechaFin = new JTextField();
	JLabel labelFechaFin = new JLabel("Fecha finalizar tarea: ");
	
	centro.add(labelNombre);
	centro.add(nombre);
	centro.add(labelFechaFin);
	centro.add(fechaFin);
	
	JButton botonAceptar = new JButton("Añade Tarea");
	JButton botonAtras = new JButton("Atras");
	
	botonAceptar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			//AÑADIR TAREA A GESTOR 
		for (Asignatura asig: gestor.getAsignatura()) {
			if(asig.equals(asignatura)) {	
				for (Alumno alum : asig.getAlumnos()) {
					Tarea tarea = new Tarea();
					tarea.setNombre(nombre.getText());
					tarea.setFecha_fin(fechaFin.getText());
					tarea.setCalificacion(-1.0);
					tarea.setEmailAlumno(alum.getEmail());
					asig.getTareas().add(tarea);
				}
			}
		}		
			// GUARDAR TAREAS
					Properties properties = Gestor.loadProperties();
					gestor.guardarTareaCSV(properties.getProperty("guardarTarea"));
					
			//REFESCAR LA TABLA DE ASIGNATURAS
			
			//SE CIERRRA LA VENTANA
			dispose();
			VentanaAsignatura v = new VentanaAsignatura(object, "Profesor",gestor,asignatura);
		}
	});
	
	
	botonAtras.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			VentanaAsignatura v = new VentanaAsignatura(object, "Profesor",gestor,asignatura);
		}
	});
	
	sur.add(botonAtras);
	sur.add(botonAceptar);
	
	this.setTitle("Añadir Tarea");
	
	this.pack();
	this.setVisible(true);
	
	}
}
