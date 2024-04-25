package mensajeria.vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import mensajeria.controlador.AltaEnvioControlador;
import mensajeria.controlador.AltaEnvioControladorInterfaz;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JButton;

public class AltaEnvioVista extends JPanel{

	private JTextField textFieldFecha;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	private JTextField textFieldPrecio;
	private JTextField textFieldPeso;
	private JTextField textFieldPrecioKilo;
	
	
	private JRadioButton paqueteRadioButton;
	private JRadioButton cartaRadioButton;
	
	public AltaEnvioVista() {
		setLayout(null);
		
		JLabel labelFecha = new JLabel("Fecha:");
		labelFecha.setBounds(43, 30, 61, 16);
		add(labelFecha);
		
		JLabel labelOrigen = new JLabel("Origen:");
		labelOrigen.setBounds(43, 60, 61, 16);
		add(labelOrigen);
		
		JLabel detinoNewLabel = new JLabel("Destino:");
		detinoNewLabel.setBounds(43, 90, 61, 16);
		add(detinoNewLabel);
	
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(116, 30, 200, 25);
		add(textFieldFecha);
	//	textFieldFecha.setColumns(10);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setBounds(116, 60, 200, 25);
		add(textFieldOrigen);
	//	textFieldOrigen.setColumns(10);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(116, 90, 200, 25);
		add(textFieldDestino);
	//	textFieldDestino.setColumns(10);
		
		JRadioButton cartaRadioButton = new JRadioButton("Carta");
		cartaRadioButton.setBounds(43, 110, 87, 42);
		add(cartaRadioButton);
		cartaRadioButton.setSelected(true);
		
		JRadioButton paqueteRadioButton = new JRadioButton("Paquete");
		paqueteRadioButton.setBounds(152, 114, 87, 34);
		add(paqueteRadioButton);
		
		JLabel precioLabel = new JLabel("Precio:");
		precioLabel.setBounds(43, 160, 61, 16);
		add(precioLabel);
		textFieldPrecio= new JTextField();
		textFieldPrecio.setBounds(116, 160, 200, 25);
		add(textFieldPrecio);
		
		JLabel pesoLabel = new JLabel("Peso(Kg):");
		pesoLabel.setBounds(43, 190, 61, 16);
		add(pesoLabel);
		
		textFieldPeso= new JTextField();
		textFieldPeso.setBounds(116, 190, 200, 25);
		add(textFieldPeso);
		textFieldPeso.setEnabled(false);
		textFieldPeso.setBackground(Color.gray);


		JLabel precioKiloLabel = new JLabel("Precio.K:");
		precioKiloLabel.setBounds(43, 220, 61, 16);
		add(precioKiloLabel);

		textFieldPrecioKilo= new JTextField();
		textFieldPrecioKilo.setBounds(116,220, 200, 25);
		add(textFieldPrecioKilo);
		textFieldPrecioKilo.setEnabled(false);
		textFieldPrecioKilo.setBackground(Color.gray);
		

	
		cartaRadioButton.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (cartaRadioButton.isSelected()==true) {
					System.out.println("Carta selected");
					paqueteRadioButton.setSelected(false);
					textFieldPrecio.setEnabled(true);
					textFieldPrecio.setBackground(Color.white);
					textFieldPeso.setEnabled(false);
					textFieldPeso.setBackground(Color.gray);
					textFieldPrecioKilo.setEnabled(false);
					textFieldPrecioKilo.setBackground(Color.gray);
					
				}
				//else 
				//	paqueteRadioButton.setSelected(true);
			}
			
		});

		
		paqueteRadioButton.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if (paqueteRadioButton.isSelected()==true) {
					cartaRadioButton.setSelected(false);
					textFieldPrecio.setEnabled(false);
					textFieldPrecio.setBackground(Color.gray);
					textFieldPeso.setEnabled(true);
					textFieldPeso.setBackground(Color.WHITE);
					textFieldPrecioKilo.setEnabled(true);
					textFieldPrecioKilo.setBackground(Color.WHITE);
				}
			}
			
		});

		JButton altaButton = new JButton("Alta");
		altaButton.setBounds(152, 257, 117, 29);
		add(altaButton);
		
		altaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Alta Envio");
				AltaEnvioControladorInterfaz controlador=
						new AltaEnvioControlador();
				String fecha=textFieldFecha.getText();
				String origen=textFieldOrigen.getText();
				String destino=textFieldDestino.getText();
				try {
					if (cartaRadioButton.isSelected()) {
						double precio=Double.parseDouble(textFieldPrecio.getText());
						if (controlador.altaCarta(fecha, origen, destino, precio)) {
							JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(altaButton),"Alta correcta");
						}
						else {
							JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(altaButton),"Error interno");							
						}
					}
					else {
						double peso=Double.parseDouble(textFieldPeso.getText());
						double precioKilo=Double.parseDouble(textFieldPrecioKilo.getText());
						if (controlador.altaPaquete(fecha, origen, destino, peso, precioKilo)) {
							JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(altaButton),"Alta correcta");
						}
						else {
							JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(altaButton),"Error interno");
						}
					}
				} catch (NumberFormatException ne) {
					System.out.println("Formato incorrecto");
					JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(altaButton),"Formato incorrecto");

				}
			}
			
		} );

		
	}
}
