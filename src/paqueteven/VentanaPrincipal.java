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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.server.Container;

import clases.Restaurante;
import javafx.scene.shape.Circle;

import rojeru_san.RSLabelHora;
import rojeru_san.RSLabelFecha;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import java.awt.HeadlessException;

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
	ArrayList<MyButton> listadoBotones = new ArrayList<>();
	

	
	public VentanaPrincipal(String usuarioIngresado) {
		String nombreRest = "ANTARES";
		String direccionRest = "CONSTITUCION 5500";
		
		Restaurante restoprueba=new Restaurante(nombreRest, direccionRest);
		restoprueba.jsonReaderMozo(); // lee el archivo de mozos
		restoprueba.jsonReaderMesa(); // lee el archivo de mesas
		restoprueba.jsonReaderBebida(); // lee el archivo de productos bebidas
		restoprueba.jsonReaderComida(); // lee el archivo de productos comida
		restoprueba.jsonReaderCuentaActiva(); // lee el archivo de cuentas activas
		restoprueba.jsonReaderCuenta(); // lee el archivo de historial cuentas
		
		
		int tiempoEnMilisegundos=2000;
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
	menu_item_acerca.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Ezequiel Morales / Mauro Castillo / Nicolas Cristobal / VERSION 1.0");
			
		}
	});
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
	
	JMenuItem menu_item_agregarComida = new JMenuItem("Agregar Comida");
	menu_item_agregarComida.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAgregarProductoComida venComida = new VentanaAgregarProductoComida(restoprueba);
			venComida.setVisible(true);
		}
	});
	menu_gestion.add(menu_item_agregarComida);
	
	JMenuItem mntmAgregarProducto = new JMenuItem("Agregar Bebida");
	mntmAgregarProducto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			VentanaAgregarProductoBebida venBebida = new VentanaAgregarProductoBebida(restoprueba);
			venBebida.setVisible(true);
		}
	});
	menu_gestion.add(mntmAgregarProducto);
	
	
	
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
	
	JMenu menu_estadi = new JMenu("ESTADISTICAS");
	barra_menu.add(menu_estadi);
	
	JMenuItem mntmPlatoMasPedido = new JMenuItem("Plato mas pedido");
	mntmPlatoMasPedido.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int idprdMasVendido=0;
			
			idprdMasVendido=restoprueba.maxLista(restoprueba.historialComidas());
			
			JOptionPane.showMessageDialog(null,"El plato mas vendido es" + restoprueba.devuelveProducto(idprdMasVendido).getNombreProducto());
			
		}
	});
	menu_estadi.add(mntmPlatoMasPedido);
	
	JMenuItem mntmdoPlatoMas = new JMenuItem("2do Plato mas pedido");
	mntmdoPlatoMas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
int idprdMasVendido=0;
			
			idprdMasVendido=restoprueba.maxLista(restoprueba.historialComidas());
	int idprd2MasVendido=0;
			
			idprd2MasVendido=restoprueba.segundolista(restoprueba.historialComidas(),idprdMasVendido);
			
			JOptionPane.showMessageDialog(null,"El 2do plato mas vendido es" + restoprueba.devuelveProducto(idprd2MasVendido).getNombreProducto());
			
		}
	});
	menu_estadi.add(mntmdoPlatoMas);
	
	JMenuItem mntmTotalVentas = new JMenuItem("Total Ventas");
	mntmTotalVentas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double total=0;
			total=restoprueba.totalHistorico();
			JOptionPane.showMessageDialog(null,"El total vendido: $ " + total);

		}
	});
	menu_estadi.add(mntmTotalVentas);
	
	JMenuItem mntmProbabilidadProducto = new JMenuItem("Probabilidad Comida");
	mntmProbabilidadProducto.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				int numero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un id para ver su probabilidad"));
				double probabilidad=0;
				probabilidad=restoprueba.probabilidadProducto(restoprueba.historialComidas(), numero);
				JOptionPane.showMessageDialog(null,"Hay una probabilidad de " + probabilidad + " que se pida " + restoprueba.devuelveProducto(numero).getNombreProducto() );
			

			
		}
	});
	menu_estadi.add(mntmProbabilidadProducto);
	
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
			restoprueba.grabaCuentasActivas();
			restoprueba.grabaHistorialCuenta();
			restoprueba.grabarBebidas();
			restoprueba.grabarComida();
			restoprueba.grabarMesa();
			restoprueba.grabarMozo();
			
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

