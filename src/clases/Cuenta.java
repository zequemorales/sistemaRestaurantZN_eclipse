package clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 * Clase cuenta
 */
public class Cuenta {
	private HashMap<Integer, Integer>listaProductos;
	private String fecha;
	private int idMesa;
	private int idMozo;
	
	/** 
	 * Constructor
	 * @param idMozo
	 * @param idMesa
	 */
	public Cuenta(int idMozo, int idMesa){
		listaProductos = new HashMap<Integer, Integer>();
		setIdMesa(idMesa);
		setIdMozo(idMozo);
		setFecha(ponerFecha());
	}
	/**
	 * Constructor vacio
	 */
	public Cuenta()
	{
		listaProductos = new HashMap<Integer, Integer>();
		setIdMesa(0);
		setIdMozo(0);
		setFecha(ponerFecha());
	}
	
	/**
	 * Obtiene la identifiacacion de mesa
	 * @return devuleve el id de mesa
	 */
	public int getIdMesa() {
		return idMesa;
	}
	/**
	 * Setea la id de mesa
	 * @param idMesa
	 */
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
		
	}
	/**
	 * Obtiene la identificacion del mozo
	 * @return devuelve el id del mozo
	 */
	public int getIdMozo() {
		return idMozo;
	}
	/**
	 * Setea el id de mozo
	 * @param idMozo
	 */
	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}
	/**
	 * Obtiene la fecha 
	 * @return devuelve la fecha
	 */
	public String getFecha()
	{
		return fecha;
	}
	/**
	 * Setea la fecha
	 * @param fechaNew
	 */
	public void setFecha(String fechaNew)
	{
		fecha = fechaNew;
	}
	/**
	 * Devolver lista
	 * @return
	 */
	public HashMap<Integer, Integer> devolverLista()
	{
		HashMap<Integer, Integer> map = listaProductos;
	
	return map;
		
	}
	/**
	 * Poner en cuenta
	 * @param id
	 * @param cant
	 * @return  
	 */
	public boolean ponerEnCuenta(int id, int cant)
	{
		boolean flag = false;
		int cantNew = 0;
		if(!listaProductos.containsKey(id))
		{
			flag = true;
			listaProductos.put(id, cant);
		}else
		{
			cantNew = listaProductos.get(id);
			cantNew += cant;
			listaProductos.put(id, cantNew);
			flag = true;
		}
		return flag;
	}
	/**
	 * Devuelve la cantidad de prodcitos de ese id en paricular
	 * @param idProducto
	 * Producto a averiguar
	 * @return
	 * la cantidad de ese producto en la cuenta
	 */
	public int getCantidadProductoPedido (int idProducto) {
		
		return listaProductos.get(idProducto);
		
	}
	
	public JSONObject getJson()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Fecha", getFecha());
			jsonObject.put("IdMesa", getIdMesa());
			jsonObject.put("IdMozo", getIdMozo());
			JSONArray jsonArray = new JSONArray();
			HashMap<Integer, Integer> listaC = listaProductos;
			for (HashMap.Entry<Integer, Integer> entry : listaC.entrySet())
			{
				
				JSONObject jsonObjectLista = new JSONObject();
				jsonObjectLista.put("Key",entry.getKey());
				jsonObjectLista.put("Value",entry.getValue());
				
				
				jsonArray.put(jsonObjectLista);
			}
			
			jsonObject.put("Ticket",jsonArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonObject;
		
	}
	/**
	 * Fecha
	 * @return devuelve el formato de fecha
	 */
	private String ponerFecha()
	{
		Date date = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		return formato.format(date);
	}
	/**
	 * Descrpcion de cuenta
	 * @return devuelve un string con la descripcion de la cuenta
	 */
	@Override
	public String toString() {
		
		return "\n|| "+ "Fecha " + fecha+" ID MESA: "+ idMesa + " ID MOZO: " + idMozo + " ||";
	}

}
