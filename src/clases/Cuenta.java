package clases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.sun.javafx.collections.MappingChange.Map;

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
	
	public boolean ponerEnCuenta(int id, int cant,BaseDatosHM<Integer,Producto> hmProducto)
	{
		boolean flag = false;
		if(hmProducto.buscar(id) !=null)
		{
			flag = true;
			listaProductos.put(id, cant);
		}
		return flag;
	}
	
	
	private String ponerFecha()
	{
		Date date = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		return formato.format(date);
	}

}
