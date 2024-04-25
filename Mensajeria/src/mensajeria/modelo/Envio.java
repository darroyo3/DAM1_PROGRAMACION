package mensajeria.modelo;

public class Envio {
	private int codigo;
	private String fecha;
	private String direccionOrigen;
	private String direccionDestino;
	private TipoEstadoEnvio estado;
	private Mensajero mensajero;
	
	public Envio(
				String fecha,
			String direccionOrigen,
			String direccionDestino) {
		this.fecha=fecha;
		this.direccionDestino=direccionDestino;
		this.direccionOrigen=direccionOrigen;
		estado=TipoEstadoEnvio.EN_ESPERA;
	}
	
	public Envio(
			int codigo,
			String fecha,
			String direccionOrigen,
			String direccionDestino) {
		this.codigo=codigo;
		this.fecha=fecha;
		this.direccionDestino=direccionDestino;
		this.direccionOrigen=direccionOrigen;
		estado=TipoEstadoEnvio.EN_ESPERA;
	}
	
	public void asignarMensajero(Mensajero mensajero) {
		this.mensajero=mensajero;
	}

	public TipoEstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(TipoEstadoEnvio estado) {
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}
	
	

	public String getFecha() {
		return fecha;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public Mensajero getMensajero() {
		return mensajero;
	}
	
	
	
}
