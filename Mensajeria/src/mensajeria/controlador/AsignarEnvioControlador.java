package mensajeria.controlador;

import mensajeria.modelo.APIMensajeria;

public class AsignarEnvioControlador implements AsignarEnvioControladorInterfaz{

	private APIMensajeria api=APIMensajeria.getInstance();
	
	@Override
	public boolean comprobarMensajeroLibre(int codigoM) {
		// TODO Auto-generated method stub
		return api.comprobarMensajeroEnEspera(codigoM);
	}

	@Override
	public boolean comprobarEnvioEnEntrega(int codigoE) {
		// TODO Auto-generated method stub
		return api.comprobarEnvioEnEspera(codigoE);
	}

	@Override
	public void asignarEnvio(int codigoE, int codigoM) {
		// TODO Auto-generated method stub
		api.asignarEnvio(codigoE, codigoM);
	}

}
