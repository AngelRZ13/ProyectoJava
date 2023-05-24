package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controladores.MySqlEntidadesDAO;
import entidades.Entidades;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaEntidadesXcategoria extends JFrame {

	private JPanel contentPane;
	private JTable tblEntidades;
	private JTextField txtEntidad;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaEntidadesXcategoria frame = new FrmConsultaEntidadesXcategoria();
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
	public FrmConsultaEntidadesXcategoria() {
		setTitle("Buscar Entidades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entidad");
		lblNewLabel.setBounds(22, 37, 82, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 95, 596, 282);
		contentPane.add(scrollPane);
		
		tblEntidades = new JTable();
		tblEntidades.setFillsViewportHeight(true);
		tblEntidades.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Direcci\u00F3n", "Telefono", "Nombre de Categoria"
			}
		));
		tblEntidades.getColumnModel().getColumn(0).setPreferredWidth(76);
		tblEntidades.getColumnModel().getColumn(1).setPreferredWidth(146);
		tblEntidades.getColumnModel().getColumn(2).setPreferredWidth(117);
		tblEntidades.getColumnModel().getColumn(3).setPreferredWidth(139);
		tblEntidades.getColumnModel().getColumn(4).setPreferredWidth(144);
		scrollPane.setViewportView(tblEntidades);
		
		txtEntidad = new JTextField();
		txtEntidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getSource() == txtEntidad) {
					keyReleasedTxtEntidad(e);
				}
			}
			private void keyReleasedTxtEntidad(KeyEvent e) {
				listado(txtEntidad.getText());
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtEntidad.setBounds(98, 34, 336, 20);
		contentPane.add(txtEntidad);
		txtEntidad.setColumns(10);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posFila=tblEntidades.getSelectedRow();
				String cod, nom, dir, tel, nomCat;
				cod=tblEntidades.getValueAt(posFila ,0).toString();
				nom=tblEntidades.getValueAt(posFila ,1).toString();
				dir=tblEntidades.getValueAt(posFila ,2).toString();
				tel=tblEntidades.getValueAt(posFila ,3).toString();
				nomCat=tblEntidades.getValueAt(posFila ,4).toString();
				FrmAsignacionFinal.txtCodigo.setText(cod);
				FrmAsignacionFinal.txtEntidad.setText(nom);
				FrmAsignacionFinal.txtDireccion.setText(dir);
				FrmAsignacionFinal.txtTelefono.setText(tel);
				FrmAsignacionFinal.txtCategoria.setText(nomCat);
				dispose();
			}
		});
		btnNewButton.setBounds(467, 33, 89, 23);
		contentPane.add(btnNewButton);
		
	}
	void listado(String ent) {
		DefaultTableModel model=(DefaultTableModel) tblEntidades.getModel();
		model.setRowCount(0);
		ArrayList<Entidades> data=new MySqlEntidadesDAO().listAllByCategoria(ent);
		for(Entidades en:data){
			Object row[]={en.getCodigo(),en.getNombre(),en.getDireccion(),
					en.getTelefono(),en.getNomCategoria()};
			model.addRow(row);
	}
}
}