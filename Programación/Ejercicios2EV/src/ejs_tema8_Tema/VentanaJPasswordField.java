package ejs_tema8_Tema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.DropMode;

public class VentanaJPasswordField extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblTexto;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJPasswordField frame = new VentanaJPasswordField();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void comprobarDatos(String usuario, char[] contraseña) {
		if (usuario.equals("1dw3") && new String(contraseña).equals("1dw3")) {
			lblTexto.setText("Bienvenido");
		} else {
			lblTexto.setText("Datos incorrectos.");
		}
	}

	/**
	 * Create the frame.
	 */
	public VentanaJPasswordField() {
		setTitle("Evento Clic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		 lblTexto = new JLabel("Anónimo");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setBounds(0, 36, 434, 14);
		contentPane.add(lblTexto);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarDatos(txtNombre.getText(), passwordField.getPassword());
			}
		});
		btnAceptar.setBounds(149, 202, 89, 23);
		contentPane.add(btnAceptar);

		txtNombre = new JTextField();
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarDatos(txtNombre.getText(), passwordField.getPassword());
			}
		});
		txtNombre.setToolTipText("");
		txtNombre.setBounds(149, 107, 144, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setBounds(149, 138, 144, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(149, 90, 104, 14);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarDatos(txtNombre.getText(), passwordField.getPassword());
			}
		});
		passwordField.setBounds(149, 163, 144, 20);
		contentPane.add(passwordField);
	}

}
