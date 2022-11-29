package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import clases.*;

public class VentanaEdita extends JFrame {
//	protected String nombre;
//	protected String apellidos;
//	protected String email;
//	protected String direccion;
//	protected String nombreUsuario;
//	protected String contraseña;
	
	protected JTextField nombre;
	protected JLabel labelNombre;
	protected JTextField apellido;
	protected JLabel labelApellido;
	protected JTextField email;
	protected JLabel labelEmail;
	protected JTextField direccion;
	protected JLabel labelDireccion;
	protected JTextField nombreUsuario;
	protected JLabel labelNombreUsuario;
	protected JTextField contraseña;
	protected JLabel labelContraseña;
	protected JButton botonAceptar;
	

	public VentanaEdita(Object objeto, String tipo, Gestor gestor) {
		
		Container cp = this.getContentPane();
		
		JPanel norte = new JPanel();
		JPanel centro = new JPanel();
		JPanel sur = new JPanel();
		
		JTextField nombre = new JTextField();
		JLabel labelNombre = new JLabel ("Nombre: ");
		JTextField apellido = new JTextField();
		JLabel labelApellido = new JLabel("Apellido(s): ");
		JTextField email = new JTextField();
		JLabel labelEmail = new JLabel("Email: ");
		JTextField direccion = new JTextField();
		JLabel labelDireccion = new JLabel("Dirección: ");
		JTextField nombreUsuario = new JTextField();
		JLabel labelNombreUsuario = new JLabel("Nombre de usuario: ");
		JTextField contraseña = new JTextField();
		JLabel labelContraseña = new JLabel("Contraseña: ");
		JButton botonAceptar = new JButton("Aceptar cambios");
		
		cp.setLayout(new BorderLayout());
		cp.add(norte, BorderLayout.NORTH);
		cp.add(centro, BorderLayout.CENTER);
		cp.add(sur, BorderLayout.SOUTH);
		
		norte.setLayout(new GridLayout(2, 1));
		
		
		centro.setLayout(new GridLayout(6, 2));
		centro.add(labelNombre);
		centro.add(nombre);
		centro.add(labelApellido);
		centro.add(apellido);
		centro.add(labelEmail);
		centro.add(email);
		centro.add(labelDireccion);
		centro.add(direccion);
		centro.add(labelNombreUsuario);
		centro.add(nombreUsuario);
		centro.add(labelContraseña);
		centro.add(contraseña);
		
		if (tipo == "Alumno") {
			Alumno alumno = (Alumno) objeto;
			nombre.setText(alumno.getNombre());
			apellido.setText(alumno.getApellidos());
			email.setText(alumno.getEmail());
			direccion.setText(alumno.getDireccion());
			nombreUsuario.setText(alumno.getNombreUsuario());
			contraseña.setText(alumno.getContraseña());
			
			norte.add(new JLabel(alumno.getNombre() + " " + alumno.getApellidos()));
		} else {
			Profesor profesor = (Profesor) objeto;
			nombre.setText(profesor.getNombre());
			apellido.setText(profesor.getApellidos());
			email.setText(profesor.getEmail());
			direccion.setText(profesor.getDireccion());
			nombreUsuario.setText(profesor.getNombreUsuario());
			contraseña.setText(profesor.getContraseña());
			
			norte.add(new JLabel(profesor.getNombre() + " " + profesor.getApellidos()));
		}
		
		
		norte.add(new JLabel("Editando perfil..."));
		
		
		sur.add(botonAceptar);
		
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
