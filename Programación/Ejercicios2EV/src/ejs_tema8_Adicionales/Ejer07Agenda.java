package ejs_tema8_Adicionales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Ejer07Agenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tnombre;
	private JTextField tapellidos;
	private JTextField ttelefono;
	private JTextField tDNI;
	private String[][] formularios = new String[5][4];
	private JTable table;
	private JButton btnLimpiarTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer07Agenda frame = new Ejer07Agenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean validarDatos(String nombre, String apellidos, String dni, String telefono) {
		boolean valido = true;
		if (((nombre.length() >= 1 || nombre.length() >= 20) && contiene(nombre, "numeros") == false
				&& contiene(nombre, "letras") == true) == false) {
			valido = false;
		}
		if (((apellidos.length() >= 1 || apellidos.length() >= 30) && contiene(apellidos, "numeros") == false
				&& contiene(apellidos, "letras") == true) == false) {
			valido = false;
		}
		if ((dni.length() == 9 && comprobarDNI(dni) == true) == false) {
			valido = false;
		}
		if ((contiene(telefono, "numeros") == true && contiene(telefono, "letras") == false) == false) {
			valido = false;
		}
		return valido;
	}

	public boolean contiene(String s, String v) {
		boolean c = true;
		char[] stSeparado = s.toCharArray();
		for (int i = 0; i < stSeparado.length; i++) {
			if ((v == "numeros" && Character.isDigit(stSeparado[i]) == false)
					|| (v == "letras" && (Character.isLetter(stSeparado[i]) == false && Character.isWhitespace(stSeparado[i]) == false))) {
				c = false;
			}
		}
		return c;
	}

	public boolean comprobarDNI(String dni) {
		boolean valido = true;

		if (dni.length() == 9) {
			char[] dniSeparado = dni.toCharArray();
			for (int i = 0; i < dniSeparado.length; i++) {
				if (((i <= 7 && Character.isDigit(dniSeparado[i]))
						|| (i == 8 && Character.isLetter(dniSeparado[i]))) == false) {
					valido = false;
				}
			}
		} else {
			valido = false;
		}
		return valido;
	}
	public static int numeroArray(String[][] array) {
		int cantidadProductos = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] != null) {
				cantidadProductos++;
			}
		}
		return cantidadProductos;
	}
	public  void limpiarDatos() {
		tnombre.setText("");
		tapellidos.setText("");
		tDNI.setText("");
		ttelefono.setText("");
	}
	/**
	 * Create the frame.
	 */
	public Ejer07Agenda() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 27, 63, 14);
		contentPane.add(lblNombre);

		tnombre = new JTextField();
		tnombre.setToolTipText("");
		tnombre.setColumns(10);
		tnombre.setBounds(83, 24, 227, 20);
		contentPane.add(tnombre);

		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(10, 55, 63, 14);
		contentPane.add(lblApellido);

		tapellidos = new JTextField();
		tapellidos.setToolTipText("");
		tapellidos.setColumns(10);
		tapellidos.setBounds(83, 52, 227, 20);
		contentPane.add(tapellidos);

		ttelefono = new JTextField();
		ttelefono.setToolTipText("");
		ttelefono.setColumns(10);
		ttelefono.setBounds(83, 80, 227, 20);
		contentPane.add(ttelefono);

		JLabel lblTel = new JLabel("Télefono:");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(10, 83, 63, 14);
		contentPane.add(lblTel);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDNI.setBounds(10, 115, 63, 14);
		contentPane.add(lblDNI);

		tDNI = new JTextField();
		tDNI.setToolTipText("");
		tDNI.setColumns(10);
		tDNI.setBounds(83, 111, 227, 22);
		contentPane.add(tDNI);

		JButton btnNewButton = new JButton("Añadir contacto a la agenda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroa = numeroArray(formularios);

				if(numeroa != formularios.length) {
				boolean datosValidos = validarDatos(tnombre.getText().trim(), tapellidos.getText().trim(),
						tDNI.getText().trim(), ttelefono.getText().trim());
				if (datosValidos) {
					formularios[numeroa][0]=tnombre.getText();
					formularios[numeroa][1]=tapellidos.getText();
					formularios[numeroa][2]=ttelefono.getText();
					formularios[numeroa][3]=tDNI.getText();
					table.repaint();
					limpiarDatos();
					btnLimpiarTabla.setVisible(true);

					JOptionPane.showMessageDialog(null, "Datos añadidos", "Datos añadidos",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos. Vuelve a intentarlo",
							"Datos incorrectos. Vuelve a intentarlo", JOptionPane.ERROR_MESSAGE);
				}
				} else {
					JOptionPane.showMessageDialog(null, "No se pueden añadir más elementos",
							"No se pueden añadir más elementos", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(320, 23, 232, 46);
		contentPane.add(btnNewButton);

		JButton btnLimpiarDatos = new JButton("Limpiar datos");
		btnLimpiarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
			}

		});
		btnLimpiarDatos.setBounds(320, 80, 232, 49);
		contentPane.add(btnLimpiarDatos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 542, 106);
		contentPane.add(scrollPane);
		String[] columnNames = { "Nombre", "Apellidos", "Telefono", "DNI" };

		table = new JTable(formularios,columnNames);
        table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		btnLimpiarTabla = new JButton("Limpiar tabla");
		btnLimpiarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroa = numeroArray(formularios);
				if(numeroa !=0) {
					for(int i=0;i<numeroa;i++) {
					formularios[i][0]=null;
					formularios[i][1]=null;
					formularios[i][2]=null;
					formularios[i][3]=null;
					}
				 table.repaint();
					btnLimpiarTabla.setVisible(false);

				 } 
			}
		});
		btnLimpiarTabla.setBounds(10, 257, 542, 22);
		contentPane.add(btnLimpiarTabla);
		btnLimpiarTabla.setVisible(false);
	}
}
