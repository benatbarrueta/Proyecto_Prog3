package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import clases.*;

public class VentanaLogIn extends JFrame {
	protected JPasswordField textoContrasena;
	protected JTextField textoUsuario;

	protected JLabel usuario;
	protected JLabel contrasena;
	protected JButton botoncontinuar;
	protected JButton botonregistrarse;
	protected JComboBox comboTipo;

	protected boolean sesion = false;

	public VentanaLogIn() {

		Container cp = this.getContentPane();

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 1));
		usuario = new JLabel("Usuario");
		contrasena = new JLabel("Contraseña");
		textoContrasena = new JPasswordField();
		textoUsuario = new JTextField();
		comboTipo = new JComboBox(Tipo.values());
		botoncontinuar = new JButton("Continuar");

		textoContrasena.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == 10) {
					botoncontinuar.doClick();
				}

			}
		});

		botoncontinuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				if (comboTipo.getSelectedItem() == Tipo.ALUMNO) {

					for (Alumno alumno : GestorBD.gestorBD.obtenerDatosAlumnos()) {

						if (textoUsuario.getText().equals(alumno.getNombreUsuario())
								&& textoContrasena.getText().equals(alumno.getContraseña())) {
							VentanaAlud v = new VentanaAlud(alumno, "Alumno");

							dispose();
							sesion = true;
							break;

						}

					}
					if (!sesion == true) {
						JOptionPane.showMessageDialog(null, "Los datos introducidos son incorrectos");
						textoUsuario.setText("");
						textoContrasena.setText("");
					}

				} else {
					for (Profesor profesor : GestorBD.gestorBD.obtenerDatosProfesor()) {
						if (textoUsuario.getText().equals(profesor.getNombreUsuario())
								&& textoContrasena.getText().equals(profesor.getContraseña())) {
							VentanaAlud v = new VentanaAlud(profesor, "Profesor");
							dispose();
							sesion = true;
							break;
						}

					}
					if (!sesion == true) {
						JOptionPane.showMessageDialog(null, "Los datos introducidos son erroneos");
						textoUsuario.setText("");
						textoContrasena.setText("");
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

		cp.add(center, BorderLayout.CENTER);

		this.setTitle("LOG IN");
		setIconImage(new ImageIcon("deusto.png").getImage());		
		this.setVisible(true);
		this.setSize(400, 200);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
