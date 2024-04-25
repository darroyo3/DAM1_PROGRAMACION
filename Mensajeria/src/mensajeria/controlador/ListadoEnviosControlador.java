package mensajeria.controlador;

import mensajeria.modelo.APIMensajeria;

public class ListadoEnviosControlador implements ListadoEnviosControladorInterfaz{

	private APIMensajeria api=APIMensajeria.getInstance();
	
	@Override
	public String[][] listadoCartasEnEspera() {
		// TODO Auto-generated method stub
		return api.obtenerCartas();
	}

	@Override
	public String[][] listadoCartasAsignados() {
		// TODO Auto-generated method stub
		return api.obtenerCartasAsignadas();
	}

	@Override
	public String[][] listadoCartasEntregado() {
		// TODO Auto-generated method stub
		return api.obtenerCartasEntregadas();
	}

	@Override
	public String[][] listadoPaquetesEnEspera() {
		// TODO Auto-generated method stub
		return api.obtenerPaquete();
	}

	@Override
	public String[][] listadoPaquetesAsignados() {
		// TODO Auto-generated method stub
		return api.obtenerPaqueteAsignados();
	}

	@Override
	public String[][] listadoPaquetesEntregado() {
		// TODO Auto-generated method stub
		return api.obtenerPaqueteEntregadas();
	}


}
