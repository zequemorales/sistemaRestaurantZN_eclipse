package clases;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

/**
 * Clase Mozo
 * 
 * @param idMozo	
 * 				identificacion del mozo
 */
public class Mozo extends Persona{
	private int idMozo;

	/**
	 * Constructor
	 * @param nombre
	 * @param apellido
	 * @param idMozo
	 */

	
	public Mozo(String nombre, String apellido, int idMozo) {
		super(nombre, apellido);
		setIdMozo(idMozo);
	}
	/**
	 * Obtiene la identificacion del mozo
	 * @return int con la identificacion del mozo
	 */
	public int getIdMozo() {
		return idMozo;
	}
	/**
	 * Setea la identificacion del mozo
	 * @param idMozo
	 * Recibe la identificacion del mozo a setear
	 */
	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}
	
	/**
	 * Descripcion del mozo
	 * @return String de la descripcion del mozo
	 */
	@Override
	public String toString() {		
		return "||" + super.toString() + "Id Mozo: " + getIdMozo() + " ||";
	}
	
	public JSONObject getFormatoJson()
	{
		JSONObject jsonObject = super.getFormatoJson();
		try {
			jsonObject.put("idMozo", getIdMozo());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	


}
