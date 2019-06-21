package paqueteven;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



import javax.swing.JProgressBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.Cursor;


/**
 * Clase de la ventana de logueo 
 * @author Zeque
 *
 */
public class Logueo extends JFrame{

	
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnIngresar;
	
	public static void main(String[] args) {
		try{
			  UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			}catch(Exception e){
			  e.printStackTrace();
			} 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logueo frame = new Logueo();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch the application.
	 * @param args 
	 */

	
	public Logueo() {


		setBackground(Color.WHITE);
		
		setVisible(true);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit mipantalla= Toolkit.getDefaultToolkit();
		
		Dimension tamanioPantalla = mipantalla.getScreenSize();
		
		int alturaPantalla = tamanioPantalla.height;
		int anchoPantalla = tamanioPantalla.width;
		
		
		setBounds(anchoPantalla/4, alturaPantalla/4, 500, 400);
		setResizable(true);
		
		iniciarComponentes();
		
		
		
		
	}
	
	private void iniciarComponentes(){
		
		//Creo panel
		JPanel contentPane;
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.BLACK);
		
		//// DECLARACION/INICIALIZACION DE VARIABLES BOTONES LABELS ETC ////
		JLabel lblLogin = new JLabel();
		JLabel lblUsuario = new JLabel();
		JLabel lblContrasenia = new JLabel();
		txtUsuario = new JTextField();
		txtPassword = new JPasswordField();
		btnIngresar = new JButton();
		
		////////PROPIEDADES ///////
		
		///lblLogin LABEL DE LOGIN 
		lblLogin.setText("Login");
		lblLogin.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBorder(new LineBorder(Color.GREEN, 4, false));
		lblLogin.setOpaque(true);
		lblLogin.setBackground(Color.BLACK);
		
		lblLogin.setBounds(200, 30, 122, 33);
		
		///lblUsuario LABEL DE USUARIO
		lblUsuario.setText("Usuario");
		lblUsuario.setBounds(100, 80, 122, 33);
		lblUsuario.setForeground(Color.WHITE);
		
		
		
		///lblCntraseña LABEL DE CONTRASEÑA
		lblContrasenia.setText("Contraseña");
		lblContrasenia.setBounds(100, 133, 122, 33);
		lblContrasenia.setForeground(Color.WHITE);
		
		/// txtUsuario CAJA DE TEXTO USUARIO
		txtUsuario.setBounds(200, 80, 122, 33);
		txtUsuario.setBackground(Color.GREEN);
		
		/// txtPassword CAJA DE TEXTO PASSWORD
		
		// agregamos que cuando presione enter, ingrese al sistema
		txtPassword.setBackground(Color.GREEN);
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				enter_ingresar(e);
			}
		});
		
		txtPassword.setBounds(200, 133, 122, 33);
		
		
		
	
		
		/// btnIngresar BOTON INGRESAR AL SISTEMA
		btnIngresar.setText("INGRESAR");
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setRolloverEnabled(false);
		btnIngresar.setBackground(Color.BLACK);
		btnIngresar.setForeground(Color.WHITE);

		// agregamos una accion al boton 
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton_ingresar(); // esta accion seria ingresar al sitema. 
			}
		});
		
		btnIngresar.setBounds(200, 250, 122, 33);
		
		
		
		/////////// AGREGAMOS AL PANEL //////////
		contentPane.add(lblLogin);
		contentPane.add(lblUsuario);
		contentPane.add(lblContrasenia);
		contentPane.add(txtUsuario);
		contentPane.add(txtPassword);
		contentPane.add(btnIngresar);
		/////////// AGREGAMOS AL PANEL //////////
		
	
	}
	
	
	/**
	 * Este metodo llama a AccesoSitema
	 */
	public void boton_ingresar(){
		accesoSistema();	
	}
	/**
	 * Este metodo recibe una tecla presionada y si es igual a un "ENTER" llama a la funcion AccesoSistema
	 * @param e seria un evento de una tecla presionada
	 */
	public void enter_ingresar(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			accesoSistema();
		}
	}
	
	/**
	 * Hace las comprobaciones necesarias para ingresar al sistema
	 * 
	 * 
	 */
	
	public void accesoSistema(){
		//////////// USUARIOS //////////////
		String adminUsuario="admin";
		String adminPassword="admin";
		String mozoUsuario="mozo";
		String mozoPassword="";
		
		
		// Getpassword devuelve un char y lo tenemos que convertir en string
		
		//guardamos el contenido de txtPassword mediante el metdo get
		char [] clave= txtPassword.getPassword();
		//y creamos una variable string 
		String claveFinal= new String (clave);
		
		// y comparamos lo ingresado con nuestros usuarios
	
		if(txtUsuario.getText().equals(adminUsuario) && claveFinal.equals(adminPassword)){
			dispose();
			VentanaPrincipal p = new VentanaPrincipal(txtUsuario.getText());
			p.setVisible(true);
			
		}
		else if (txtUsuario.getText().equals(mozoUsuario) && claveFinal.equals(mozoPassword)){
			dispose();
			VentanaPrincipal p = new VentanaPrincipal(txtUsuario.getText());
			p.setVisible(true);
			
		}
		else{
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			txtPassword.setText("");
			txtUsuario.requestFocus();
		}
		
	}

	
	
}
