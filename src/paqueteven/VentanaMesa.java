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
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Cursor;

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
	private JTable tabla_pedido;
	public VentanaMesa(Restaurante resto, int idMesa, String usuarioIngresado) {
		
		setEstadoMesa(resto.mesaIsOcupada(idMesa));
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(getEstadoMesa());
		label.setBounds(6, 6, 136, 16);
		contentPane.add(label);
	
		if ( resto.mesaIsOcupada(idMesa)){
			
			
			
			
			
		}
		else{
			
			JButton btnCrearCuenta = new JButton("CREAR CUENTA");
			btnCrearCuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCrearCuenta vencuenta = new VentanaCrearCuenta(resto, idMesa);
					vencuenta.setVisible(true);
					
				}
			});
			btnCrearCuenta.setBounds(12, 59, 130, 25);
			contentPane.add(btnCrearCuenta);
			
		}
		
		
		
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFocusPainted(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		btnGuardar.setBounds(250, 401, 117, 29);
		contentPane.add(btnGuardar);
		
		tabla_pedido = new JTable(5, 5);
		tabla_pedido.setBounds(51, 100, 339, 280);
		contentPane.add(tabla_pedido);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaMesa_AgregarProducto ventanaagregar = new VentanaMesa_AgregarProducto(resto, idMesa);
				ventanaagregar.setVisible(true);
				
			}
		});
		btnAgregarProducto.setBounds(442, 95, 146, 25);
		contentPane.add(btnAgregarProducto);
		
		JButton btnCerrarCuenta = new JButton("Cerrar Cuenta");
		btnCerrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resto.eliminarCuentaActiva(idMesa);
			}
		});
		btnCerrarCuenta.setBounds(442, 148, 146, 25);
		contentPane.add(btnCerrarCuenta);
		
		
		

		
	}
	
	private String [] nombresColumnas= {"Producto", "Cantidad", "Precio Unitario", "Importe"};
	
	private Object [] [] datosFila= {
			{
				""
			}
			
	};
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