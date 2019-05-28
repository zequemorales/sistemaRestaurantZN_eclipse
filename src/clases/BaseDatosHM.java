package clases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import interfaces.IBaseDeDatosHM;


public class BaseDatosHM <K,V> implements IBaseDeDatosHM <K,V>{
	private HashMap<K,V> listaMapa;
	
	
	@Override
	public void agregar(K clave, V valor) {
		listaMapa.put(clave, valor);
		
	}

	@Override
	public void borrar(K clave) {
		listaMapa.remove(clave);
		
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

	@Override
	public V buscar(K clave) {
		V value = listaMapa.get(clave);
		return value;
	}

	
}
