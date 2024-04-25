package mensajeria.principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mensajeria.vistas.AltaEnvioVista;
import mensajeria.vistas.AltaMensajeroVista;
import mensajeria.vistas.AsignarEnvioVista;
import mensajeria.vistas.BajaMensajeroVista;
import mensajeria.vistas.EntregaEnvioVista;
import mensajeria.vistas.ListadoEnviosEnEspera;
import mensajeria.vistas.ListadoEnviosEntregados;
import mensajeria.vistas.ListadoEnviosAsignados;
import mensajeria.vistas.ListadoMensajeroVista;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PantallaInicio extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuItem altaMensajeroMenuItem;
	private JMenuItem bajaMensajeroMenuItem;
	private JMenuItem altaEnvioMenuItem;
	private JMenuItem asignarEnvioMenuItem;
	private JMenuItem entregaEnvioMenuItem;
	private JMenuItem listadoMenMenuItem;
	private JMenuItem listadoEnviosEnEsperasMenuItem;
	private JMenuItem listadoEnviosAsignadosMenuItem;
	private JMenuItem listadoEnviosEntregadosMenuItem;
	private AltaMensajeroVista altaMensajeroVista;
	private BajaMensajeroVista bajaMensajeroVista;
	private AltaEnvioVista altaEnvioVista;
	private AsignarEnvioVista asignarEnvioVista;
	private EntregaEnvioVista entregaEnvioVista;
	
	/**
	 * Create the frame.
	 */
	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 550, 412);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mensajeroMenu = new JMenu("Mensajero");
		menuBar.add(mensajeroMenu);
		
		altaMensajeroMenuItem = new JMenuItem("Alta Mensajero");
		mensajeroMenu.add(altaMensajeroMenuItem);
		altaMensajeroMenuItem.addActionListener(this);
		
		bajaMensajeroMenuItem = new JMenuItem("Baja Mensajero");
		mensajeroMenu.add(bajaMensajeroMenuItem);
		bajaMensajeroMenuItem.addActionListener(this);
		
		JMenu envioMenu = new JMenu("Envio");
		menuBar.add(envioMenu);

		
		altaEnvioMenuItem = new JMenuItem("Alta envio");
		envioMenu.add(altaEnvioMenuItem);
		altaEnvioMenuItem.addActionListener(this);
			
		asignarEnvioMenuItem = new JMenuItem("Asignar Envio");
		envioMenu.add(asignarEnvioMenuItem);
		asignarEnvioMenuItem.addActionListener(this);
		
		entregaEnvioMenuItem = new JMenuItem("Entrega Envio");
		envioMenu.add(entregaEnvioMenuItem);
		entregaEnvioMenuItem.addActionListener(this);
		
		JMenu listadosMenu = new JMenu("Listados");
		menuBar.add(listadosMenu);
		
		listadoMenMenuItem = new JMenuItem("Listado mensajeros");
		listadosMenu.add(listadoMenMenuItem);
		listadoMenMenuItem.addActionListener(this);
		
		listadoEnviosEnEsperasMenuItem = new JMenuItem("Envios en Espera");
		listadosMenu.add(listadoEnviosEnEsperasMenuItem);
		listadoEnviosEnEsperasMenuItem.addActionListener(this);

		listadoEnviosAsignadosMenuItem = new JMenuItem("Envios asignados");
		listadosMenu.add(listadoEnviosAsignadosMenuItem);
		listadoEnviosAsignadosMenuItem.addActionListener(this);

		listadoEnviosEntregadosMenuItem = new JMenuItem("Envios entregados");
		listadosMenu.add(listadoEnviosEntregadosMenuItem);
		listadoEnviosEntregadosMenuItem.addActionListener(this);

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		altaMensajeroVista=new AltaMensajeroVista();
		bajaMensajeroVista=	new BajaMensajeroVista();
		altaEnvioVista=new AltaEnvioVista();
		asignarEnvioVista=new AsignarEnvioVista();
		entregaEnvioVista=new EntregaEnvioVista();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==altaMensajeroMenuItem) {
			setContentPane(altaMensajeroVista);
			setVisible(true);
			
		}
		else if (e.getSource()==bajaMensajeroMenuItem) {
			setContentPane(bajaMensajeroVista);
			setVisible(true);
		}
		else if (e.getSource()==altaEnvioMenuItem) {
			setContentPane(altaEnvioVista);
			setVisible(true);
			
		}
		else if (e.getSource()==asignarEnvioMenuItem) {
			System.out.println("Asignar Envio");
			setContentPane(asignarEnvioVista);
			setVisible(true);
		}
		else if (e.getSource()==entregaEnvioMenuItem) {
			System.out.println("Entrega Envio");
			setContentPane(entregaEnvioVista);
			setVisible(true);
		}

		else if (e.getSource()==listadoMenMenuItem) {
			System.out.println("Listados mensajeros");
			ListadoMensajeroVista listadoMensajeroVista=
					new ListadoMensajeroVista();
			setContentPane(listadoMensajeroVista);
			setVisible(true);
		}
		else if (e.getSource()==listadoEnviosEnEsperasMenuItem) {
			System.out.println("Envios en espera");
			ListadoEnviosEnEspera listadoEnviosEnEspera=
					new ListadoEnviosEnEspera();
			setContentPane(listadoEnviosEnEspera);
			setVisible(true);

		}
		else if (e.getSource()==listadoEnviosAsignadosMenuItem) {
			System.out.println("Envios asignados");
			ListadoEnviosAsignados listadoEnviosAsignados=
					new ListadoEnviosAsignados();
			setContentPane(listadoEnviosAsignados);
			setVisible(true);
		}
		else if (e.getSource()==listadoEnviosEntregadosMenuItem) {
			System.out.println("Envios entregados");
			ListadoEnviosEntregados listadoEnviosPaquetesEnEspera=
					new ListadoEnviosEntregados();
			setContentPane(listadoEnviosPaquetesEnEspera);
			setVisible(true);
		}
		else {
			System.out.println("Others");
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setVisible(true);
			
		}
		
	}

}
