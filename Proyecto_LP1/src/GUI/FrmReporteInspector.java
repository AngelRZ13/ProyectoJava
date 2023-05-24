package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.MySqlInspectoresDAO;
import entidades.Inspectores;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.ReporteGenerador;

public class FrmReporteInspector extends JFrame {

	private JPanel contentPane;
	private JPanel PanelInspector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteInspector frame = new FrmReporteInspector();
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
	public FrmReporteInspector() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelInspector = new JPanel();
		PanelInspector.setBounds(10, 24, 554, 464);
		contentPane.add(PanelInspector);
		mostrar();
	}
	void mostrar(){
		try {
			ArrayList<Inspectores> data=new MySqlInspectoresDAO().listAll();
			JRBeanCollectionDataSource datos=new JRBeanCollectionDataSource(data);
			JasperPrint pdf=ReporteGenerador.genera("Inspectores.jasper", datos, null);
			PanelInspector.setLayout(new BorderLayout(0, 0));
			JRViewer visor=new JRViewer(pdf);
			PanelInspector.add(visor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
