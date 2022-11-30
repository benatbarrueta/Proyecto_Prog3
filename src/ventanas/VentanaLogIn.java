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
	protected GestorBD gestorBD = new GestorBD();
	protected static String contrasenaContenido = "";
	
	public VentanaLogIn (Gestor gestor) {
		
		Container cp = this.getContentPane();
	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,1));
		usuario=new JLabel("Usuario");
		contrasena= new JLabel("Contraseña");
		textoContrasena = new JTextField();
		textoUsuario = new JTextField();
		comboTipo = new JComboBox(Tipo.values());
		botoncontinuar = new  JButton("Continuar");
		
		
		
		textoContrasena.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==8) {
					contrasenaContenido= contrasenaContenido.substring(0,contrasenaContenido.length()-1);
				}
				else {
					contrasenaContenido = contrasenaContenido + e.getKeyChar();
				}
				
				
				int tamano = textoContrasena.getText().length();
				String texto = "";
				textoContrasena.setText(texto);
				for (int i = 0; i < tamano; i++) {
					texto=texto + "*";
				}
				textoContrasena.setText(texto);
				System.out.println(contrasenaContenido);
			}
			
	
		});
		
		botoncontinuar.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				if (comboTipo.getSelectedItem() == Tipo.ALUMNO) {
					for (Alumno alumno : gestorBD.obtenerDatosAlumnos()) {
						if(textoUsuario.getText().equals(alumno.getNombreUsuario())  &&contrasenaContenido.equals(alumno.getContraseña())) {
							VentanaAlud v = new VentanaAlud(alumno, "Alumno", gestor);
							
							dispose();
						
							break;
						} else if (textoUsuario.getText().equals(alumno.getNombreUsuario()) && !contrasenaContenido .equals(alumno.getContraseña())) {
							JOptionPane.showMessageDialog(null, "La contraseña introducida es incorrecta");
							textoUsuario.setText(alumno.getNombreUsuario());
							textoContrasena.setText("");
							break;
						} else if (!textoUsuario.getText().equals(alumno.getNombreUsuario()) && contrasenaContenido.equals(alumno.getContraseña())) { 
							JOptionPane.showMessageDialog(null, "El nombre de usuario introducido es incorrecta");
							textoUsuario.setText("");
							textoContrasena.setText(alumno.getContraseña());
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Los datos introducidos son incorrectos");
							textoUsuario.setText("");
							textoContrasena.setText("");
							break;
						}
						
					}
					
					
					
					
				} else {
					for (Profesor profesor : gestorBD.obtenerDatosProfesor()) {
						if(textoUsuario.getText() .equals(profesor.getNombreUsuario())  && textoContrasena.getText() .equals(profesor.getContraseña())) {
							VentanaAlud v = new VentanaAlud(profesor, "Profesor", gestor);
						} else {
//							JOptionPane.showMessageDialog(null, "Los datos introducidos son erroneos");
//							textoUsuario.setText("");
//							textoContrasena.setText("");
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
