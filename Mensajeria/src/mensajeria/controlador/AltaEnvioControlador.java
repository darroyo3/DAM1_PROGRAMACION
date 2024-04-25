package mensajeria.controlador;

import mensajeria.modelo.APIMensajeria;

public class AltaEnvioControlador implements AltaEnvioControladorInterfaz{

	private APIMensajeria api=APIMensajeria.getInstance();
	
	@Override
	public boolean altaCarta(String fecha, String origen, String destino, double precio) {
		// TODO Auto-generated method stub
		return api.altaCarta(fecha, origen, destino, precio);
	}

	@Override
	public boolean altaPaquete(String fecha, String origen, String destino, double peso, double precioKilo) {
		// TODO Auto-generated method stub
		return api.altaPaquete(fecha, origen, destino, peso, precioKilo);
	}

}
