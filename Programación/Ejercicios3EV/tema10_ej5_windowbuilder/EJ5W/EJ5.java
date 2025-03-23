package EJ5W;

import java.awt.EventQueue;

import Vista_EJ5W.Mascotas;

public class EJ5 {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mascotas frame = new Mascotas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
