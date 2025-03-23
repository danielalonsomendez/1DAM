package Vista_EJ5W;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import Controlador_EJ5W.Controlador;
import Modelo_EJ5W.Gato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class NuevoGato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private Controlador controlador = new Controlador();
	private Font fuentePlain = new Font("Segoe UI", Font.PLAIN, 20);
	private JTextField textFieldEdad;
	private JTextField textFieldDNI;
	private JTextField textFieldColor;
	private JRadioButton rdbtnLargo;
	private JRadioButton rdbtnMedio;
	private JRadioButton rdbtnCorto;
	private JButton btnCancelar;

	public NuevoGato() {
		setFont(fuentePlain);
		setResizable(false);
		setTitle("Crear gato");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 356, 645);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		txtNombre = new JTextField();
		txtNombre.setFont(fuentePlain);
		txtNombre.setColumns(10);
		txtNombre.setBounds(28, 119, 273, 35);
		contentPane.add(txtNombre);


		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(fuentePlain);
		lblNombre.setBounds(28, 76, 273, 32);
		contentPane.add(lblNombre);

		JLabel lblTitulo = new JLabel("Crear gato");
		lblTitulo.setBounds(28, 11, 273, 54);
		contentPane.add(lblTitulo);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 40));

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblEdad.setBounds(28, 153, 273, 32);
		contentPane.add(lblEdad);

		textFieldEdad = new JTextField();
		textFieldEdad.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(28, 196, 273, 35);
		contentPane.add(textFieldEdad);

		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(28, 272, 273, 35);
		contentPane.add(textFieldDNI);

		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDni.setBounds(28, 231, 273, 32);
		contentPane.add(lblDni);

		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblColor.setBounds(28, 306, 273, 32);
		contentPane.add(lblColor);

		textFieldColor = new JTextField();
		textFieldColor.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(28, 349, 273, 35);
		contentPane.add(textFieldColor);

		JLabel lblPelo = new JLabel("Pelo");
		lblPelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPelo.setBounds(28, 395, 273, 32);
		contentPane.add(lblPelo);

		rdbtnLargo = new JRadioButton("Largo");
		rdbtnLargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMedio.setSelected(false);
				rdbtnCorto.setSelected(false);
			}
		});
		rdbtnLargo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnLargo.setBounds(28, 438, 100, 35);
		contentPane.add(rdbtnLargo);

		rdbtnMedio = new JRadioButton("Medio");
		rdbtnMedio.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnMedio.setBounds(28, 473, 100, 35);
		rdbtnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLargo.setSelected(false);
				rdbtnCorto.setSelected(false);
			}
		});
		contentPane.add(rdbtnMedio);

		rdbtnCorto = new JRadioButton("Corto");
		rdbtnCorto.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnCorto.setBounds(28, 511, 100, 35);
		rdbtnCorto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMedio.setSelected(false);
				rdbtnLargo.setSelected(false);
			}
		});
		contentPane.add(rdbtnCorto);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBounds(28, 553, 144, 38);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Mascotas ventana = new Mascotas();
				ventana.setVisible(true);
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(182, 553, 138, 38);
		contentPane.add(btnCancelar);

	}

	public boolean validar() {
		String Nombre = txtNombre.getText();
		String Edad = textFieldEdad.getText();
		String DNI = textFieldDNI.getText();
		String Color = textFieldColor.getText();
		String Pelo = null;
		if (rdbtnCorto.isSelected()) {
			Pelo = "C";
		} else if (rdbtnMedio.isSelected()) {
			Pelo = "M";
		} else if (rdbtnLargo.isSelected()) {
			Pelo = "L";
		}
		ArrayList<String> mensajeError = new ArrayList<String>();
		if ((Nombre.length() >= 1 || Nombre.length() >= 30) == false) {
			mensajeError.add("Nombre no puede estar vacio");
		}
		if (Edad.length() == 0 || Gato.validarEdad(Integer.parseInt(Edad)) == false) {
			mensajeError.add("Edad no puede estar vacio");
		}
		if (DNI.length() == 0 || Gato.validarDNI(DNI) == false) {
			mensajeError.add("DNI no puede estar vacio");
		}
		if (Color.length() == 0) {
			mensajeError.add("Color no puede estar vacio");
		}
		if (Pelo == null || Gato.validarPelo(Pelo) == false) {
			mensajeError.add("Pelo no puede estar vacio");
		}

		if (mensajeError.size() == 0) {
			Gato gato = new Gato(0, Nombre, Integer.parseInt(Edad), DNI, Color, Pelo.toCharArray()[0]);

			if (controlador.añadirMascota(gato) == true) {
				dispose();
				Mascotas ventana = new Mascotas();
				ventana.setVisible(true);
				JOptionPane.showMessageDialog(null, "¡Mascota creada correctamente!", "Mascotas",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, " - " + String.join("\n - ", mensajeError), "Error al crear mascota",
					JOptionPane.ERROR_MESSAGE);
		}
		return mensajeError.size() == 0;
	}
}
