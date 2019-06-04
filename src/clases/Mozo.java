package clases;

public class Mozo extends Persona{
	private int idMozo;

	public Mozo(String nombre, String apellido, int idMozo) {
		super(nombre, apellido);
		setIdMozo(idMozo);
	}

	public int getIdMozo() {
		return idMozo;
	}
	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "Id Mozo: " + getIdMozo();
	}
	
	
	

}
