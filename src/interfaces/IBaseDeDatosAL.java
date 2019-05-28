package interfaces;

public interface IBaseDeDatosAL<T> {
	boolean agregar(T objeto);
	boolean borrar(T objeto);
	String listar ();
	boolean buscar(T objeto);

}
