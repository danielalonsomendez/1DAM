package ejs_tema8_Adicionales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ejer08Calculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String resultado1 = "0";
	String resultado2 = "0";
	String operacion = "";
	private JLabel lblResultado;
	private JLabel lblResultadoArriba;
	ArrayList<String> resultados = new ArrayList<String>();
	private JLabel lblCalculos;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer08Calculadora frame = new Ejer08Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void cambiarnum(String numero) {
		if (operacion.equals("")) {
			if (resultado1.equals("0")) {
				resultado1 = numero;
			} else {
				resultado1 += numero;
			}
			lblResultado.setText(resultado1);
			lblResultadoArriba.setText("");

		} else {
			if (resultado2.equals("0")) {
				resultado2 = numero;
			} else {
				resultado2 += numero;
			}
			lblResultado.setText(resultado2);

		}
	}

	public void cambiaroperacion(String nuevaOperacion) {
		if (resultado1.equals("0")) {
			resultado1 = lblResultado.getText();
		}
		if (operacion == "") {
			operacion = nuevaOperacion;
			lblResultadoArriba.setText(resultado1 + " " + operacion);
		} else {
			calcular(true);
			operacion = nuevaOperacion;
		}
	}

	public void calcular(boolean guardarResultado) {
		if (operacion.equals("") == false) {
			int resultado = 0;
			int r1 = Integer.parseInt(resultado1);
			int r2 = Integer.parseInt(resultado2);
			switch (operacion) {
			case "+":
				resultado = r1 + r2;
				break;
			case "-":
				resultado = r1 - r2;
				break;
			case "*":
				resultado = r1 * r2;
				break;
			case "/":
				resultado = r1 / r2;
				break;
			}

			lblResultado.setText(resultado + "");
			if (guardarResultado == true) {
	
				resultados.add(resultado1 + " " + operacion + " " + resultado2 + " = "+ resultado);
				
				lblCalculos.setText("<html>" + String.join("<br>", resultados) + "</html>");
				resultado1 = resultado + "";

				lblResultadoArriba.setText(resultado1 + " " + operacion);
			} else {
				lblResultadoArriba.setText(resultado1 + " " + operacion + " " + resultado2 + " =");
				resultados.add(resultado1 + " " + operacion + " " + resultado2 + " = "+ resultado);
				lblCalculos.setText("<html>" + String.join("<br>", resultados) + "</html>");
				resultado1 = "0";

			}

			resultado2 = "0";
			operacion = "";

		}
	}

	/**
	 * Create the frame.
	 */
	public Ejer08Calculadora() {
		setBackground(new Color(255, 255, 255));
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnN1 = new JButton("1");
		btnN1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("1");
			}
		});
		btnN1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN1.setBounds(10, 219, 89, 55);
		contentPane.add(btnN1);

		JButton btnN2 = new JButton("2");
		btnN2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("2");

			}
		});
		btnN2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN2.setBounds(109, 219, 89, 55);
		contentPane.add(btnN2);

		JButton btnN3 = new JButton("3");
		btnN3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("3");
			}
		});
		btnN3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN3.setBounds(208, 219, 89, 55);
		contentPane.add(btnN3);

		JButton btnN0 = new JButton("0");
		btnN0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("0");
			}
		});
		btnN0.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN0.setBounds(10, 285, 89, 55);
		contentPane.add(btnN0);

		JButton btnCalc = new JButton("=");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular(false);
			}
		});
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnCalc.setBounds(109, 285, 89, 55);
		contentPane.add(btnCalc);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResultado.setText("0");
				lblResultadoArriba.setText("");

				resultado1 = "0";
				resultado2 = "0";
				operacion = "";
			}
		});
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnC.setBounds(208, 285, 89, 55);
		contentPane.add(btnC);

		JButton btnN4 = new JButton("4");
		btnN4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("4");
			}
		});
		btnN4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN4.setBounds(10, 153, 89, 55);
		contentPane.add(btnN4);

		JButton btnN5 = new JButton("5");
		btnN5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("5");
			}
		});
		btnN5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN5.setBounds(109, 153, 89, 55);
		contentPane.add(btnN5);

		JButton btnN6 = new JButton("6");
		btnN6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("6");
			}
		});
		btnN6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN6.setBounds(208, 153, 89, 55);
		contentPane.add(btnN6);

		JButton btnN7 = new JButton("7");
		btnN7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("7");
			}
		});
		btnN7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN7.setBounds(10, 87, 89, 55);
		contentPane.add(btnN7);

		JButton btnN8 = new JButton("8");
		btnN8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("8");
			}
		});
		btnN8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN8.setBounds(109, 87, 89, 55);
		contentPane.add(btnN8);

		JButton btnN9 = new JButton("9");
		btnN9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarnum("9");
			}
		});
		btnN9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnN9.setBounds(208, 87, 89, 55);
		contentPane.add(btnN9);

		JButton btnNDiv = new JButton("/");
		btnNDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiaroperacion("/");

			}
		});
		btnNDiv.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNDiv.setBounds(307, 285, 89, 55);
		contentPane.add(btnNDiv);

		JButton btnNMult = new JButton("*");
		btnNMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiaroperacion("*");
			}
		});
		btnNMult.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNMult.setBounds(307, 219, 89, 55);
		contentPane.add(btnNMult);

		JButton btnNMinus = new JButton("-");
		btnNMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operacion.equals("") == true && resultado1.equals("0") == true) {
					cambiarnum("-");
				} else {
					cambiaroperacion("-");
				}
			}
		});
		btnNMinus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNMinus.setBounds(307, 153, 89, 55);
		contentPane.add(btnNMinus);

		JButton btnNPlus = new JButton("+");
		btnNPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiaroperacion("+");
			}
		});
		btnNPlus.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNPlus.setBounds(307, 87, 89, 55);
		contentPane.add(btnNPlus);

		lblResultado = new JLabel("0");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblResultado.setBounds(10, 25, 386, 51);
		contentPane.add(lblResultado);

		lblResultadoArriba = new JLabel("");
		lblResultadoArriba.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultadoArriba.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultadoArriba.setBounds(182, 11, 214, 13);
		contentPane.add(lblResultadoArriba);
		
		
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBackground(new Color(0, 0, 0));
		panelResultados.setBounds(430, 0, 347, 351);
		contentPane.add(panelResultados);
		panelResultados.setLayout(null);
		
		lblCalculos = new JLabel("");
		lblCalculos.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCalculos.setVerticalAlignment(SwingConstants.TOP);
		lblCalculos.setForeground(new Color(255, 255, 255));
		lblCalculos.setBounds(10, 11, 327, 329);
		panelResultados.add(lblCalculos);
	}
}
