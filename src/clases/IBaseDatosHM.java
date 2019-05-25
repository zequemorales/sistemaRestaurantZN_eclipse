package clases;

public interface IBaseDatosHM<K,V> {
	public void agregar(K clave, V valor);
	public void borrar(K clave);
	public String listar();
	public V buscar(K clave);
}
