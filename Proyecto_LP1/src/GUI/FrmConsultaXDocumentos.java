package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controladores.MySqlAsignacion;
import Controladores.MySqlEntidadesDAO;
import entidades.Asignacion;
import entidades.Entidades;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConsultaXDocumentos extends JFrame {

	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTable tblDocumento;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaXDocumentos frame = new FrmConsultaXDocumentos();
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
	public FrmConsultaXDocumentos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 621, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDocumento = new JTextField();
		txtDocumento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getSource() == txtDocumento) {
					keyReleasedTxtDocumento(e);
				}
			}
			private void keyReleasedTxtDocumento(KeyEvent e) {
				listado(txtDocumento.getText());
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		txtDocumento.setBounds(121, 30, 296, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Documento");
		lblNewLabel.setBounds(10, 33, 101, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 585, 404);
		contentPane.add(scrollPane);
		
		tblDocumento = new JTable();
		tblDocumento.setFillsViewportHeight(true);
		tblDocumento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Documento", "Fecha de Asignacion", "Nombre de Inspector", "Resultado"
			}
		));
		tblDocumento.getColumnModel().getColumn(1).setPreferredWidth(136);
		tblDocumento.getColumnModel().getColumn(2).setPreferredWidth(128);
		tblDocumento.getColumnModel().getColumn(3).setPreferredWidth(154);
		tblDocumento.getColumnModel().getColumn(4).setPreferredWidth(126);
		scrollPane.setViewportView(tblDocumento);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int posFila=tblDocumento.getSelectedRow();
				String cod,doc,fec,ins,res;
				cod=tblDocumento.getValueAt(posFila, 0).toString();
				doc=tblDocumento.getValueAt(posFila, 1).toString();
				fec=tblDocumento.getValueAt(posFila, 2).toString();
				ins=tblDocumento.getValueAt(posFila, 3).toString();
				res=tblDocumento.getValueAt(posFila, 4).toString();
				FrmAsignacionFinal.txtCodigoDoc.setText(cod);
				FrmAsignacionFinal.txtDocumento.setText(doc);
				FrmAsignacionFinal.txtFecha.setText(fec);
				FrmAsignacionFinal.txtInsp.setText(ins);
				FrmAsignacionFinal.txtResultado.setText(res);
				dispose();
				
			}
		});
		btnNewButton.setBounds(476, 29, 89, 23);
		contentPane.add(btnNewButton);
		
	}
	
	void listado(String asg) {
		DefaultTableModel model=(DefaultTableModel) tblDocumento.getModel();
		model.setRowCount(0);
		ArrayList<Asignacion> data=new MySqlAsignacion().listAllByDocumento(asg);
		for(Asignacion en:data){
			Object row[]={en.getCodAsignacion(),en.getDocAsignacion(),en.getFechAsignacion(),
					en.getNomInspector(),en.getNomResultado()};
			model.addRow(row);
	}

}
}
