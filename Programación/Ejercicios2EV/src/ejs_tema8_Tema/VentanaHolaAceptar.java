package ejs_tema8_Tema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VentanaHolaAceptar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaHolaAceptar frame = new VentanaHolaAceptar();
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
	public VentanaHolaAceptar() {
		setTitle("Evento Clic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTexto = new JLabel("No se ha pulsado ACEPTAR.");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setBounds(150, 104, 179, 14);
		contentPane.add(lblTexto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(173, 135, 89, 23);
		contentPane.add(btnAceptar);
	}

}
