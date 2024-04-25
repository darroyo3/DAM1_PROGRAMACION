package mensajeria.controlador;

public interface AsignarEnvioControladorInterfaz {

	public boolean comprobarMensajeroLibre(int codigoM);
	
	public boolean comprobarEnvioEnEntrega(int codigoE);
	
	public void asignarEnvio(int codigoE, int codigoM);
}
