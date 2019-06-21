 package paqueteven;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Comida;
import clases.Cuenta;
import clases.Restaurante;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Cursor;

/**
 * Clase de la Ventana de la MESA
 * 
 * Muestra si la mesa esta vacia o no. y podemos crear una cuenta agregar
 * prodcutos etc
 * 
 * @author Zeque
 *
 */
public class VentanaMesa extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	private String estadoMesa;
	private JTable tabla_pedidos;

	public VentanaMesa( Restaurante resto, int idMesa) {
		
		setTitle("MESA "+ idMesa);

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

		if (resto.mesaIsOcupada(idMesa)) {
			
			DefaultTableModel model = new DefaultTableModel() { 
	            String[] nombres = {"emp 1", "emp 2"};
			};
			
			tabla_pedidos = new JTable(model);
			tabla_pedidos.setAutoResizeMode(1);
			tabla_pedidos.setBounds(47, 54, 306, 205);
			contentPane.add(tabla_pedidos);
		
		
			
			
			

			Cuenta cuenta = resto.devuelveCuenta(idMesa);

			HashMap<Integer, Integer> listaProductosCuenta = cuenta.devolverLista();

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
					dispose();

				}
			});
			btnCerrarCuenta.setBounds(442, 148, 146, 25);
			contentPane.add(btnCerrarCuenta);

		} else {

			JButton btnCrearCuenta = new JButton("CREAR CUENTA");
			btnCrearCuenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCrearCuenta vencuenta = new VentanaCrearCuenta(resto, idMesa);
					dispose();
					vencuenta.setVisible(true);

				}
			});
			btnCrearCuenta.setBounds(12, 59, 130, 25);
			contentPane.add(btnCrearCuenta);

		}

		JButton btnGuardar = new JButton("Ver Plano");
		
	
		
		
		
		btnGuardar.setFocusPainted(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		}); 
		btnGuardar.setBounds(250, 401, 117, 29);
		contentPane.add(btnGuardar);
		
	

	}

	public void setEstadoMesa(boolean ocupado) {
		if (ocupado) {
			this.estadoMesa = "MESA OCUPADA";
		} else {
			this.estadoMesa = "MESA VACIA";
		}
		  
	}

	public String getEstadoMesa() {
		return estadoMesa;
	}
}