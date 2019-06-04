package interfaces;

public interface IBaseDeDatosHM<K, V> {
	public boolean agregar(K clave, V valor);
	public boolean borrar(K clave);
	public String listar ();
	public V buscar (K clave);
	public boolean existe(K clave);
}