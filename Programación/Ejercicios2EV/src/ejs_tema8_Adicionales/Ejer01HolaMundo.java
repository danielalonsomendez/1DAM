package ejs_tema8_Adicionales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejer01HolaMundo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txthola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer01HolaMundo frame = new Ejer01HolaMundo();
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
	public Ejer01HolaMundo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Cambiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txthola.getText().equals("¡Hey!")) {
					txthola.setText("¡Hola mundo!");
				} else {
					txthola.setText("¡Hey!");
				}

			}
		});
		btnNewButton.setBounds(174, 132, 89, 23);
		contentPane.add(btnNewButton);

		txthola = new JTextField();
		txthola.setText("¡Hey!");
		txthola.setBounds(174, 101, 86, 20);
		contentPane.add(txthola);
		txthola.setColumns(10);
	}

}
