package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.MySqlAsignacion;
import Controladores.MySqlInspectoresDAO;
import entidades.Asignacion;
import entidades.Inspectores;
import interfaces.AsignacionDAO;
import utils.MySQLCONEXION;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAsignacionEntidades extends JFrame {
	
	MySqlAsignacion AsignacionDao = new MySqlAsignacion();

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTextField txtFecha;
	private JLabel lblNewLabel_2;
	private JTextField txtDocumento;
	private JLabel lblNewLabel_3;
	private JTable table;
	private JLabel lblNewLabel_4;
	private JComboBox cboInspector_1;
	private JComboBox cboResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAsignacionEntidades frame = new FrmAsignacionEntidades();
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
	public FrmAsignacionEntidades() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setTitle("Asignacion de Entidades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("F.Asignacion");
		lblNewLabel_1.setBounds(227, 36, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(306, 33, 112, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Documento");
		lblNewLabel_2.setBounds(20, 67, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(88, 64, 112, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Inspector");
		lblNewLabel_3.setBounds(20, 36, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		cboInspector_1 = new JComboBox();
		cboInspector_1.setBounds(88, 32, 112, 22);
		contentPane.add(cboInspector_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 106, 548, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Asig", "Documento", "Fecha Asignacion", "Nombre Inspector", "Resultado"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(142);
		table.getColumnModel().getColumn(2).setPreferredWidth(137);
		table.getColumnModel().getColumn(3).setPreferredWidth(133);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("PROCESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Doc,fec;
				int codIns;
				int codRes;
				Doc=txtDocumento.getText().trim();
				fec=txtFecha.getText().trim();
				codIns=cboInspector_1.getSelectedIndex()+1;
				codRes=cboResultado.getSelectedIndex()+1;
				if(Doc.equals("")) {
					mensaje("Campo Documento es obligatorio");
					txtDocumento.requestFocus();
				}
				else if(fec.matches("")) {
					mensaje("Campo fecha inicial incorrecto");
					txtFecha.requestFocus();
				}
				else {
					Asignacion Reg=new Asignacion();
					Reg.setDocAsignacion(Doc);
					Reg.setFechAsignacion(fec);
					Reg.setCodInspector(codIns);
					Reg.setCodResultado(codRes);
					int resu=AsignacionDao.save(Reg);
					if(resu>0) {
						mensaje("Registro de caja registrado");
						listado();
					}
					else
						mensaje("Error en el registro");
				}
			}
		});
		btnNewButton.setBounds(450, 32, 106, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_4 = new JLabel("Resultado");
		lblNewLabel_4.setBounds(227, 67, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		cboResultado = new JComboBox();
		cboResultado.setModel(new DefaultComboBoxModel(new String[] {"Aprobado", "Desaprobado"}));
		cboResultado.setBounds(306, 63, 112, 22);
		contentPane.add(cboResultado);
		
		CargarInspectores();
		listado();
	}
	private void CargarInspectores() {
		MySqlAsignacion AsignacionIns = new MySqlAsignacion();
		List<Inspectores> Inspector = AsignacionIns.getListInsp();
		
		for(Inspectores Inspectores:Inspector) {
			cboInspector_1.addItem(Inspectores.getNombreIns());
		}
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);	
}
	void listado() {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Asignacion> lista=AsignacionDao.findAll();
		for(Asignacion Asig:lista) {
			Object row[]= {Asig.getCodAsignacion(),Asig.getDocAsignacion(), Asig.getFechAsignacion(),Asig.getNomInspector(),Asig.getNomResultado()};
			model.addRow(row);
		}
	}
}
