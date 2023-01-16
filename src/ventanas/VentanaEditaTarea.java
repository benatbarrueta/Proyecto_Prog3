package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Asignatura;
import clases.Gestor;
import clases.GestorBD;
import clases.Tarea;

public class VentanaEditaTarea extends JFrame {
	public VentanaEditaTarea(Asignatura asignatura, Tarea tarea, Object objeto) {
		Container cp = this.getContentPane();

		// CREACIONES
		cp.setLayout(new BorderLayout());
		// NORTE
		JPanel norte = new JPanel();
		cp.add(norte, BorderLayout.NORTH);
		JLabel labelAsig = new JLabel(asignatura.getNombre());
		// CENTRO
		JPanel centro = new JPanel();
		cp.add(centro, BorderLayout.CENTER);
		centro.setLayout(new GridLayout(4, 2));

		JPanel sur = new JPanel();
		cp.add(sur, BorderLayout.SOUTH);

		JTextField nombre = new JTextField();
		JLabel labelNombre = new JLabel("Nombre*: ");
		JTextField fechaFin = new JTextField();
		JLabel labefechaFin = new JLabel("Fecha finalizar tarea: ");

		JTextField calificacion = new JTextField();
		JLabel labeCalificacion = new JLabel("Calificacion: ");

		centro.add(labelNombre);
		centro.add(nombre);
		centro.add(labefechaFin);
		centro.add(fechaFin);
		centro.add(labeCalificacion);
		centro.add(calificacion);

		nombre.setText(tarea.getNombre());
		fechaFin.setText(tarea.getFecha_fin());
		calificacion.setText("" + tarea.getCalificacion());

		JButton botonAceptar = new JButton("Edita Tarea");
		JButton botonAtras = new JButton("Atras");

		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GestorBD.gestorBD.actualizarTarea(tarea, nombre.getText(), fechaFin.getText(),
						Integer.parseInt(calificacion.getText()), tarea.getPorcentaje());
				try {
					Gestor.guardarTareaCSV(GestorBD.gestorBD.obtenerDatosTareas());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// SE CIERRRA LA VENTANA
				VentanaAsignatura v = new VentanaAsignatura(objeto, "Profesor", asignatura);
				dispose();
			}
		});

		botonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAsignatura v = new VentanaAsignatura(objeto, "Profesor", asignatura);
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
