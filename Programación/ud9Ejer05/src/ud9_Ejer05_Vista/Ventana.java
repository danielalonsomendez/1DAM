package ud9_Ejer05_Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ud9Ejer05_Modelo_Pojos.Alumno;
import ud9_Ejer05_Controlador.Controlador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDNI;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldGrupo;
	private DefaultTableModel modelo;
	private JTable table;
	private Controlador controlador = new Controlador();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Ejer 05");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 438, 158);
		contentPane.add(scrollPane);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("DNI");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Grupo");

		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(21, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(106, 27, 186, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(21, 58, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(106, 55, 186, 20);
		contentPane.add(textFieldNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellidos");
		lblNewLabel_1_1.setBounds(21, 86, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(106, 83, 186, 20);
		contentPane.add(textFieldApellidos);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Grupo");
		lblNewLabel_1_1_1.setBounds(21, 114, 75, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textFieldGrupo = new JTextField();
		textFieldGrupo.setColumns(10);
		textFieldGrupo.setBounds(106, 111, 186, 20);
		contentPane.add(textFieldGrupo);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			añadirAlumno(textFieldDNI.getText(),textFieldNombre.getText(),textFieldApellidos.getText(),textFieldGrupo.getText());
			}
		});
		btnAnadir.setBounds(327, 58, 89, 23);
		contentPane.add(btnAnadir);
		rellenarTablaAlumnos();
	}
	private void añadirAlumno(String dni,String nombre,String apellidos,String grupo) {
		Alumno alumno = new Alumno();
		alumno.setDni(dni);
		alumno.setNombre(nombre);
		alumno.setApellidos(apellidos);
		alumno.setGrupo(grupo);
		System.out.println(alumno);
		controlador.insertarAlumno(alumno);
		rellenarTablaAlumnos();
	}
	private void rellenarTablaAlumnos() {
		modelo.setRowCount(0);
		ArrayList<Alumno> alumnos = controlador.mostrarTodosAlumnos();
		for(Alumno alumno: alumnos) {
			String[] fila= new String[4];
			fila[0] =  alumno.getDni();
			fila[1] =  alumno.getNombre();
			fila[2] =  alumno.getApellidos();
			fila[3] =  alumno.getGrupo();
			modelo.addRow(fila);

		}
	}
}
