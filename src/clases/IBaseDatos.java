package clases;

public interface IBaseDatos<T>{
	public void agregar(T o);
	public void borrar(T o);
	public String listar();

	
}
