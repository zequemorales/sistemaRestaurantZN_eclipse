package interfaces;

/**
 * 
 * Clase IBaseDeDatosAL
 *
 * @param <T>
 */
public interface IBaseDeDatosAL<T> {
	public boolean agregar(T objeto);
	public boolean borrar(T objeto);
	public String listar ();
	public T  buscar(T objeto);
	public boolean existe(T objeto);
	public int tamanioLista();
	public T getindice(int i);
}
