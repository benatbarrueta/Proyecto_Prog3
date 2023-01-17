package ventanas;

import static org.junit.Assert.assertThrows;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Alumno;
import clases.Asignatura;
import clases.Gestor;
import clases.GestorBD;
import clases.Tarea;

public class VentanaAñadeTarea extends JFrame {

	public VentanaAñadeTarea(Asignatura asignatura, Object object) {
		Container cp = this.getContentPane();

		// CREACIONES
		cp.setLayout(new BorderLayout());

		JPanel norte = new JPanel();
		cp.add(norte, BorderLayout.NORTH);
		JLabel labelAsig = new JLabel(asignatura.getNombre());

		JPanel centro = new JPanel();
		cp.add(centro, BorderLayout.CENTER);
		centro.setLayout(new GridLayout(3, 2));

		JPanel sur = new JPanel();
		cp.add(sur, BorderLayout.SOUTH);

		JTextField nombre = new JTextField();
		JLabel labelNombre = new JLabel("Nombre*: ");
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

				// AÑADIR TAREA A GESTOR
				ArrayList<Tarea> tareas = GestorBD.gestorBD.obtenerDatosTareas();
				for (Asignatura asig : GestorBD.gestorBD.obtenerDatosAsignaturas()) {
					if (asig.getId() == asignatura.getId()) {
						for (Alumno alum : GestorBD.gestorBD.obtenerDatosAlumnos()) {
							Tarea tarea = new Tarea();
							tarea.setNombre(nombre.getText());
							tarea.setFecha_fin(fechaFin.getText());
							tarea.setCalificacion(-1);
							tarea.setId_alumna(alum.getId());
							tarea.setId_asignatura(asig.getId());
							tarea.setId(tareas.get(tareas.size() - 1).getId() + 1);

							tareas.add(tarea);

							GestorBD.gestorBD.insertarDatosTarea(tarea);

						}
					}
				}

				try {
					Gestor.guardarTareaCSV(tareas);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// GUARDAR TAREAS
				GestorBD.gestorBD.borrarDatosTareas();
				for (Tarea tarea : tareas) {
					GestorBD.gestorBD.insertarDatosTarea(tarea);
				}

				// REFESCAR LA TABLA DE ASIGNATURAS

				// SE CIERRRA LA VENTANA
				dispose();
				VentanaAsignatura v = new VentanaAsignatura(object, "Profesor", asignatura);
			}
		});

		botonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				VentanaAsignatura v = new VentanaAsignatura(object, "Profesor", asignatura);
			}
		});

		sur.add(botonAtras);
		sur.add(botonAceptar);
		setIconImage(new ImageIcon("deusto.png").getImage());
		this.setTitle("Añadir Tarea");
		this.pack();
		setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
