package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Asignatura;
import clases.Gestor;
import clases.Tarea;

public class VentanaTarea extends JFrame {
	public VentanaTarea(Tarea tarea) {
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
	
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		
		
		norte.setLayout(new GridLayout(1,1));
		centro.setLayout(new GridLayout(8,2));
		
		
		
		
		
		
		this.setTitle(tarea.getNombre());
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
