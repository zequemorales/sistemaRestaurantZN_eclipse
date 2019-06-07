package paqueteven;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.server.Container;

import clases.Restaurante;
import javafx.scene.shape.Circle;
import rojeru_san.RSLabelHora;
import rojeru_san.RSLabelFecha;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					Restaurante restoprueba=new Restaurante("ANTARES", "CONSTITUCION 5500");
					System.out.println(restoprueba.toString());
					
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
	public Principal() {
		boolean ocupado1=true;
		boolean ocupado2=false;
		
		setMinimumSize(new Dimension(750, 550));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		
		JMenuBar barra_menu = new JMenuBar();
		setJMenuBar(barra_menu);
		
		JMenu menu_restaurante = new JMenu("RESTAURANTE");
		menu_restaurante.setRequestFocusEnabled(false);
		barra_menu.add(menu_restaurante);
		
		JMenuItem menu_item_info = new JMenuItem("Info");
		menu_restaurante.add(menu_item_info);
		
		JMenu menu_version = new JMenu("VERSION");
		menu_version.setRequestFocusEnabled(false);
		barra_menu.add(menu_version);
		
		JMenuItem menu_item_acerca = new JMenuItem("Acerca");
		menu_version.add(menu_item_acerca);
		
		JMenu menu_gestion = new JMenu("GESTION");
		barra_menu.add(menu_gestion);
		
		JMenuItem menu_item_AgregarMozo = new JMenuItem("Agregar Mozo");
		menu_gestion.add(menu_item_AgregarMozo);
		
		JMenu menu_reportes = new JMenu("REPORTES");
		barra_menu.add(menu_reportes);
		
		RSLabelHora menu_hora = new RSLabelHora();
		barra_menu.add(menu_hora);
		
		RSLabelFecha menu_fecha = new RSLabelFecha();
		barra_menu.add(menu_fecha);
		
		
	
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		///////////////////////////////////
		
		Canvas canvas_0 = new Canvas();		
		
 		canvas_0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
 		canvas_0.addMouseListener(new MouseAdapter() {		
 			@Override		
 			public void mouseClicked(MouseEvent e) {		
 				VentanaMesa mesa0 = new VentanaMesa(ocupado1);		
 				mesa0.setTitle("MESA 1");		
 				mesa0.setVisible(true);		

  			}		
 		});		
 		if(ocupado1){
 			canvas_0.setBackground(Color.RED);	
 			
 		}
 		else
 		{
 			canvas_0.setBackground(Color.GREEN);	
 		}		
 		canvas_0.setBounds(10, 120, 60, 60);		
 		contentPane.add(canvas_0);		

  		Canvas canvas_1 = new Canvas();		
  		
 		canvas_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
 		canvas_1.addMouseListener(new MouseAdapter() {		
 			@Override		
 			public void mouseClicked(MouseEvent e) {		
 				VentanaMesa mesa1 = new VentanaMesa(ocupado2);		
 				mesa1.setTitle("MESA 2");		
 				mesa1.setVisible(true);		
 			}		
 		});		
 		if(ocupado2){
 			canvas_1.setBackground(Color.RED);	
 			
 		}
 		else
 		{
 			canvas_1.setBackground(Color.GREEN);	
 		}			
 		canvas_1.setBounds(10, 186, 60, 60);		
 		contentPane.add(canvas_1);		

 		
 		JButton btnMesa = new JButton("mesa 1");
 		btnMesa.setBorder(UIManager.getBorder("Button.border"));
 		btnMesa.setForeground(Color.RED);
 		btnMesa.setBounds(10, 357, 60, 54);
 		btnMesa.setBackground(Color.RED);
 		contentPane.add(btnMesa);


//  		Canvas canvas_2 = new Canvas();		
//  	
// 		canvas_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_2.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa2 = new VentanaMesa();		
// 				mesa2.setTitle("MESA 4");		
// 				mesa2.setVisible(true);		
// 			}		
// 		});		
// 		canvas_2.setBackground(Color.GREEN);		
// 		canvas_2.setBounds(10, 252, 60, 60);	
// 		contentPane.add(canvas_2);		
//
//  		Canvas canvas_3 = new Canvas();		
//  		
// 		canvas_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_3.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa3 = new VentanaMesa();		
// 				mesa3.setTitle("MESA 3");		
// 				mesa3.setVisible(true);		
// 			}		
// 		});		
// 		canvas_3.setBackground(Color.GREEN);		
// 		canvas_3.setBounds(10, 318, 60, 60);		
// 		contentPane.add(canvas_3);		
//
//  		Canvas canvas_4 = new Canvas();		
//  		
// 		canvas_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_4.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa4 = new VentanaMesa();		
// 				mesa4.setTitle("MESA 5");		
// 				mesa4.setVisible(true);		
// 			}		
// 		});		
// 		canvas_4.setBackground(Color.GREEN);		
// 		canvas_4.setBounds(10, 384, 60, 60);	
// 		contentPane.add(canvas_4);		
//
//  		Canvas canvas_5 = new Canvas();		
// 		canvas_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_5.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa5 = new VentanaMesa();		
// 				mesa5.setTitle("MESA 6");		
// 				mesa5.setVisible(true);		
// 			}		
// 		});	
// 		if(ocupado){
// 			canvas_5.setBackground(Color.RED);	
// 			
// 		}
// 		else
// 		{
// 			canvas_5.setBackground(Color.GREEN);	
// 		}
// 			
// 		canvas_5.setBounds(100, 120, 60, 60);		
// 		contentPane.add(canvas_5);		
//
//  		Canvas canvas_6 = new Canvas();		
//  		canvas_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
// 		canvas_6.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa6 = new VentanaMesa();		
// 				mesa6.setTitle("MESA 7");		
// 				mesa6.setVisible(true);		
// 			}		
// 		});		
// 		canvas_6.setBackground(Color.GREEN);		
// 		canvas_6.setBounds(100, 186, 60, 60);		
// 		contentPane.add(canvas_6);		
//
//  		Canvas canvas_7 = new Canvas();		
// 		canvas_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_7.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa7 = new VentanaMesa();		
// 				mesa7.setTitle("MESA 8");		
// 				mesa7.setVisible(true);		
// 			}		
// 		});		
// 		canvas_7.setBackground(Color.GREEN);		
// 		canvas_7.setBounds(100, 252, 60, 60);		
// 		contentPane.add(canvas_7);		
//
// 
//  		Canvas canvas_8 = new Canvas();		 		
// 		canvas_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
// 		canvas_8.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa8 = new VentanaMesa();		
// 				mesa8.setTitle("MESA 9");		
// 				mesa8.setVisible(true);		
// 			}		
// 		});		
// 		canvas_8.setBackground(Color.GREEN);		
// 		canvas_8.setBounds(100, 318, 60, 60);		
// 		contentPane.add(canvas_8);		
//
// 
//  		Canvas canvas_9 = new Canvas();		 		
// 		canvas_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		 	
// 		canvas_9.addMouseListener(new MouseAdapter() {
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa9 = new VentanaMesa();		
// 				mesa9.setTitle("MESA 10");		
// 				mesa9.setVisible(true);		
// 			}		
// 		});		
// 		canvas_9.setBackground(Color.GREEN);		
// 		canvas_9.setBounds(100, 384, 60, 60);		
// 		contentPane.add(canvas_9);		
//
// 
//  		Canvas canvas_10 = new Canvas();
//  		
// 		canvas_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
// 		
// 		canvas_10.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa10 = new VentanaMesa();		
// 				mesa10.setTitle("MESA 11");		
// 				mesa10.setVisible(true);		
// 			}		
// 		});		
// 		canvas_10.setBackground(Color.GREEN);		
// 		canvas_10.setBounds(341, 120, 60, 60);		
// 		contentPane.add(canvas_10);		
//
// 
//  		Canvas canvas_11 = new Canvas();
// 		canvas_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		 	
// 		canvas_11.addMouseListener(new MouseAdapter() {	
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa11 = new VentanaMesa();		
// 				mesa11.setTitle("MESA 12");		
// 				mesa11.setVisible(true);		
// 			}		
// 		});		
// 		canvas_11.setBackground(Color.GREEN);		
// 		canvas_11.setBounds(341, 186, 60, 60);		
// 		contentPane.add(canvas_11);		
//
// 
//  		Canvas canvas_12 = new Canvas();		 		
// 		canvas_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
// 		canvas_12.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa12 = new VentanaMesa();		
//
//  				mesa12.setTitle("MESA 13");		
// 				mesa12.setVisible(true);		
// 			}		
// 		});		
// 		canvas_12.setBackground(Color.GREEN);		
// 		canvas_12.setBounds(341, 252, 60, 60);	
// 		contentPane.add(canvas_12);		
//
//  		Canvas canvas_13 = new Canvas();		
// 		canvas_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_13.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa13 = new VentanaMesa();		
// 				mesa13.setTitle("MESA 14");		
// 				mesa13.setVisible(true);		
// 			}		
// 		});		
// 		canvas_13.setBackground(Color.GREEN);		
// 		canvas_13.setBounds(341, 318, 60, 60);		
// 		contentPane.add(canvas_13);		
//
// 
//  		Canvas canvas_14 = new Canvas();		 		
// 		canvas_14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));	
// 		canvas_14.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa14 = new VentanaMesa();		
// 				mesa14.setTitle("MESA 15");		
// 				mesa14.setVisible(true);		
// 			}		
// 		});		
// 		canvas_14.setBackground(Color.GREEN);		
// 		canvas_14.setBounds(341, 384, 60, 60);	
// 		contentPane.add(canvas_14);		
//
//  		Canvas canvas_15 = new Canvas();		
// 		canvas_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_15.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa15 = new VentanaMesa();		
// 				mesa15.setTitle("MESA 16");		
// 				mesa15.setVisible(true);		
// 			}		
// 		});		
// 		canvas_15.setBackground(Color.GREEN);		
// 		canvas_15.setBounds(407, 120, 60, 60);	
// 		contentPane.add(canvas_15);		
//
// 
//  		Canvas canvas_16 = new Canvas();		 	
// 		canvas_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		 	
// 		canvas_16.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa16 = new VentanaMesa();		
// 				mesa16.setTitle("MESA 17");		
// 				mesa16.setVisible(true);		
// 			}		
// 		});		
// 		canvas_16.setBackground(Color.GREEN);		
// 		canvas_16.setBounds(407, 186, 60, 60);		
// 		contentPane.add(canvas_16);		
//
// 
//  		Canvas canvas_17 = new Canvas();		 		
// 		canvas_17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_17.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa17 = new VentanaMesa();		
// 				mesa17.setTitle("MESA 18");		
// 				mesa17.setVisible(true);		
// 			}		
// 		});		
// 		canvas_17.setBackground(Color.GREEN);		
// 		canvas_17.setBounds(407, 252, 60, 60);		
// 		contentPane.add(canvas_17);		
//
// 
//  		Canvas canvas_18 = new Canvas();		 		
// 		canvas_18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_18.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa18 = new VentanaMesa();		
// 				mesa18.setTitle("MESA 19");		
// 				mesa18.setVisible(true);		
// 			}		
// 		});		
// 		canvas_18.setBackground(Color.GREEN);		
// 		canvas_18.setBounds(407, 318, 60, 60);	
// 		contentPane.add(canvas_18);		
//
// 
//  		Canvas canvas_19 = new Canvas();		 		
// 		canvas_19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
// 		canvas_19.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa19 = new VentanaMesa();		
// 				mesa19.setTitle("MESA 20");		
// 				mesa19.setVisible(true);		
// 			}		
// 		});		
// 		canvas_19.setBackground(Color.GREEN);		
// 		canvas_19.setBounds(407, 384, 60, 60);		
// 		contentPane.add(canvas_19);		
//
// 
//  		Canvas canvas_20 = new Canvas();		
//  		canvas_20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		
// 		canvas_20.addMouseListener(new MouseAdapter() {		
// 			@Override		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa20 = new VentanaMesa();		
// 				mesa20.setTitle("MESA 21");		
// 				mesa20.setVisible(true);		
// 			}		
// 		});		
// 		canvas_20.setBackground(Color.GREEN);		
// 		canvas_20.setBounds(531, 120, 60, 60);		
// 		contentPane.add(canvas_20);		
//
// 
//  		Canvas canvas_21 = new Canvas();		 		
// 		canvas_21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));		 		
// 		canvas_21.addMouseListener(new MouseAdapter() {		 		
// 			@Override		 		
// 			public void mouseClicked(MouseEvent e) {		
// 				VentanaMesa mesa21 = new VentanaMesa();		
// 				mesa21.setTitle("MESA 22");		
// 				mesa21.setVisible(true);		
// 			}		
// 		});		
// 		canvas_21.setBackground(Color.GREEN);	
// 		canvas_21.setBounds(531, 186, 60, 60);		
// 		contentPane.add(canvas_21);

		
	
	
		
	}
}
