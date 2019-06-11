package paqueteven;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInfo frame = new VentanaInfo();
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
	public VentanaInfo() {
		Toolkit mipantalla= Toolkit.getDefaultToolkit();
		
		Dimension tamanioPantalla = mipantalla.getScreenSize();
		
		int alturaPantalla = tamanioPantalla.height;
		int anchoPantalla = tamanioPantalla.width;
		
		
		setBounds(anchoPantalla/3, alturaPantalla/3, 410, 165);
		setResizable(true);
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInfo = new JLabel("INFO");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(177, 12, 60, 15);
		contentPane.add(lblInfo);
		
		JLabel lbl_nombre = new JLabel();
		lbl_nombre.setText("Antares" );
		lbl_nombre.setBounds(107, 50, 205, 37);
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_nombre);
		
		JLabel lbl_direccion = new JLabel();
		lbl_direccion.setText("Consitucion 5500");
		lbl_direccion.setBounds(107, 94, 205, 37);
		lbl_direccion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_direccion);
		

		
	}
}
