package paqueteven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Restaurante;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaCrearCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdMozo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					VentanaCrearCuenta frame = new VentanaCrearCuenta(restoprueba, idMesa);
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCrearCuenta(Restaurante restoprueba, int idMesa) {
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
		
		JLabel label_idMOZO = new JLabel("ID MOZO");
		label_idMOZO.setHorizontalAlignment(SwingConstants.CENTER);
		label_idMOZO.setBounds(177, 12, 60, 15);
		contentPane.add(label_idMOZO);
		
		txtIdMozo = new JTextField();
		txtIdMozo.setBounds(146, 39, 130, 26);
		contentPane.add(txtIdMozo);
		txtIdMozo.setColumns(10);
		
		JButton btnGuardar = new JButton("INGRESAR");
		btnGuardar.setBounds(156, 78, 117, 29);
		contentPane.add(btnGuardar);
		
		int idMozoIngresado = Integer.parseInt(txtIdMozo.getText());
		
		restoprueba.crearCuentaActiva(idMozoIngresado, idMesa);
	
		
		
		
	}
}
