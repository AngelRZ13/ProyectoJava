package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Controladores.MySqlInspectoresDAO;
import entidades.Inspectores;
import interfaces.InpectoresDAO;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmInspectores extends JFrame {
	
	MySqlInspectoresDAO InpectoresDAO = new MySqlInspectoresDAO();

	private JPanel contentPane;
	private JTextField txtNomIns;
	private JTextField txtTelInsp;
	private JTextField txtCodigoIns;
	private JTextField txtApeIns;
	private JTextField txtFechIns;
	private JTable tblInspectores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInspectores frame = new FrmInspectores();
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
	public FrmInspectores() {
		setTitle("MANTENIMIENTO INSPECTORES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo de Inspecctor");
		lblNewLabel.setBounds(20, 11, 141, 14);
		contentPane.add(lblNewLabel);
		
		txtNomIns = new JTextField();
		txtNomIns.setBounds(20, 66, 141, 20);
		contentPane.add(txtNomIns);
		txtNomIns.setColumns(10);
		
		txtTelInsp = new JTextField();
		txtTelInsp.setColumns(10);
		txtTelInsp.setBounds(236, 46, 141, 20);
		contentPane.add(txtTelInsp);
		
		txtCodigoIns = new JTextField();
		txtCodigoIns.setEditable(false);
		txtCodigoIns.setColumns(10);
		txtCodigoIns.setBounds(20, 25, 141, 20);
		contentPane.add(txtCodigoIns);
		
		txtApeIns = new JTextField();
		txtApeIns.setColumns(10);
		txtApeIns.setBounds(20, 107, 141, 20);
		contentPane.add(txtApeIns);
		
		txtFechIns = new JTextField();
		txtFechIns.setColumns(10);
		txtFechIns.setBounds(236, 92, 141, 20);
		contentPane.add(txtFechIns);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nombre,Apellido,telefono,FechIns;
				Nombre=txtNomIns.getText().trim();
				telefono=txtTelInsp.getText().trim();
				Apellido=txtApeIns.getText().trim();
				FechIns=txtFechIns.getText().trim();
				if(Nombre.equals("")) {
					mensaje("Campo nombre es obligatorio");
					txtNomIns.requestFocus();
				}
				else if(telefono.matches("")) {
					mensaje("Campo telefono incorrecto");
					txtTelInsp.requestFocus();
				}
				else if(Apellido.equals("")) {
					mensaje("Campo Apellido es obligatorio");
					txtApeIns.requestFocus();
				}
				else if(FechIns.equals("")) {
					mensaje("Campo fecha es obligatorio");
					txtFechIns.requestFocus();
				}
				else {
					Inspectores Ins=new Inspectores();
					Ins.setNombreIns(Nombre);
					Ins.setTelefonoIns(Integer.parseInt(telefono));
					Ins.setApellidoIns(Apellido);
					Ins.setFecha(FechIns);
					int resu=InpectoresDAO.save(Ins);
					if(resu>0) {
						mensaje("Inspector Registrado");
						listado();
					}
					else
						mensaje("Error en el Registro");
				}
			}
		});
		btnRegistrar.setBounds(426, 45, 106, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo;
				String Nombre,Apellido,telefono,FechIns;
				codigo=Integer.parseInt(txtCodigoIns.getText());
				Nombre=txtNomIns.getText().trim();
				telefono=txtTelInsp.getText().trim();
				Apellido=txtApeIns.getText().trim();
				FechIns=txtFechIns.getText().trim();
				if(Nombre.equals("")) {
					mensaje("Campo nombre es obligatorio");
					txtNomIns.requestFocus();
				}
				else if(telefono.matches("")) {
					mensaje("Campo telefono incorrecto");
					txtTelInsp.requestFocus();
				}
				else if(Apellido.equals("")) {
					mensaje("Campo Apellido es obligatorio");
					txtApeIns.requestFocus();
				}
				else if(FechIns.equals("")) {
					mensaje("Campo fecha es obligatorio");
					txtFechIns.requestFocus();
				}
				else {
					Inspectores Ins=new Inspectores();
					
					Ins.setCodigo(codigo);
					Ins.setNombreIns(Nombre);
					Ins.setTelefonoIns(Integer.parseInt(telefono));
					Ins.setApellidoIns(Apellido);
					Ins.setFecha(FechIns);
					int resu=InpectoresDAO.update(Ins);
					if(resu>0) {
						mensaje("Inspector Actualizado");
						listado();
					}
					else
						mensaje("Error en la Actualizacion");
				}
			}
		});
		btnActualizar.setBounds(426, 77, 106, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int boton;
				boton=JOptionPane.showConfirmDialog(null,"Seguro de eliminar?","Sistema",JOptionPane.YES_NO_OPTION);
				if(boton==0) {
					int resu=InpectoresDAO.delete(Integer.parseInt((txtCodigoIns.getText())));
					if(resu>0) {
						mensaje("Entidad eliminado");
						listado();
					}
					else
						mensaje("Error en la eliminación");
				}
			}
		});
		
		btnEliminar.setBounds(426, 106, 106, 23);
		contentPane.add(btnEliminar);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Inspecctor");
		lblNewLabel_1.setBounds(20, 49, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido de Inpector");
		lblNewLabel_2.setBounds(20, 92, 151, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("telefono ");
		lblNewLabel_3.setBounds(236, 28, 75, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Inspeccion");
		lblNewLabel_4.setBounds(236, 72, 129, 14);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 137, 523, 168);
		contentPane.add(scrollPane);
		
		tblInspectores = new JTable();
		tblInspectores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == tblInspectores) {
					mouseClickedTbInspectores(e);
				}
			}
			private void mouseClickedTbInspectores(MouseEvent e) {
				Seleccionar();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		tblInspectores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getSource() == tblInspectores) {
					keyReleasedTbInspectores(e);
				}
			}
			private void keyReleasedTbInspectores(KeyEvent e) {

				Seleccionar();
				}
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		tblInspectores.setFillsViewportHeight(true);
		tblInspectores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "nombre", "Apellido", "Telefono", "Fecha_Inspeccion"
			}
		));
		scrollPane.setViewportView(tblInspectores);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar();
			}
		});
		btnLimpiar.setBounds(426, 7, 106, 23);
		contentPane.add(btnLimpiar);
		listado();
	}
	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	
		
}
	void listado() {
		DefaultTableModel model=(DefaultTableModel) tblInspectores.getModel();
		model.setRowCount(0);
		ArrayList<Inspectores> lista=InpectoresDAO.findAll();
		for(Inspectores Ins:lista) {
			Object row[]= {Ins.getCodigo(),Ins.getNombreIns(),Ins.getApellidoIns(),Ins.getTelefonoIns(),Ins.getFecha()};
			model.addRow(row);
		}
	}
	void Seleccionar() {
		int posFila;
		String cod, nom, ape, tel, fech;
		
		posFila=tblInspectores.getSelectedRow();
		
		cod=tblInspectores.getValueAt(posFila, 0).toString();
		nom=tblInspectores.getValueAt(posFila, 1).toString();
		ape=tblInspectores.getValueAt(posFila, 2).toString();
		tel=tblInspectores.getValueAt(posFila, 3).toString();
		fech=tblInspectores.getValueAt(posFila, 4).toString();
		
		txtCodigoIns.setText(cod);
		txtNomIns.setText(nom);
		txtApeIns.setText(ape);
		txtTelInsp.setText(tel);
		txtFechIns.setText(fech);
	}
	void Limpiar() {
		txtCodigoIns.setText("");
		txtNomIns.setText("");
		txtApeIns.setText("");
		txtTelInsp.setText("");
		txtFechIns.setText("");
	}
}
