package paqueteven;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import clases.Restaurante;

/**
 * Clase de la Ventana de la MESA
 * 
 * Muestra si la mesa esta vacia o no. y podemos crear una cuenta agregar prodcutos etc
 * @author Zeque
 *
 */
public class VentanaMesa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param args
	 * @param ocupado
	 */
	public static void main(String[] args,boolean ocupado) {
		try{
			  UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			}catch(Exception e){
			  e.printStackTrace();
			} 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VentanaMesa frame = new VentanaMesa();
					//frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private String estadoMesa;
	public VentanaMesa(Restaurante resto, int idMesa, String usuarioIngresado) {
		
		setEstadoMesa(resto.mesaIsOcupada(idMesa));
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(getEstadoMesa());
		label.setBounds(6, 6, 136, 16);
		contentPane.add(label);
	
		
		JButton btnCrearCuenta = new JButton("CREAR CUENTA");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearCuenta vencuenta = new VentanaCrearCuenta(resto, idMesa);
				vencuenta.setVisible(true);
				
			}
		});
		btnCrearCuenta.setBounds(12, 59, 130, 25);
		contentPane.add(btnCrearCuenta);
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFocusPainted(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Principal p = new Principal(usuarioIngresado);
				p.setVisible(true);
			
			}
		});
		btnGuardar.setBounds(165, 232, 117, 29);
		contentPane.add(btnGuardar);
		
	}
	
	public void setEstadoMesa(boolean ocupado){
		if(ocupado){
			this.estadoMesa="MESA OCUPADA";
		}
		else
		{
			this.estadoMesa="MESA VACIA";
		}
		
	}
	
	public String getEstadoMesa(){
		return estadoMesa;
	}
}