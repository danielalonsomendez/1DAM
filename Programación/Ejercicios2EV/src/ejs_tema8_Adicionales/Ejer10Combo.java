package ejs_tema8_Adicionales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejer10Combo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public void cambiarfondo(String fondo,JPanel panel1) {
		Color colorSel = Color.white;
		switch (fondo) {
		case "Rojo": 
		colorSel= Color.red;

			break;
		case "Amarillo":
			colorSel= Color.yellow;
			break;
		case "Verde":
			colorSel= Color.green;
			break;
		case "Azul":
			colorSel= Color.blue;
			break;
		}
		contentPane.setBackground(colorSel);
		panel1.setBackground(colorSel);

	}

	/**
	 * Create the frame.
	 */
	public Ejer10Combo(Ejer10Inicial ventanaPrincipal, JPanel panel1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(panel1.getBackground());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Elige el color de fondo");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1_1_1.setBounds(168, 24, 353, 35);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnAtras3 = new JButton("Atrás");
		btnAtras3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				dispose();
			}
		});
		btnAtras3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtras3.setBounds(263, 240, 89, 45);
		contentPane.add(btnAtras3);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarfondo(comboBox.getSelectedItem() + "",panel1);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { " ", "Rojo", "Amarillo", "Verde", "Azul" }));
		comboBox.setBounds(231, 117, 174, 35);
		contentPane.add(comboBox);
	}
}