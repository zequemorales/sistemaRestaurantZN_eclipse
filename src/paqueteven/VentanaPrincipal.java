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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import paqueteven.MyButton;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * Clase de la ventana principal del restaurante. Muestra el plano del local.
 * @author Zeque
 *
 */
public class VentanaPrincipal extends JFrame {

	public JPanel contentPane;
	public JPanel panelMesasAbajo;
	public JPanel panelMesasArriba;

	
	public VentanaPrincipal(String usuarioIngresado) {
		String nombreRest = "ANTARES";
		String direccionRest = "CONSTITUCION 5500";
		
		Restaurante restoprueba=new Restaurante(nombreRest, direccionRest);
		
		int tiempoEnMilisegundos=3000;
		Timer timer = new Timer (tiempoEnMilisegundos, new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	contentPane.repaint();
				contentPane.validate();
				contentPane.updateUI();
				pintarMesas(restoprueba);
		     } 
		}); 


		timer.start();
		
		
		Toolkit mipantalla= Toolkit.getDefaultToolkit();
		
		Dimension tamanioPantalla = mipantalla.getScreenSize();
		
		int alturaPantalla = tamanioPantalla.height;
		int anchoPantalla = tamanioPantalla.width;
		
		
		setBounds(anchoPantalla/4, alturaPantalla/4, anchoPantalla-10, alturaPantalla-10);

		for(int i=0; i<30; i++){
			restoprueba.agregarMesa(i+1);
		}
		
		restoprueba.crearMozo("JUAN", "PEREZ", 1);
		
		restoprueba.agregarProducto(1, "Fideos", 100, "Pastas", true);
		restoprueba.agregarProducto(2, "Honey", 90, "Cerveza", 500);
	
		
		
		// PROPIEDADES VENTANA
		
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
///////////////  BARRA DE MENU   /////////////
	// DECLARACION 
	JMenuBar barra_menu = new JMenuBar();
	JMenu menu_restaurante = new JMenu();
	JMenuItem menu_item_info = new JMenuItem("Info");
	
	JMenu menu_version = new JMenu("VERSION");
	JMenuItem menu_item_acerca = new JMenuItem("Acerca");
	JMenu menu_gestion = new JMenu("GESTION");
	JMenuItem menu_item_AgregarMozo = new JMenuItem("Agregar Mozo");
	JMenuItem menu_item_AgregarMesa = new JMenuItem("Agregar Mesa");
	
	JMenu menu_reportes = new JMenu("REPORTES");
	JButton menu_boton_salir = new JButton("SALIR");
	
	JLabel menu_label_usuario = new JLabel(usuarioIngresado);
	JLabel menu_label_espacio = new JLabel("  |  ");
	
	menu_label_espacio.setBounds(new Rectangle(0, 0, 10, 10));
	RSLabelHora menu_hora = new RSLabelHora();
	menu_hora.setPreferredSize(new Dimension(60, 40));
	menu_hora.setBounds(new Rectangle(0, 0, 30, 40));
	
	RSLabelFecha menu_fecha = new RSLabelFecha();
	menu_fecha.setBounds(new Rectangle(0, 0, 60, 40));
	menu_fecha.setPreferredSize(new Dimension(60, 40));
	
	
	// PROPIEDADES
	
	// BARRA DE MENU
	setJMenuBar(barra_menu);
	
	// MENU RESTAURANTE
	menu_restaurante.setText("RESTAURANTE");
	menu_restaurante.setRequestFocusEnabled(false);
	barra_menu.add(menu_restaurante);
	
	// MENU INFO	
	menu_item_info.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaInfo veninf = new VentanaInfo(restoprueba);
			veninf.setVisible(true);
			
		}
	});
	menu_restaurante.add(menu_item_info);
	
	// MENU VERSION 
	menu_version.setRequestFocusEnabled(false);
	barra_menu.add(menu_version);
	// MENU VERSION --> ACERCA
	menu_version.add(menu_item_acerca);
	
	// MENU GESTION 
	barra_menu.add(menu_gestion);
	
	// MENU GESTION --> AGREGAR MOZO
	menu_gestion.add(menu_item_AgregarMozo);
	menu_item_AgregarMozo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAgregarMozo venAgreMozo = new VentanaAgregarMozo(restoprueba);
			venAgreMozo.setVisible(true);
			
		}
	});
	
	// MENU GESTION --> AGREGAR MESA
	
	menu_item_AgregarMesa.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAgregarMesa venAgreMesa = new VentanaAgregarMesa(restoprueba);
			venAgreMesa.setVisible(true);
			
			
		}
	});
	
	menu_gestion.add(menu_item_AgregarMesa);
	
	
	
	// MENU REPORTES 
	barra_menu.add(menu_reportes);
	
	JMenuItem menu_item_cuentasActivas = new JMenuItem("Ver Cuentas Activas");
	menu_item_cuentasActivas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println(restoprueba.listarCuentasActivas());
			
		}
	});
	menu_reportes.add(menu_item_cuentasActivas);
	
	JMenuItem menu_item_historialCuentas = new JMenuItem("Ver Historial Cuentas");
	menu_item_historialCuentas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println(restoprueba.listarHistorialCuentas());
		}
	});
	menu_reportes.add(menu_item_historialCuentas);
	
	// MENU LABEL USUARIO
	barra_menu.add(menu_label_usuario);
	
	// MENU LABEL VACIO
	
	barra_menu.add(menu_label_espacio);
	
	// MENU BOTON SALIR
	menu_boton_salir.setText("SALIR");
	menu_boton_salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	menu_boton_salir.setRolloverEnabled(false);
	menu_boton_salir.setBackground(Color.BLACK);
	menu_boton_salir.setForeground(Color.WHITE);
	menu_boton_salir.setFocusPainted(false);
	
	menu_boton_salir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			Logueo l = new Logueo();
			l.setVisible(true);
		}
	});
	barra_menu.add(menu_boton_salir);
	
	// MENU HORA
	menu_hora.setForeground(Color.BLACK);
	barra_menu.add(menu_hora);
	menu_hora.setMinimumSize(new Dimension(1, 1));
	menu_hora.setSize(30, 30);
	
	
	// MENU FECHA 

	barra_menu.add(menu_fecha);
	menu_fecha.setMinimumSize(new Dimension(1, 1));
	menu_fecha.setForeground(Color.BLACK);
	menu_fecha.setSize(30,30);
	
	
	//////////// PANEL //////////////
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	panelMesasArriba = new JPanel();
	panelMesasArriba.setBounds(155, 12, 1121, 320);
	contentPane.add(panelMesasArriba);
	panelMesasArriba.setLayout(new GridLayout(0, 3, 470, 10));
	 
	 JPanel panelMedio = new JPanel();
	 panelMedio.setBounds(-1, 344, 1416, 79);
	 contentPane.add(panelMedio);
	 panelMedio.setLayout(null);
	 
	 JLabel lblBanios = new JLabel("BAÑOS");
	 lblBanios.setBackground(Color.YELLOW);
	 lblBanios.setOpaque(true);
	 lblBanios.setHorizontalAlignment(SwingConstants.CENTER);
	 lblBanios.setFont(new Font("Dialog", Font.BOLD, 50));
	 lblBanios.setBounds(497, 0, 439, 79);
	 panelMedio.add(lblBanios);
	 
	 JLabel lblCocina = new JLabel("COCINA");
	 lblCocina.setOpaque(true);
	 lblCocina.setBackground(Color.YELLOW);
	 lblCocina.setHorizontalAlignment(SwingConstants.CENTER);
	 lblCocina.setFont(new Font("Dialog", Font.BOLD, 50));
	 lblCocina.setBounds(0, 0, 398, 79);
	 panelMedio.add(lblCocina);
	 
	 JLabel lblPasillo2 = new JLabel("Pasillo");
	 lblPasillo2.setOpaque(true);
	 lblPasillo2.setHorizontalAlignment(SwingConstants.CENTER);
	 lblPasillo2.setBackground(Color.CYAN);
	 lblPasillo2.setBounds(410, 0, 64, 79);
	 panelMedio.add(lblPasillo2);
	 
	 JLabel lblPasillo1 = new JLabel("Pasillo");
	 lblPasillo1.setHorizontalAlignment(SwingConstants.CENTER);
	 lblPasillo1.setBackground(Color.CYAN);
	 lblPasillo1.setOpaque(true);
	 lblPasillo1.setBounds(968, 0, 64, 79);
	 panelMedio.add(lblPasillo1);
	 
	 JLabel lblEntrada = new JLabel("RECEPCCION | PUERTA");
	 lblEntrada.setFont(new Font("Dialog", Font.BOLD, 30));
	 lblEntrada.setOpaque(true);
	 lblEntrada.setHorizontalAlignment(SwingConstants.CENTER);
	 lblEntrada.setBackground(Color.CYAN);
	 lblEntrada.setBounds(1044, 0, 372, 79);
	 panelMedio.add(lblEntrada);
	
	 panelMesasAbajo = new JPanel();
	 panelMesasAbajo.setBounds(50, 457, 1324, 328);
	contentPane.add(panelMesasAbajo);
	panelMesasAbajo.setLayout(new GridLayout(0, 5, 250, 10));
	
	
	
	crearBotonesMesaLista(restoprueba);
	
	
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
	
	public void crearBotonMesa(Restaurante resto, String usuarioIngresado){
		
		
//		
//		MyButton mesa3 = new MyButton("3");
//		mesa3.setPressedBackgroundColor(Color.BLACK);
//		mesa3.setPreferredSize(new Dimension(50, 50));
//		mesa3.setMinimumSize(new Dimension(50, 50));
//		mesa3.setMaximumSize(new Dimension(50, 50));
//		mesa3.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa3.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa3.setForeground(Color.BLACK);
//		mesa3.setFocusPainted(false);
//		mesa3.setBorder(null);
//		mesa3.setBounds(12, 178, 50, 50);
//		mesa3.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa3 = new VentanaMesa(resto.mesaIsOcupada(3));		
//				mesa3.setTitle("MESA "+ "3");		
//				mesa3.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(3), mesa3);
//		contentPane.add(mesa3);
//		
//		MyButton mesa4 = new MyButton("4");
//		mesa4.setPressedBackgroundColor(Color.BLACK);
//		mesa4.setPreferredSize(new Dimension(50, 50));
//		mesa4.setMinimumSize(new Dimension(50, 50));
//		mesa4.setMaximumSize(new Dimension(50, 50));
//		mesa4.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa4.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa4.setForeground(Color.BLACK);
//		mesa4.setFocusPainted(false);
//		mesa4.setBorder(null);
//		mesa4.setBounds(12, 240, 50, 50);
//		mesa4.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa4 = new VentanaMesa(resto.mesaIsOcupada(4));		
//				mesa4.setTitle("MESA "+ "4");		
//				mesa4.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(4), mesa4);
//		contentPane.add(mesa4);
//		
//		MyButton mesa5 = new MyButton("5");
//		mesa5.setPressedBackgroundColor(Color.BLACK);
//		mesa5.setPreferredSize(new Dimension(50, 50));
//		mesa5.setMinimumSize(new Dimension(50, 50));
//		mesa5.setMaximumSize(new Dimension(50, 50));
//		mesa5.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa5.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa5.setForeground(Color.BLACK);
//		mesa5.setFocusPainted(false);
//		mesa5.setBorder(null);
//		mesa5.setBounds(12, 302, 50, 50);
//		mesa5.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa5 = new VentanaMesa(resto.mesaIsOcupada(5));		
//				mesa5.setTitle("MESA "+ "5");		
//				mesa5.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(5), mesa5);
//		contentPane.add(mesa5);
//		
//		MyButton mesa6 = new MyButton("6");
//		mesa6.setPressedBackgroundColor(Color.BLACK);
//		mesa6.setPreferredSize(new Dimension(50, 50));
//		mesa6.setMinimumSize(new Dimension(50, 50));
//		mesa6.setMaximumSize(new Dimension(50, 50));
//		mesa6.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa6.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa6.setForeground(Color.BLACK);
//		mesa6.setFocusPainted(false);
//		mesa6.setBorder(null);
//		mesa6.setBounds(12, 364, 50, 50);
//		mesa6.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa6 = new VentanaMesa(resto.mesaIsOcupada(6));		
//				mesa6.setTitle("MESA "+ "6");		
//				mesa6.setVisible(true);		
//			}		
//		});
//		setColorMesa(resto.mesaIsOcupada(6), mesa6);
//		contentPane.add(mesa6);
//		
//		MyButton mesa7 = new MyButton("1");
//		mesa7.setPressedBackgroundColor(Color.BLACK);
//		mesa7.setPreferredSize(new Dimension(50, 50));
//		mesa7.setMinimumSize(new Dimension(50, 50));
//		mesa7.setMaximumSize(new Dimension(50, 50));
//		mesa7.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa7.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa7.setForeground(Color.BLACK);
//		mesa7.setFocusPainted(false);
//		mesa7.setBorder(null);
//		mesa7.setBounds(178, 54, 50, 50);
//		mesa7.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa7 = new VentanaMesa(resto.mesaIsOcupada(7));		
//				mesa7.setTitle("MESA "+ "7");		
//				mesa7.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(7), mesa7);
//		contentPane.add(mesa7);
//		
//		MyButton mesa8 = new MyButton("8");
//		mesa8.setPressedBackgroundColor(Color.BLACK);
//		mesa8.setPreferredSize(new Dimension(50, 50));
//		mesa8.setMinimumSize(new Dimension(50, 50));
//		mesa8.setMaximumSize(new Dimension(50, 50));
//		mesa8.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa8.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa8.setForeground(Color.BLACK);
//		mesa8.setFocusPainted(false);
//		mesa8.setBorder(null);
//		mesa8.setBounds(178, 116, 50, 50);
//		mesa8.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa8 = new VentanaMesa(resto.mesaIsOcupada(8));		
//				mesa8.setTitle("MESA "+ "8");		
//				mesa8.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(8), mesa8);
//		contentPane.add(mesa8);
//		
//		MyButton mesa9 = new MyButton("9");
//		mesa9.setPressedBackgroundColor(Color.BLACK);
//		mesa9.setPreferredSize(new Dimension(50, 50));
//		mesa9.setMinimumSize(new Dimension(50, 50));
//		mesa9.setMaximumSize(new Dimension(50, 50));
//		mesa9.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa9.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa9.setForeground(Color.BLACK);
//		mesa9.setFocusPainted(false);
//		mesa9.setBorder(null);
//		mesa9.setBounds(178, 178, 50, 50);
//		mesa9.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa9 = new VentanaMesa(resto.mesaIsOcupada(9));		
//				mesa9.setTitle("MESA "+ "9");		
//				mesa9.setVisible(true);		
//			}		
//		});
//		setColorMesa(resto.mesaIsOcupada(9), mesa9);
//		contentPane.add(mesa9);
//		
//		MyButton mesa10 = new MyButton("10");
//		mesa10.setPressedBackgroundColor(Color.BLACK);
//		mesa10.setPreferredSize(new Dimension(50, 50));
//		mesa10.setMinimumSize(new Dimension(50, 50));
//		mesa10.setMaximumSize(new Dimension(50, 50));
//		mesa10.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa10.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa10.setForeground(Color.BLACK);
//		mesa10.setFocusPainted(false);
//		mesa10.setBorder(null);
//		mesa10.setBounds(178, 240, 50, 50);
//		mesa10.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa2 = new VentanaMesa(resto.mesaIsOcupada(10));		
//				mesa2.setTitle("MESA "+ "10");		
//				mesa2.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(10), mesa10);
//		contentPane.add(mesa10);
//		
//		MyButton mesa11 = new MyButton("11");
//		mesa11.setPressedBackgroundColor(Color.BLACK);
//		mesa11.setPreferredSize(new Dimension(50, 50));
//		mesa11.setMinimumSize(new Dimension(50, 50));
//		mesa11.setMaximumSize(new Dimension(50, 50));
//		mesa11.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa11.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa11.setForeground(Color.BLACK);
//		mesa11.setFocusPainted(false);
//		mesa11.setBorder(null);
//		mesa11.setBounds(178, 302, 50, 50);
//		mesa11.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa11 = new VentanaMesa(resto.mesaIsOcupada(11));		
//				mesa11.setTitle("MESA "+ "2");		
//				mesa11.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(11), mesa11);
//		contentPane.add(mesa11);
//		
//		MyButton mesa12 = new MyButton("12");
//		mesa12.setPressedBackgroundColor(Color.BLACK);
//		mesa12.setPreferredSize(new Dimension(50, 50));
//		mesa12.setMinimumSize(new Dimension(50, 50));
//		mesa12.setMaximumSize(new Dimension(50, 50));
//		mesa12.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa12.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa12.setForeground(Color.BLACK);
//		mesa12.setFocusPainted(false);
//		mesa12.setBorder(null);
//		mesa12.setBounds(178, 364, 50, 50);
//		mesa12.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa12 = new VentanaMesa(resto.mesaIsOcupada(12));		
//				mesa12.setTitle("MESA "+ "2");		
//				mesa12.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(12), mesa12);
//		contentPane.add(mesa12);
//		
//		MyButton mesa13 = new MyButton("13");
//		mesa13.setPressedBackgroundColor(Color.BLACK);
//		mesa13.setPreferredSize(new Dimension(50, 50));
//		mesa13.setMinimumSize(new Dimension(50, 50));
//		mesa13.setMaximumSize(new Dimension(50, 50));
//		mesa13.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa13.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa13.setForeground(Color.BLACK);
//		mesa13.setFocusPainted(false);
//		mesa13.setBorder(null);
//		mesa13.setBounds(348, 54, 50, 50);
//		mesa13.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa13 = new VentanaMesa(resto.mesaIsOcupada(13));		
//				mesa13.setTitle("MESA "+ "13");		
//				mesa13.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(13), mesa13);
//		contentPane.add(mesa13);
//		
//		MyButton mesa14 = new MyButton("14");
//		mesa14.setPressedBackgroundColor(Color.BLACK);
//		mesa14.setPreferredSize(new Dimension(50, 50));
//		mesa14.setMinimumSize(new Dimension(50, 50));
//		mesa14.setMaximumSize(new Dimension(50, 50));
//		mesa14.setHoverBackgroundColor(new Color(208, 208, 208));
//		mesa14.setHorizontalTextPosition(SwingConstants.CENTER);
//		mesa14.setForeground(Color.BLACK);
//		mesa14.setFocusPainted(false);
//		mesa14.setBorder(null);
//		mesa14.setBounds(348, 116, 50, 50);
//		mesa14.addMouseListener(new MouseAdapter() {		
//			@Override		
//			public void mouseClicked(MouseEvent e) {		
//				VentanaMesa mesa14 = new VentanaMesa(resto.mesaIsOcupada(14));		
//				mesa14.setTitle("MESA "+ "14");		
//				mesa14.setVisible(true);		
//			}		
//		});	
//		setColorMesa(resto.mesaIsOcupada(14), mesa14);
//		contentPane.add(mesa14);
		
	}
	ArrayList<MyButton> listadoBotones = new ArrayList<>();
	
	public void pintarMesas(Restaurante resto){
		int idMesa = 1;
		
		for ( MyButton e : listadoBotones){
			setColorMesa(resto.mesaIsOcupada(idMesa), e);
			idMesa++;
			
		}
		
	}
	
	
	
	public void crearBotonesMesaLista(Restaurante restoprueba ){
		
		
		for(int i=0;i<restoprueba.devuelveArrayMesas().size();i++){
			
			
			int nromesa = i + 1;
			
			MyButton mesa1 = new MyButton(nromesa);
			
			setPropiedadesBotonMesa(mesa1, restoprueba.mesaIsOcupada(i));
			mesa1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			listadoBotones.add(mesa1);
			mesa1.addMouseListener(new MouseAdapter() {	
				
				@Override		
				public void mouseClicked(MouseEvent e) {
					
					VentanaMesa mesa = new VentanaMesa(restoprueba, nromesa);		
					mesa.setTitle("MESA "+ nromesa);		
					mesa.setVisible(true);		
				}		
			});	
			
			if (i<13){
				panelMesasArriba.add(mesa1);
				
			}
			else{
				panelMesasAbajo.add(mesa1);
				
			}
			
			
			
			
			
			
			
			
			
		}
	}
}


	/**
	 * Create the frame.
	 * @param usuarioIngresado
	 */

