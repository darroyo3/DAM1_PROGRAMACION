package mensajeria.controlador;

import mensajeria.modelo.APIMensajeria;

public class BajaMensajeroControlador implements BajaMensajeroControladorInterfaz{

	private APIMensajeria api=APIMensajeria.getInstance();
	
	@Override
	public int existeMensajero(String nombre) {
		// TODO Auto-generated method stub
		return api.buscarMensajero(nombre);
	}

	@Override
	public void elimnarMensajero(int codigo) {
		// TODO Auto-generated method stub
		api.eliminarMensajero(codigo);
	}

}
