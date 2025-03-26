package Vista_EJ5W;

import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import Controlador_EJ5W.Controlador;
import Modelo_EJ5W.Gato;
import Modelo_EJ5W.Perro;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class NuevoPerro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private Controlador controlador = new Controlador();
	private Font fuentePlain = new Font("Segoe UI", Font.PLAIN, 20);
	private JTextField textFieldEdad;
	private JTextField textFieldDNI;
	private JTextField textFieldRaza;
	private JRadioButton rdbtnLargo;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JButton btnCancelar;

	public NuevoPerro() {
		setFont(fuentePlain);
		setResizable(false);
		setTitle("Crear perro");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 356, 605);
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

		JLabel lblTitulo = new JLabel("Crear perro");
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

		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblRaza.setBounds(28, 306, 273, 32);
		contentPane.add(lblRaza);

		textFieldRaza = new JTextField();
		textFieldRaza.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textFieldRaza.setColumns(10);
		textFieldRaza.setBounds(28, 349, 273, 35);
		contentPane.add(textFieldRaza);

		JLabel lblPelo = new JLabel("Pulgas");
		lblPelo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblPelo.setBounds(28, 395, 273, 32);
		contentPane.add(lblPelo);

		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnSi.setBounds(28, 438, 100, 35);
		rdbtnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(false);
			}
		});
		contentPane.add(rdbtnSi);

		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		rdbtnNo.setBounds(28, 476, 100, 35);
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSi.setSelected(false);
			}
		});
		contentPane.add(rdbtnNo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBounds(28, 518, 138, 38);
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
		btnCancelar.setBounds(176, 518, 138, 38);
		contentPane.add(btnCancelar);

	}

	public boolean validar() {
		ArrayList<String> mensajeError = new ArrayList<String>();
		String Nombre = txtNombre.getText();
		int Edad=0;
		try {
		 Edad = Integer.parseInt(textFieldEdad.getText());
		}catch(InputMismatchException e) {
			mensajeError.add("Edad tiene que ser un número");
		}
		String DNI = textFieldDNI.getText();
		String Raza = textFieldRaza.getText();
		boolean Pulgas = false;

		if (rdbtnNo.isSelected()) {
			Pulgas = true;
		} else if (rdbtnSi.isSelected()) {
			Pulgas =false;
		} else {
			mensajeError.add("Pulgas no puede estar vacio");
		}
		if ((Nombre.length() >= 1 || Nombre.length() >= 30) == false) {
			mensajeError.add("Nombre no puede estar vacio");
		}
		if (Gato.validarEdad(Edad) == false) {
			mensajeError.add("Edad no puede estar vacio");
		}
		if (DNI.length() == 0 || Gato.validarDNI(DNI) == false) {
			mensajeError.add("DNI no puede estar vacio");
		}
		if (Raza.length() == 0) {
			mensajeError.add("Raza no puede estar vacio");
		}
		if (mensajeError.size() == 0) {
			Perro perro = new Perro(0, Nombre, Edad, DNI, Raza, Pulgas);
			try {
				if (controlador.añadirMascota(perro) == true) {
					dispose();
					Mascotas ventana = new Mascotas();
					ventana.setVisible(true);
					JOptionPane.showMessageDialog(null, "¡Mascota creada correctamente!", "Mascotas",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null,"Error con la base de datos" + sqle.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error génerico" + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, " - " + String.join("\n - ", mensajeError), "Error al crear mascota",
					JOptionPane.ERROR_MESSAGE);
		}
		return mensajeError.size() == 0;
	}
}
