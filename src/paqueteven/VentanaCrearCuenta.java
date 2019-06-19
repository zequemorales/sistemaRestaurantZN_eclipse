package paqueteven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Restaurante;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdMozo;

	/**
	 * Create the frame.
	 */
	public VentanaCrearCuenta( Restaurante restoprueba, int idMesa) {
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
		
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idMozoIngresado = Integer.parseInt(txtIdMozo.getText());
				if(restoprueba.compruebaMozo(idMozoIngresado)){
					restoprueba.crearCuentaActiva(idMozoIngresado, idMesa);
					System.out.println(restoprueba.listarCuentasActivas());
					dispose();
					VentanaMesa venMesa= new VentanaMesa(restoprueba, idMesa);
					venMesa.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ID MOZO INVALIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
					txtIdMozo.setText("");
					txtIdMozo.requestFocus();
				}
				
			}
		});
		btnIngresar.setBounds(156, 78, 117, 29);
		contentPane.add(btnIngresar);
		
		
		
		
	
		
		
		
	}
}
