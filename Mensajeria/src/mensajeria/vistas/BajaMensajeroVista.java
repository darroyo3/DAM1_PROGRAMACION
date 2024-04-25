package mensajeria.vistas;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mensajeria.controlador.BajaMensajeroControlador;
import mensajeria.controlador.BajaMensajeroControladorInterfaz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BajaMensajeroVista extends JPanel {
	private JTextField nombretextField;

	/**
	 * Create the panel.
	 */
	public BajaMensajeroVista() {
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreLabel.setBounds(21, 21, 100, 33);
		add(nombreLabel);
		
		nombretextField = new JTextField();
		nombretextField.setBounds(118, 27, 176, 25);
		add(nombretextField);
		nombretextField.setColumns(10);
		
		JButton buscarButton = new JButton("Buscar");
		buscarButton.setBounds(140, 64, 117, 25);
		add(buscarButton);
		System.out.println("Baja mensajero");
		buscarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Boton buscar");
				BajaMensajeroControladorInterfaz controlador=new BajaMensajeroControlador();
				int codigo=controlador.existeMensajero(nombretextField.getText());
				if (codigo==-1) {
					System.out.println("Mensajero no encontrado.");
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(buscarButton),"Mensajero no encontrado");
				}
				else {
					System.out.println("Mensajero encontrado con codigo. "+codigo );
					int n = JOptionPane.showConfirmDialog(JOptionPane.getFrameForComponent(buscarButton), "¿Desea borrar el mensajero con codigo "+codigo+" ?", "Eliminar mensajero", JOptionPane.YES_NO_OPTION);
					if (n==0) {
						controlador.elimnarMensajero(codigo);
						nombretextField.setText("");
					}
				}
			}
			
		});
	}
}
