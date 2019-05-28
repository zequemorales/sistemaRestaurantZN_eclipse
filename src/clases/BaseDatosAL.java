package clases;

import java.util.ArrayList;

import interfaces.IBaseDeDatosAL;

public class BaseDatosAL <T> implements IBaseDeDatosAL<T>{
	
	private ArrayList<T> listaAL;
	
	// Agrega un elemento
	@Override
	public boolean agregar(T objeto) {
		boolean flag=false;
		if(listaAL.add(objeto)){
			flag=true;
		}
		return flag;
	}
	
 // Borra un elemento.
	
	@Override
	public boolean borrar(T objeto) {
		boolean flag=false;
		if(listaAL.remove(objeto)){
			flag=true;
		}
		return flag;
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
	public T buscar (T objeto) {
		T copia = null;
		for(T e : listaAL)
		{
			if(e.equals(objeto))
				copia = objeto;
		}
		return copia;
		
	}

	

}
	