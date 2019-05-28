package interfaces;

public interface IBaseDeDatosHM<K, V> {
	 boolean agregar(K clave, V valor);
	 boolean borrar(K clave);
	 String listar ();
	 public V buscar (K clave);

}