package clases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import interfaces.IBaseDeDatosHM;
/**
 * Clase BaseDeDatosHM
 *
 * @param <K>
 * @param <V>
 */

public class BaseDatosHM <K,V> implements IBaseDeDatosHM <K,V>{
	private HashMap<K,V> listaMapa;
	
	 public BaseDatosHM() {
		listaMapa = new HashMap<K,V>();
	}
	
	 /**
	  * Agrega un elemento
	  * @return true si se agrego y false si no.
	  */
	@Override
	public boolean agregar(K clave, V valor) {
		boolean flag=false;
		if(!listaMapa.containsKey(clave)){
			
			listaMapa.put(clave, valor);
			flag=true;
		}
		return flag;
	}
	/**
	 * Borra un elemento
	 * @return true si se borro y false si no.
	 */
	@Override
	public boolean borrar(K clave) {
		boolean flag=false;
		if(listaMapa.get(clave)!=null){
			listaMapa.remove(clave);
			flag=true;
		}
		return flag;
	}
	/**
	 * Listar
	 * @return en un String toda la coleccion
	 */
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
	/**
	 * Buscar
	 */
	@Override
	public V buscar(K clave) {
	return listaMapa.get(clave);
	}
	/**
	 * Devolver lista
	 */
	@Override
	public HashMap<K,V> devolverLista()
	{
		return listaMapa;
	}
	/**
	 * Existe
	 */
	@Override
	public boolean existe(K clave) {	
		return listaMapa.containsKey(clave);
	}
	/**
	 * Obtiene cuenta
	 */
	@Override
	public V getCuenta(K clave)
	{
		return listaMapa.get(clave);
	}
	
}
