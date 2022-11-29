package ventanas;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

import clases.*;

import javax.swing.*;

public class VentanaAlud extends JFrame {
	
	protected JLabel prueba;

	public VentanaAlud (Object objeto, String tipo) {
		
		
		
		Container cp = this.getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		cp.add(panel);
		
	
		this.setSize(600,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		if (tipo == "Alumno") {
			Alumno alumno = (Alumno) objeto;
			JLabel prueba = new JLabel(alumno.getNombre());
			panel.add(prueba, BorderLayout.CENTER);
			System.out.println(alumno);
			this.setTitle(alumno.getNombre() + " " + alumno.getApellidos());
		} else {
			Profesor profesor = (Profesor) objeto;
			JLabel prueba = new JLabel(profesor.getNombre());
			this.setTitle(profesor.getNombre() + " " + profesor.getApellidos());
			panel.add(prueba, BorderLayout.CENTER);
		}
	}
}
