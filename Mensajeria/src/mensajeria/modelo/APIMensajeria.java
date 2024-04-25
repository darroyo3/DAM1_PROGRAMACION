package mensajeria.modelo;

import mensajeria.accesodatos.JDBCMensajeriaDAO;

public class APIMensajeria {

	private static APIMensajeria instancia=new APIMensajeria();
	
	private Mensajeria mensajeria;
	
	private APIMensajeria()  {
		mensajeria=new Mensajeria();
	}
	
	public static APIMensajeria getInstance() {
		return instancia;
	}
	
	public void altaMensajero(String nombre, double sueldo, int maximoEnvios) {
		Mensajero mensajero=new Mensajero(nombre,sueldo, maximoEnvios);
		mensajeria.altaMensajero(mensajero);
	}
	
	public int buscarMensajero(String nombre) {
		return mensajeria.buscarMensajero(nombre);
	}
	
	public void eliminarMensajero(int codigo) {
		mensajeria.bajaMensajero(codigo);
	}
	
	public String[][] obtenerMensajeros() {
		
		Mensajero[] mensajeros=mensajeria.obtenerMensajeros();
		String[][] mensajerosString=null;
		if (mensajeros!=null) {
			mensajerosString=new String[mensajeros.length][4];
			for (int i=0;i<mensajeros.length; i++ ) {
				mensajerosString[i][0]=""+mensajeros[i].getCodigo();
				mensajerosString[i][1]=mensajeros[i].getNombre();
				mensajerosString[i][2]=""+mensajeros[i].getNumMax();
				mensajerosString[i][3]=""+mensajeros[i].getNumEnvios();
			}
		}
		return mensajerosString;
	}
	
	public String[][] obtenerCartas() {
		
		Carta[] cartas=mensajeria.obtenerCartas();
		String[][] cartasString=null;
		if (cartas!=null) {
			cartasString=new String[cartas.length][5];
			for (int i=0;i<cartas.length; i++ ) {
				cartasString[i][0]=""+cartas[i].getCodigo();
				cartasString[i][1]=cartas[i].getFecha();
				cartasString[i][2]=cartas[i].getDireccionOrigen();
				cartasString[i][3]=cartas[i].getDireccionDestino();
				cartasString[i][4]=""+cartas[i].getPrecio();
			}
		}
		return cartasString;
	}
	
	
	public String[][] obtenerPaquete() {
		
		Paquete[] paquetes=mensajeria.obtenerPaquetes();
		String[][] paquetesString=null;
		if (paquetes!=null) {
			paquetesString=new String[paquetes.length][6];
			for (int i=0;i<paquetes.length; i++ ) {
				paquetesString[i][0]=""+paquetes[i].getCodigo();
				paquetesString[i][1]=paquetes[i].getFecha();
				paquetesString[i][2]=paquetes[i].getDireccionOrigen();
				paquetesString[i][3]=paquetes[i].getDireccionDestino();
				paquetesString[i][4]=""+paquetes[i].getPeso();
				paquetesString[i][5]=""+paquetes[i].getPrecioKilo();
			}
		}
		return paquetesString;
	}
	
	
	public String[][] obtenerCartasAsignadas() {
		
		Carta[] cartas=mensajeria.obtenerCartasAsignadas();
		String[][] cartasString=null;
		if (cartas!=null) {
			cartasString=new String[cartas.length][6];
			for (int i=0;i<cartas.length; i++ ) {
				cartasString[i][0]=""+cartas[i].getCodigo();
				cartasString[i][1]=cartas[i].getFecha();
				cartasString[i][2]=cartas[i].getDireccionOrigen();
				cartasString[i][3]=cartas[i].getDireccionDestino();
				cartasString[i][4]=""+cartas[i].getPrecio();
			}
			String[] nombres=mensajeria.obtenerMensajerosCartasAsignadas();
			for (int i=0;i<nombres.length; i++ ) {
				cartasString[i][5]=nombres[i];
			}

		}
		return cartasString;
	}
	
	
	public String[][] obtenerPaqueteAsignados() {
		
		Paquete[] paquetes=mensajeria.obtenerPaquetesAsignados();
		String[][] paquetesString=null;
		if (paquetes!=null) {
			paquetesString=new String[paquetes.length][7];
			for (int i=0;i<paquetes.length; i++ ) {
				paquetesString[i][0]=""+paquetes[i].getCodigo();
				paquetesString[i][1]=paquetes[i].getFecha();
				paquetesString[i][2]=paquetes[i].getDireccionOrigen();
				paquetesString[i][3]=paquetes[i].getDireccionDestino();
				paquetesString[i][4]=""+paquetes[i].getPeso();
				paquetesString[i][5]=""+paquetes[i].getPrecioKilo();
			}
			String[] nombres=mensajeria.obtenerMensajerosPaquetesAsignadas();
			for (int i=0;i<nombres.length; i++ ) {
				paquetesString[i][6]=nombres[i];
			}
		}
		return paquetesString;
	}

	
	public String[][] obtenerCartasEntregadas() {
		
		Carta[] cartas=mensajeria.obtenerCartasEntregadas();
		String[][] cartasString=null;
		if (cartas!=null) {
			cartasString=new String[cartas.length][5];
			for (int i=0;i<cartas.length; i++ ) {
				cartasString[i][0]=""+cartas[i].getCodigo();
				cartasString[i][1]=cartas[i].getFecha();
				cartasString[i][2]=cartas[i].getDireccionOrigen();
				cartasString[i][3]=cartas[i].getDireccionDestino();
				cartasString[i][4]=""+cartas[i].getPrecio();
			}
		}
		return cartasString;
	}
	
	
	public String[][] obtenerPaqueteEntregadas() {
		
		Paquete[] paquetes=mensajeria.obtenerPaquetesEntregados();
		String[][] paquetesString=null;
		if (paquetes!=null) {
			paquetesString=new String[paquetes.length][6];
			for (int i=0;i<paquetes.length; i++ ) {
				paquetesString[i][0]=""+paquetes[i].getCodigo();
				paquetesString[i][1]=paquetes[i].getFecha();
				paquetesString[i][2]=paquetes[i].getDireccionOrigen();
				paquetesString[i][3]=paquetes[i].getDireccionDestino();
				paquetesString[i][4]=""+paquetes[i].getPeso();
				paquetesString[i][5]=""+paquetes[i].getPrecioKilo();
			}
		}
		return paquetesString;
	}

	
	public boolean altaCarta(String fecha, String origen, String destino, double precio) {
		Carta carta=new Carta(fecha,origen,destino, precio);
		return mensajeria.altaEnvio(carta);
	}
	
	public boolean altaPaquete(String fecha, String origen, String destino, double peso,
			double precioKilo) {
		Paquete paquete=new Paquete(fecha,origen,destino, peso, precioKilo);
		return mensajeria.altaEnvio(paquete);
	}
	
	public boolean comprobarEnvioEnEspera(int codigoE) {
		return mensajeria.comprobarEnvioEnEspera(codigoE)==1?true:false;
	}
	
	public boolean comprobarMensajeroEnEspera(int codigoM) {
		return mensajeria.comprobarMensajeroLibre(codigoM)==1?true:false;
	}
	
	public void asignarEnvio(int codigoE, int codigoM) {
		mensajeria.asignarEnvio(codigoE, codigoM);
	}

	public boolean comprobarEnvioAsignado(int codigoE) {
		return mensajeria.comprobarEnvioAsignado(codigoE)==1?true:false;
	}
	
	public void entregarEnvio(int codigoE) {
		mensajeria.entregarEnvio(codigoE);
	}
}
