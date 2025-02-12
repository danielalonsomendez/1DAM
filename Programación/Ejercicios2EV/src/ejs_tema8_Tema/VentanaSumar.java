package ejs_tema8_Tema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSumar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JLabel lblN2;
	private JTextField textField2;
	private JButton btnNewButton;
	private JLabel lblSuma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSumar frame = new VentanaSumar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSumar() {
		setTitle("Ejercicio Ejemplo Suma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblN1 = new JLabel("Número 1:");
		lblN1.setBounds(129, 83, 67, 14);
		contentPane.add(lblN1);

		textField1 = new JTextField();
		textField1.setBounds(206, 80, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);

		lblN2 = new JLabel("Número 2:");
		lblN2.setBounds(129, 118, 67, 14);
		contentPane.add(lblN2);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(206, 115, 86, 20);
		contentPane.add(textField2);

		btnNewButton = new JButton("SUMAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField1.getText() != "" && textField2.getText() != "") {
					int num1 = Integer.parseInt(textField1.getText());
					int num2 = Integer.parseInt(textField2.getText());
					int suma = num1+num2;
					lblSuma.setText("Resultado: "+suma);
				}
			}
		});
		btnNewButton.setBounds(171, 159, 89, 23);
		contentPane.add(btnNewButton);

		lblSuma = new JLabel("Resultado:");
		lblSuma.setBounds(171, 193, 144, 14);
		contentPane.add(lblSuma);
	}

}
