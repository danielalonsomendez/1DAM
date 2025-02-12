package ejs_tema8_Adicionales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejer03Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido1;
	private JTextField tfApellido2;
	private JTextField tfDNINIE;
	private JComboBox comboBoxDNINIE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer03Formulario frame = new Ejer03Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void comprobarDNI(String dni) {
		boolean valido = true;

		
		if (comboBoxDNINIE.getSelectedItem().equals("DNI")) {
			if (dni.length() == 9) {
				char[] dniSeparado = dni.toCharArray();
				for (int i = 0; i < dniSeparado.length; i++) {
					if (((i <= 7 && Character.isDigit(dniSeparado[i]))
							|| (i == 8 && Character.isLetter(dniSeparado[i]))) == false) {
						valido = false;
					}
				}
			} else {
				valido = false;
			}
		}
		if (valido) {
			JOptionPane.showMessageDialog(null, "DNI válido",  "DNI válido", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "DNI incorrecto","DNI incorrecto",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public Ejer03Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(39, 66, 63, 14);
		contentPane.add(lblNewLabel_1);

		tfNombre = new JTextField();
		tfNombre.setBounds(112, 63, 227, 20);
		tfNombre.setToolTipText("");
		tfNombre.setColumns(10);
		contentPane.add(tfNombre);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido 1:");
		lblNewLabel_1_1.setBounds(39, 94, 63, 14);
		contentPane.add(lblNewLabel_1_1);

		tfApellido1 = new JTextField();
		tfApellido1.setToolTipText("");
		tfApellido1.setColumns(10);
		tfApellido1.setBounds(112, 91, 227, 20);
		contentPane.add(tfApellido1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido 2:");
		lblNewLabel_1_1_1.setBounds(39, 122, 63, 14);
		contentPane.add(lblNewLabel_1_1_1);

		tfApellido2 = new JTextField();
		tfApellido2.setToolTipText("");
		tfApellido2.setColumns(10);
		tfApellido2.setBounds(112, 119, 227, 20);
		contentPane.add(tfApellido2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("DNI/NIE:");
		lblNewLabel_1_1_1_1.setBounds(39, 150, 63, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		tfDNINIE = new JTextField();
		tfDNINIE.setToolTipText("");
		tfDNINIE.setColumns(10);
		tfDNINIE.setBounds(191, 150, 148, 22);
		contentPane.add(tfDNINIE);

		comboBoxDNINIE = new JComboBox();
		comboBoxDNINIE.setModel(new DefaultComboBoxModel(new String[] { "DNI", "NIE" }));
		comboBoxDNINIE.setBounds(112, 150, 74, 22);
		contentPane.add(comboBoxDNINIE);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarDNI(tfDNINIE.getText());
			}
		});
		btnNewButton.setBounds(39, 200, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNombre.setText("");
				tfApellido1.setText("");
				tfApellido2.setText("");
				tfDNINIE.setText("");
				comboBoxDNINIE.setSelectedIndex(0);
			}
		});
		btnNewButton_1.setBounds(134, 200, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
