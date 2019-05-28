package clases;

import java.util.ArrayList;

public class BaseDatosAL <T> implements IBaseDatos<T>{
	private ArrayList<T> listaAL;
// Agrega un elemento
	@Override
	public void agregar(T o) {
		listaAL.add(o);
		
	}
// Borra un elemento.
	@Override
	public void borrar(T o) {
		listaAL.remove(o);
		
	}
// Lista en un String toda la coleccion.
	@Override
	public String listar() {
		StringBuilder str = new StringBuilder();
		for(T o : listaAL)
		{
			str.append(o.toString());
			str.append(" |");
		}
		return str.toString();
		}
	@Override
	public T buscar(T o) {
		T resultado = null;
		for(T e : listaAL)
		{
			if(e.equals(o))
				resultado = o;
		}
		return resultado;
	}
	

}
	

