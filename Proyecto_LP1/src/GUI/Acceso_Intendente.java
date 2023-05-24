package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.MySqlLogeoDAO;
import entidades.logeo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class Acceso_Intendente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoInt;
	private JPasswordField passContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceso_Intendente frame = new Acceso_Intendente();
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
	public Acceso_Intendente() {
		setTitle("Login Intendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodigoInt = new JTextField();
		txtCodigoInt.setBorder(null);
		txtCodigoInt.setBounds(33, 213, 124, 20);
		contentPane.add(txtCodigoInt);
		txtCodigoInt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("INICIAR SESI\u00D3N");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(33, 70, 181, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String vLogin,vClave;
				vLogin=txtCodigoInt.getText();
				vClave=passContra.getText();
				//invocar al método
				logeo bean=new MySqlLogeoDAO().iniciarSesion(vLogin, vClave);
				//validar bean
				if(bean==null){
					mensaje("Usuario y/o clave incorrectos");
				}
				else{
					FrmMenu frm=new FrmMenu();
					frm.setVisible(true);
					dispose();
				}
				
				
				
			}
			void mensaje(String m){
				JOptionPane.showMessageDialog(null, m);
			}
			
		});
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(Color.BLACK);
		btnIngresar.setBounds(111, 284, 124, 38);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(33, 188, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(202, 188, 96, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\fotoactualizaa.png"));
		lblNewLabel_2.setBounds(496, 70, 228, 133);
		contentPane.add(lblNewLabel_2);
		
		passContra = new JPasswordField();
		passContra.setBorder(null);
		passContra.setBounds(190, 213, 120, 20);
		contentPane.add(passContra);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(33, 236, 124, 8);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(190, 236, 124, 8);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("INSPECCION DE ENTIDADES BAJO LA SUPERVISION DE SMV\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(410, 213, 376, 99);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\wallpaperbetter.jpg"));
		lblNewLabel_3.setBounds(396, 0, 400, 421);
		contentPane.add(lblNewLabel_3);
	}
}
