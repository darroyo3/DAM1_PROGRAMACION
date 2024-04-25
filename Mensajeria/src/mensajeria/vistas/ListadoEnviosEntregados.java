package mensajeria.vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import mensajeria.controlador.ListadoEnviosControlador;
import mensajeria.controlador.ListadoEnviosControladorInterfaz;

public class ListadoEnviosEntregados extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListadoEnviosEntregados() {
		setForeground(UIManager.getColor("Button.background"));
		setLayout(null);
	
		JLabel titulo = new JLabel("ENVIOS ENTREGADOS");
		titulo.setBounds(100, 5, 260, 22);
		titulo.setFont(new Font("Dialog", Font.BOLD, 18));
		add(titulo);
		
		ListadoEnviosControladorInterfaz controlador=
				new ListadoEnviosControlador();
		
		//Cartas
		JLabel cartasLabel = new JLabel("Cartas");
		cartasLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cartasLabel.setBounds(10, 36, 80, 14);
		add(cartasLabel);
		
		String[][] cartas= controlador.listadoCartasEntregado();		
		final String[] cabeceraTabla= {"Codigo","Fecha","Origen", 
				"Destino","Precio"};
	
		JTable tablaCartas=new JTable(cartas,cabeceraTabla) {
			// Se hacen las celdas no editables.
			public boolean isCellEditable(int row, int column) {
		            return false;
		         }
		};
		
		// Color a la grilla
		tablaCartas.setGridColor(Color.BLACK);	
		JScrollPane scrollPane = new JScrollPane(tablaCartas);
		scrollPane.setBounds(10, 61, 406, 109);
		add(scrollPane);
		

		//Paquetes
		JLabel paquetesLabel = new JLabel("Paquetes");
		paquetesLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		paquetesLabel.setBounds(10, 181, 80, 14);
		add(paquetesLabel);
		
		String[][] paquetes= controlador.listadoPaquetesEntregado();		
		final String[] cabeceraPaqueteTabla= {"Codigo","Fecha","Origen", 
				"Destino","Peso","PrecioKilo"};
	
		JTable tablaPaquete=new JTable(paquetes,cabeceraPaqueteTabla) {
			// Se hacen las celdas no editables.
			public boolean isCellEditable(int row, int column) {
		            return false;
		         }
		};
		
		JScrollPane scrollPane_1 = new JScrollPane(tablaPaquete);
		scrollPane_1.setBounds(10, 203, 406, 109);
		add(scrollPane_1);

	}

}
