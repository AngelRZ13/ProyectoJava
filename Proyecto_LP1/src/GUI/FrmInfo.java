package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class FrmInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInfo frame = new FrmInfo();
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
	public FrmInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnResolucinDeSuperintendente = new JTextPane();
		txtpnResolucinDeSuperintendente.setEditable(false);
		txtpnResolucinDeSuperintendente.setText("Resoluci\u00F3n de Superintendente N\u00BA 026-2021-SMV/02\r\nEl usuario o responsable del monitoreo de la plataforma de TI reporta un incidente\r\nEl Jefe de Inspecci\u00F3n TR coordina con el Equipo de Inspecci\u00F3n TR la distribuci\u00F3n de la tem\u00E1tica de b\u00FAsqueda de la informaci\u00F3n y documentaci\u00F3n interna de la entidad supervisada a trav\u00E9s de los aplicativos de la SMV, u otras fuentes y proceden a consolidar la informaci\u00F3n y documentaci\u00F3n recopilada para la inspecci\u00F3n. Se prosigue con la actividad \r\nLa entidad supervisada env\u00EDa, por el medio de transmisi\u00F3n acordado, la informaci\u00F3n y documentaci\u00F3n general solicitada. Se prosigue con la actividad \r\nEl Equipo de Inspecci\u00F3n TR revisa y eval\u00FAa la informaci\u00F3n y documentaci\u00F3n general remitida por la entidad supervisada y la informaci\u00F3n y documentaci\u00F3n interna, se\u00F1aladas en los dos numerales precedentes para luego registrar el resultado por cada atributo considerado, seg\u00FAn el programa establecido para la etapa de planeamiento en el sistema TeamMate. \r\nEl Equipo de Inspecci\u00F3n TR prepara el memor\u00E1ndum de requerimiento de la informaci\u00F3n y documentaci\u00F3n espec\u00EDfica, de acuerdo, principalmente, con los objetivos de inspecci\u00F3n predefinidos, seg\u00FAn el tipo de riesgo identificado en la matriz de riesgos, cuyo detalle est\u00E1 contenido en un Resumen Ejecutivo por entidad, seg\u00FAn el tipo de industria. De ser el caso, se incorpora aquella informaci\u00F3n y documentaci\u00F3n general que se encuentra pendiente de entrega, para lo cual se tendr\u00E1 en cuenta que dicho plazo ser\u00E1 con un m\u00EDnimo de dos (02) d\u00EDas antes que se inicie la etapa de ejecuci\u00F3n y se le remite por correo electr\u00F3nico a la entidad supervisada. \r\nLa entidad supervisada env\u00EDa, por el medio de transmisi\u00F3n acordado, la informaci\u00F3n y documentaci\u00F3n especifica solicitada en el punto precedente.\r\nEl documento ser\u00E1 APROBADO cuando la problem\u00E1tica este en el rango menor a 1 falta grave\r\nEl documento ser\u00E1 DESAPROBADO si las faltas son graves a mas");
		txtpnResolucinDeSuperintendente.setBounds(10, 11, 688, 456);
		contentPane.add(txtpnResolucinDeSuperintendente);
	}
}
