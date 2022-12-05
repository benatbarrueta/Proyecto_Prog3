package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.*;

public class VentanaAsignatura extends JFrame{
	protected JButton cerrar_sesion;
	protected JLabel tareas;
	protected JLabel nombreAsig;
	protected JLabel apuntes;
	
	protected JButton tareaBoton;
	public VentanaAsignatura(Object objeto, String tipo, Gestor gestor, Asignatura asignatura) {
		Container cp = this.getContentPane();
		
		if (tipo == "Alumno") {
			Alumno alumno = (Alumno) objeto;
			
		} else {
			Profesor profesor = (Profesor) objeto;
			
		}
		
		cp.setLayout(new BorderLayout());
		
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		tareas = new JLabel("Tareas");
		nombreAsig = new JLabel("Asignatura:  " + asignatura.getNombre());
		apuntes = new JLabel("Apuntes");
		
	
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		
		
		norte.setLayout(new GridLayout(1,1));
		centro.setLayout(new GridLayout(8,2));
		//NORTE
		norte.add(nombreAsig);
		
		
		//CENTRO
		centro.add(apuntes);
		centro.add(tareas);
	
		
		
		
		
		this.setTitle(asignatura.getNombre());
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
