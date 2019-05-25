package clases;

import java.util.ArrayList;

public class BaseDatosAL <T> implements IBaseDatos<T>{
	private ArrayList<T> listaAL;

	@Override
	public void agregar(T o) {
		listaAL.add(o);
		
	}

	@Override
	public void borrar(T o) {
		listaAL.remove(o);
		
	}

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

}
	

