package clases;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Producto {
	private int idProducto;
	private String nombreProducto;
	private double precioProducto;

	public Producto(int idProducto, String nombreProducto, double precioProducto) {
		setIdProducto(idProducto);
		setNombreProducto(nombreProducto);
		setPrecioProducto(precioProducto);
	}

	public Producto() {
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
