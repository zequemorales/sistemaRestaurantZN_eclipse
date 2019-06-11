package clases;
/**
 * Clase Mozo
 * 

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
	 * Obtiene la identificaci�n del mozo
	 * @return int con la identificacion del mozo
	 */
	public int getIdMozo() {
		return idMozo;
	}
	/**
	 * Setea la identificaci�n del mozo
	 * @param idMozo
	 * Recibe la identificaci�n del mozo a setear
	 */
	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}
	/**
	 * Descripci�n del mozo
	 * @return String de la descripci�n del mozo
	 */
	@Override
	public String toString() {		
		return "||" + super.toString() + "Id Mozo: " + getIdMozo() + " ||";
	}
	
	
	

}
