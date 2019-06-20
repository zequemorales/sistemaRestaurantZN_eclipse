package clases;

/**
 * Clase Producto
 * 
 * @param idProducto
 * 					numero de identificación del producto
 * @param nombreProducto
 * 					nombre del producto
 * @param precioProducto
 * 					precio del producto
 */


import org.json.JSONException;
import org.json.JSONObject;

public abstract class Producto {
	private int idProducto;
	private String nombreProducto;
	private double precioProducto;
	
	
	/**
	 * Descripcion del producto
	 * @return String con la descripcion
	 */
	@Override
	public String toString() {
		return "idProducto: " + getIdProducto() + " Nombre Producto: " + getNombreProducto() + " Precio Producto:"
				+ getPrecioProducto();
	}
	
	/**
	 * Contructor
	 * @param idProducto
	 * @param nombreProducto
	 * @param precioProducto
	 */
	public Producto(int idProducto, String nombreProducto, double precioProducto) {
		setIdProducto(idProducto);
		setNombreProducto(nombreProducto);
		setPrecioProducto(precioProducto);
	}

	/**
	 * Constructo vacio
	 */
	public Producto() {
		setIdProducto(-1);
		setNombreProducto("");
		setPrecioProducto(-1);
	}
	
	/**
	 * Obtiene el identificador del restaurante
	 * @return int con el identificador del restaurante
	 */
	public int getIdProducto() {
		return idProducto;
	}
	/**
	 * Setea el identificador del producto
	 * @param idProducto
	 * Recibe el identificador a setear
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * Obtiene el nombre del producto
	 * @return String con el nombre del producto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * Setea el nombre del prodcuto
	 * @param nombreProducto
	 * Recibie el nombre del producto a setear
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * Obtiene el precio del producto
	 * @return double con el precio del producto
	 */
	public double getPrecioProducto() {
		return precioProducto;
	}
	/**
	 * Setea el precio del producto
	 * @param precioProducto
	 * Recibe el precio del producto a setear
	 */
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	/**
	 * Formato json
	 * @return devuelve objeto json
	 */
	public JSONObject getFormatoJSON()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("idProducto", getIdProducto());
			jsonObject.put("nombreProducto", getNombreProducto());
			jsonObject.put("precioProducto", getPrecioProducto());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject;
		
	}
	
}
