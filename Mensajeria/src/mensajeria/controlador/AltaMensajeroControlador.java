package mensajeria.controlador;

import mensajeria.modelo.APIMensajeria;

public class AltaMensajeroControlador implements AltaMensajeroControladorInterfaz {

	private APIMensajeria api=APIMensajeria.getInstance();
	
	@Override
	public void altaMensajero(String nombre, double sueldo, int maximoEnvios) {
		// TODO Auto-generated method stub
		api.altaMensajero(nombre, sueldo, maximoEnvios);		
	}

}
