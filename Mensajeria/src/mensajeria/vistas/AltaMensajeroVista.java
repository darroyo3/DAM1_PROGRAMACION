package mensajeria.vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mensajeria.controlador.AltaMensajeroControlador;
import mensajeria.controlador.AltaMensajeroControladorInterfaz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AltaMensajeroVista extends JPanel {
	private JTextField nombreMenTextField;
	private JTextField sueldoTextField;
	private JTextField numMaxTextField;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AltaMensajeroVista() {
		setLayout(null);
		
		JLabel lblAltaMensajero = new JLabel("ALTA MENSAJERO");
		lblAltaMensajero.setFont(new Font("Dialog", Font.BOLD, 18));
		lblAltaMensajero.setBounds(123, 12, 232, 34);
		add(lblAltaMensajero);
		System.out.println("Alta mensajero");
		
		JLabel nombreMensajeroLabel = new JLabel("Nombre:");
		nombreMensajeroLabel.setVerticalAlignment(SwingConstants.TOP);
		nombreMensajeroLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreMensajeroLabel.setBounds(73, 61, 60, 17);
		add(nombreMensajeroLabel);
		
		nombreMenTextField = new JTextField();
		nombreMenTextField.setBounds(201, 57, 114, 19);
		add(nombreMenTextField);
		nombreMenTextField.setColumns(10);
		
		
		JLabel sueldoMensajeroLabel = new JLabel("Sueldo:");
		sueldoMensajeroLabel.setVerticalAlignment(SwingConstants.TOP);
		sueldoMensajeroLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		sueldoMensajeroLabel.setBounds(73, 93, 60, 17);
		add(sueldoMensajeroLabel);
		
		sueldoTextField = new JTextField();
		sueldoTextField.setColumns(10);
		sueldoTextField.setBounds(201, 89, 114, 19);
		add(sueldoTextField);
		
		JLabel numMaxEnviosMensajeroLabel = new JLabel("Max. envios:");
		numMaxEnviosMensajeroLabel.setVerticalAlignment(SwingConstants.TOP);
		numMaxEnviosMensajeroLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		numMaxEnviosMensajeroLabel.setBounds(73, 122, 110, 17);
		add(numMaxEnviosMensajeroLabel);
		
		numMaxTextField = new JTextField();
		numMaxTextField.setColumns(10);
		numMaxTextField.setBounds(201, 120, 114, 19);
		add(numMaxTextField);
		
		JButton altaButton = new JButton("Alta");
		altaButton.setBounds(166, 186, 117, 25);
		add(altaButton);
		altaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AltaMensajeroControladorInterfaz controlador=new AltaMensajeroControlador();
					String nombre=nombreMenTextField.getText();
					double sueldo=Double.parseDouble(sueldoTextField.getText());
					int numMaxEnvios=Integer.parseInt(numMaxTextField.getText());
					controlador.altaMensajero(nombre, sueldo, numMaxEnvios);
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(altaButton),"Alta correcta");
					limpiarEditText();
				} catch(NumberFormatException ex) {
					System.out.println("Formato incorrecto");
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(altaButton),"Formato incorrecto");
				}
			}
			
		});

	}
	
	private void limpiarEditText() {
		nombreMenTextField.setText("");
		sueldoTextField.setText("");
		numMaxTextField.setText("");
	}
}
