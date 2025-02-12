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

public class Ejer10RadioButton extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnRadioRojo;
	private JRadioButton rdbtnRadioAmarillo;
	private JRadioButton rdbtnRadioVerde;
	private JRadioButton rdbtnRadioAzul;

	public void deseleccionar(String textoElegido) {
		if (rdbtnRadioRojo.getText().equals(textoElegido) == false) {
			rdbtnRadioRojo.setSelected(false);
		}
		if (rdbtnRadioAmarillo.getText().equals(textoElegido) == false) {
			rdbtnRadioAmarillo.setSelected(false);
		}
		if (rdbtnRadioVerde.getText().equals(textoElegido) == false) {
			rdbtnRadioVerde.setSelected(false);
		}
		if (rdbtnRadioAzul.getText().equals(textoElegido) == false) {
			rdbtnRadioAzul.setSelected(false);
		}
	}

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
	public Ejer10RadioButton(Ejer10Inicial ventanaPrincipal, JPanel panel1) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(panel1.getBackground());
		setContentPane(contentPane);
		contentPane.setLayout(null);

	
		JLabel lblNewLabel_1_1 = new JLabel("Elige el color de fondo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1_1.setBounds(168, 24, 353, 35);
		contentPane.add(lblNewLabel_1_1);

		rdbtnRadioRojo = new JRadioButton("Rojo");
		rdbtnRadioRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Rojo");
				cambiarfondo("Rojo",panel1);
			}
		});
		rdbtnRadioRojo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioRojo.setBounds(263, 79, 129, 23);
		contentPane.add(rdbtnRadioRojo);

		rdbtnRadioAmarillo = new JRadioButton("Amarillo");
		rdbtnRadioAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Amarillo");
				cambiarfondo("Amarillo",panel1);
			}
		});
		rdbtnRadioAmarillo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioAmarillo.setBounds(263, 116, 129, 23);
		contentPane.add(rdbtnRadioAmarillo);

		rdbtnRadioVerde = new JRadioButton("Verde");
		rdbtnRadioVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Verde");
				cambiarfondo("Verde",panel1);
			}
		});
		rdbtnRadioVerde.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioVerde.setBounds(263, 159, 129, 23);
		contentPane.add(rdbtnRadioVerde);

		rdbtnRadioAzul = new JRadioButton("Azul");
		rdbtnRadioAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Azul");
				cambiarfondo("Azul",panel1);
			}
		});
		rdbtnRadioAzul.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioAzul.setBounds(263, 199, 129, 23);
		contentPane.add(rdbtnRadioAzul);

		JButton btnAtras2 = new JButton("Atrás");
		btnAtras2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				dispose();	
			}
		});
		btnAtras2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtras2.setBounds(263, 240, 89, 45);
		contentPane.add(btnAtras2);
	}
}
