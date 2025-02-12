package ejs_tema8_Adicionales;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejer05Paneles extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane2;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejer05Paneles frame = new Ejer05Paneles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejer05Paneles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane2 = new JPanel();
		contentPane2.setBackground(new Color(0, 0, 0));
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(255, 0, 0));
		panel1.setBounds(0, 0, 144, 261);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JButton btnC2 = new JButton("Cambiar");
		btnC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
			}
		});
		btnC2.setBounds(10, 118, 114, 23);
		panel1.add(btnC2);
		
		panel2 = new JPanel();
		panel2.setBackground(new Color(0, 255, 0));
		panel2.setLayout(null);
		panel2.setBounds(144, 0, 144, 261);
		contentPane.add(panel2);
		
		JButton btnC3 = new JButton("Cambiar");
		btnC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel2.setVisible(false);
				panel3.setVisible(true);
			}
		});
		btnC3.setBounds(20, 117, 114, 23);
		panel2.add(btnC3);
		
		panel3 = new JPanel();
		panel3.setBackground(new Color(0, 0, 255));
		panel3.setLayout(null);
		panel3.setBounds(288, 0, 146, 261);
		contentPane.add(panel3);
		
		JButton btnC4 = new JButton("Cambiar");
		btnC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(false);
				panel1.setVisible(true);
			}
		});
		btnC4.setBounds(20, 118, 114, 23);
		panel3.add(btnC4);
		
		panel3.setVisible(false);
		panel2.setVisible(false);

	}
}
