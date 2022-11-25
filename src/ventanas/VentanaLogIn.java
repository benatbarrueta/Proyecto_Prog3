package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import clases.*;



public class VentanaLogIn extends JFrame {

	protected JTextField textoUsuario;
	protected JTextField textoContrasena;
	protected JLabel usuario;
	protected JLabel contrasena;
	protected JButton botoncontinuar;
	protected JButton botonregistrarse;
	protected JComboBox comboTipo;
	protected GestorBD gestor = new GestorBD();
	
	
	public VentanaLogIn () {
		
		Container cp = this.getContentPane();
	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,1));
		usuario=new JLabel("Usuario");
		contrasena= new JLabel("Contraseña");
		textoContrasena = new JTextField();
		textoUsuario = new JTextField();
		comboTipo = new JComboBox(Tipo.values());
		botoncontinuar = new  JButton("Continuar");
		
		
		botoncontinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				if (comboTipo.getSelectedItem() == Tipo.ALUMNO) {
					for (Alumno alumno : gestor.obtenerDatosAlumnos()) {
						if(textoUsuario.getText() == alumno.getNombreUsuario() && textoContrasena.getText() == alumno.getContraseña()) {
							VentanaAlumno v = new VentanaAlumno(alumno);
							System.out.println("Hola");
						} else {
							//JOptionPane.showInputDialog("Los datos introducidos son erroneos");
							System.out.println("Adios");
						}
					}
					
					
				} else {
					for (Profesor profesor : gestor.obtenerDatosProfesor()) {
						if(textoUsuario.getText() == profesor.getNombreUsuario() && textoContrasena.getText() == profesor.getContraseña()) {
							VentanaProfesor v = new VentanaProfesor(profesor);
						}
					}
				}
			}
		});
		
		center.add(usuario);
		center.add(textoUsuario);
		center.add(contrasena);
		center.add(textoContrasena);
		center.add(comboTipo);
		center.add(botoncontinuar);
		//center.add(botonregistrarse);
		
		cp.add(center, BorderLayout.CENTER);
	
		this.setTitle("LOG IN");
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}



}
