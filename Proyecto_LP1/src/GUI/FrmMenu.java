package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrmMenu extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmEntidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
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
	public FrmMenu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 435);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmEntidad = new JMenuItem("Entidades");
		mntmEntidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEntidades frm=new frmEntidades();
				frm.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmEntidad);
		
		JMenuItem mntmInspectores = new JMenuItem("Inspectores");
		mntmInspectores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmInspectores frm=new FrmInspectores();
				frm.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmInspectores);
		
		JMenuItem mntmAnalista = new JMenuItem("Asignacion");
		mntmAnalista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAsignacionEntidades frm=new FrmAsignacionEntidades();
						frm.setVisible(true);
			}
		});
		mnMantenimiento.add(mntmAnalista);
		
		JMenu mnNewMenu = new JMenu("Busquedas");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Documentos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmConsultaXDocumentos frm=new FrmConsultaXDocumentos();
				frm.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Entidades");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmConsultaEntidadesXcategoria frm = new FrmConsultaEntidadesXcategoria();
				frm.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Inspeccion");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Inspeccion");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAsignacionFinal frm = new FrmAsignacionFinal();
				frm.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Reporte de Inspectores");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReporteInspector frm = new FrmReporteInspector();
				frm.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Reporte de Entidades");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmReporteEntidades frm = new FrmReporteEntidades();
				frm.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mas Informacion");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmInfo frm = new FrmInfo();
				frm.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\svm.png"));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}

}
