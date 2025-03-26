package Vista_EJ5W;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controlador_EJ5W.Controlador;
import Modelo_EJ5W.Gato;
import Modelo_EJ5W.Mascota;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Mascotas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Mascota> mascotas;
	private DefaultTableModel modelo;
	private JTable table;
	private JButton btnBorrarSeleccionado;
	private Controlador controlador = new Controlador();
	private JButton btnGato;

	
	public Mascotas() {
		setResizable(false);
		setTitle("Mascotas");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 687, 370);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		modelo = new DefaultTableModel(new String[]{"Identificador","Tipo", "Nombre", "Edad", "DNI"}, 0);
		table = new JTable(modelo);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
	
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				Mascota mascotaSeleccionada = mascotaSeleccionada();
				if (mascotaSeleccionada != null) {
					btnBorrarSeleccionado.setVisible(true);
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 647, 208);
		scrollPane.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnPerro = new JButton("Crear perro");
		btnPerro.setForeground(Color.BLACK);
		btnPerro.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnPerro.setBackground(Color.WHITE);
		btnPerro.setBounds(461, 15, 196, 51);
		contentPane.add(btnPerro);
		btnGato = new JButton("Crear gato");
		btnGato.setForeground(Color.BLACK);
		btnGato.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnGato.setBackground(Color.WHITE);
		btnGato.setBounds(255, 15, 196, 51);
		contentPane.add(btnGato);
		
	

		btnBorrarSeleccionado = new JButton("Borrar mascota seleccionada");
		btnBorrarSeleccionado.setForeground(Color.BLACK);
		btnBorrarSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrarSeleccionado.setBackground(Color.WHITE);
		btnBorrarSeleccionado.setBounds(10, 285, 261, 35);
		btnBorrarSeleccionado.setVisible(false);
		contentPane.add(btnBorrarSeleccionado);

	
		
		btnPerro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoPerro nuevo = new NuevoPerro();
				setVisible(false);
			nuevo.setVisible(true);
			}
		});
		btnGato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoGato nuevo = new NuevoGato();
				setVisible(false);
			nuevo.setVisible(true);
			}
		});
	
		btnBorrarSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarMascota();
			}
		});
		
		JLabel lbl = new JLabel("Mascotas");
		lbl.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbl.setBounds(10, 11, 160, 51);
		contentPane.add(lbl);

	
		
		mascotas();
	}

	public Mascota mascotaSeleccionada() {
		if (table.getSelectedRow() != -1) {
			String IDSeleccionado =  table.getValueAt(table.getSelectedRow(), 0).toString();
			for (int i = 0; i < mascotas.size(); i++) {
				String id = mascotas.get(i).getIdentificador()+"";
				if (id.equals(IDSeleccionado)) {
					return mascotas.get(i);
				}
			}
		}
		return null;
	}



	public void mascotas() {
		modelo.setRowCount(0);
		try {
			mascotas = controlador.todasMascotas();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la base de datos" + sqle.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error génerico" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		for (int i = 0; i < mascotas.size(); i++) {
			String[] fila = new String[6];
			fila[0] = mascotas.get(i).getIdentificador()+"";
			fila[1] = (mascotas.get(i) instanceof Gato )?"Gato":"Perro";
			fila[2] = mascotas.get(i).getNombre();
			fila[3] = mascotas.get(i).getEdad()+"";
			fila[4] = mascotas.get(i).getDni();

			modelo.addRow(fila);
		}

	}

	public void eliminarMascota() {
		try {
			if (controlador.eliminarMascotaID(mascotaSeleccionada().getIdentificador()) == true) {
				JOptionPane.showMessageDialog(null, "Mascota eliminada correctamente.", "Mascotas",
						JOptionPane.INFORMATION_MESSAGE);
				mascotas();
				btnBorrarSeleccionado.setVisible(false);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la base de datos" + sqle.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error génerico" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
