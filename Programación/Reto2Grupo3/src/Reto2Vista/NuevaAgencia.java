package Reto2Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Reto2Controlador.Controlador;
import Reto2Modelo.Agencia;
import Reto2Modelo.Viaje;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class NuevaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreAgencia;
	private JTextField txtColor;
	private JTextField txtLogo;
	private JTextField txtContraseña;
	private Controlador controlador = new Controlador();
	private JComboBox comboBoxTipoAgencia;
	private JComboBox comboBoxNumeroEmpleados;
	private JPanel panelColor;
	private JLabel lblNewLabel_1;
	private JTextField txtRepetirContraseña;

	/**
	 * Create the frame.
	 */
	public NuevaAgencia() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setTitle("Nueva agencia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 425, 796);
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreAgencia = new JLabel("Nombre de la agencia");
		lblNombreAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNombreAgencia.setBounds(26, 82, 307, 32);
		contentPane.add(lblNombreAgencia);

		JLabel lblColorMarca = new JLabel("Color de Marca");
		lblColorMarca.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblColorMarca.setBounds(26, 163, 307, 32);
		contentPane.add(lblColorMarca);

		JLabel lblNumeroEmpleados = new JLabel("Número de empleados");
		lblNumeroEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNumeroEmpleados.setBounds(26, 245, 307, 32);
		contentPane.add(lblNumeroEmpleados);

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblLogo.setBounds(26, 405, 356, 32);
		contentPane.add(lblLogo);

		txtNombreAgencia = new JTextField();
		txtNombreAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtNombreAgencia.setBounds(26, 125, 356, 35);
		contentPane.add(txtNombreAgencia);
		txtNombreAgencia.setColumns(10);

		txtColor = new JTextField("#");
		txtColor.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColor.setBackground( Color.decode(txtColor.getText()));
			}
		});
		txtColor.setColumns(10);
		txtColor.setBounds(26, 206, 258, 35);
		contentPane.add(txtColor);

		txtLogo = new JTextField();
		txtLogo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtLogo.setColumns(10);
		txtLogo.setBounds(24, 448, 358, 35);
		contentPane.add(txtLogo);

		JLabel lblTipoAgencia = new JLabel("Tipo de Agencia");
		lblTipoAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTipoAgencia.setBounds(26, 332, 307, 32);
		contentPane.add(lblTipoAgencia);

		comboBoxNumeroEmpleados = new JComboBox();
		comboBoxNumeroEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBoxNumeroEmpleados.setModel(new DefaultComboBoxModel(new String[] {"", "Entre 2 y 10 empleados", "Entre 10 y 100 empleados", "Entre 100 y 1000 empleados"}));
		comboBoxNumeroEmpleados.setBounds(26, 288, 356, 33);
		contentPane.add(comboBoxNumeroEmpleados);

		comboBoxTipoAgencia = new JComboBox();
		comboBoxTipoAgencia.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBoxTipoAgencia
				.setModel(new DefaultComboBoxModel(new String[] {"", "mayorista", "minorista", "mayorista-minorista"}));
		comboBoxTipoAgencia.setBounds(24, 371, 358, 33);
		contentPane.add(comboBoxTipoAgencia);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarAgencia() == true) {
					dispose();
				}

			}
		});
		btnGuardar.setBounds(26, 673, 164, 38);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(220, 673, 164, 38);
		contentPane.add(btnCancelar);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblContrasea.setBounds(24, 494, 309, 27);
		contentPane.add(lblContrasea);

		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(26, 530, 356, 35);
		contentPane.add(txtContraseña);
		
		panelColor = new JPanel();
		panelColor.setBackground(new Color(255, 255, 255));
		panelColor.setBounds(294, 206, 88, 35);
		contentPane.add(panelColor);
		
		lblNewLabel_1 = new JLabel("Nueva agencia");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 37));
		lblNewLabel_1.setBounds(0, 11, 409, 57);
		contentPane.add(lblNewLabel_1);
		
		txtRepetirContraseña = new JPasswordField();
		txtRepetirContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtRepetirContraseña.setColumns(10);
		txtRepetirContraseña.setBounds(26, 627, 356, 35);
		contentPane.add(txtRepetirContraseña);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir contraseña");
		lblRepetirContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblRepetirContrasea.setBounds(24, 591, 309, 27);
		contentPane.add(lblRepetirContrasea);
	}

	public boolean validarAgencia() {
		String NombreAgencia = txtNombreAgencia.getText();
		String TipoAgencia = comboBoxTipoAgencia.getSelectedItem() + "";
		String NumeroEmpleados = comboBoxNumeroEmpleados.getSelectedItem() + "";
		String ColorMarca = txtColor.getText();
		String Logo = txtLogo.getText();
		String Contraseña = txtContraseña.getText();
		String Rcontraseña = txtRepetirContraseña.getText();
		
		ArrayList<String> mensajeError = new ArrayList<String>();
		if ((NombreAgencia.length() >= 1 || NombreAgencia.length() >= 30) == false) {
			mensajeError.add( "Nombre de agencia incorrecto.");
		}
		if (TipoAgencia.length() == 0) {
			mensajeError.add( "Tipo de agencia incorrecto");
		}
		if (NumeroEmpleados.length() == 0) {
			mensajeError.add( "Número de empleados incorrecto");
		}
		if (ColorMarca.length() != 7) {
			mensajeError.add( "Color de marca incorrecto, tiene que tener 7 caracteres incluyendo el #");
		}
		if (Logo.length() == 0) {
			mensajeError.add( "Logo incorrecto");
		}
		if (Contraseña.length() == 0) {
			mensajeError.add( "Contraseña incorrecto");
		}
		if(Rcontraseña.length()==0) {
			mensajeError.add( "El campo repetir contraseña no puede estar vacio");
		}
		if (Contraseña.equals( Rcontraseña) == false) {
			mensajeError.add( "Las dos contraseñas no coinciden");
		}
		if (mensajeError.size()==0) {
			Agencia agencia = new Agencia();
			agencia.setNombreAgencia(NombreAgencia);
			agencia.setColorMarca(ColorMarca);
			agencia.setContraseña(Contraseña);
			agencia.setLogo(Logo);
			agencia.setTipoAgencia(TipoAgencia);
			agencia.setNumeroEmpleados(NumeroEmpleados);
			if(controlador.insertarAgencia(agencia)== true) {
				JOptionPane.showMessageDialog(null, "Agencia creada correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null,"- " + String.join("\n - ", mensajeError), "Error al crear agencia ",
					JOptionPane.ERROR_MESSAGE);
		}
		return mensajeError.size()==0;
	}
}
