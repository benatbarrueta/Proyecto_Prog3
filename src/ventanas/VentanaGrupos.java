package ventanas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

import clases.Alumno;
import clases.Asignatura;
import clases.Estudia;
import clases.GestorBD;

public class VentanaGrupos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaGrupos(Asignatura asignatura) {

		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());

		DefaultListModel<String> lista = new DefaultListModel<>();
		JList<String> jlist = new JList<String>(lista);

		JPanel centro = new JPanel();
		JPanel norte = new JPanel();
		JPanel south = new JPanel();
		cp.add(centro, BorderLayout.CENTER);
		cp.add(norte, BorderLayout.NORTH);
		cp.add(south, BorderLayout.SOUTH);

		norte.setLayout(new GridLayout(1, 1));
		centro.setLayout(new GridLayout(1, 1));
		south.setLayout(new GridLayout(1, 4));

		JButton crear = new JButton("Crear Grupos");

		ArrayList<String> nombreAlumnos = new ArrayList<String>();

		for (Alumno a : GestorBD.gestorBD.obtenerDatosAlumnos()) {
			for (Estudia e : GestorBD.gestorBD.obtenerDatosEstudia()) {
				if (a.getId() == e.getId_alumno() && asignatura.getId() == e.getId_asignatura()) {
					nombreAlumnos.add(a.getNombre() + " " + a.getApellidos());
				}

			}
		}
		JLabel numero_Grupos = new JLabel("Numero de Grupos");
		JSlider numeroGruposFill = new JSlider();
		numeroGruposFill.setMinimum(2);
		numeroGruposFill.setMaximum(10);

		numeroGruposFill.setPaintTicks(true);
		numeroGruposFill.setPaintLabels(true);
		numeroGruposFill.setValue(4);
		numeroGruposFill.setMinorTickSpacing(1);
		numeroGruposFill.setMajorTickSpacing(1);

		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lista.removeAllElements();
				// TODO Auto-generated method stub

				ArrayList<ArrayList<String>> alumnos = combinaciones(nombreAlumnos, numeroGruposFill.getValue());
				ArrayList<String> alumnosUsado = new ArrayList<>();
				lista.addElement("GRUPOS:");
				for (ArrayList<String> grupo : alumnos) {
					String grupoString = "";

					for (String string : grupo) {

						grupoString = grupoString + string + "     ";
						alumnosUsado.add(string);
					}

					lista.addElement(grupoString);

				}
				ArrayList<String> alumnosSinGrupo = new ArrayList<>();

				for (String string : nombreAlumnos) {
					if (!alumnosUsado.contains(string)) {
						alumnosSinGrupo.add(string);
					}
				}

				lista.addElement("ALUMNOS SIN GRUPO:");
				String sinUsar = "";
				for (String string : alumnosSinGrupo) {

					sinUsar = sinUsar + string + "     ";

				}
				lista.addElement(sinUsar);

				jlist.repaint();
			}
		});

		norte.add(numero_Grupos);
		norte.add(numeroGruposFill);

		JScrollPane scrollGrupos = new JScrollPane(jlist);
		centro.add(scrollGrupos);

		south.add(crear);

		this.setTitle("Crear Grupos");
		this.setSize(600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public static ArrayList<ArrayList<String>> combinaciones(ArrayList<String> elementos, int n) {
		// Se inicializa la lista de combinaciones que se devolverá como resultado.
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		// Se invoca al método recursivo
		combinaciones(result, elementos, n, new ArrayList<String>());
		// Se devuelve el resultado.
		return result;
	}

	private static void combinaciones(ArrayList<ArrayList<String>> result, ArrayList<String> elementos, int n,
			ArrayList<String> temp) {
		// Caso base. n=0
		if (n == temp.size()) {

			temp.sort(null);

			// Se añade la lista temporal a la lista de resultados

			if (result.size() == 0) {
				result.add(new ArrayList<>(temp));

			} else {
				Boolean contiene = false;
				for (ArrayList<String> string : result) {
					for (String nombre : temp) {
						if (string.contains(nombre)) {

							contiene = true;

						}
					}

				}
				if (contiene.equals(false)) {

					if (!result.contains(temp)) {
						result.add(new ArrayList<>(temp));
					}
				}

			}

		} else {
			// Caso recursivo. Por cada elemento
			for (String e : elementos) {
				if (!temp.contains(e)) {
					// Se añade el elemento a la lista temporal
					temp.add(e);
					combinaciones(result, elementos, n, temp);
					// Se elimina el último de la lista temporal
					temp.remove(temp.size() - 1);
				}
			}

		}
	}
}
