package mensajeria.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import mensajeria.controlador.AsignarEnvioControlador;
import mensajeria.controlador.AsignarEnvioControladorInterfaz;
import mensajeria.controlador.EntregaEnvioControlador;
import mensajeria.controlador.EntregaEnvioControladorInterfaz;

import javax.swing.JButton;

public class EntregaEnvioVista extends JPanel {
	private JTextField codigoEtextField;

	/**
	 * Create the panel.
	 */
	public EntregaEnvioVista() {
		setLayout(null);
		
		JLabel tituloLabel = new JLabel("ENTREGA ENVIO");
		tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		tituloLabel.setBounds(102, 11, 228, 42);
		add(tituloLabel);
		
		JLabel codioELabel = new JLabel("Codigo Envio:");
		codioELabel.setBounds(61, 69, 88, 14);
		add(codioELabel);
		
		codigoEtextField = new JTextField();
		codigoEtextField.setBounds(159, 66, 88, 20);
		add(codigoEtextField);
		codigoEtextField.setColumns(10);
		
		JButton entregarButton = new JButton("Entregar");
		entregarButton.setBounds(147, 115, 89, 23);
		add(entregarButton);
		
		entregarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int codigoE=Integer.parseInt(codigoEtextField.getText());
					EntregaEnvioControladorInterfaz entregaEnvioControlador=
							new EntregaEnvioControlador();
					if (!entregaEnvioControlador.comprobarEnvioAsignado(codigoE)) {
						throw new EnvioException("El envio no está asignado");
					}
					entregaEnvioControlador.entregaEnvio(codigoE);
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(entregarButton),"Entrega correcta");
				} catch (NumberFormatException ne) {
					System.out.println("Formato incorrecto");
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(entregarButton),"Formato incorrecto");
				} catch (EnvioException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(entregarButton),"Envio asignado no encontrado");
				} 
			}
		});	

	}
}
