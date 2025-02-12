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

public class Ejer09Paneles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel3;
	private JPanel panel1;
	private JPanel panel2;
	private JRadioButton rdbtnRadioRojo;
	private JRadioButton rdbtnRadioAmarillo;
	private JRadioButton rdbtnRadioVerde;
	private JRadioButton rdbtnRadioAzul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer09Paneles frame = new Ejer09Paneles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

	public void cambiarfondo(String fondo) {
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
		panel2.setBackground(colorSel);
		panel3.setBackground(colorSel);

	}

	/**
	 * Create the frame.
	 */
	public Ejer09Paneles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		panel1 = new JPanel();
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ELECCIÓN COLOR DE FONDO");
		lblNewLabel_1.setBounds(101, 91, 422, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		panel1.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Con radio button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(69, 166, 218, 35);
		panel1.add(btnNewButton);

		JButton btnConCombo = new JButton("Con combo");
		btnConCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel3.setVisible(true);
			}
		});
		btnConCombo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnConCombo.setBounds(319, 166, 218, 35);
		panel1.add(btnConCombo);

		panel2 = new JPanel();
		panel2.setLayout(null);
		contentPane.add(panel2);

		JLabel lblNewLabel_1_1 = new JLabel("Elige el color de fondo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1_1.setBounds(168, 24, 353, 35);
		panel2.add(lblNewLabel_1_1);

		rdbtnRadioRojo = new JRadioButton("Rojo");
		rdbtnRadioRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Rojo");
				cambiarfondo("Rojo");
			}
		});
		rdbtnRadioRojo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioRojo.setBounds(263, 79, 129, 23);
		panel2.add(rdbtnRadioRojo);

		rdbtnRadioAmarillo = new JRadioButton("Amarillo");
		rdbtnRadioAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Amarillo");
				cambiarfondo("Amarillo");
			}
		});
		rdbtnRadioAmarillo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioAmarillo.setBounds(263, 116, 129, 23);
		panel2.add(rdbtnRadioAmarillo);

		rdbtnRadioVerde = new JRadioButton("Verde");
		rdbtnRadioVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Verde");
				cambiarfondo("Verde");
			}
		});
		rdbtnRadioVerde.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioVerde.setBounds(263, 159, 129, 23);
		panel2.add(rdbtnRadioVerde);

		rdbtnRadioAzul = new JRadioButton("Azul");
		rdbtnRadioAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar("Azul");
				cambiarfondo("Azul");
			}
		});
		rdbtnRadioAzul.setFont(new Font("Tahoma", Font.PLAIN, 21));
		rdbtnRadioAzul.setBounds(263, 199, 129, 23);
		panel2.add(rdbtnRadioAzul);

		JButton btnAtras2 = new JButton("Atrás");
		btnAtras2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.setVisible(false);
				panel1.setVisible(true);
			}
		});
		btnAtras2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtras2.setBounds(263, 240, 89, 45);
		panel2.add(btnAtras2);

		panel3 = new JPanel();
		panel3.setLayout(null);
		contentPane.add(panel3);

		JLabel lblNewLabel_1_1_1 = new JLabel("Elige el color de fondo");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_1_1_1.setBounds(168, 24, 353, 35);
		panel3.add(lblNewLabel_1_1_1);

		JButton btnAtras3 = new JButton("Atrás");
		btnAtras3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(false);
				panel1.setVisible(true);
			}
		});
		btnAtras3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtras3.setBounds(263, 240, 89, 45);
		panel3.add(btnAtras3);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deseleccionar(comboBox.getSelectedItem() + "");
				cambiarfondo(comboBox.getSelectedItem() + "");

			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { " ", "Rojo", "Amarillo", "Verde", "Azul" }));
		comboBox.setBounds(231, 117, 174, 35);
		panel3.add(comboBox);
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
	}
}
