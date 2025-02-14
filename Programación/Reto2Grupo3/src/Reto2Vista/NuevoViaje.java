package Reto2Vista;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Reto2Modelo.Agencia;
import Reto2Modelo.Pais;
import Reto2Modelo.Viaje;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;

import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingConstants;

public class NuevoViaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreViaje;
	private JTextArea txtServiciosNoIncluidos;
	private DefaultComboBoxModel<String> modeloPais;
	private JComboBox<String> cbTipoViaje;
	private JComboBox<String> cbPais;
	private JDateChooser chooserFechaIncio;
	private JDateChooser chooserFechaFin;
	private JTextArea txtDescripcion;
	private JLabel lblDiasViaje;
	private Controlador controlador = new Controlador();
	private Font fuentePlain = new Font("Segoe UI", Font.PLAIN, 20);
	private Font fuenteBold = new Font("Segoe UI", Font.BOLD, 20);
	
	public NuevoViaje(Agencia agencia, ArrayList<Pais> paises) {
		setFont(fuentePlain);
		setResizable(false);
		setTitle("Crear viaje | " + agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1000, 650);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setBorder(null);
		panelIzquierda.setBackground(Color.decode(agencia.getColorMarca()));
		panelIzquierda.setBounds(0, 0, 304, 700);
		panelIzquierda.setLayout(null);
		contentPane.add(panelIzquierda);

		ImageIcon image = null;
		try {
			image = new ImageIcon(new URL(agencia.getLogo()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		JLabel lblLogo = new JLabel(new ImageIcon(image.getImage().getScaledInstance(256, 173, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(15, 15, 256, 173);
		panelIzquierda.add(lblLogo);


		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(fuenteBold);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(10, 540, 284, 38);
		panelIzquierda.add(btnCancelar);

		JButton btnGenerarOfertaViaje = new JButton("Guardar");
		btnGenerarOfertaViaje.setForeground(new Color(0, 0, 0));
		btnGenerarOfertaViaje.setFont(fuenteBold);
		btnGenerarOfertaViaje.setBackground(new Color(255, 255, 255));
		btnGenerarOfertaViaje.setBounds(10, 491, 284, 38);
		panelIzquierda.add(btnGenerarOfertaViaje);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio ventana = new Inicio(agencia);
				ventana.setVisible(true);
			}
		});
		btnGenerarOfertaViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarViaje(agencia, paises);
			}
		});
		txtNombreViaje = new JTextField();
		txtNombreViaje.setFont(fuentePlain);
		txtNombreViaje.setColumns(10);
		txtNombreViaje.setBounds(334, 76, 580, 35);
		contentPane.add(txtNombreViaje);

		cbTipoViaje = new JComboBox<String>();
		cbTipoViaje.setBackground(Color.white);
		cbTipoViaje.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "Novios", "Senior", "Grupos", "Grandes viajes(destinos exoticos)",
						"Combinado(vuelo+hotel)", "Escapadas", "Familias con niños menores" }));
		cbTipoViaje.setFont(fuentePlain);
		cbTipoViaje.setBounds(334, 182, 273, 33);
		contentPane.add(cbTipoViaje);

		chooserFechaIncio = new JDateChooser(Calendar.getInstance().getTime());
		chooserFechaIncio.getCalendarButton().setFont(fuentePlain);
		chooserFechaIncio.setSize(273, 35);
		chooserFechaIncio.setFont(fuentePlain);
		chooserFechaIncio.setLocation(334, 269);
		chooserFechaIncio.addPropertyChangeListener("date", e -> calcularDias());
		contentPane.add(chooserFechaIncio);


		chooserFechaFin = new JDateChooser(Calendar.getInstance().getTime());
		chooserFechaFin.getCalendarButton().setFont(fuentePlain);
		chooserFechaFin.setFont(fuentePlain);
		chooserFechaFin.setBounds(641, 269, 273, 35);
		chooserFechaFin.addPropertyChangeListener("date", e -> calcularDias());
		contentPane.add(chooserFechaFin);

		txtDescripcion = new JTextArea();
		txtDescripcion.setFont(fuentePlain);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(334, 404, 580, 60);
		contentPane.add(txtDescripcion);


		txtServiciosNoIncluidos = new JTextArea();
		txtServiciosNoIncluidos.setFont(fuentePlain);
		txtServiciosNoIncluidos.setColumns(10);
		txtServiciosNoIncluidos.setBounds(334, 517, 580, 60);
		contentPane.add(txtServiciosNoIncluidos);

		modeloPais = new DefaultComboBoxModel<String>();
		cbPais = new JComboBox<String>(modeloPais);
		cbPais.setBackground(Color.white);
		cbPais.setFont(fuentePlain);
		cbPais.setBounds(638, 182, 273, 33);
		contentPane.add(cbPais);
		rellenarpaises(paises);

		JPanel panelDias = new JPanel();
		panelDias.setBounds(334, 314, 580, 41);
		panelDias.setBackground(Color.white);
		contentPane.add(panelDias);
		
		//LABELS
		JLabel lblTipoDelViaje = new JLabel("Tipo de viaje");
		lblTipoDelViaje.setFont(fuentePlain);
		lblTipoDelViaje.setBounds(334, 139, 264, 32);
		contentPane.add(lblTipoDelViaje);
		
		JLabel lblNombreAgencia = new JLabel(agencia.getNombreAgencia());
		lblNombreAgencia.setFont(fuenteBold);
		lblNombreAgencia.setForeground(Inicio.colorTexto(Color.decode(agencia.getColorMarca())));
		lblNombreAgencia.setBounds(15, 196, 256, 38);
		panelIzquierda.add(lblNombreAgencia);
		
		JLabel lblTitulo2 = new JLabel("Crear viaje");
		lblTitulo2.setForeground(Inicio.colorTexto(Color.decode(agencia.getColorMarca())));
		lblTitulo2.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblTitulo2.setBounds(15, 244, 256, 54);
		panelIzquierda.add(lblTitulo2);

		JLabel lblNombreDelViaje = new JLabel("Nombre del viaje");
		lblNombreDelViaje.setFont(fuentePlain);
		lblNombreDelViaje.setBounds(334, 33, 273, 32);
		contentPane.add(lblNombreDelViaje);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setFont(fuentePlain);
		lblFechaInicio.setBounds(334, 226, 273, 32);
		contentPane.add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setFont(fuentePlain);
		lblFechaFin.setBounds(641, 226, 273, 32);
		contentPane.add(lblFechaFin);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setFont(fuentePlain);
		lblDescripcin.setBounds(334, 359, 580, 41);
		contentPane.add(lblDescripcin);

		JLabel lblServiciosNoIncluidos = new JLabel("Servicios no incluidos");
		lblServiciosNoIncluidos.setFont(fuentePlain);
		lblServiciosNoIncluidos.setBounds(334, 474, 580, 41);
		contentPane.add(lblServiciosNoIncluidos);
		
		JLabel lblPais = new JLabel("Pais de destino");
		lblPais.setFont(fuentePlain);
		lblPais.setBounds(638, 139, 273, 32);
		contentPane.add(lblPais);
		
		lblDiasViaje = new JLabel("Duración del viaje: 1 día");
		lblDiasViaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiasViaje.setFont(fuentePlain);
		lblDiasViaje.setBounds(334, 314, 580, 41);
		panelDias.add(lblDiasViaje);
		
		
	}

	public void rellenarpaises(ArrayList<Pais> paises) {
		modeloPais.addElement("");
		for (Pais pais : paises) {
			modeloPais.addElement(pais.getDescripcionPais());
		}
	}

	public void calcularDias() {
			long dias = TimeUnit.DAYS.convert(
					chooserFechaFin.getDate().getTime() - chooserFechaIncio.getDate().getTime(), TimeUnit.MILLISECONDS)+1;
			if (dias>0 ) {
				lblDiasViaje.setText("Duración del viaje: " + dias + (dias == 1?" día": " días"));
			} else {
				lblDiasViaje.setText("La FECHA FIN no puede ser antes que la FECHA INICIO");

			}
		
	}

	public boolean validarViaje(Agencia agencia, ArrayList<Pais> paises) {
		String NombreViaje = txtNombreViaje.getText();
		String TipoViaje = cbTipoViaje.getSelectedItem() + "";
		String Pais = cbPais.getSelectedItem() + "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String FechaInicio = df.format(chooserFechaIncio.getDate());
		String FechaFin = df.format(chooserFechaFin.getDate());
		String Descripcion = txtDescripcion.getText();
		String ServiciosNoIncluidos = txtServiciosNoIncluidos.getText();

		ArrayList<String> mensajeError = new ArrayList<String>();
		if ((NombreViaje.length() >= 1 || NombreViaje.length() >= 30) == false) {
			mensajeError.add("Nombre del viaje no puede estar vacio");
		}
		if (TipoViaje.length() == 0) {
			mensajeError.add("Tipo de viaje no puede estar vacio");
		}
		if (Pais.length() == 0) {
			mensajeError.add("País no puede estar vacio");
		}
		if (FechaInicio.length() == 0) {
			mensajeError.add("Fecha de inicio no puede estar vacio");
		}
		if (FechaFin.length() == 0) {
			mensajeError.add("Fecha de fin no puede estar vacio");
		}
		if ((chooserFechaIncio.getDate().before(chooserFechaFin.getDate()) || chooserFechaIncio.getDate().equals(chooserFechaFin.getDate())) == false) {
			mensajeError.add("Fecha fin no puede ser antes que fecha inicio");
		}
		if (Descripcion.length() == 0) {
			mensajeError.add("Descripción no puede estar vacio");

		}
		if (ServiciosNoIncluidos.length() == 0) {
			mensajeError.add("Servicios no incluidos no puede estar vacio");
		}
		if (mensajeError.size() == 0) {
			Viaje viaje = new Viaje();
			viaje.setNombreAgencia(agencia);
			viaje.setNombreViaje(NombreViaje);
			viaje.setTipoViaje(TipoViaje);
			for (Pais pais : paises) {
				if (pais.getDescripcionPais().equals(Pais)) {
					viaje.setPaisDestino(pais);
				}
			}
			viaje.setFechaInicio(FechaInicio);
			viaje.setFechaFin(FechaFin);
			viaje.setDescripciónViaje(Descripcion);
			viaje.setServiciosNoIncluidos(ServiciosNoIncluidos);
			if (controlador.insertarViaje(viaje) == true) {
				dispose();
				Inicio ventana = new Inicio(agencia);
				ventana.setVisible(true);
				JOptionPane.showMessageDialog(null, "¡Viaje `" + NombreViaje + "' creado correctamente!",
						agencia.getNombreAgencia(), JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, " - " + String.join("\n - ", mensajeError),
					"Error al crear viaje | " + agencia.getNombreAgencia(), JOptionPane.ERROR_MESSAGE);
		}
		return mensajeError.size() == 0;
	}
}
