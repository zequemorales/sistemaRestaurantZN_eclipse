package clases;

import java.util.ArrayList;

import interfaces.IBaseDeDatosAL;

public class BaseDatosAL <T> implements IBaseDeDatosAL<T>{
	
	private ArrayList<T> listaAL;
	
	public  BaseDatosAL() {
		listaAL= new ArrayList<T>();
	}
	
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
			str.append("| \n");
		}
		return str.toString();
		}

	@Override
	public  T buscar (T objeto) {
		T copia = null;
		for(T e : listaAL)
		{
			if(e.equals(objeto))
				copia = objeto;
		}
		return copia;
		
	}

	@Override
	public boolean existe(T objeto) {
		boolean flag=false;
		for(T o : listaAL){
			if(o.equals(objeto)){
				flag=true;
			}
		}
		return flag;
	}
	
	//Devuelve el tama�o de la lista
	@Override
	public int tamanioLista(){
		return listaAL.size();
	}
	//Devuelve el objeto de una determinada posicion
	@Override
	public T getindice(int i){
		return listaAL.get(i);
	}
	

	

}
	
