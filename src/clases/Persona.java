package clases;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase Persona
 * 
 * @param nombre
 * 				nombre la de persona
 * @paramo apellido
 * 				apellido de la persona
 */				
public class Persona {
	private String nombre;
	private String apellido;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param apellido
	 */
	public Persona(String nombre, String apellido) {
		setNombre(nombre);
		setApellido(apellido);
	}
	
	
	/**
	 * Obtiene el nombre de la persona
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setea el nombre de la persona
	 * @param nombre
	 * Recibe el nombre de la persona a setea
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene el nombre de la persona
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Setea el apellido de la persona
	 * @param apellido
	 * Recibre el apellido de la perosna a setear
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public JSONObject getFormatoJson()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Nombre", getNombre());
			jsonObject.put("Apellido", getApellido());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * Descripcion de la persona
	 * @return String con la descripcion de la persona
	 */
	 @Override
	public String toString() {
		return " Nombre: "+ getNombre()+" Apellido: "+ getApellido()+ " ";
	}
}
