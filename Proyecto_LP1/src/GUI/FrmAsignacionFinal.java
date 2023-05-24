package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.MySqlInspeccionFinal;
import entidades.InspeccionFinal;

public class FrmAsignacionFinal extends JFrame {

	private JPanel contentPane;
	private JTextField txtFInspeccion;
	public static JTextField txtCodigo;
	public static JTextField txtEntidad;
	public static JTextField txtDireccion;
	public static JTextField txtTelefono;
	public static JTextField txtCategoria;
	private JTable tblInspeccion;
	private JPanel panel;
	public static JTextField txtCodigoDoc;
	public static JTextField txtDocumento;
	public static JTextField txtFecha;
	public static JTextField txtInsp;
	public static JTextField txtResultado;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_5;
	private JLabel lblNewLabel_1_6;
	private JLabel lblNewLabel_1_7;
	private JLabel lblNewLabel_1_8;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAsignacionFinal frame = new FrmAsignacionFinal();
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
	public FrmAsignacionFinal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 772, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFInspeccion = new JTextField();
		txtFInspeccion.setBounds(150, 38, 145, 20);
		contentPane.add(txtFInspeccion);
		txtFInspeccion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha de Inspeccion:");
		lblNewLabel.setBounds(29, 41, 111, 14);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(29, 83, 680, 122);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(83, 23, 108, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtEntidad = new JTextField();
		txtEntidad.setEditable(false);
		txtEntidad.setColumns(10);
		txtEntidad.setBounds(83, 49, 108, 20);
		panel.add(txtEntidad);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(83, 80, 108, 20);
		panel.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(319, 23, 108, 20);
		panel.add(txtTelefono);
		
		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(319, 49, 108, 20);
		panel.add(txtCategoria);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setBounds(10, 26, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Entidad");
		lblNewLabel_1_1.setBounds(10, 52, 63, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Direccion");
		lblNewLabel_1_2.setBounds(10, 83, 63, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefono");
		lblNewLabel_1_3.setBounds(231, 26, 56, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Categoria");
		lblNewLabel_1_4.setBounds(231, 52, 78, 14);
		panel.add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("BUSCAR ENTIDAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmConsultaEntidadesXcategoria frm = new FrmConsultaEntidadesXcategoria();
				frm.setVisible(true);
			}
		});
		btnNewButton.setBounds(253, 79, 150, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(29, 235, 680, 122);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtCodigoDoc = new JTextField();
		txtCodigoDoc.setEditable(false);
		txtCodigoDoc.setBounds(87, 11, 103, 20);
		panel_1.add(txtCodigoDoc);
		txtCodigoDoc.setColumns(10);
		
		txtDocumento = new JTextField();
		txtDocumento.setEditable(false);
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(87, 42, 103, 20);
		panel_1.add(txtDocumento);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(87, 73, 103, 20);
		panel_1.add(txtFecha);
		
		txtInsp = new JTextField();
		txtInsp.setEditable(false);
		txtInsp.setColumns(10);
		txtInsp.setBounds(318, 11, 103, 20);
		panel_1.add(txtInsp);
		
		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(318, 42, 103, 20);
		panel_1.add(txtResultado);
		
		lblNewLabel_2 = new JLabel("Codigo");
		lblNewLabel_2.setBounds(10, 14, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_1_5 = new JLabel("Documento");
		lblNewLabel_1_5.setBounds(10, 45, 63, 14);
		panel_1.add(lblNewLabel_1_5);
		
		lblNewLabel_1_6 = new JLabel("F.Asignacion");
		lblNewLabel_1_6.setBounds(10, 76, 63, 14);
		panel_1.add(lblNewLabel_1_6);
		
		lblNewLabel_1_7 = new JLabel("Nombre de Inspector");
		lblNewLabel_1_7.setBounds(200, 14, 108, 14);
		panel_1.add(lblNewLabel_1_7);
		
		lblNewLabel_1_8 = new JLabel("Resultado");
		lblNewLabel_1_8.setBounds(200, 45, 63, 14);
		panel_1.add(lblNewLabel_1_8);
		
		btnNewButton_1 = new JButton("BUSCAR DOCUMENTO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmConsultaXDocumentos frm = new FrmConsultaXDocumentos();
				frm.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(243, 88, 167, 23);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("ADICIONAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) tblInspeccion.getModel();
				int codigo=Integer.parseInt(txtCodigoDoc.getText());
				for (int i = 0; i < tblInspeccion.getRowCount(); i++) {
					if (codigo == Integer.parseInt(tblInspeccion.getValueAt(i, 0).toString())) {
						mensaje("Código existe");
						return;
					}
				}
				
				Object row[]={txtCodigoDoc.getText(),txtEntidad.getText(),
						txtFInspeccion.getText(),txtInsp.getText(),
						txtDireccion.getText()};
				model.addRow(row);
			}
			
		});
		btnNewButton_2.setBounds(449, 88, 114, 23);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 368, 678, 142);
		contentPane.add(scrollPane);
		
		tblInspeccion = new JTable();
		tblInspeccion.setFillsViewportHeight(true);
		tblInspeccion.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Entidad", "Fecha de Inspeccion", "Nombre de Inspector", "Direccion"
			}
		));
		tblInspeccion.getColumnModel().getColumn(1).setPreferredWidth(131);
		tblInspeccion.getColumnModel().getColumn(2).setPreferredWidth(140);
		tblInspeccion.getColumnModel().getColumn(3).setPreferredWidth(145);
		tblInspeccion.getColumnModel().getColumn(4).setPreferredWidth(128);
		scrollPane.setViewportView(tblInspeccion);
	}
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
	}
}
