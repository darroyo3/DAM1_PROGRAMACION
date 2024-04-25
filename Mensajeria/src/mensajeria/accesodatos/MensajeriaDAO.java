package mensajeria.accesodatos;

import java.sql.SQLException;
import java.util.List;

import mensajeria.modelo.Carta;
import mensajeria.modelo.Envio;
import mensajeria.modelo.Mensajero;
import mensajeria.modelo.Paquete;

public interface MensajeriaDAO {
	
	public void altaMensajero(Mensajero mensajero) throws SQLException ;
	
	public void bajaMensajero(int codigo) throws SQLException;
	
	public int buscarMensajero(String nombre)  throws SQLException ;
	
	public List<Mensajero> obtenerMensajeros()  throws SQLException ;

	public void altaCarta(Carta carta)  throws SQLException ;

	public void bajaCarta(Carta carta)  throws SQLException ;
	
	public void altaPaquete(Paquete paquete)  throws SQLException ;

	public void bajaPaquete(Paquete paquete)  throws SQLException ;
	
	public List<Carta> obtenerCartas()  throws SQLException ;
	
	public List<Paquete> obtenerPaquetes()  throws SQLException ;
	
	public List<Carta> obtenerCartasAsignadas()  throws SQLException ;
	
	public List<Paquete> obtenerPaquetesAsignados()  throws SQLException ;
	
	public List<String >obtenerMensajerosCartasAsignadas() throws SQLException ;
	
	public List<String >obtenerMensajerosPaquetesAsignados() throws SQLException ;

	public List<Carta> obtenerCartasEntregados()  throws SQLException ;
	
	public List<Paquete> obtenerPaquetesEntregados()  throws SQLException ;
	
	public int comprobarEnvioEnEspera(int codigoE)  throws SQLException ;
	
	public int comprobarMensajeroLibre(int codigoM)  throws SQLException ;
	
	public void asignarEnvio(int codigoE, int codigoM) throws SQLException ;
	
	public int comprobarEnvioAsignado(int codigoE)  throws SQLException ;
	
	public void entregarEnvio(int codigoE)  throws SQLException ;
	
}
