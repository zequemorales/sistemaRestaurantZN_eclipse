package paqueteven;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;

import clases.Restaurante;

import javax.swing.event.PopupMenuEvent;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Cursor;

public class VentanaMesa_AgregarProducto extends JFrame {
	private JPanel contentPane;
	private JTextField txtIDProducto;
	
	public VentanaMesa_AgregarProducto(Restaurante resto, int idMesa) {
		setBounds(new Rectangle(100, 100, 450, 200));
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(125, 121, 10, 10);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIDProducto = new JTextField();
		txtIDProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDProducto.setBounds(175, 62, 100, 30);
		contentPane.add(txtIDProducto);
		txtIDProducto.setColumns(10);
		
		JComboBox selectorProducto = new JComboBox();
		selectorProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		selectorProducto.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		selectorProducto.setBounds(42, 62, 100, 30);
		contentPane.add(selectorProducto);
		
		
		selectorProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDProducto.setText(selectorProducto.getSelectedItem().toString());
				
			}
		});
		
		
		
			
		
		
		
		
		
		

	
		
		
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProducto.setBounds(42, 25, 100, 30);
		contentPane.add(lblProducto);
		
		JLabel lblIdProducto = new JLabel("ID Producto");
		lblIdProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdProducto.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIdProducto.setBounds(175, 25, 100, 30);
		contentPane.add(lblIdProducto);
		
		JSpinner cantidadProductos = new JSpinner();
		
		cantidadProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cantidadProductos.setBounds(315, 62, 100, 30);
		contentPane.add(cantidadProductos);
		
		JLabel lblCantidad = new JLabel("Cantidad ");
		lblCantidad.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(315, 25, 100, 30);
		contentPane.add(lblCantidad);
		
		JButton btnAgregarProductoAcuenta = new JButton("Agregar");
		btnAgregarProductoAcuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cantidadSelec = Integer.parseInt(cantidadProductos.getValue().toString());
				int idProductoSelec= Integer.parseInt(txtIDProducto.getText());
				
				resto.agregaProductoAlaCuenta(idMesa, idProductoSelec, cantidadSelec);
				System.out.println(resto.calcularTotal(idMesa));
				
				dispose();
				
				
				
					
			}
		});
		btnAgregarProductoAcuenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarProductoAcuenta.setBounds(175, 109, 100, 30);
		contentPane.add(btnAgregarProductoAcuenta);
	}
}
