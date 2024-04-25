package mensajeria.vistas;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import mensajeria.controlador.ListadoMensajeroControlador;
import mensajeria.controlador.ListadoMensajeroControladorInterfaz;

import java.awt.Font;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class ListadoMensajeroVista extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListadoMensajeroVista() {
		setForeground(UIManager.getColor("Button.background"));
		setLayout(null);
	
		JLabel titulo = new JLabel("LISTADO MENSAJEROS");
		titulo.setBounds(100, 5, 260, 22);
		titulo.setFont(new Font("Dialog", Font.BOLD, 18));
		add(titulo);
		
		ListadoMensajeroControladorInterfaz controlador=
				new ListadoMensajeroControlador();
		String[][] mensajeros= controlador.listadoMensajeros();		
		final String[] cabeceraTabla= {"Codigo","Nombre","Max. envios", "Envios actuales"};

		
		JTable tablaMensajeros=new JTable(mensajeros,cabeceraTabla) {
			// Se hacen las celdas no editables.
			public boolean isCellEditable(int row, int column) {
		            return false;
		         }
		};
		
		// Color a la grilla
		tablaMensajeros.setGridColor(Color.BLACK);

	
		JScrollPane scrollPane = new JScrollPane(tablaMensajeros);
		scrollPane.setBounds(10, 32, 400, 200);
		add(scrollPane);
	}

}
