package ventanas;

import java.awt.*;
import java.awt.event.*;

import clases.*;

import javax.swing.*;

public class VentanaAlud extends JFrame {
	
	protected JLabel prueba;
	protected JButton edita;
	protected JButton botonasig;
	protected int contasig = 0;
	
	protected JButton cerrar_sesion;
	public VentanaAlud (Object objeto, String tipo, Gestor gestor) {
			
		Container cp = this.getContentPane();
		
		cp.setLayout(new BorderLayout());
		
		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		JPanel sur = new JPanel();
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		cp.add(sur, BorderLayout.SOUTH);
		
		
		edita = new JButton("EDITA");
		
		if (tipo == "Alumno") {
			norte.setLayout(new GridLayout(1,8));
			centro.setLayout(new GridLayout(1,1));
			Alumno alumno = (Alumno) objeto;
			norte.add(new JLabel(alumno.getNombre()));
			norte.add(new JLabel(alumno.getApellidos()));	
			for (Asignatura asig : gestor.getAsignatura()) {
				if (("" + asig.getAlumnos()).contains("" + alumno)) {
					 botonasig = new JButton(asig.getNombre());
			            centro.add(botonasig);
			            botonasig.setBackground(new Color((int)(Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
			            
			            botonasig.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
			        			VentanaAsignatura v= new VentanaAsignatura(objeto, "Alumno", gestor, asig);
							}
						});
					contasig++;
				} 
			}
			
			
			norte.add(new JLabel(""));
			norte.add(new JLabel(""));
			norte.add(new JLabel(""));
			norte.add(new JLabel(""));
			norte.add(new JLabel(""));
		} else {
			
			norte.setLayout(new GridLayout(2,4));
			Profesor profesor = (Profesor) objeto;
			
			norte.add(new JLabel(profesor.getNombre()));
			norte.add(new JLabel(profesor.getApellidos()));
			norte.add(new JLabel(""));
			
			norte.add(new JLabel("Asignaturas"));
			norte.add(new JLabel(""));
			for (Asignatura asig : gestor.getAsignatura()) {
				System.out.println(asig.getProfesor());
				//System.out.println(profesor);
				if (asig.getProfesor().equals(profesor)) {
					 botonasig = new JButton(asig.getNombre());
			            centro.add(botonasig);
			            botonasig.setBackground(new Color((int)(Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
			            
			            botonasig.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
			        			VentanaAsignatura v= new VentanaAsignatura(objeto, "Profesor", gestor, asig);
							}
						});
					contasig++;
				} 
			}
		}
		centro.setLayout(new GridLayout((int) contasig/2,contasig));
		
		
//		.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (tipo == "Alumno") {
//					for (Asignatura asig : gestor.getAsignatura()) {
//						if (asig.getNombre().equals("" + asignaturas.getSelectedValue())) {
//							VentanaAsignatura v= new VentanaAsignatura(objeto, "Alumno", gestor, asig);
//						}
//					}
//				} else {
//					for (Asignatura asig : gestor.getAsignatura()) {
//						if (asig.getNombre() == "" + asignaturas.getSelectedValue()) {
//							VentanaAsignatura v = new VentanaAsignatura(objeto, "Profesor", gestor, asig);
//						}
//					}
//				}
//			}
//		});
//		
//		centro.add(scrollAsignaturas);
		
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
		
	
		norte.add(edita);
		//System.out.println(gestor.getAsignatura().get(0).getAlumnos());
		//System.out.println(gestor.getAsignatura().get(0).getProfesor());
		if (tipo == "Alumno") {
			Alumno alumno = (Alumno) objeto;
			this.setTitle(alumno.getNombre() + " " + alumno.getApellidos());
		} else {
			Profesor profesor = (Profesor) objeto;
			this.setTitle(profesor.getNombre() + " " + profesor.getApellidos());
		}
		
		
		//SUR
		sur.setLayout(new GridLayout(1,8));
		
		cerrar_sesion = new JButton("Cerrar Sesion");
		
		cerrar_sesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaLogIn v = new VentanaLogIn(gestor);
				dispose();
				
			}
		});
		
		sur.add(cerrar_sesion);
		sur.add(new JLabel(""));
		sur.add(new JLabel(""));
	
		//
		
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
