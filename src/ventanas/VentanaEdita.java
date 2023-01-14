package ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.*;

import clases.*;

public class VentanaEdita extends JFrame {
	
	protected GestorBD gestorBD;
	
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
	protected JButton botonAtras;
	

	public VentanaEdita(Object objeto, String tipo, Gestor gestor) {
		
		Container cp = this.getContentPane();
		
		JPanel norte = new JPanel();
		JPanel centro = new JPanel();
		JPanel sur = new JPanel();
		
	
		JTextField nombre = new JTextField();
		JLabel labelNombre = new JLabel ("Nombre*: ");
		JTextField apellido = new JTextField();
		JLabel labelApellido = new JLabel("Apellido(s)*: ");
		JTextField email = new JTextField();
		JLabel labelEmail = new JLabel("Email*: ");
		JTextField direccion = new JTextField();
		JLabel labelDireccion = new JLabel("Dirección*: ");
		JTextField nombreUsuario = new JTextField();
		JLabel labelNombreUsuario = new JLabel("Nombre de usuario*: ");
		JTextField contraseña = new JTextField();
		JLabel labelContraseña = new JLabel("Contraseña*: ");
		JButton botonAceptar = new JButton("Aceptar cambios");
		JButton botonAtras = new JButton("Atras");
		
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
		
		sur.add(botonAtras);
		sur.add(botonAceptar);
		
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo == "Alumno") {
					Alumno alumno = (Alumno) objeto;
					VentanaAlud v = new VentanaAlud(alumno, "Alumno");
					dispose();
				} else {
					Profesor profesor = (Profesor) objeto;
					VentanaAlud v = new VentanaAlud(profesor, "Profesor");
					dispose();
				}
			}
		});
		
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tipo == "Alumno") {
					Alumno alumno = (Alumno) objeto;
					if (nombre.getText() != null || apellido.getText() != null || email.getText() != null ||  nombreUsuario.getText() != null || contraseña.getText() != null) {
						GestorBD.gestorBD.actualizarAlumno(alumno, nombre.getText(), apellido.getText(), email.getText(), direccion.getText(), nombreUsuario.getText(), contraseña.getText());
						System.out.println("- Nombre: " + nombre.getText() + "\n- Apellido: " + apellido.getText() + "\n- Email: " + email.getText() + "\n- Dirección:" + direccion.getText() + "\n- Nombre de usuario : " + nombreUsuario.getText() + "\n- Contraseña: " + contraseña.getText());
					}
				} else {
					Profesor profesor = (Profesor) objeto;
					
					if (nombre.getText() != null || apellido.getText() != null || email.getText() != null ||  nombreUsuario.getText() != null || contraseña.getText() != null) {
						GestorBD.gestorBD.actualizarProfesor(profesor, nombre.getText(), apellido.getText(), email.getText(), direccion.getText(), nombreUsuario.getText(), contraseña.getText());
						System.out.println("- Nombre: " + nombre.getText() + "\n- Apellido: " + apellido.getText() + "\n- Email: " + email.getText() + "\n- Dirección:" + direccion.getText() + "\n- Nombre de usuario : " + nombreUsuario.getText() + "\n- Contraseña: " + contraseña.getText());
					}
				}
			}
		});
		
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
