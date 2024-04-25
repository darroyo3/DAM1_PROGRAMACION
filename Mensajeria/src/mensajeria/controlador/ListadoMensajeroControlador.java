package mensajeria.controlador;

import mensajeria.modelo.APIMensajeria;

public class ListadoMensajeroControlador implements ListadoMensajeroControladorInterfaz{

	private APIMensajeria api=APIMensajeria.getInstance();
			
	@Override
	public String[][] listadoMensajeros() {
		// TODO Auto-generated method stub
		return api.obtenerMensajeros();
	}

}
