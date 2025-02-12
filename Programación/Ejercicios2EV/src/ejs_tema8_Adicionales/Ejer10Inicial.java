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

public class Ejer10Inicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer10Inicial frame = new Ejer10Inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	}

	/**
	 * Create the frame.
	 */
	public Ejer10Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel lblNewLabel_1 = new JLabel("ELECCIÓN COLOR DE FONDO");
		lblNewLabel_1.setBounds(101, 91, 422, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Con radio button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejer10RadioButton ejer10radio = new Ejer10RadioButton(Ejer10Inicial.this,contentPane);
				setVisible(false);
				ejer10radio.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(69, 166, 218, 35);
		contentPane.add(btnNewButton);

		JButton btnConCombo = new JButton("Con combo");
		btnConCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Ejer10Combo ejer10combo = new Ejer10Combo(Ejer10Inicial.this,contentPane);
			setVisible(false);
			ejer10combo.setVisible(true);
			}
		});
		btnConCombo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnConCombo.setBounds(319, 166, 218, 35);
		contentPane.add(btnConCombo);
	}
}
