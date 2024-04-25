package mensajeria.modelo;

public class Carta extends Envio{

	private double precio;
	
	public Carta(
			String fecha, 
			String direccionOrigen, 
			String direccionDestino,
			double precio) {
		super(fecha, direccionOrigen, direccionDestino);
		// TODO Auto-generated constructor stub
		this.precio=precio;
	}

	public Carta(int codigo,
			String fecha, 
			String direccionOrigen, 
			String direccionDestino,
			double precio) {
		super(codigo, fecha, direccionOrigen, direccionDestino);
		// TODO Auto-generated constructor stub
		this.precio=precio;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	
	
}
