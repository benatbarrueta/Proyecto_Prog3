package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class VentanaLogIn extends JFrame {

	protected JTextField textoUsuario;
	protected JTextField textoContrasena;
	public VentanaLogIn () {
		
	
	


		this.setTitle("LOG IN");
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		VentanaLogIn v = new VentanaLogIn();
		v.setVisible(true);
		
	}

}
