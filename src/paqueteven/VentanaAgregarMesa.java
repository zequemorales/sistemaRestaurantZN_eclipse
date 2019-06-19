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

public class VentanaAgregarMesa extends JFrame {private JPanel contentPane;
private JTextField txtID;


public VentanaAgregarMesa(Restaurante restoprueba) {
	setBounds(new Rectangle(100, 100, 450, 200));
	getContentPane().setLayout(null);
	
	contentPane = new JPanel();
	contentPane.setBounds(125, 121, 10, 10);
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblID = new JLabel("ID ");
	lblID.setHorizontalTextPosition(SwingConstants.CENTER);
	lblID.setHorizontalAlignment(SwingConstants.CENTER);
	lblID.setBounds(216, 35, 18, 16);
	contentPane.add(lblID);
	
	JButton btnAgregarMesa = new JButton("Agregar");
	btnAgregarMesa.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			int idMesa = Integer.parseInt(txtID.getText());
			
			if(restoprueba.agregarMesa(idMesa)){
				MyButton mesa1 = new MyButton(idMesa);
				
				setPropiedadesBotonMesa(mesa1, restoprueba.mesaIsOcupada(idMesa));
				mesa1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				mesa1.addMouseListener(new MouseAdapter() {	
					
					@Override		
					public void mouseClicked(MouseEvent e) {
						
						VentanaMesa mesa = new VentanaMesa(restoprueba, idMesa);		
						mesa.setTitle("MESA "+ idMesa);		
						mesa.setVisible(true);		
					}		
				});	
				

				
				dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "ID EXISTE", "ERROR", JOptionPane.ERROR_MESSAGE);
				
				txtID.setText("");
				txtID.requestFocus();
			}
			
			
			
			
			
				
		}
	});
	btnAgregarMesa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAgregarMesa.setBounds(175, 109, 100, 30);
	contentPane.add(btnAgregarMesa);
	
	txtID = new JTextField();
	txtID.setHorizontalAlignment(SwingConstants.CENTER);
	txtID.setColumns(10);
	txtID.setBounds(175, 62, 100, 30);
	contentPane.add(txtID);
}


public void setPropiedadesBotonMesa(MyButton btnSave, boolean ocupado){
	   btnSave.setForeground(Color.BLACK); 
	     btnSave.setHorizontalTextPosition(SwingConstants.CENTER); 
	     btnSave.setBorder(null);  
	     btnSave.setHoverBackgroundColor(new Color(208, 208, 208)); 
	     btnSave.setPressedBackgroundColor(Color.BLACK);
	     setColorMesa(ocupado, btnSave);
	     btnSave.setMinimumSize(new Dimension(50, 50));
	     btnSave.setMaximumSize(new Dimension(50, 50));
	     btnSave.setPreferredSize(new Dimension(50, 50));
	     btnSave.setFocusPainted(false);
}


public void setColorMesa(boolean ocupado, MyButton btnSave){
	if (ocupado) {
		btnSave.setBackground(Color.RED);
	}
	else{
		btnSave.setBackground(Color.GREEN);
	}
}

}
