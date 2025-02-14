package Reto2Vista;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Reto2Modelo.Aerolinea;
import Reto2Modelo.Aeropuerto;
import Reto2Modelo.Agencia;
import Reto2Modelo.Pais;
import Reto2Modelo.Viaje;
import Reto2Modelo.Vuelo;
import Reto2Modelo.Alojamiento;
import Reto2Modelo.Otros;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Reto2Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modeloViajes;
	private DefaultTableModel modeloEventos;
	private JTable tableViajes;
	private JTable tableEventos;
	private ArrayList<Aerolinea> aerolineas;
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Pais> paises;
	private JButton btnCrearEvento;
	private JButton btnBorrarViajeSeleccionado;
	private JButton btnBorrarEventoSeleccionado;
	private JLabel lblEventos;
	private JScrollPane scrollPaneEventos;
	private Controlador controlador = new Controlador();
	private Font fuenteBold = new Font("Segoe UI", Font.BOLD, 20);

	
	public Inicio(Agencia agencia) {
		setResizable(false);
		setTitle(agencia.getNombreAgencia());
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		JButton btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setForeground(new Color(0, 0, 0));
		btnDesconectar.setFont(fuenteBold);
		btnDesconectar.setBackground(new Color(255, 255, 255));
		btnDesconectar.setBounds(10, 540, 284, 38);
		panelIzquierda.add(btnDesconectar);

		JButton btnGenerarOfertaViaje = new JButton("Generar oferta viaje");
		btnGenerarOfertaViaje.setForeground(new Color(0, 0, 0));
		btnGenerarOfertaViaje.setFont(fuenteBold);
		btnGenerarOfertaViaje.setBackground(new Color(255, 255, 255));
		btnGenerarOfertaViaje.setBounds(10, 491, 284, 38);
		panelIzquierda.add(btnGenerarOfertaViaje);
		
		JButton btnInformes = new JButton("Informes");
		btnInformes.setForeground(Color.BLACK);
		btnInformes.setFont(fuenteBold);
		btnInformes.setBackground(Color.WHITE);
		btnInformes.setBounds(10, 442, 284, 38);
		panelIzquierda.add(btnInformes);

		
		// TABLA VIAJES
		
		
		modeloViajes = new DefaultTableModel(new String[]{"ViajeID", "Nombre", "Tipo", "Fecha inicio", "Fecha fin", "Pais"}, 0);
		tableViajes = new JTable(modeloViajes);
		tableViajes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableViajes.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableViajes.setRowHeight(25);
		// Desactivar ediciones
		tableViajes.setDefaultEditor(Object.class, null);
		// Ocultar columna ViajeID
		tableViajes.getColumnModel().getColumn(0).setMinWidth(0);
		tableViajes.getColumnModel().getColumn(0).setMaxWidth(0);
		// Desactivar mover columnas
		tableViajes.getTableHeader().setReorderingAllowed(false);
		// Ordenar por fecha de inicio
		TableRowSorter<TableModel> sort = new TableRowSorter<>(modeloViajes);
		tableViajes.setRowSorter(sort);
		sort.setSortKeys(Collections.singletonList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
	
		tableViajes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				Viaje viajeSeleccionado = viajeSeleccionado(agencia);
				if (viajeSeleccionado != null) {
					btnBorrarViajeSeleccionado.setVisible(true);
					mostrarEventosViaje(viajeSeleccionado);
				}
			}
		});
		JScrollPane scrollPaneViajes = new JScrollPane();
		scrollPaneViajes.setBounds(327, 91, 647, 208);
		scrollPaneViajes.getViewport().setBackground(Color.WHITE);
		contentPane.add(scrollPaneViajes);
		scrollPaneViajes.setViewportView(tableViajes);

		// TABLA EVENTOS
		

		modeloEventos = new DefaultTableModel(new String[]{"EventoID", "Nombre", "Tipo", "Fecha", "Precio"}, 0);
		tableEventos = new JTable(modeloEventos);
		tableEventos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableEventos.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableEventos.setRowHeight(25);
		// Desactivar ediciones
		tableEventos.setDefaultEditor(Object.class, null);
		// Ocultar columna EventoID
		tableEventos.getColumnModel().getColumn(0).setMinWidth(0);
		tableEventos.getColumnModel().getColumn(0).setMaxWidth(0);
		// Desactivar mover columnas
		tableEventos.getTableHeader().setReorderingAllowed(false);
		// Ordenar por fecha
		TableRowSorter<TableModel> sortEventos = new TableRowSorter<>(modeloEventos);
		tableEventos.setRowSorter(sortEventos);
		sortEventos.setSortKeys(Collections.singletonList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
		tableEventos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				btnBorrarEventoSeleccionado.setVisible(true);
			}
		});
		scrollPaneEventos = new JScrollPane();
		scrollPaneEventos.setBounds(327, 392, 647, 208);
		contentPane.add(scrollPaneEventos);
		scrollPaneEventos.setViewportView(tableEventos);
		scrollPaneEventos.getViewport().setBackground(Color.WHITE);
		// BOTONES DE LAS TABLAS
		JButton btnCrearViaje = new JButton("Crear viaje");
		btnCrearViaje.setForeground(Color.BLACK);
		btnCrearViaje.setFont(fuenteBold);
		btnCrearViaje.setBackground(Color.WHITE);
		btnCrearViaje.setBounds(778, 33, 196, 51);
		contentPane.add(btnCrearViaje);
		
		btnCrearEvento = new JButton("Crear evento");
		btnCrearEvento.setForeground(Color.BLACK);
		btnCrearEvento.setFont(fuenteBold);
		btnCrearEvento.setBackground(Color.WHITE);
		btnCrearEvento.setBounds(778, 334, 196, 51);
		contentPane.add(btnCrearEvento);

		btnBorrarViajeSeleccionado = new JButton("Borrar viaje seleccionado");
		btnBorrarViajeSeleccionado.setForeground(Color.BLACK);
		btnBorrarViajeSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrarViajeSeleccionado.setBackground(Color.WHITE);
		btnBorrarViajeSeleccionado.setBounds(558, 49, 210, 35);
		btnBorrarViajeSeleccionado.setVisible(false);
		contentPane.add(btnBorrarViajeSeleccionado);

		btnBorrarEventoSeleccionado = new JButton("Borrar evento seleccionado");
		btnBorrarEventoSeleccionado.setForeground(Color.BLACK);
		btnBorrarEventoSeleccionado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBorrarEventoSeleccionado.setBackground(Color.WHITE);
		btnBorrarEventoSeleccionado.setBounds(537, 346, 231, 35);
		btnBorrarEventoSeleccionado.setVisible(false);
		contentPane.add(btnBorrarEventoSeleccionado);
		
		ImageIcon image = null;
		try {
			image = new ImageIcon(new URL(agencia.getLogo()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		btnDesconectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login ventana = new Login();
				ventana.setVisible(true);
			}
		});
		btnGenerarOfertaViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viaje viajeSeleccionado = viajeSeleccionado(agencia);
				if (viajeSeleccionado != null) {
					controlador.generarOfertaViaje(viajeSeleccionado);

				} else {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún viaje.",
							"Error al generar oferta cliente | " + agencia.getNombreAgencia(),
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> nombres = new 	ArrayList<String>();
				nombres.add("Informe de cada viaje en "+controlador.generarViajes(agencia));	
				nombres.add("Informe de cada viaje y sus eventos en "+controlador.generarViajesEventos(agencia));
				nombres.add("Informe de cada viaje ordenado por territorio en "+controlador.generarViajesPais(agencia));
				nombres.add("Informe de cada viaje y sus eventos ordenado por precio en "+controlador.generarEventosPrecio(agencia));

				JOptionPane.showMessageDialog(null, "¡Se han creado los siguientes informes en el escritorio: \n - "+String.join("\n - ", nombres),
				agencia.getNombreAgencia(), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCrearViaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoViaje nuevoviaje = new NuevoViaje(agencia, paises);
				setVisible(false);
				nuevoviaje.setVisible(true);
			}
		});
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viaje viajeSeleccionado = viajeSeleccionado(agencia);
				if (viajeSeleccionado != null) {
					NuevoEvento nuevoevento = new NuevoEvento(viajeSeleccionado, agencia, aeropuertos, aerolineas);
					setVisible(false);
					nuevoevento.setVisible(true);
				}
			}

		});
		btnBorrarEventoSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarEvento(agencia);
			}
		});
		btnBorrarViajeSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarViaje(agencia);
			}
		});
		
		// LABELS
		JLabel lblLogo = new JLabel(new ImageIcon(image.getImage().getScaledInstance(256, 173, Image.SCALE_SMOOTH)));
		lblLogo.setBounds(15, 15, 256, 173);
		panelIzquierda.add(lblLogo);
		
		JLabel lblViaje = new JLabel("Viajes");
		lblViaje.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblViaje.setBounds(327, 29, 160, 51);
		contentPane.add(lblViaje);

		lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblEventos.setBounds(327, 330, 139, 51);
		contentPane.add(lblEventos);
		
		JLabel lblNombreAgencia = new JLabel(agencia.getNombreAgencia());
		lblNombreAgencia.setFont(fuenteBold);
		lblNombreAgencia.setForeground(colorTexto(Color.decode(agencia.getColorMarca())));
		lblNombreAgencia.setBounds(15, 196, 256, 58);
		panelIzquierda.add(lblNombreAgencia);
		
		
		btnCrearEvento.setVisible(false);
		tableEventos.setVisible(false);
		lblEventos.setVisible(false);
		scrollPaneEventos.setVisible(false);
		cargarTabla(agencia);
	}

	public Viaje viajeSeleccionado(Agencia agencia) {
		if (tableViajes.getSelectedRow() != -1) {
			String ViajeIDSeleccionado = tableViajes.getValueAt(tableViajes.getSelectedRow(), 0).toString();
			ArrayList<Viaje> viajesArray = agencia.getViajes();
			for (int i = 0; i < viajesArray.size(); i++) {
				if (viajesArray.get(i).getViajeID().equals(ViajeIDSeleccionado)) {
					return viajesArray.get(i);
				}
			}
		}
		return null;
	}

	public void mostrarEventosViaje(Viaje viaje) {

		btnCrearEvento.setVisible(true);
		tableEventos.setVisible(true);
		lblEventos.setVisible(true);
		scrollPaneEventos.setVisible(true);
		modeloEventos.setRowCount(0);
		
		ArrayList<Vuelo> vuelosArray = viaje.getVuelos();
		ArrayList<Alojamiento> alojamientosArray = viaje.getAlojamientos();
		ArrayList<Otros> otrosArray = viaje.getOtros();
		for (int z = 0; z < vuelosArray.size(); z++) {
			String[] fila = new String[5];
			fila[0] = vuelosArray.get(z).getEventoID();
			fila[1] = vuelosArray.get(z).getNombreEvento();
			fila[2] = "Vuelo";
			fila[3] = vuelosArray.get(z).getFechaSalida();
			fila[4] = vuelosArray.get(z).getPrecio() + "€";
			modeloEventos.addRow(fila);
		}
		for (int e = 0; e < alojamientosArray.size(); e++) {
			String[] fila = new String[5];
			fila[0] = alojamientosArray.get(e).getEventoID();
			fila[1] = alojamientosArray.get(e).getNombreEvento();
			fila[2] = "Alojamiento";
			fila[3] = alojamientosArray.get(e).getFechaEntrada();
			fila[4] = alojamientosArray.get(e).getPrecio() + "€";
			modeloEventos.addRow(fila);
		}
		for (int d = 0; d < otrosArray.size(); d++) {
			String[] fila = new String[5];
			fila[0] = otrosArray.get(d).getEventoID();
			fila[1] = otrosArray.get(d).getNombreEvento();
			fila[2] = "Otros";
			fila[3] = otrosArray.get(d).getFecha();
			fila[4] = otrosArray.get(d).getPrecio() + "€";
			modeloEventos.addRow(fila);
		}
	}

	public void cargarTabla(Agencia agencia) {
		modeloViajes.setRowCount(0);
		paises = controlador.getListaPaises();
		aeropuertos = controlador.getListaAeropuertos();
		aerolineas = controlador.getListaAerolineas();
		btnCrearEvento.setVisible(false);
		tableEventos.setVisible(false);
		lblEventos.setVisible(false);
		scrollPaneEventos.setVisible(false);
		
		agencia.setViajes(controlador.getListaViajes(paises, agencia));
		ArrayList<Viaje> viajesArray = agencia.getViajes();
		for (int i = 0; i < viajesArray.size(); i++) {
			viajesArray.get(i).setVuelos(controlador.getListaVuelos(viajesArray.get(i), aeropuertos, aerolineas));
			viajesArray.get(i).setAlojamientos(controlador.getListaAlojamiento(viajesArray.get(i)));
			viajesArray.get(i).setOtros(controlador.getListaOtros(viajesArray.get(i)));
			String[] fila = new String[6];
			fila[0] = viajesArray.get(i).getViajeID();
			fila[1] = viajesArray.get(i).getNombreViaje();
			fila[2] = viajesArray.get(i).getTipoViaje();
			fila[3] = viajesArray.get(i).getFechaInicio();
			fila[4] = viajesArray.get(i).getFechaFin();
			fila[5] = viajesArray.get(i).getPaisDestino().getDescripcionPais();

			modeloViajes.addRow(fila);
		}

	}

	public void eliminarViaje(Agencia agencia) {
		if (controlador.eliminarViaje(viajeSeleccionado(agencia)) == true) {
			JOptionPane.showMessageDialog(null, "Eliminado correctamente.", agencia.getNombreAgencia(),
					JOptionPane.INFORMATION_MESSAGE);
			cargarTabla(agencia);
			modeloEventos.setRowCount(0);
			btnBorrarViajeSeleccionado.setVisible(false);
			btnBorrarEventoSeleccionado.setVisible(false);
		}
	}

	public void eliminarEvento(Agencia agencia) {
		boolean valido = false;
		if (tableEventos.getSelectedRow() != -1) {
			String EventoIDSeleccionado = tableEventos.getValueAt(tableEventos.getSelectedRow(), 0).toString();
			String TipoEventoSeleccionado = tableEventos.getValueAt(tableEventos.getSelectedRow(), 2).toString();
			
			if (TipoEventoSeleccionado == "Vuelo") {
				for (Vuelo vuelo: viajeSeleccionado(agencia).getVuelos()) {
					if (vuelo.getEventoID().equals(EventoIDSeleccionado)) {
						valido = controlador.eliminarVuelo(vuelo);
					}
				}
			} else if (TipoEventoSeleccionado == "Alojamiento") {
				for (Alojamiento alojamiento: viajeSeleccionado(agencia).getAlojamientos()) {
					if (alojamiento.getEventoID().equals(EventoIDSeleccionado)) {
						valido = controlador.eliminarAlojamiento(alojamiento);
					}
				}
			} else if (TipoEventoSeleccionado == "Otros") {
				for (Otros otro:viajeSeleccionado(agencia).getOtros()) {
					if (otro.getEventoID().equals(EventoIDSeleccionado)) {
						valido = controlador.eliminarOtros(otro);
					}
				}
			}
		}
		if (valido == true) {
			JOptionPane.showMessageDialog(null, "Eliminado correctamente.", agencia.getNombreAgencia(),
					JOptionPane.INFORMATION_MESSAGE);
			cargarTabla(agencia);
			modeloEventos.setRowCount(0);
			btnBorrarEventoSeleccionado.setVisible(false);
		}

	}
	public static Color colorTexto(Color fondo) {
        double iluminacion = (0.299 * fondo.getRed() + 0.587 * fondo.getGreen() + 0.114 * fondo.getBlue()) / 255;
        return iluminacion < 0.5 ? Color.WHITE : Color.BLACK;
    }
}
