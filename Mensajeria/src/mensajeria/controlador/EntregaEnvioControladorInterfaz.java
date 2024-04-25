package mensajeria.controlador;

public interface EntregaEnvioControladorInterfaz {

	public boolean comprobarEnvioAsignado(int codigoE);
	
	public void entregaEnvio(int codigoE);
}
