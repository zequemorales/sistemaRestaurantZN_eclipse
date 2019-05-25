package clases;

public class Producto {
	private int idProducto;
	private String nombreProducto;
	private double precioProducto;
	
	public Producto()
	{
		setId(-1);
		setNombre("");
		setPrecio(-1);
	}
	
	
	private int getIdProducto()
	{
		return idProducto;
	}
	
	private String getNombre()
	{
		return nombreProducto;
	}
	
	private double getPrecio() {
		return precioProducto;
	}
	
	private void setId(int id)
	{
		idProducto = id;
	}
	
	private void setNombre(String nombre)
	{
		nombreProducto = nombre;
	}
	
	private void setPrecio(double precio)
	{
		precioProducto = precio;
	}
}
