package mensajeria.modelo;

public class Paquete extends Envio{
	
	private double precioKilo;
	private double peso;
	
	public Paquete(
			String fecha, 
			String direccionOrigen, 
			String direccionDestino,
			double precioKilo,
			double peso) {
		super( fecha, direccionOrigen, direccionDestino);
		// TODO Auto-generated constructor stub
		this.precioKilo=precioKilo;
		this.peso=peso;
	}

	public Paquete(
			int codigo,
			String fecha, 
			String direccionOrigen, 
			String direccionDestino,
			double precioKilo,
			double peso) {
		super(codigo, fecha, direccionOrigen, direccionDestino);
		// TODO Auto-generated constructor stub
		this.precioKilo=precioKilo;
		this.peso=peso;
	}

	public double getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(double precioKilo) {
		this.precioKilo = precioKilo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
}
