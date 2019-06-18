package clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cuenta {
	private HashMap<Integer, Integer>listaProductos;
	private String fecha;
	private int idMesa;
	private int idMozo;
	
	public Cuenta(int idMozo, int idMesa){
		listaProductos = new HashMap<Integer, Integer>();
		setIdMesa(idMesa);
		setIdMozo(idMozo);
		setFecha(ponerFecha());
	}
	
	public Cuenta()
	{
		listaProductos = new HashMap<Integer, Integer>();
		setIdMesa(0);
		setIdMozo(0);
		setFecha(ponerFecha());
	}
	
	
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
		
	}
	public int getIdMozo() {
		return idMozo;
	}
	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}
	
	public String getFecha()
	{
		return fecha;
	}
	
	public void setFecha(String fechaNew)
	{
		fecha = fechaNew;
	}
	
	public HashMap<Integer, Integer> devolverLista()
	{
		HashMap<Integer, Integer> map = listaProductos;
	
	return map;
		
	}
	
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
				System.out.println("Key "+entry.getKey()+ " Value "+ entry.getValue() +"\r\n");
				
				jsonArray.put(jsonObjectLista);
			}
			
			jsonObject.put("Cuenta",jsonArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonObject;
		
	}
	
	private String ponerFecha()
	{
		Date date = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		return formato.format(date);
	}
	
	@Override
	public String toString() {
		
		return "\n|| "+ "Fecha " + fecha+" ID MESA: "+ idMesa + " ID MOZO: " + idMozo + " ||";
	}

}
