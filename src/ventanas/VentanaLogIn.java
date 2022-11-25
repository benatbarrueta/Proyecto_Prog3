package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import clases.Tipo;



public class VentanaLogIn extends JFrame {

	protected JTextField textoUsuario;
	protected JTextField textoContrasena;
	protected JLabel usuario;
	protected JLabel contrasena;
	protected JButton botoncontinuar;
	protected JButton botonregistrarse;
	protected JComboBox comboTipo;
	
	
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
		//botonregistrarse = new JButton("Registrarse");
		
		
		botoncontinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				
			}
		});
//		botonregistrarse.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
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
