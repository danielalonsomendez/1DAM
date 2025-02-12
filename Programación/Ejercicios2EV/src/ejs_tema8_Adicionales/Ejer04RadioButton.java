package ejs_tema8_Adicionales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejer04RadioButton extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JRadioButton rdbtnPRG;
	private JRadioButton rdbtnBD;
	private JRadioButton rdbtnED;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer04RadioButton frame = new Ejer04RadioButton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mostrarydeseleccionar(String textoElegido) {
		textField.setText(textoElegido);
		if(rdbtnPRG.getText().equals(textoElegido) == false) {
			rdbtnPRG.setSelected(false);
		}
		if(rdbtnED.getText().equals(textoElegido) == false) {
			rdbtnED.setSelected(false);
		}
		if(rdbtnBD.getText().equals(textoElegido) == false) {
			rdbtnBD.setSelected(false);
		}
	}

	/**
	 * Create the frame.
	 */
	public Ejer04RadioButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		rdbtnPRG = new JRadioButton("Programación");
		rdbtnPRG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				mostrarydeseleccionar(rdbtnPRG.getText());
			}
		});
		rdbtnPRG.setBounds(74, 80, 109, 23);
		contentPane.add(rdbtnPRG);

		rdbtnED = new JRadioButton("Entornos de desarollo");
		rdbtnED.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarydeseleccionar(rdbtnED.getText());
			}
		});
		rdbtnED.setBounds(74, 106, 187, 23);
		contentPane.add(rdbtnED);

		rdbtnBD = new JRadioButton("Bases de datos");
		rdbtnBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarydeseleccionar(rdbtnBD.getText());
			}
		});
		rdbtnBD.setBounds(74, 135, 187, 23);
		contentPane.add(rdbtnBD);

		textField = new JTextField();
		textField.setBounds(74, 177, 216, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
