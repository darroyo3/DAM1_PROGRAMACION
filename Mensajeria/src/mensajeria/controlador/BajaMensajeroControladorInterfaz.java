package mensajeria.controlador;

public interface BajaMensajeroControladorInterfaz {

	/**
	 * Método para devolver el codigo del mensajero
	 * @param nombre
	 * @return el codigo del mensajero y -1 si no se encuentra
	 */
	public int existeMensajero(String nombre);
	
	public void elimnarMensajero(int codigo);
}
