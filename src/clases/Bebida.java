package clases;

public class Bebida extends Producto{
	
	private String tipoDeBebida;

		
	public Bebida(int idProducto, String nombreProducto, double precioProducto, String tipoDeBebida) {
		super(idProducto, nombreProducto, precioProducto);
		this.tipoDeBebida = tipoDeBebida;
	}
		
	public Bebida() {
		super();
		tipoDeBebida = "";
	}

	public String getTipoDeBebida() {
		return tipoDeBebida;
	}
	public void setTipoDeBebida(String tipoDeBebida) {
		this.tipoDeBebida = tipoDeBebida;
	}
	
	

}
