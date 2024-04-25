package mensajeria.controlador;

import mensajeria.modelo.APIMensajeria;

public class EntregaEnvioControlador implements EntregaEnvioControladorInterfaz{

	private APIMensajeria api=APIMensajeria.getInstance();
	
	@Override
	public boolean comprobarEnvioAsignado(int codigoE) {
		// TODO Auto-generated method stub
		return api.comprobarEnvioAsignado(codigoE);
	}

	@Override
	public void entregaEnvio(int codigoE) {
		// TODO Auto-generated method stub
		api.entregarEnvio(codigoE);
	}

}
