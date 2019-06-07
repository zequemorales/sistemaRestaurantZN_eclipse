package clases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import interfaces.IBaseDeDatosHM;


public class BaseDatosHM <K,V> implements IBaseDeDatosHM <K,V>{
	private HashMap<K,V> listaMapa;
	
	 public BaseDatosHM() {
		listaMapa = new HashMap<K,V>();
	}
	
	@Override
	public boolean agregar(K clave, V valor) {
		boolean flag=false;
		if(!listaMapa.containsKey(clave)){
			
			listaMapa.put(clave, valor);
			flag=true;
		}
		return flag;
		
		
	}
	

	@Override
	public boolean borrar(K clave) {
		boolean flag=false;
		if(listaMapa.get(clave)!=null){
			listaMapa.remove(clave);
			flag=true;
		}
		return flag;
		
	}

	@Override
	public String listar() {
		Iterator<Map.Entry<K, V>> entradas = listaMapa.entrySet().iterator();
		StringBuilder str = new StringBuilder();
		str.append("( Clave |"+" Valor )"+"\r\n");
		while (entradas.hasNext()) {
		    Map.Entry<K, V> entrada = entradas.next();
		    str.append("("+entrada.getKey()+" |"+entrada.getValue()+")");
		}
		return str.toString();
	}

	
	//?
	@Override
	public V buscar(K clave) {
			
	return listaMapa.get(clave);
		
		
	}
	
	@Override
	public HashMap<K,V> devolverLista()
	{
		return listaMapa;
	}

	@Override
	public boolean existe(K clave) {
		
		return listaMapa.containsKey(clave);
		
	}

	
	@Override
	public V getCuenta(K clave)
	{
		return listaMapa.get(clave);
	}
	
}
