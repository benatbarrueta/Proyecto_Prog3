package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import clases.Alumno;
import clases.Asignatura;
import clases.Estudia;
import clases.GestorBD;
import clases.Tarea;

public class VentanaMapa extends JFrame {

	public VentanaMapa(Alumno alumno) {

		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());

		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		JPanel south = new JPanel();

		JTextArea panel = new JTextArea();
		JScrollPane spane = new JScrollPane(panel);
		panel.setEditable(false);

		centro.add(spane);
		JLabel titulo = new JLabel("Mapa");
		norte.add(titulo);
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		cp.add(south, BorderLayout.SOUTH);

		// te vale
		String string = "";

		for (Estudia est : GestorBD.gestorBD.obtenerDatosEstudia()) {
			if (alumno.getId() == est.getId_alumno()) {
				for (Asignatura asig : GestorBD.gestorBD.obtenerDatosAsignaturas()) {
					if (asig.getId() == est.getId_asignatura()) {
						for (Tarea tarea2 : GestorBD.gestorBD.obtenerDatosTareas()) {
							if (alumno.getId() == tarea2.getId_alumna() && tarea2.getId_asignatura() == asig.getId()) {
								string = string + "    " + tarea2.getNombre() + " - " + tarea2.getCalificacion() + " - "
										+ tarea2.getFecha_fin() + " - " + tarea2.getPorcentaje() + "/100 \r\n";
							}
						}
					}
				}

			}
		}
		panel.setText(string);

		norte.setLayout(new GridLayout(1, 1));
		centro.setLayout(new GridLayout(1, 1));
		south.setLayout(new GridLayout(1, 4));

		this.setTitle("Mostrar Tareas");
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
