package mensajeria.controlador;

public interface AltaEnvioControladorInterfaz {

	public boolean altaCarta(String fecha, String origen, String destino, double precio);
	
	public boolean altaPaquete(String fecha, String origen, String destino, double peso,
			double precioKilo);
	
}
