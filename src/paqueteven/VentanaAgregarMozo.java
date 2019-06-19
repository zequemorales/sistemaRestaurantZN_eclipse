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
import java.awt.Cursor;

public class VentanaAgregarMozo extends JFrame {
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtID;
	

	
	public VentanaAgregarMozo(Restaurante resto) {
		setBounds(new Rectangle(100, 100, 450, 200));
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBounds(125, 121, 10, 10);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
			
		
		
		
		
		txtApellido = new JTextField();
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setBounds(175, 62, 100, 30);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		

	
		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNombre.setBounds(64, 35, 50, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblApellido.setBounds(196, 35, 52, 16);
		contentPane.add(lblApellido);
		
		JLabel lblID = new JLabel("ID ");
		lblID.setHorizontalTextPosition(SwingConstants.CENTER);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(354, 35, 18, 16);
		contentPane.add(lblID);
		
		JButton btnAgregarMozo = new JButton("Agregar");
		btnAgregarMozo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = txtNombre.getText();
				String apellido= txtApellido.getText();
				int idMozo = Integer.parseInt(txtID.getText());
				
				if(resto.crearMozo(nombre, apellido, idMozo)){
					
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Nombre/Apellido o ID incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
					txtNombre.setText("");
					txtApellido.setText("");
					txtID.setText("");
					txtNombre.requestFocus();
				}
				
				
				
				
				
					
			}
		});
		btnAgregarMozo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarMozo.setBounds(175, 109, 100, 30);
		contentPane.add(btnAgregarMozo);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setColumns(10);
		txtNombre.setBounds(42, 62, 100, 30);
		contentPane.add(txtNombre);
		
		txtID = new JTextField();
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setColumns(10);
		txtID.setBounds(315, 62, 100, 30);
		contentPane.add(txtID);
	}
}
