package clases;

public class Comida extends Producto{
	
	private String tipoDeComida;
	
	public Comida(int idProducto, String nombreProducto, double precioProducto, String tipoDeComida) {
		super(idProducto, nombreProducto, precioProducto);
		this.tipoDeComida = tipoDeComida;
	}

		
	public Comida() {
		super();
		tipoDeComida = "";
	}

	public String getTipoDeComida() {
		return tipoDeComida;
	}
	public void setTipoDeComida(String tipoDeComida) {
		this.tipoDeComida = tipoDeComida;
	}
	
	

}
