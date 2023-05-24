package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.MySqlEntidadesDAO;
import Controladores.MySqlInspectoresDAO;
import entidades.Entidades;
import entidades.Inspectores;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.ReporteGenerador;

public class FrmReporteEntidades extends JFrame {

	private JPanel contentPane;
	private JPanel panelEntidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteEntidades frame = new FrmReporteEntidades();
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
	public FrmReporteEntidades() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelEntidad = new JPanel();
		panelEntidad.setBounds(10, 11, 571, 429);
		contentPane.add(panelEntidad);
		mostrar();
	}
	void mostrar(){
		try {
			ArrayList<Entidades> data=new MySqlEntidadesDAO().listAll();
			JRBeanCollectionDataSource datos=new JRBeanCollectionDataSource(data);
			JasperPrint pdf=ReporteGenerador.genera("ReporteEntidad.jasper", datos, null);
			panelEntidad.setLayout(new BorderLayout(0, 0));
			JRViewer visor=new JRViewer(pdf);
			panelEntidad.add(visor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
