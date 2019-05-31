package clases;

public class Producto {
	private int idProducto;
	private String nombreProducto;
	private double precioProducto;
		
	public Producto(int idProducto, String nombreProducto, double precioProducto) {
		super();
		setIdProducto(idProducto);
		setNombreProducto(nombreProducto);
		setPrecioProducto(precioProducto);
	}

	public Producto()
	{
		setIdProducto(-1);
		setNombreProducto("");
		setPrecioProducto(-1);
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	
}
