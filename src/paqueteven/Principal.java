package paqueteven;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Restaurante;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 714);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRestaurante = new JMenu("RESTAURANTE");
		menuBar.add(mnRestaurante);
		
		JMenuItem mntmInfo = new JMenuItem("Info");
		mnRestaurante.add(mntmInfo);
		
		JMenu mnVersion = new JMenu("VERSION");
		menuBar.add(mnVersion);
		
		JMenuItem mntmAcerca = new JMenuItem("Acerca");
		mnVersion.add(mntmAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Canvas canvas_0 = new Canvas();
		canvas_0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa0 = new VentanaMesa();
				mesa0.setTitle("MESA 1");
				mesa0.setVisible(true);
				
			}
		});
		canvas_0.setBackground(Color.GREEN);
		canvas_0.setBounds(10, 88, 41, 40);
		contentPane.add(canvas_0);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa1 = new VentanaMesa();
				mesa1.setTitle("MESA 2");
				mesa1.setVisible(true);
			}
		});
		canvas_1.setBackground(Color.GREEN);
		canvas_1.setBounds(10, 134, 41, 40);
		contentPane.add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa2 = new VentanaMesa();
				mesa2.setTitle("MESA 4");
				mesa2.setVisible(true);
			}
		});
		canvas_2.setBackground(Color.GREEN);
		canvas_2.setBounds(10, 228, 41, 40);
		contentPane.add(canvas_2);
		
		Canvas canvas_3 = new Canvas();
		canvas_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa3 = new VentanaMesa();
				mesa3.setTitle("MESA 3");
				mesa3.setVisible(true);
			}
		});
		canvas_3.setBackground(Color.GREEN);
		canvas_3.setBounds(10, 180, 41, 40);
		contentPane.add(canvas_3);
		
		Canvas canvas_4 = new Canvas();
		canvas_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa4 = new VentanaMesa();
				mesa4.setTitle("MESA 5");
				mesa4.setVisible(true);
			}
		});
		canvas_4.setBackground(Color.GREEN);
		canvas_4.setBounds(57, 88, 41, 40);
		contentPane.add(canvas_4);
		
		Canvas canvas_5 = new Canvas();
		canvas_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa5 = new VentanaMesa();
				mesa5.setTitle("MESA 6");
				mesa5.setVisible(true);
			}
		});
		canvas_5.setBackground(Color.GREEN);
		canvas_5.setBounds(57, 134, 41, 40);
		contentPane.add(canvas_5);
		
		Canvas canvas_6 = new Canvas();
		canvas_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa6 = new VentanaMesa();
				mesa6.setTitle("MESA 7");
				mesa6.setVisible(true);
			}
		});
		canvas_6.setBackground(Color.GREEN);
		canvas_6.setBounds(57, 228, 41, 40);
		contentPane.add(canvas_6);
		
		Canvas canvas_7 = new Canvas();
		canvas_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa7 = new VentanaMesa();
				mesa7.setTitle("MESA 8");
				mesa7.setVisible(true);
			}
		});
		canvas_7.setBackground(Color.GREEN);
		canvas_7.setBounds(57, 180, 41, 40);
		contentPane.add(canvas_7);
		
		Canvas canvas_8 = new Canvas();
		canvas_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa8 = new VentanaMesa();
				mesa8.setTitle("MESA 9");
				mesa8.setVisible(true);
			}
		});
		canvas_8.setBackground(Color.GREEN);
		canvas_8.setBounds(150, 88, 41, 40);
		contentPane.add(canvas_8);
		
		Canvas canvas_9 = new Canvas();
		canvas_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa9 = new VentanaMesa();
				mesa9.setTitle("MESA 10");
				mesa9.setVisible(true);
			}
		});
		canvas_9.setBackground(Color.GREEN);
		canvas_9.setBounds(150, 134, 41, 40);
		contentPane.add(canvas_9);
		
		Canvas canvas_10 = new Canvas();
		canvas_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa10 = new VentanaMesa();
				mesa10.setTitle("MESA 11");
				mesa10.setVisible(true);
			}
		});
		canvas_10.setBackground(Color.GREEN);
		canvas_10.setBounds(150, 228, 41, 40);
		contentPane.add(canvas_10);
		
		Canvas canvas_11 = new Canvas();
		canvas_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa11 = new VentanaMesa();
				mesa11.setTitle("MESA 12");
				mesa11.setVisible(true);
			}
		});
		canvas_11.setBackground(Color.GREEN);
		canvas_11.setBounds(150, 180, 41, 40);
		contentPane.add(canvas_11);
		
		Canvas canvas_12 = new Canvas();
		canvas_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa12 = new VentanaMesa();
				
				mesa12.setTitle("MESA 13");
				mesa12.setVisible(true);
			}
		});
		canvas_12.setBackground(Color.GREEN);
		canvas_12.setBounds(197, 88, 41, 40);
		contentPane.add(canvas_12);
		
		Canvas canvas_13 = new Canvas();
		canvas_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa13 = new VentanaMesa();
				mesa13.setTitle("MESA 14");
				mesa13.setVisible(true);
			}
		});
		canvas_13.setBackground(Color.GREEN);
		canvas_13.setBounds(197, 134, 41, 40);
		contentPane.add(canvas_13);
		
		Canvas canvas_14 = new Canvas();
		canvas_14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa14 = new VentanaMesa();
				mesa14.setTitle("MESA 15");
				mesa14.setVisible(true);
			}
		});
		canvas_14.setBackground(Color.GREEN);
		canvas_14.setBounds(197, 228, 41, 40);
		contentPane.add(canvas_14);
		
		Canvas canvas_15 = new Canvas();
		canvas_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa15 = new VentanaMesa();
				mesa15.setTitle("MESA 16");
				mesa15.setVisible(true);
			}
		});
		canvas_15.setBackground(Color.GREEN);
		canvas_15.setBounds(197, 180, 41, 40);
		contentPane.add(canvas_15);
		
		Canvas canvas_16 = new Canvas();
		canvas_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa16 = new VentanaMesa();
				mesa16.setTitle("MESA 17");
				mesa16.setVisible(true);
			}
		});
		canvas_16.setBackground(Color.GREEN);
		canvas_16.setBounds(399, 10, 41, 40);
		contentPane.add(canvas_16);
		
		Canvas canvas_17 = new Canvas();
		canvas_17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa17 = new VentanaMesa();
				mesa17.setTitle("MESA 18");
				mesa17.setVisible(true);
			}
		});
		canvas_17.setBackground(Color.GREEN);
		canvas_17.setBounds(399, 56, 41, 40);
		contentPane.add(canvas_17);
		
		Canvas canvas_18 = new Canvas();
		canvas_18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa18 = new VentanaMesa();
				mesa18.setTitle("MESA 19");
				mesa18.setVisible(true);
			}
		});
		canvas_18.setBackground(Color.GREEN);
		canvas_18.setBounds(399, 150, 41, 40);
		contentPane.add(canvas_18);
		
		Canvas canvas_19 = new Canvas();
		canvas_19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa19 = new VentanaMesa();
				mesa19.setTitle("MESA 20");
				mesa19.setVisible(true);
			}
		});
		canvas_19.setBackground(Color.GREEN);
		canvas_19.setBounds(399, 102, 41, 40);
		contentPane.add(canvas_19);
		
		Canvas canvas_20 = new Canvas();
		canvas_20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa20 = new VentanaMesa();
				mesa20.setTitle("MESA 21");
				mesa20.setVisible(true);
			}
		});
		canvas_20.setBackground(Color.GREEN);
		canvas_20.setBounds(399, 244, 41, 40);
		contentPane.add(canvas_20);
		
		Canvas canvas_21 = new Canvas();
		canvas_21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		canvas_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMesa mesa21 = new VentanaMesa();
				mesa21.setTitle("MESA 22");
				mesa21.setVisible(true);
			}
		});
		canvas_21.setBackground(Color.GREEN);
		canvas_21.setBounds(399, 196, 41, 40);
		contentPane.add(canvas_21);
		
	}
}
