package mensajeria.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mensajeria.controlador.AsignarEnvioControlador;
import mensajeria.controlador.AsignarEnvioControladorInterfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AsignarEnvioVista extends JPanel {
	private JTextField codigoEtextField;
	private JTextField codigoMtextField;

	/**
	 * Create the panel.
	 */
	public AsignarEnvioVista() {
		setLayout(null);
		
		JLabel codigoELabel = new JLabel("Codigo Envio:");
		codigoELabel.setBounds(36, 48, 90, 20);
		add(codigoELabel);
		
		codigoEtextField = new JTextField();
		codigoEtextField.setBounds(152, 48, 100, 20);
		add(codigoEtextField);
		codigoEtextField.setColumns(10);
		
		JLabel codigoMLabel = new JLabel("Codigo Mensajero:");
		codigoMLabel.setBounds(36, 82, 100, 14);
		add(codigoMLabel);
		
		codigoMtextField = new JTextField();
		codigoMtextField.setBounds(152, 79, 100, 20);
		add(codigoMtextField);
		codigoMtextField.setColumns(10);
		
		JLabel tituloLabel = new JLabel("ASIGNAR ENVIO");
		tituloLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		tituloLabel.setBounds(106, 11, 185, 21);
		add(tituloLabel);
		
		JButton asignarButton = new JButton("Asignar");
		asignarButton.setBounds(147, 128, 89, 23);
		add(asignarButton);
		asignarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int codigoE=Integer.parseInt(codigoEtextField.getText());
					int codigoM=Integer.parseInt(codigoMtextField.getText());
					AsignarEnvioControladorInterfaz asignarEnvioControlador=
							new AsignarEnvioControlador();
					if (!asignarEnvioControlador.comprobarEnvioEnEntrega(codigoE)) {
						throw new EnvioException("El envio no está en espera");
					}
					if (!asignarEnvioControlador.comprobarMensajeroLibre(codigoM)) {
						throw new MensajeroException("El mensajero no esta libre");
					}
					asignarEnvioControlador.asignarEnvio(codigoE, codigoM);
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(asignarButton),"Asignacion correcta");
				} catch (NumberFormatException ne) {
					System.out.println("Formato incorrecto");
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(asignarButton),"Formato incorrecto");
				} catch (MensajeroException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(asignarButton),"El mensajero no esta libre");

				} catch (EnvioException e2) {
					// TODO Auto-generated catch block
					System.out.println(e2.getMessage());
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(asignarButton),"Envio no encontrado");

				}
			}
		});

	}
}
