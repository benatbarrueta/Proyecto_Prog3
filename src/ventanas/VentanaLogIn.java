package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class VentanaLogIn extends JFrame {

	protected JTextField textoUsuario;
	protected JTextField textoContrasena;
	protected JLabel usuario;
	protected JLabel contrasena;
	protected JButton continuar;
	protected JButton registrarse;
	public VentanaLogIn () {
		
		Container cp = this.getContentPane();
	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,1));
		usuario=new JLabel("Usuario");
		contrasena= new JLabel("Contraseña");
		textoContrasena = new JTextField();
		textoUsuario = new JTextField();
		continuar = new  JButton("Continuar");
		registrarse = new JButton("Registrarse");
		
		
		
		center.add(usuario);
		center.add(textoUsuario);
		center.add(contrasena);
		center.add(textoContrasena);
		center.add(continuar);
		center.add(registrarse);
		
		cp.add(center, BorderLayout.CENTER);
	
		this.setTitle("LOG IN");
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		VentanaLogIn v = new VentanaLogIn();
		v.setVisible(true);
		
	}

}
