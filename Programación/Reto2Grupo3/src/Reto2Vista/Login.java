package Reto2Vista;

import java.awt.EventQueue;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Reto2Controlador.Controlador;
import Reto2Modelo.Agencia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreAgencia;
	private JPasswordField txtContraseña;
	private Controlador controlador = new Controlador();

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Iniciar sesión");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JPanel pnl_login = new JPanel();
		pnl_login.setBackground(new Color(255, 255, 255));
		pnl_login.setBounds(277, 150, 446, 349);
		contentPane.add(pnl_login);
		pnl_login.setLayout(null);

		txtNombreAgencia = new JTextField();
		txtNombreAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreAgencia.setBounds(32, 118, 384, 38);
		pnl_login.add(txtNombreAgencia);
		txtNombreAgencia.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre de la agencia");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(32, 87, 332, 27);
		pnl_login.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(32, 167, 332, 27);
		pnl_login.add(lblNewLabel_1_1);

		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(32, 205, 384, 38);
		pnl_login.add(txtContraseña);

		JButton btnInciarSesion = new JButton("Iniciar sesión");
		btnInciarSesion.setForeground(new Color(255, 255, 255));
		btnInciarSesion.setBackground(new Color(0, 0, 0));
		btnInciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnInciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNombreAgencia.getText().equals("") && txtContraseña.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nombre de agencia y contraseña incorrectos.", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else if (txtNombreAgencia.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Nombre de agencia incorrecto.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (txtContraseña.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Agencia agenciaLogin = controlador.login(txtNombreAgencia.getText(), txtContraseña.getText());
					if (agenciaLogin == null) {
						JOptionPane.showMessageDialog(null, "Nombre de agencia y contraseña incorrectos.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Inicio ventana = new Inicio(agenciaLogin);
						ventana.setVisible(true);
						dispose();
					}
				}
			}
		});
		btnInciarSesion.setBounds(32, 279, 183, 38);
		pnl_login.add(btnInciarSesion);

		JButton btnNuevaAgencia = new JButton("Nueva agencia");
		btnNuevaAgencia.setBackground(new Color(0, 0, 0));
		btnNuevaAgencia.setForeground(new Color(255, 255, 255));
		btnNuevaAgencia.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNuevaAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaAgencia ventana = new NuevaAgencia();
				ventana.setVisible(true);
			}
		});
		btnNuevaAgencia.setBounds(233, 279, 183, 38);
		pnl_login.add(btnNuevaAgencia);
		
		JLabel lblNewLabel_1_2 = new JLabel("Iniciar sesión");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 37));
		lblNewLabel_1_2.setBounds(0, 11, 446, 57);
		pnl_login.add(lblNewLabel_1_2);

		JPanel fondo = new JPanel();
		fondo.setBounds(0, 0, 1000, 650);
		fondo.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(fondo);
		fondo.setLayout(new BorderLayout(0, 0));
		ImageIcon image = new ImageIcon(getClass().getResource("/Reto2Img/fondo1.jpg"));
		JLabel lblNewLabel = new JLabel(
				new ImageIcon(image.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT)));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnl_login.setVisible(true);
			}
		});
		fondo.add(lblNewLabel);
		pnl_login.setVisible(false);
	}
}
