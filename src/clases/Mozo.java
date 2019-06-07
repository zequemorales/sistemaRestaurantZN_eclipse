package clases;
/**
 * Clase Mozo
 * 
 * @param idMozo
 * 				número de identificación del mozo
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
	 * Obtiene la identificación del mozo
	 * @return int con la identificacion del mozo
	 */
	public int getIdMozo() {
		return idMozo;
	}
	/**
	 * Setea la identificación del mozo
	 * @param idMozo
	 * Recibe la identificación del mozo a setear
	 */
	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}
	/**
	 * Descripción del mozo
	 * @return String de la descripción del mozo
	 */
	@Override
	public String toString() {		
		return super.toString() + "Id Mozo: " + getIdMozo();
	}
	
	
	

}
