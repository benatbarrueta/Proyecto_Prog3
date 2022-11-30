package ventanas;

import java.awt.*;
import java.awt.event.*;

import clases.*;

import javax.swing.*;

public class VentanaAlud extends JFrame {
	
	protected JLabel prueba;
	protected JScrollPane scrollAsignaturas;
	protected JButton edita;
	protected JList asignaturas;
	protected DefaultListModel modeloAsignaturas = new DefaultListModel();

	public VentanaAlud (Object objeto, String tipo, Gestor gestor) {
			
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		
		norte.setLayout(new GridLayout(1,8));
		centro.setLayout(new GridLayout(1,1));
		
		edita = new JButton("EDITA");
		
		if (tipo == "Alumno") {
			Alumno alumno = (Alumno) objeto;
			norte.add(new JLabel(alumno.getNombre()));
			norte.add(new JLabel(alumno.getApellidos()));	
			for (Asignatura asig : gestor.getAsignatura()) {
				if (("" + asig.getAlumnos()).contains("" + alumno)) {
					System.out.println(asig.getNombre());
					modeloAsignaturas.addElement(asig.getNombre());
				} else {
					
				}
			}
		} else {
			Profesor profesor = (Profesor) objeto;
			JLabel prueba = new JLabel(profesor.getNombre());
			centro.add(prueba);
		}
		
		asignaturas = new JList(modeloAsignaturas);
		scrollAsignaturas = new JScrollPane(asignaturas);
		
		asignaturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tipo == "Alumno") {
					for (Asignatura asig : gestor.getAsignatura()) {
						if (asig.getNombre().equals("" + asignaturas.getSelectedValue())) {
							VentanaAsignatura va = new VentanaAsignatura(objeto, "Alumno", gestor, asig);
						}
					}
				} else {
					for (Asignatura asig : gestor.getAsignatura()) {
						if (asig.getNombre() == "" + asignaturas.getSelectedValue()) {
							VentanaAsignatura va = new VentanaAsignatura(objeto, "Profesor", gestor, asig);
						}
					}
				}
			}
		});
		
		centro.add(scrollAsignaturas);
		
		edita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo == "Alumno") {
					Alumno alumno = (Alumno) objeto;
					VentanaEdita v = new VentanaEdita(alumno, "Alumno", gestor);
				} else {
					Profesor profesor = (Profesor) objeto;
					VentanaEdita v = new VentanaEdita(profesor, "Profesor", gestor);
				}
			}
		});
		
		norte.add(new JLabel(""));
		norte.add(new JLabel(""));
		norte.add(new JLabel(""));
		norte.add(new JLabel(""));
		norte.add(new JLabel(""));
		norte.add(edita);
		System.out.println(gestor.getAsignatura().get(0).getAlumnos());
		
		if (tipo == "Alumno") {
			Alumno alumno = (Alumno) objeto;
			this.setTitle(alumno.getNombre() + " " + alumno.getApellidos());
		} else {
			Profesor profesor = (Profesor) objeto;
			this.setTitle(profesor.getNombre() + " " + profesor.getApellidos());
		}
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
