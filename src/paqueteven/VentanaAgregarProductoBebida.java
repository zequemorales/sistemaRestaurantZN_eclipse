package paqueteven;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Color;
import java.awt.Cursor;

public class VentanaAgregarProductoBebida extends JFrame {private JPanel contentPane;
private JTextField txtID;
private JTextField textNombre;
private JTextField textPrecio;
private JTextField textTipo;
private JTextField textTamaño;


public VentanaAgregarProductoBebida(Restaurante restoprueba) {
	setBounds(new Rectangle(100, 100, 450, 200));
	getContentPane().setLayout(null);
	setTitle("AGREGAR BEBIDA");
	
	contentPane = new JPanel();
	contentPane.setBounds(125, 121, 10, 10);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblIDproducto = new JLabel("ID PRODUCTO");
	lblIDproducto.setHorizontalTextPosition(SwingConstants.CENTER);
	lblIDproducto.setHorizontalAlignment(SwingConstants.CENTER);
	lblIDproducto.setBounds(31, 35, 94, 16);
	contentPane.add(lblIDproducto);
	

	
	txtID = new JTextField();
	txtID.setHorizontalAlignment(SwingConstants.CENTER);
	txtID.setColumns(10);
	txtID.setBounds(202, 28, 100, 30);
	contentPane.add(txtID);
	
	textNombre = new JTextField();
	textNombre.setHorizontalAlignment(SwingConstants.CENTER);
	textNombre.setColumns(10);
	textNombre.setBounds(202, 70, 100, 30);
	contentPane.add(textNombre);
	
	JLabel lblNombre = new JLabel("NOMBRE");
	lblNombre.setHorizontalTextPosition(SwingConstants.CENTER);
	lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
	lblNombre.setBounds(31, 77, 94, 16);
	contentPane.add(lblNombre);
	
	JLabel lblPrecio = new JLabel("PRECIO");
	lblPrecio.setHorizontalTextPosition(SwingConstants.CENTER);
	lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
	lblPrecio.setBounds(31, 117, 94, 16);
	contentPane.add(lblPrecio);
	
	JLabel lblTipo = new JLabel("TIPO");
	lblTipo.setHorizontalTextPosition(SwingConstants.CENTER);
	lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
	lblTipo.setBounds(31, 161, 94, 16);
	contentPane.add(lblTipo);
	
	textPrecio = new JTextField();
	textPrecio.setHorizontalAlignment(SwingConstants.CENTER);
	textPrecio.setColumns(10);
	textPrecio.setBounds(202, 110, 100, 30);
	contentPane.add(textPrecio);
	
	textTipo = new JTextField();
	textTipo.setHorizontalAlignment(SwingConstants.CENTER);
	textTipo.setColumns(10);
	textTipo.setBounds(202, 154, 100, 30);
	contentPane.add(textTipo);
	
	JLabel lblTamanio = new JLabel("TAMAÑO");
	lblTamanio.setHorizontalTextPosition(SwingConstants.CENTER);
	lblTamanio.setHorizontalAlignment(SwingConstants.CENTER);
	lblTamanio.setBounds(31, 203, 94, 16);
	contentPane.add(lblTamanio);
	
	textTamaño = new JTextField();
	textTamaño.setHorizontalAlignment(SwingConstants.CENTER);
	textTamaño.setColumns(10);
	textTamaño.setBounds(202, 196, 100, 30);
	contentPane.add(textTamaño);
	
	JButton btnAgregarBebida = new JButton("Agregar");
	btnAgregarBebida.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			int idIngresado = Integer.parseInt(txtID.getText());
			String nombre = textNombre.getText();
			double precio = Double.parseDouble(textPrecio.getText());
			String tipo= textTipo.getText();
			int tamanio=Integer.parseInt(textTamaño.getText());
			
			
			if(restoprueba.agregarProducto(idIngresado, nombre, precio, tipo, tamanio)){
				
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				textNombre.setText("");
				textPrecio.setText("");
				txtID.setText("");
				textTipo.setText("");
				textPrecio.setText("");
				textNombre.requestFocus();
			}
			
			
				
		}
	});
	btnAgregarBebida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAgregarBebida.setBounds(202, 276, 100, 30);
	contentPane.add(btnAgregarBebida);
}
}
