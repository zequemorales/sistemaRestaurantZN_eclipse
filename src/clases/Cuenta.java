package clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
	
	private void setFecha(String fechaNew)
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
	
	
	private String ponerFecha()
	{
		Date date = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		return formato.format(date);
	}
	
	@Override
	public String toString() {
		
		return "CUENTA\n " + " Fecha " + fecha+" ID MESA: "+ idMesa + " ID MOZO: " + idMozo;
	}

}
