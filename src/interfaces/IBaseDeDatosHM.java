package interfaces;

import java.util.HashMap;
/**
 * Clase IBaseDeDatosHM
 *
 * @param <K>
 * @param <V>
 */
public interface IBaseDeDatosHM<K, V> {
	public boolean agregar(K clave, V valor);
	public boolean borrar(K clave);
	public String listar ();
	public V buscar (K clave);
	public boolean existe(K clave);
	public V getCuenta(K clave);
	public HashMap<K, V> devolverLista();
}