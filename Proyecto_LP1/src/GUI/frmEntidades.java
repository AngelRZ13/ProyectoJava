package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controladores.MySqlEntidadesDAO;
import entidades.Entidades;
import interfaces.EntidadesDao;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;

public class frmEntidades extends JFrame {
	
	MySqlEntidadesDAO EntidadesDao = new MySqlEntidadesDAO();

	private JPanel contentPane;
	private JTable tblEntidades;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JComboBox cboCategoria;
	private JTextField txtCodigo;
	private JComboBox cboCategoria_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEntidades frame = new frmEntidades();
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
	public frmEntidades() {
		setTitle("MENTENIMINETO DE ENTIDADES SUPERVISADAS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO DE ENTIDADES");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 0, 528, 42);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		scrollPane.setBounds(36, 171, 505, 184);
		contentPane.add(scrollPane);
		
		tblEntidades = new JTable();
		tblEntidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == tblEntidades) {
					mouseClickedTbEntidades(e);
				}
			}
			private void mouseClickedTbEntidades(MouseEvent e) {
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
		tblEntidades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getSource() == tblEntidades) {
					keyReleasedTbEntidades(e);
				}
			}
			private void keyReleasedTbEntidades(KeyEvent e) {
				Seleccionar();
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		tblEntidades.setFillsViewportHeight(true);
		tblEntidades.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Direccion", "Telefono", "Categoria"
			}
		));
		tblEntidades.getColumnModel().getColumn(1).setPreferredWidth(134);
		tblEntidades.getColumnModel().getColumn(2).setPreferredWidth(169);
		tblEntidades.getColumnModel().getColumn(3).setPreferredWidth(112);
		tblEntidades.getColumnModel().getColumn(4).setPreferredWidth(107);
		scrollPane.setViewportView(tblEntidades);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de Entidad");
		lblNewLabel_1.setBounds(36, 87, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(36, 107, 167, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setBounds(36, 125, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(36, 140, 167, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(246, 70, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(246, 84, 162, 20);
		contentPane.add(txtTelefono);
		
		JLabel lblNewLabel_4 = new JLabel("Categoria");
		lblNewLabel_4.setBounds(246, 125, 79, 14);
		contentPane.add(lblNewLabel_4);
		
		cboCategoria_1 = new JComboBox();
		cboCategoria_1.setModel(new DefaultComboBoxModel(new String[] {"BANCO", "CONSORCIO", "INMOBILIARIA", "SOCIEDAD"}));
		cboCategoria_1.setBounds(246, 139, 162, 22);
		contentPane.add(cboCategoria_1);
		
		
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nombre,telefono,direccion;
				int codEnt;
				Nombre=txtNombre.getText().trim();
				telefono=txtTelefono.getText().trim();
				direccion=txtDireccion.getText().trim();
				codEnt=cboCategoria_1.getSelectedIndex()+1;
				if(Nombre.equals("")) {
					mensaje("Campo nombre es obligatorio");
					txtNombre.requestFocus();
				}
				else if(telefono.matches("")) {
					mensaje("Campo telefono incorrecto");
					txtTelefono.requestFocus();
				}
				else if(direccion.equals("")) {
					mensaje("Campo direccion es obligatorio");
					txtDireccion.requestFocus();
				}
				else {
					Entidades Ent=new Entidades();
					Ent.setNombre(Nombre);
					Ent.setTelefono(Integer.parseInt(telefono));
					Ent.setDireccion(direccion);
					Ent.setcodCategoria(codEnt);
					int resu=EntidadesDao.save(Ent);
					if(resu>0) {
						mensaje("Entidad registrada");
						listado();
					}
					else
						mensaje("Error en el registro");
				}
			}
			
		});
		
		btnRegistrar.setBounds(439, 78, 102, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cod;
				String Nombre,telefono,direccion;
				int codEnt;
				cod = Integer.parseInt(txtCodigo.getText());
				Nombre=txtNombre.getText().trim();
				telefono=txtTelefono.getText().trim();
				direccion=txtDireccion.getText().trim();
				codEnt=cboCategoria_1.getSelectedIndex()+1;
				if(Nombre.equals("")) {
					mensaje("Campo nombre es obligatorio");
					txtNombre.requestFocus();
				}
				else if(telefono.matches("")) {
					mensaje("Campo telefono incorrecto");
					txtTelefono.requestFocus();
				}
				else if(direccion.equals("")) {
					mensaje("Campo direccion es obligatorio");
					txtDireccion.requestFocus();
				}
				else {
					Entidades Ent=new Entidades();
					Ent.setCodigo(cod);
					Ent.setNombre(Nombre);
					Ent.setTelefono(Integer.parseInt(telefono));
					Ent.setDireccion(direccion);
					Ent.setcodCategoria(codEnt);
					int resu=EntidadesDao.update(Ent);
					if(resu>0) {
						mensaje("Libro Actualizado");
						listado();
					}
					else
						mensaje("Error en la Actualizacion");
				}
			}
		});
		btnActualizar.setBounds(439, 106, 102, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int boton;
				boton=JOptionPane.showConfirmDialog(null,"Seguro de eliminar?","Sistema",JOptionPane.YES_NO_OPTION);
				if(boton==0) {
					int resu=EntidadesDao.delete(Integer.parseInt((txtCodigo.getText())));
					if(resu>0) {
						mensaje("Entidad eliminado");
						listado();
					}
					else
						mensaje("Error en la eliminación");
				}	
			}
		});
		btnEliminar.setBounds(439, 139, 102, 23);
		contentPane.add(btnEliminar);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(32, 64, 171, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Codigo");
		lblNewLabel_5.setBounds(36, 51, 79, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar();
				
			}
		});
		btnLimpiar.setBounds(439, 47, 102, 23);
		contentPane.add(btnLimpiar);
		listado();
	}
		
		void mensaje(String m) {
			JOptionPane.showMessageDialog(null, m);
		
			
	}
		void listado() {
			DefaultTableModel model=(DefaultTableModel) tblEntidades.getModel();
			model.setRowCount(0);
			ArrayList<Entidades> lista=EntidadesDao.findAll();
			for(Entidades Ent:lista) {
				Object row[]= {Ent.getCodigo(),Ent.getNombre(),Ent.getDireccion(),Ent.getTelefono(),Ent.getNomCategoria()};
				model.addRow(row);
			}
		}
		void Seleccionar(){
			int posFila;
			String cod, nom, direc, tel, nomCat;
			
			posFila=tblEntidades.getSelectedRow();
			
			cod=tblEntidades.getValueAt(posFila, 0).toString();
			nom=tblEntidades.getValueAt(posFila, 1).toString();
			direc=tblEntidades.getValueAt(posFila, 2).toString();
			tel=tblEntidades.getValueAt(posFila, 3).toString();
			nomCat=tblEntidades.getValueAt(posFila, 4).toString();
			
			txtCodigo.setText(cod);
			txtNombre.setText(nom);
			txtDireccion.setText(direc);
			txtTelefono.setText(tel);
			cboCategoria_1.setSelectedItem(nomCat);
			
		}
		void Limpiar() {
			txtCodigo.setText("");
			txtNombre.setText("");
			txtDireccion.setText("");
			txtTelefono.setText("");

		}
		}
