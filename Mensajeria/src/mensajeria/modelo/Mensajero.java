package mensajeria.modelo;

public class Mensajero {
	private int codigo;
	private static int contador=1;
	private String nombre;
	private double sueldo;
	private int numMax;
	private int numEnvios=0;
	private boolean libre;
	private Envio[] envios;
	
	public Mensajero(String nombre,
			double sueldo,
			int numMax) {
		codigo=contador++;
		this.nombre=nombre;
		this.sueldo=sueldo;
		this.numMax=numMax;
		libre=true;
		envios=new Envio[numMax];
	}
	
	public Mensajero(
			int codigo,
			String nombre,
			double sueldo,
			int numMax,
			int numEnvios) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.sueldo=sueldo;
		this.numMax=numMax;
		this.numEnvios=numEnvios;
		libre=true;
		envios=new Envio[numMax];
	}

	
	/**
	 * Asignar envio: se asigna un envio si el mensajero esta libre
	 * @param envio
	 * @return true: envio asignado
	 * 			false: mensajero ocupado
	 */
	public boolean asignarEnvio(Envio envio) {
		if (libre) {
			envios[numEnvios]=envio;
			numEnvios++;
			if (numEnvios==numMax) {
				libre=false;
			}
			envio.setEstado(TipoEstadoEnvio.ASIGNADO_MENSAJERO);
			envio.asignarMensajero(this);
		}
		return false;
		
	}
	
	public void desasignarEnvio(int codigo) {
		for (int i=0; i<numEnvios; i++) {
			if (envios[i].getCodigo()==codigo) {
				envios[i]=envios[numEnvios-1];
				envios[numEnvios-1]=null;
				numEnvios--;
				libre=true;
			}
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean isLibre() {
		return libre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumMax() {
		return numMax;
	}

	public int getNumEnvios() {
		return numEnvios;
	}

	public double getSueldo() {
		return sueldo;
	}
	
	
	
	
}
