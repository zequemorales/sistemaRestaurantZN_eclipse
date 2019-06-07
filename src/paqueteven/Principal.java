package paqueteven;
import java.awt.Canvas;
import java.awt.Color;
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
import rojeru_san.RSLabelHora;
import rojeru_san.RSLabelFecha;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
}
