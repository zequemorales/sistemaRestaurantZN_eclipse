package paqueteven;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class VentanaMesa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,boolean ocupado) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMesa frame = new VentanaMesa( ocupado);
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
	private String estadoMesa;
	private JTable table;
	public VentanaMesa(boolean ocupado) {
		
		setEstadoMesa(ocupado);
		
		
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(getEstadoMesa());
		label.setBounds(6, 6, 84, 16);
		contentPane.add(label);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
		});
		btnGuardar.setBounds(186, 6, 117, 29);
		
		contentPane.add(btnGuardar);
		
		table = new JTable();
		table.setBounds(28, 99, 275, 154);
		table.addRowSelectionInterval(1, 4);
		table.addColumnSelectionInterval(1, 4);
		contentPane.add(table);
	}
	
	public void setEstadoMesa(boolean ocupado){
		if(ocupado){
			this.estadoMesa="MESA OCUPADA";
		}
		else
		{
			this.estadoMesa="MESA VACIA";
		}
		
	}
	
	public String getEstadoMesa(){
		return estadoMesa;
	}
}
