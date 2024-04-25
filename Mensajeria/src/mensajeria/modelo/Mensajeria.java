package mensajeria.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mensajeria.accesodatos.JDBCMensajeriaDAO;

public class Mensajeria {
	
	private JDBCMensajeriaDAO dao=new JDBCMensajeriaDAO();
	
	public Mensajeria() {
	}
	
	public boolean altaMensajero(Mensajero mensajero) {
		try {
			dao.altaMensajero(mensajero);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}	

	public boolean bajaMensajero(int codigo) {
		try {
			dao.bajaMensajero(codigo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean altaEnvio(Envio envio) {
		
		try {
			if (envio instanceof Carta) {
				dao.altaCarta((Carta)envio);
			}
			else {
				dao.altaPaquete((Paquete)envio);
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	public int buscarMensajero(String nombre) {		
		try {
			return dao.buscarMensajero(nombre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	public Mensajero[] obtenerMensajeros() {
		Mensajero[] mensajeros=null;		
		try {
			List<Mensajero> m=dao.obtenerMensajeros();
			mensajeros=new Mensajero[m.size()];
			m.toArray(mensajeros);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mensajeros;
	}
	
	
	public Carta[] obtenerCartas() {
		Carta[] cartas=null;		
		try {
			List<Carta> c=dao.obtenerCartas();
			cartas=new Carta[c.size()];
			c.toArray(cartas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartas;
	}
	
	public Paquete[] obtenerPaquetes() {
		Paquete[] paquetes=null;		
		try {
			List<Paquete> c=dao.obtenerPaquetes();
			paquetes=new Paquete[c.size()];
			c.toArray(paquetes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paquetes;
	}
	
	public Carta[] obtenerCartasAsignadas() {
		Carta[] cartas=null;		
		try {
			List<Carta> c=dao.obtenerCartasAsignadas();
			cartas=new Carta[c.size()];
			c.toArray(cartas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartas;
	}
	
	public String[] obtenerMensajerosCartasAsignadas() {
		String[] nombres=null;
		try {
			List<String> c=dao.obtenerMensajerosCartasAsignadas();
			nombres=new String[c.size()];
			c.toArray(nombres);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombres;
	}
	
	public Paquete[] obtenerPaquetesAsignados() {
		Paquete[] paquetes=null;		
		try {
			List<Paquete> c=dao.obtenerPaquetesAsignados();
			paquetes=new Paquete[c.size()];
			c.toArray(paquetes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paquetes;
	}
	
	public String[] obtenerMensajerosPaquetesAsignadas() {
		String[] nombres=null;
		try {
			List<String> c=dao.obtenerMensajerosPaquetesAsignados();
			nombres=new String[c.size()];
			c.toArray(nombres);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombres;
	}

	
	public Carta[] obtenerCartasEntregadas() {
		Carta[] cartas=null;		
		try {
			List<Carta> c=dao.obtenerCartasEntregados();
			cartas=new Carta[c.size()];
			c.toArray(cartas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartas;
	}
	
	public Paquete[] obtenerPaquetesEntregados() {
		Paquete[] paquetes=null;		
		try {
			List<Paquete> c=dao.obtenerPaquetesEntregados();
			paquetes=new Paquete[c.size()];
			c.toArray(paquetes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paquetes;
	}
	
	public int comprobarEnvioEnEspera(int codigoE) {
		int valor=0;
		try {
			valor=dao.comprobarEnvioEnEspera(codigoE);
			return valor;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;		
	}
	
	public int comprobarMensajeroLibre(int codigoM) {
		int valor=0;
		try {
			valor=dao.comprobarMensajeroLibre(codigoM);
			return valor;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
		
	}
	
	public void asignarEnvio(int codigoE, int codigoM) {
		try {
			dao.asignarEnvio(codigoE, codigoM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int comprobarEnvioAsignado(int codigoE) {
		int valor=0;
		try {
			valor=dao.comprobarEnvioAsignado(codigoE);
			return valor;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
	}
	
	public void entregarEnvio(int codigoE) {
		try {
			dao.entregarEnvio(codigoE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
