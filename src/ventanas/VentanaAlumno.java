package ventanas;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

import clases.*;

import javax.swing.*;

public class VentanaAlumno extends JFrame {
	
	protected JLabel prueba;

	public VentanaAlumno (Alumno alumno) {
		
		Container cp = this.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel prueba = new JLabel(alumno.getNombre());
		
		cp.add(panel);
		panel.add(prueba, BorderLayout.CENTER);
	
		this.setTitle(alumno.getNombre() + alumno.getApellidos());
		this.setSize(600,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
