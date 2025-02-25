package Reto2Vista;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Reto2Modelo.Aerolinea;
import Reto2Modelo.Aeropuerto;
import Reto2Modelo.Agencia;
import Reto2Modelo.Viaje;
import Reto2Modelo.Vuelo;
import Reto2Modelo.Alojamiento;
import Reto2Modelo.Otros;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

public class NuevoEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelIzquierda;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private Controlador controlador = new Controlador();
	private Font fuentePlain = new Font("Segoe UI", Font.PLAIN, 20);
	private Font fuenteBold = new Font("Segoe UI", Font.BOLD, 20);
	// MODELOS: COMBO BOX
	private DefaultComboBoxModel<String> modeloAeropuertosOrigen;
	private DefaultComboBoxModel<String> modeloAeropuertosDestino;
	private DefaultComboBoxModel<String> modeloAerolineasIda;
	private DefaultComboBoxModel<String> modeloAerolineasVuelta;
	// PANELES POR SECCIÓN
	private JPanel panelAlojamiento;
	private JPanel panelOtros;
	private JPanel panelVuelo;
	private JPanel panelVueloVuelta;
	// EVENTO: COMUNES
	private JTextField txtNombreEvento;
	private JRadioButton rdbtnVuelo;
	private JRadioButton rdbtnAlojamiento;
	private JRadioButton rdbtnOtros;
	// EVENTO: PRECIOS
	private JSpinner spinnerPrecioAlojamiento;
	private JSpinner spinnerPrecioVuelo;
	private JSpinner spinnerPrecioOtros;
	// ALOJAMIENTO
	private JTextField txtCiudad;
	private JTextField txtNombreHotel;
	private JDateChooser chooserEntrada;
	private JDateChooser chooserSalida;
	private JComboBox<String> cbTipoHabitacion;
	private String TipoHabitacion = "";
	// VUELO: SELECTOR TIPO
	private JRadioButton rdbtnVueloIdaVuelta;
	private JRadioButton rdbtnVueloIda;
	// VUELO: IDA
	private JComboBox<String> cbA_Origen;
	private JComboBox<String> cbA_Destino;
	private JComboBox<String> cbAerolinea;
	private JSpinner spinnerHoraSalida;
	private JDateChooser chooserVueloFechaSalida;
	private JTextField txtCodigoVuelo;
	private JTextField txtDuracionVuelo;
	// VUELO: VUELTA
	private JComboBox<String> cbAerolineaVuelta;
	private JTextField txtCodigoVueloVuelta;
	private JDateChooser chooserVueloFechaSalidaVuelta;
	private JSpinner spinnerHoraSalidaVuelta;
	private JTextField txtDuracionVueloVuelta;
	// OTROS
	private JDateChooser chooserFechaOtros;
	private JTextArea txtDescripcionOtros;

	public NuevoEvento(Viaje viaje, Agencia agencia, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		setResizable(false);
		setTitle("Crear evento | " + agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		panelIzquierda = new JPanel();
		panelIzquierda.setBorder(null);
		panelIzquierda.setBackground(Color.decode(agencia.getColorMarca()));
		panelIzquierda.setBounds(0, 0, 304, 700);
		panelIzquierda.setLayout(null);
		contentPane.add(panelIzquierda);

		JLabel lblNombreAgencia = new JLabel(agencia.getNombreAgencia());
		lblNombreAgencia.setFont(fuenteBold);
		lblNombreAgencia.setForeground(Inicio.colorTexto(Color.decode(agencia.getColorMarca())));
		lblNombreAgencia.setBounds(15, 196, 256, 38);
		panelIzquierda.add(lblNombreAgencia);

		JLabel lblCrearEvento = new JLabel("Crear evento");
		lblCrearEvento.setForeground(Inicio.colorTexto(Color.decode(agencia.getColorMarca())));
		lblCrearEvento.setFont(new Font("Segoe UI", Font.BOLD, 40));
		lblCrearEvento.setBounds(15, 244, 256, 54);
		panelIzquierda.add(lblCrearEvento);

		JLabel lblNombreEvento = new JLabel("Nombre del evento");
		lblNombreEvento.setFont(fuentePlain);
		lblNombreEvento.setBounds(355, 12, 250, 32);
		contentPane.add(lblNombreEvento);

		JLabel lblTipoEvento = new JLabel("Tipo de evento");
		lblTipoEvento.setFont(fuentePlain);
		lblTipoEvento.setBounds(355, 108, 250, 32);
		contentPane.add(lblTipoEvento);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(fuenteBold);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(10, 540, 284, 38);
		panelIzquierda.add(btnCancelar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setFont(fuenteBold);
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setBounds(10, 491, 284, 38);
		panelIzquierda.add(btnGuardar);

		txtNombreEvento = new JTextField();
		txtNombreEvento.setFont(fuentePlain);
		txtNombreEvento.setColumns(10);
		txtNombreEvento.setBounds(355, 54, 488, 41);
		contentPane.add(txtNombreEvento);

		rdbtnVuelo = new JRadioButton("Vuelo");
		rdbtnVuelo.setFont(fuentePlain);
		rdbtnVuelo.setBounds(355, 146, 126, 41);
		contentPane.add(rdbtnVuelo);

		rdbtnAlojamiento = new JRadioButton("Alojamiento");
		rdbtnAlojamiento.setFont(fuentePlain);
		rdbtnAlojamiento.setBounds(516, 146, 162, 41);
		contentPane.add(rdbtnAlojamiento);

		rdbtnOtros = new JRadioButton("Otros");
		rdbtnOtros.setFont(fuentePlain);
		rdbtnOtros.setBounds(717, 146, 126, 47);
		contentPane.add(rdbtnOtros);

		ImageIcon image = null;
		try {
			image = new ImageIcon(new URL(agencia.getLogo()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		JLabel lblLogo = new JLabel(new ImageIcon(image.getImage().getScaledInstance(256, 173, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(15, 15, 256, 173);
		panelIzquierda.add(lblLogo);

		rdbtnVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnAlojamiento.setSelected(false);
				rdbtnOtros.setSelected(false);
				tipoEvento();
			}
		});
		rdbtnAlojamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnVuelo.setSelected(false);
				rdbtnOtros.setSelected(false);
				tipoEvento();
			}
		});
		rdbtnOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnAlojamiento.setSelected(false);
				rdbtnVuelo.setSelected(false);
				tipoEvento();
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarEvento(viaje, agencia, aeropuertos, aerolineas);
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio ventana = new Inicio(agencia);
				ventana.setVisible(true);
			}
		});

		modeloAeropuertosOrigen = new DefaultComboBoxModel<String>();
		modeloAeropuertosDestino = new DefaultComboBoxModel<String>();
		modeloAerolineasIda = new DefaultComboBoxModel<String>();
		modeloAerolineasVuelta = new DefaultComboBoxModel<String>();

		desplegarAlojamiento();
		desplegarVuelo(aeropuertos);
		desplegarVueloVuelta();
		desplegarOtros();
		contentPane.add(panelAlojamiento);
		contentPane.add(panelVuelo);
		contentPane.add(panelVueloVuelta);
		contentPane.add(panelOtros);

		cargarComboBoxes(aeropuertos, aerolineas);
		panelAlojamiento.setVisible(false);
		panelOtros.setVisible(false);
		panelVuelo.setVisible(false);
		panelVueloVuelta.setVisible(false);
	}

	public void desplegarAlojamiento() {
		panelAlojamiento = new JPanel();
		panelAlojamiento.setBounds(354, 195, 492, 333);
		panelAlojamiento.setLayout(null);
		Calendar c = Calendar.getInstance();

		chooserEntrada = new JDateChooser(c.getTime());
		chooserEntrada.setFont(fuentePlain);
		chooserEntrada.setBounds(0, 42, 220, 41);
		panelAlojamiento.add(chooserEntrada);

		chooserSalida = new JDateChooser(c.getTime());
		chooserSalida.setFont(fuentePlain);
		chooserSalida.setBounds(269, 42, 220, 41);
		panelAlojamiento.add(chooserSalida);

		JButton btnBuscarAlojamiento = new JButton("Buscar alojamiento en Booking");
		btnBuscarAlojamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCiudad.getText() != null && chooserEntrada.getDate().equals(chooserSalida.getDate()) == false
						&& (chooserEntrada.getDate().before(chooserSalida.getDate())
								|| chooserEntrada.getDate().equals(chooserSalida.getDate()))
						&& Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String url = "https://www.booking.com/searchresults.html?ss=" + txtCiudad.getText() + "&checkin="
							+ df.format(chooserEntrada.getDate()) + "&checkout=" + df.format(chooserSalida.getDate());
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Para acceder a Booking.com, necesitas indicar una ciudad, una fecha de entrada y una fecha de salida",
							"Error al acceder a Booking.com", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarAlojamiento.setBackground(new Color(255, 255, 255));
		btnBuscarAlojamiento.setFont(fuentePlain);
		btnBuscarAlojamiento.setBounds(0, 200, 489, 41);
		panelAlojamiento.add(btnBuscarAlojamiento);

		txtCiudad = new JTextField();
		txtCiudad.setFont(fuentePlain);
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(0, 145, 220, 41);
		panelAlojamiento.add(txtCiudad);

		txtNombreHotel = new JTextField();
		txtNombreHotel.setFont(fuentePlain);
		txtNombreHotel.setColumns(10);
		txtNombreHotel.setBounds(0, 292, 220, 41);
		panelAlojamiento.add(txtNombreHotel);

		spinnerPrecioAlojamiento = new JSpinner();
		spinnerPrecioAlojamiento
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPrecioAlojamiento.setFont(fuentePlain);
		spinnerPrecioAlojamiento.setBounds(269, 145, 195, 41);
		panelAlojamiento.add(spinnerPrecioAlojamiento);

		cbTipoHabitacion = new JComboBox<String>();
		cbTipoHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Tipo = cbTipoHabitacion.getSelectedItem() + "";
				if (Tipo.equals("Doble")) {
					TipoHabitacion = "DB";
				} else if (Tipo.equals("Doble con uso individual")) {
					TipoHabitacion = "DUI";
				} else if (Tipo.equals("Individual")) {
					TipoHabitacion = "SIN";
				} else if (Tipo.equals("Triple")) {
					TipoHabitacion = "TPL";
				}
			}
		});
		cbTipoHabitacion.setBackground(new Color(255, 255, 255));
		cbTipoHabitacion.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "Doble", "Doble con uso individual", "Individual", "Triple" }));
		cbTipoHabitacion.setFont(fuentePlain);
		cbTipoHabitacion.setBounds(270, 292, 219, 41);
		panelAlojamiento.add(cbTipoHabitacion);

		// LABELS
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(fuentePlain);
		lblCiudad.setBounds(0, 106, 203, 41);
		panelAlojamiento.add(lblCiudad);

		JLabel lblNombreHotel = new JLabel("Nombre del hotel");
		lblNombreHotel.setFont(fuentePlain);
		lblNombreHotel.setBounds(0, 251, 249, 41);
		panelAlojamiento.add(lblNombreHotel);

		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntrada.setFont(fuentePlain);
		lblEntrada.setBounds(0, 0, 203, 41);
		panelAlojamiento.add(lblEntrada);

		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setFont(fuentePlain);
		lblSalida.setBounds(269, 0, 203, 41);
		panelAlojamiento.add(lblSalida);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(fuentePlain);
		lblPrecio.setBounds(269, 106, 170, 41);
		panelAlojamiento.add(lblPrecio);

		JLabel lblTipoHab = new JLabel("Tipo de habitacion");
		lblTipoHab.setFont(fuentePlain);
		lblTipoHab.setBounds(269, 251, 195, 41);
		panelAlojamiento.add(lblTipoHab);

		JLabel lblEuro = new JLabel("€");
		lblEuro.setFont(fuentePlain);
		lblEuro.setBounds(473, 149, 16, 32);
		panelAlojamiento.add(lblEuro);
	}

	public void desplegarOtros() {
		panelOtros = new JPanel();
		panelOtros.setBounds(354, 195, 488, 383);
		panelOtros.setLayout(null);

		chooserFechaOtros = new JDateChooser(Calendar.getInstance().getTime());
		chooserFechaOtros.setFont(fuentePlain);
		chooserFechaOtros.setBounds(0, 41, 220, 41);
		panelOtros.add(chooserFechaOtros);
		chooserFechaOtros.getCalendarButton().setFont(fuentePlain);

		spinnerPrecioOtros = new JSpinner();
		spinnerPrecioOtros
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPrecioOtros.setFont(fuentePlain);
		spinnerPrecioOtros.setBounds(269, 41, 186, 41);
		panelOtros.add(spinnerPrecioOtros);

		txtDescripcionOtros = new JTextArea();
		txtDescripcionOtros.setFont(fuentePlain);
		txtDescripcionOtros.setColumns(10);
		txtDescripcionOtros.setBounds(0, 156, 488, 227);
		panelOtros.add(txtDescripcionOtros);

		// LABELS
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(fuentePlain);
		lblFecha.setBounds(0, 0, 203, 41);
		panelOtros.add(lblFecha);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(fuentePlain);
		lblPrecio.setBounds(269, 0, 166, 41);
		panelOtros.add(lblPrecio);

		JLabel lblEuro = new JLabel("€");
		lblEuro.setFont(fuentePlain);
		lblEuro.setBounds(465, 41, 34, 32);
		panelOtros.add(lblEuro);

		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setFont(fuentePlain);
		lblDescripcion.setBounds(0, 105, 478, 41);
		panelOtros.add(lblDescripcion);
	}

	public void desplegarVuelo(ArrayList<Aeropuerto> aeropuertos) {
		Calendar c = Calendar.getInstance();
		panelVuelo = new JPanel();
		panelVuelo.setBounds(354, 195, 493, 473);
		panelVuelo.setLayout(null);

		rdbtnVueloIda = new JRadioButton("Ida");
		rdbtnVueloIda.setFont(fuentePlain);
		rdbtnVueloIda.setBounds(10, 41, 66, 23);
		panelVuelo.add(rdbtnVueloIda);

		rdbtnVueloIdaVuelta = new JRadioButton("Ida y vuelta");
		rdbtnVueloIdaVuelta.setFont(fuentePlain);
		rdbtnVueloIdaVuelta.setBounds(83, 41, 140, 23);
		panelVuelo.add(rdbtnVueloIdaVuelta);

		rdbtnVueloIda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoVuelo("Ida");

			}
		});
		rdbtnVueloIdaVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTipoVuelo("Ida y vuelta");
			}
		});

		spinnerPrecioVuelo = new JSpinner();
		spinnerPrecioVuelo
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerPrecioVuelo.setFont(fuentePlain);
		spinnerPrecioVuelo.setBounds(270, 41, 195, 41);
		panelVuelo.add(spinnerPrecioVuelo);

		cbA_Origen = new JComboBox<String>(modeloAeropuertosOrigen);
		cbA_Origen.setFont(fuentePlain);
		cbA_Origen.setBackground(Color.white);
		cbA_Origen.setBounds(0, 131, 203, 41);
		panelVuelo.add(cbA_Origen);

		cbA_Destino = new JComboBox<String>(modeloAeropuertosDestino);
		cbA_Destino.setFont(fuentePlain);
		cbA_Destino.setBounds(270, 131, 218, 41);
		cbA_Destino.setBackground(Color.white);
		panelVuelo.add(cbA_Destino);

		cbAerolinea = new JComboBox<String>(modeloAerolineasIda);
		cbAerolinea.setFont(fuentePlain);
		cbAerolinea.setBounds(270, 263, 218, 41);
		cbAerolinea.setBackground(Color.white);
		panelVuelo.add(cbAerolinea);

		txtCodigoVuelo = new JTextField();
		txtCodigoVuelo.setFont(fuentePlain);
		txtCodigoVuelo.setColumns(10);
		txtCodigoVuelo.setBounds(0, 344, 250, 41);
		panelVuelo.add(txtCodigoVuelo);

		chooserVueloFechaSalida = new JDateChooser(c.getTime());
		chooserVueloFechaSalida.setFont(fuentePlain);
		chooserVueloFechaSalida.setBounds(0, 427, 250, 41);
		panelVuelo.add(chooserVueloFechaSalida);
		chooserVueloFechaSalida.getCalendarButton().setFont(fuentePlain);

		txtDuracionVuelo = new JTextField();
		txtDuracionVuelo.setFont(fuentePlain);
		txtDuracionVuelo.setColumns(10);
		txtDuracionVuelo.setBounds(270, 429, 218, 41);
		panelVuelo.add(txtDuracionVuelo);

		SpinnerDateModel model = new SpinnerDateModel();
		model.setValue(Calendar.getInstance().getTime());
		spinnerHoraSalida = new JSpinner(model);
		spinnerHoraSalida.setFont(fuentePlain);
		spinnerHoraSalida.setLocation(270, 344);
		spinnerHoraSalida.setSize(218, 41);
		JSpinner.DateEditor de_spinnerHoraSalida = new JSpinner.DateEditor(spinnerHoraSalida, "HH:mm");
		spinnerHoraSalida.setEditor(de_spinnerHoraSalida);
		spinnerHoraSalida.setPreferredSize(new Dimension(80, 30));
		panelVuelo.add(spinnerHoraSalida);

		JButton btnBuscarViaje = new JButton("Buscar viaje en SkyScanner");
		btnBuscarViaje.setBackground(new Color(255, 255, 255));
		btnBuscarViaje.setFont(fuentePlain);
		btnBuscarViaje.setBounds(0, 182, 488, 41);
		panelVuelo.add(btnBuscarViaje);
		btnBuscarViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbA_Origen.getSelectedItem() != "" && cbA_Destino.getSelectedItem() != ""
						&& Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
					String aeropuertoOrigen = "";
					String aeropuertoDestino = "";
					for (Aeropuerto aeropuerto : aeropuertos) {
						if (aeropuerto.getNombreAeropuerto().equals(cbA_Origen.getSelectedItem())) {
							aeropuertoOrigen = aeropuerto.getCodigoAeropuerto();
						}
						if (aeropuerto.getNombreAeropuerto().equals(cbA_Destino.getSelectedItem())) {
							aeropuertoDestino = aeropuerto.getCodigoAeropuerto();
						}
					}
					String url = "https://skyscanner.es/transporte/vuelos/" + aeropuertoOrigen + "/" + aeropuertoDestino
							+ "/" + df.format(chooserVueloFechaSalida.getDate()) + "/";
					if (rdbtnVueloIdaVuelta.isSelected() == true) {
						url = url + df.format(chooserVueloFechaSalidaVuelta.getDate());
					}
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Para acceder a Skyscanner.es, necesitas indicar un aeropuerto de origen, un aeropuerto de destino y una fecha de salida",
							"Error al acceder a Skyscanner.es", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// LABELS
		JLabel lblDuracion = new JLabel("Duración del vuelo");
		lblDuracion.setFont(fuentePlain);
		lblDuracion.setBounds(270, 386, 218, 41);
		panelVuelo.add(lblDuracion);

		JLabel lblPrecio_1 = new JLabel("€");
		lblPrecio_1.setBounds(474, 45, 21, 32);
		lblPrecio_1.setFont(fuentePlain);
		panelVuelo.add(lblPrecio_1);

		JLabel lblTipoV = new JLabel("¿Que tipo de vuelo es?");
		lblTipoV.setFont(fuentePlain);
		lblTipoV.setBounds(0, 0, 250, 41);
		panelVuelo.add(lblTipoV);

		JLabel lblVueloDeIda = new JLabel("VUELO DE IDA");
		lblVueloDeIda.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblVueloDeIda.setBounds(0, 251, 250, 32);
		panelVuelo.add(lblVueloDeIda);

		JLabel lblAOrigen = new JLabel("Aeropuerto origen");
		lblAOrigen.setFont(fuentePlain);
		lblAOrigen.setBounds(0, 87, 250, 41);
		panelVuelo.add(lblAOrigen);

		JLabel lblADestino = new JLabel("Aeropuerto destino");
		lblADestino.setFont(fuentePlain);
		lblADestino.setBounds(270, 87, 250, 41);
		panelVuelo.add(lblADestino);

		JLabel lblAerolinea = new JLabel("Aerolínea");
		lblAerolinea.setFont(fuentePlain);
		lblAerolinea.setBounds(270, 222, 218, 41);
		panelVuelo.add(lblAerolinea);

		JLabel lblCodigoV = new JLabel("Código del vuelo");
		lblCodigoV.setFont(fuentePlain);
		lblCodigoV.setBounds(0, 293, 250, 41);
		panelVuelo.add(lblCodigoV);
		JLabel lblFSalida = new JLabel("Fecha de salida");
		lblFSalida.setFont(fuentePlain);
		lblFSalida.setBounds(0, 382, 250, 41);
		panelVuelo.add(lblFSalida);

		JLabel lblHSalida = new JLabel("Hora de salida");
		lblHSalida.setFont(fuentePlain);
		lblHSalida.setBounds(270, 302, 218, 41);
		panelVuelo.add(lblHSalida);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(fuentePlain);
		lblPrecio.setBounds(269, 0, 224, 32);
		panelVuelo.add(lblPrecio);

	}

	public void desplegarVueloVuelta() {
		panelVueloVuelta = new JPanel();
		panelVueloVuelta.setBounds(888, 195, 493, 473);
		panelVueloVuelta.setLayout(null);

		cbAerolineaVuelta = new JComboBox<String>(modeloAerolineasVuelta);
		cbAerolineaVuelta.setBackground(Color.white);
		cbAerolineaVuelta.setFont(fuentePlain);
		cbAerolineaVuelta.setBounds(270, 263, 218, 41);
		panelVueloVuelta.add(cbAerolineaVuelta);

		txtCodigoVueloVuelta = new JTextField();
		txtCodigoVueloVuelta.setFont(fuentePlain);
		txtCodigoVueloVuelta.setColumns(10);
		txtCodigoVueloVuelta.setBounds(0, 344, 250, 41);
		panelVueloVuelta.add(txtCodigoVueloVuelta);

		chooserVueloFechaSalidaVuelta = new JDateChooser(Calendar.getInstance().getTime());
		chooserVueloFechaSalidaVuelta.setFont(fuentePlain);
		chooserVueloFechaSalidaVuelta.setBounds(0, 427, 250, 41);
		panelVueloVuelta.add(chooserVueloFechaSalidaVuelta);
		chooserVueloFechaSalidaVuelta.getCalendarButton().setFont(fuentePlain);

		txtDuracionVueloVuelta = new JTextField();
		txtDuracionVueloVuelta.setFont(fuentePlain);
		txtDuracionVueloVuelta.setColumns(10);
		txtDuracionVueloVuelta.setBounds(270, 429, 218, 41);
		panelVueloVuelta.add(txtDuracionVueloVuelta);

		SpinnerDateModel model = new SpinnerDateModel();
		model.setValue(Calendar.getInstance().getTime());
		spinnerHoraSalidaVuelta = new JSpinner(model);
		spinnerHoraSalidaVuelta.setFont(fuentePlain);
		spinnerHoraSalidaVuelta.setLocation(270, 344);
		spinnerHoraSalidaVuelta.setSize(218, 41);
		JSpinner.DateEditor de_spinnerHoraSalidaVuelta = new JSpinner.DateEditor(spinnerHoraSalidaVuelta, "HH:mm");
		spinnerHoraSalidaVuelta.setEditor(de_spinnerHoraSalidaVuelta);
		spinnerHoraSalidaVuelta.setPreferredSize(new Dimension(80, 30));
		panelVueloVuelta.add(spinnerHoraSalidaVuelta);

		// LABELS
		JLabel lblVueloDeIda = new JLabel("VUELO DE VUELTA");
		lblVueloDeIda.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblVueloDeIda.setBounds(0, 251, 250, 32);
		panelVueloVuelta.add(lblVueloDeIda);

		JLabel lblAerolinea = new JLabel("Aerolínea");
		lblAerolinea.setFont(fuentePlain);
		lblAerolinea.setBounds(270, 222, 218, 41);
		panelVueloVuelta.add(lblAerolinea);

		JLabel lblCodigoV = new JLabel("Código del vuelo");
		lblCodigoV.setFont(fuentePlain);
		lblCodigoV.setBounds(0, 293, 250, 41);
		panelVueloVuelta.add(lblCodigoV);

		JLabel lblFSalida = new JLabel("Fecha de salida");
		lblFSalida.setFont(fuentePlain);
		lblFSalida.setBounds(0, 382, 250, 41);
		panelVueloVuelta.add(lblFSalida);

		JLabel lblHoraSalida = new JLabel("Hora de salida");
		lblHoraSalida.setFont(fuentePlain);
		lblHoraSalida.setBounds(270, 302, 218, 41);
		panelVueloVuelta.add(lblHoraSalida);

		JLabel lblDuracionV = new JLabel("Duración del vuelo");
		lblDuracionV.setFont(fuentePlain);
		lblDuracionV.setBounds(270, 386, 218, 41);
		panelVueloVuelta.add(lblDuracionV);
	}

	public String tipoEvento() {
		if (rdbtnVuelo.isSelected()) {
			panelAlojamiento.setVisible(false);
			panelOtros.setVisible(false);
			panelVuelo.setVisible(true);
			btnGuardar.setBounds(10, 573, 284, 38);
			btnCancelar.setBounds(10, 622, 284, 38);
			if (rdbtnVueloIdaVuelta.isSelected() == true) {
				panelVueloVuelta.setVisible(true);
				setBounds(0, 0, 1450, 720);
				setLocationRelativeTo(null);
				return "VueloIdaVuelta";
			} else {
				if (rdbtnVueloIda.isSelected() == false) {
					rdbtnVueloIda.setSelected(true);
				}
				setBounds(0, 0, 1000, 720);
				setLocationRelativeTo(null);
				return "VueloIda";
			}
		}
		if (rdbtnAlojamiento.isSelected()) {
			panelVuelo.setVisible(false);
			panelOtros.setVisible(false);
			panelVueloVuelta.setVisible(false);
			panelAlojamiento.setVisible(true);
			setBounds(0, 0, 1000, 650);
			setLocationRelativeTo(null);
			btnGuardar.setBounds(10, 491, 284, 38);
			btnCancelar.setBounds(10, 540, 284, 38);
			return "Alojamiento";
		}
		if (rdbtnOtros.isSelected()) {
			panelVuelo.setVisible(false);
			panelVueloVuelta.setVisible(false);
			panelAlojamiento.setVisible(false);
			panelOtros.setVisible(true);
			setBounds(0, 0, 1000, 650);
			setLocationRelativeTo(null);
			btnGuardar.setBounds(10, 491, 284, 38);
			btnCancelar.setBounds(10, 540, 284, 38);
			return "Otros";
		}
		return null;
	}

	public void cargarComboBoxes(ArrayList<Aeropuerto> aeropuertos, ArrayList<Aerolinea> aerolineas) {
		modeloAeropuertosOrigen.addElement("");
		modeloAeropuertosDestino.addElement("");
		modeloAerolineasIda.addElement("");
		modeloAerolineasVuelta.addElement("");
		for (Aeropuerto aeropuerto : aeropuertos) {
			modeloAeropuertosOrigen.addElement(aeropuerto.getNombreAeropuerto());
			modeloAeropuertosDestino.addElement(aeropuerto.getNombreAeropuerto());
		}
		for (Aerolinea aerolinea : aerolineas) {
			modeloAerolineasIda.addElement(aerolinea.getNombreAerolinea());
			modeloAerolineasVuelta.addElement(aerolinea.getNombreAerolinea());
		}
	}

	public void cambiarTipoVuelo(String TipoVuelo) {
		rdbtnVueloIda.setSelected(TipoVuelo == "Ida");
		rdbtnVueloIdaVuelta.setSelected(TipoVuelo == "Ida y vuelta");
		panelVueloVuelta.setVisible(TipoVuelo == "Ida y vuelta");
		if (TipoVuelo == "Ida y vuelta") {
			setBounds(0, 0, 1450, 720);
			setLocationRelativeTo(null);
		} else {
			setBounds(0, 0, 1000, 720);
			setLocationRelativeTo(null);
		}
	}

	public boolean validarEvento(Viaje viaje, Agencia agencia, ArrayList<Aeropuerto> aeropuertos,
			ArrayList<Aerolinea> aerolineas) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dfh = new SimpleDateFormat("HH:mm");

		// Atributos comunes de todos los eventos
		String NombreEvento = txtNombreEvento.getText();
		String TipoEvento = tipoEvento();
		int Precio = 0;
		if (TipoEvento != null) {
			switch (TipoEvento) {
			case "Alojamiento":
				Precio = (Integer) spinnerPrecioAlojamiento.getValue();
				break;
			case "VueloIda":
				Precio = (Integer) spinnerPrecioVuelo.getValue();
				break;
			case "VueloIdaVuelta":
				Precio = (Integer) spinnerPrecioVuelo.getValue();
				break;
			case "Otros":
				Precio = (Integer) spinnerPrecioOtros.getValue();
				break;
			}
		}
		// Atributos ALOJAMIENTO
		String NombreHotel = txtNombreHotel.getText();
		String FechaEntrada_Alojamiento = df.format(chooserEntrada.getDate());
		String FechaSalida_Alojamiento = df.format(chooserSalida.getDate());
		String Ciudad = txtCiudad.getText();
		// Atributos OTROS
		String Fecha_Otros = df.format(chooserFechaOtros.getDate());
		String Descripcion = txtDescripcionOtros.getText();
		// Atributos VUELO
		String AeropuertoOrigen = cbA_Origen.getSelectedItem() + "";
		String AeropuertoDestino = cbA_Destino.getSelectedItem() + "";
		// Atributos VUELO IDA
		String Aerolinea = cbAerolinea.getSelectedItem() + "";
		String CodigoVuelo = txtCodigoVuelo.getText();
		String DuracionVuelo = txtDuracionVuelo.getText();
		String HoraSalida = dfh.format((Date) spinnerHoraSalida.getValue());
		String FechaSalida = df.format(chooserVueloFechaSalida.getDate());
		// Atributos VUELO VUELTA
		String AerolineaVuelta = cbAerolineaVuelta.getSelectedItem() + "";
		String CodigoVueloVuelta = txtCodigoVueloVuelta.getText();
		String HoraSalidaVuelta = dfh.format((Date) spinnerHoraSalidaVuelta.getValue());
		String FechaSalidaVuelta = df.format(chooserVueloFechaSalidaVuelta.getDate());
		String DuracionVueloVuelta = txtDuracionVueloVuelta.getText();

		ArrayList<String> mensajeError = new ArrayList<String>();
		if (NombreEvento.length() < 1 || NombreEvento.length() > 30) {
			mensajeError.add("El nombre del evento no puede estar vacío");
		}
		if (TipoEvento == null) {
			mensajeError.add("El tipo del Evento no puede estar vacío");
		} else {
			if (TipoEvento.equals("Alojamiento")) {
				if (NombreHotel.length() < 1 || NombreHotel.length() > 30) {
					mensajeError.add("El nombre del hotel no puede estar vacío");
				}
				if (FechaEntrada_Alojamiento.length() == 0) {
					mensajeError.add("La fecha de entrada al hotel no puede estar vacía");
				}
				if (FechaSalida_Alojamiento.length() == 0) {
					mensajeError.add("La fecha de salida al hotel no puede estar vacío");
				}
				if ((chooserEntrada.getDate().before(chooserSalida.getDate())
						|| chooserEntrada.getDate().equals(chooserSalida.getDate())) == false) {
					mensajeError.add("Fecha salida no puede ser antes que fecha entrada");
				}
				if (Ciudad.length() == 0) {
					mensajeError.add("El nombre de la ciudad no puede estar vacío");
				}
				if (TipoHabitacion.length() == 0) {
					mensajeError.add("El tipo de habitación no puede estar vacío");
				}

			}
			if (TipoEvento.equals("VueloIda") || TipoEvento.equals("VueloIdaVuelta")) {
				if (AeropuertoOrigen.length() == 0) {
					mensajeError.add("El aeropuerto de origen no puede estar vacío");
				}
				if (AeropuertoDestino.length() == 0) {
					mensajeError.add("El aeropuerto de destino no puede estar vacío");
				}
				if (Aerolinea.length() == 0) {
					mensajeError.add("El nombre de la aerolinea no puede estar vacío");
				}
				if (CodigoVuelo.length() == 0) {
					mensajeError.add("El codigo del vuelo no puede estar vacío");
				}
				if (HoraSalida.length() == 0) {
					mensajeError.add("La hora de salida del vuelo no puede estar vacía");
				}
				if (DuracionVuelo.length() == 0) {
					mensajeError.add("La duración del vuelo no puede estar vacía");
				}
				if (FechaSalida.length() == 0) {
					mensajeError.add("La fecha de salida del vuelo no puede estar vacía");
				}
				if (TipoEvento.equals("VueloIdaVuelta")) {

					if (AerolineaVuelta.length() == 0) {
						mensajeError.add("El nombre de la aerolinea de vuelta no puede estar vacío");
					}
					if (CodigoVueloVuelta.length() == 0) {
						mensajeError.add("El codigo del vuelo de vuelta no puede estar vacío");
					}
					if (HoraSalidaVuelta.length() == 0) {
						mensajeError.add("La hora de salida del vuelo de vuelta no puede estar vacía");
					}
					if (FechaSalidaVuelta.length() == 0) {
						mensajeError.add("La fecha de salida del vuelo de vuelta no puede estar vacía");
					}
					if ((chooserVueloFechaSalida.getDate().before(chooserVueloFechaSalidaVuelta.getDate())
							|| chooserVueloFechaSalida.getDate()
									.equals(chooserVueloFechaSalidaVuelta.getDate())) == false) {
						mensajeError.add("El vuelo de vuelta no puede ser antes que el vuelo de ida");
					}
					if (DuracionVueloVuelta.length() == 0) {
						mensajeError.add("La duración del vuelo de vuelta no puede estar vacía");
					}
				}
			}
			if (TipoEvento.equals("Otros")) {
				if (Fecha_Otros.length() == 0) {
					mensajeError.add("La fecha del evento no puede estar vacía");
				}
				if (Descripcion.length() == 0) {
					mensajeError.add("La descripcion evento no puede estar vacía");
				}
			}
		}
		if (mensajeError.size() == 0) {
			boolean creado = false;
			if (TipoEvento.equals("Alojamiento")) {
				Alojamiento alojamiento = new Alojamiento();
				alojamiento.setViajeID(viaje);
				alojamiento.setNombreEvento(NombreEvento);
				alojamiento.setPrecio(Precio + "");
				alojamiento.setNombreHotel(NombreHotel);
				alojamiento.setFechaEntrada(FechaEntrada_Alojamiento);
				alojamiento.setFechaSalida(FechaSalida_Alojamiento);
				alojamiento.setCiudad(Ciudad);
				alojamiento.setTipoHabitacion(TipoHabitacion);
				creado = controlador.insertarAlojamiento(alojamiento);
			} else if (TipoEvento.equals("Otros")) {
				Otros otros = new Otros();
				otros.setViajeID(viaje);
				otros.setNombreEvento(NombreEvento);
				otros.setPrecio(Precio + "");
				otros.setFecha(Fecha_Otros);
				otros.setDescripcion(Descripcion);
				creado = controlador.insertarOtros(otros);
			} else if (TipoEvento.equals("VueloIda") || TipoEvento.equals("VueloIdaVuelta")) {

				Vuelo vuelo = crearVuelo(viaje, NombreEvento, Precio, AeropuertoOrigen, AeropuertoDestino, Aerolinea,
						CodigoVuelo, HoraSalida, FechaSalida, DuracionVuelo, aeropuertos, aerolineas);

				if (TipoEvento.equals("VueloIdaVuelta")) {
					Vuelo vueloVuelta = crearVuelo(viaje, NombreEvento, Precio, AeropuertoDestino, AeropuertoOrigen,
							AerolineaVuelta, CodigoVueloVuelta, HoraSalidaVuelta, FechaSalidaVuelta,
							DuracionVueloVuelta, aeropuertos, aerolineas);
					controlador.insertarVuelo(vueloVuelta);
					vueloVuelta.setEventoID(controlador.getSumaVuelos() + "");
					vuelo.setEventoVueltaID(vueloVuelta);

				}
				creado = controlador.insertarVuelo(vuelo);

			}

			if (creado == true) {
				dispose();
				Inicio ventana = new Inicio(agencia);
				ventana.setVisible(true);
				JOptionPane.showMessageDialog(null, "!Evento creado correctamente!", agencia.getNombreAgencia(),
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, " - " + String.join("\n - ", mensajeError),
					"Error al crear evento | " + agencia.getNombreAgencia(), JOptionPane.ERROR_MESSAGE);
		}

		return mensajeError.size() == 0;

	}

	public Vuelo crearVuelo(Viaje viaje, String NombreEvento, int Precio, String AeropuertoOrigen,
			String AeropuertoDestino, String Aerolinea, String CodigoVuelo, String HoraSalida, String FechaSalida,
			String DuracionVuelo, ArrayList<Aeropuerto> aeropuertos, ArrayList<Aerolinea> aerolineas) {
		Vuelo vuelo = new Vuelo();
		vuelo.setViajeID(viaje);
		vuelo.setNombreEvento(NombreEvento);
		vuelo.setPrecio(Precio + "");
		vuelo.setDuracionVuelo(DuracionVuelo);
		for (Aerolinea aerolinea : aerolineas) {
			if (aerolinea.getNombreAerolinea().equals(Aerolinea)) {
				vuelo.setAerolinea(aerolinea);
			}
		}
		vuelo.setCodigoVuelo(CodigoVuelo);
		vuelo.setHoraSalida(HoraSalida);
		vuelo.setFechaSalida(FechaSalida);
		for (Aeropuerto aeropuerto : aeropuertos) {
			if (aeropuerto.getNombreAeropuerto().equals(AeropuertoOrigen)) {
				vuelo.setAeropuertoOrigen(aeropuerto);

			}
			if (aeropuerto.getNombreAeropuerto().equals(AeropuertoDestino)) {
				vuelo.setAeropuertoDestino(aeropuerto);
			}
		}
		return vuelo;
	}
}
