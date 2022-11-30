package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Asignatura;
import clases.Gestor;

public class VentanaAsignatura extends JFrame{
	public VentanaAsignatura(Object objeto, String tipo, Gestor gestor, Asignatura asignatura) {
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		
		norte.setLayout(new GridLayout(1,1));
		centro.setLayout(new GridLayout(1,1));
		
		this.setTitle(asignatura.getNombre());
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
