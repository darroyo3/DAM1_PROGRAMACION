package mensajeria.controlador;

public interface ListadoEnviosControladorInterfaz {

	public String[][] listadoCartasEnEspera();
	public String[][] listadoCartasAsignados();
	public String[][] listadoCartasEntregado();
	
	public String[][] listadoPaquetesEnEspera();
	public String[][] listadoPaquetesAsignados();
	public String[][] listadoPaquetesEntregado();


}
